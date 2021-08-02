package com.cdi.pa.di.service;

import com.cdi.domain.model.Order;
import com.cdi.domain.model.Patient;
import com.cdi.domain.repository.DataRepository;
import com.cdi.domain.util.AppUtils;
import com.cdi.domain.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * QCService class used to consume message from kafka topics and ingest data into
 * target tables in MS SQL server.
 *
 * @author Ravi Reddy
 * @CopyRight (C) All rights reserved to CDI Inc. It's Illegal to reproduce this code.
 */
@Service
@Slf4j
public class QCService {

    @Autowired
    private DataRepository dataRepository;


    /**
     * Method to listen order and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_orders}")  //Working
    public void orderListener(@Payload String messagePayload) throws Exception {
        log.info("QCService:orderListener::Message: {}", messagePayload);

        /* Translate message payload to map. */
        Map<String, Object> orderMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        Order order = buildOrder(orderMessage);

        /* Save or persist the data into the table. */
        dataRepository.save(order);
        log.info("Order is Saved/Updated for order id: {} ", order.getId());
    }


    /**
     * Method to listen patient and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_patients}")  //TODO: Need to Work
    public void patientListener(@Payload String messagePayload) throws Exception {
        log.info("QCService:patientListener::Message: {}", messagePayload);

        /* Translate message payload to map. */
        Map<String, Object> patientMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        Patient patient = buildPatient(patientMessage);

        /* Save or persist the data into the table. */
        dataRepository.save(patient);
        log.info("Patient is Saved/Updated for patient id: {} ", patient.getId());
    }


    /**
     * Method to build patient information.
     *
     * @param patientMessage
     * @return BodyPart
     */
    private Patient buildPatient(Map<String, Object> patientMessage) throws Exception {
        /* Map and build the patient entity to save data into the table. */
        List<Integer> orderingFacilityData = (List<Integer>) patientMessage.get("ordering_facilities");
        String orderingFacility = AppUtils.convertNumbersToValue(orderingFacilityData);

        Patient patient = new Patient();
        patient.setId((Integer) patientMessage.get("id"));
        patient.setOrderingFacilities(orderingFacility);
        patient.setGender((String) patientMessage.get("gender"));
        patient.setAlertNote((String) patientMessage.get("alert_note"));
        patient.setOwnerId((BigInteger) patientMessage.get("owner_id"));
        patient.setBirthDate((new Date()).toString()); //TODO patientMessage.get("birth_date") Issues with date value getting 4 numeric values
        patient.setAccountNo((String) patientMessage.get("account_no"));
        patient.setSuffixName((String) patientMessage.get("suffix_name"));
        patient.setPatientType((String) patientMessage.get("patient_type"));
        patient.setLastEditDt(AppUtils.convertToOffSetDateTime((String) patientMessage.get("last_edit_dt")));
        patient.setFirstName((String) patientMessage.get("first_name"));
        patient.setLastName((String) patientMessage.get("last_name"));
        patient.setLastEditBy((Integer) patientMessage.get("last_edit_by"));
        patient.setAltAccountNo((String) patientMessage.get("alt_account_no"));
        patient.setActive((Boolean) patientMessage.get("is_active"));
        patient.setCreatedDt(AppUtils.convertToOffSetDateTime((String) patientMessage.get("created_dt")));
        patient.setCompanyId((Integer) patientMessage.get("company_id"));
        patient.setVip((Boolean) patientMessage.get("is_vip"));
        patient.setDicomPatientId((String) patientMessage.get("dicom_patient_id"));
        patient.setMiddleName((String) patientMessage.get("middle_name"));
        patient.setFullName((String) patientMessage.get("full_name"));
        patient.setPatientInfo((String) patientMessage.get("patient_info"));
        patient.setPortalInfo((String) patientMessage.get("portal_info"));
        patient.setAccountNoHistory((String) patientMessage.get("account_no_history"));
        patient.setPatientDetails((String) patientMessage.get("patient_details"));
        patient.setLastAction((String) patientMessage.get("operationType"));
        patient.setLastModified(new Timestamp(System.currentTimeMillis()));

        /* Populate the patient info, portal info, account history and patient details information. */
        buildPatientInfo(patient, patientMessage);
        buildPortalInfo(patient, patientMessage);
        buildAccountHistoryInfo(patient, patientMessage);
        buildPatientDetailsInfo(patient, patientMessage);
        return patient;
    }


    /**
     * Method to build order information.
     *
     * @param orderMessage
     * @return BodyPart
     */
    private Order buildOrder(Map<String, Object> orderMessage) throws Exception {
        /* Map and build the patient entity to save data into the table. */
        List<Integer> readingProvidersData = (List<Integer>) orderMessage.get("reading_providers");
        List<String> referringProvidersData = (List<String>) orderMessage.get("referring_providers");
        List<String> icdCodesData = (List<String>) orderMessage.get("icd_codes");
        List<Integer> referringProviderIdsData = (List<Integer>) orderMessage.get("referring_provider_ids");

        long patientId = new Long((Integer) orderMessage.get("patient_id"));
        String readingProviders = CollectionUtils.isEmpty(readingProvidersData) ? "" : AppUtils.convertNumbersToValue(readingProvidersData);
        String referringProviders = CollectionUtils.isEmpty(referringProvidersData) ? "" : String.join(",", referringProvidersData);
        String icdCodes = CollectionUtils.isEmpty(icdCodesData) ? "" : String.join(",", icdCodesData);
        String referringProviderIds = CollectionUtils.isEmpty(referringProviderIdsData) ? "" : AppUtils.convertNumbersToValue(referringProviderIdsData);
        OffsetDateTime muLastUpdate = AppUtils.convertToOffSetDateTime((String) orderMessage.get("mu_last_updated"));
        OffsetDateTime orderStatusLastChangedDt = AppUtils.convertToOffSetDateTime((String) orderMessage.get("order_status_last_changed_dt"));

        Order order = new Order();
        order.setId((Integer) orderMessage.get("id"));
        order.setOrderedDt((String) orderMessage.get("ordered_dt"));
        order.setQuickAppt((Boolean) orderMessage.get("is_quick_appt"));
        order.setReadingProviders(readingProviders);
        order.setReferringProviders(referringProviders);
        order.setTechnologistId((Integer) orderMessage.get("technologist_id"));
        order.setOrderedBy((Integer) orderMessage.get("ordered_by"));
        order.setPrimaryPatientInsuranceId((BigInteger) orderMessage.get("primary_patient_insurance_id"));
        order.setScheduledDate((new Date()).toString()); //TODO: (Integer) orderMessage.get("scheduled_date") need to convert 5 digit number to date value
        order.setMuPassed((Boolean) orderMessage.get("mu_passed"));
        order.setDuration((Integer) orderMessage.get("duration"));
        order.setMuLastUpdated(muLastUpdate);
        order.setOrderStatus((String) orderMessage.get("order_status"));
        order.setModalityRoomId((Integer) orderMessage.get("modality_room_id"));
        order.setModalityId((Integer) orderMessage.get("modality_id"));
        order.setFacilityId((Integer) orderMessage.get("facility_id"));
        order.setOrderStatusLastChangedBy((Integer) orderMessage.get("order_status_last_changed_by"));
        order.setOrderStatusLastChangedDt(orderStatusLastChangedDt);
        order.setOrderType((String) orderMessage.get("order_type"));
        order.setCompanyId((Integer) orderMessage.get("company_id"));
        order.setIcdCodes(icdCodes);
        order.setReferringProviderIds(referringProviderIds);
        order.setScheduledDate((String) orderMessage.get("scheduled_dt"));
        order.setOrderInfo((String) orderMessage.get("order_info"));
        order.setMuValidationData((String) orderMessage.get("mu_validation_data"));
        order.setCompanyId((Integer) orderMessage.get("company_id"));
        order.setPatientId(patientId);
        order.setOrderStatusDesc((String) orderMessage.get("order_status_desc"));
        order.setLastAction((String) orderMessage.get("operationType"));
        order.setLastModified(new Timestamp(System.currentTimeMillis()));

        /* Populate the mu validation and order info data information. */
        buildMuValidationData(order, orderMessage);
        buildOrderInfo(order, orderMessage);
        return order;
    }


    /**
     * Method to build or populate Mu validation data.
     *
     * @param order
     * @param orderMessage
     * @throws Exception
     */
    private void buildMuValidationData(Order order, Map<String, Object> orderMessage) throws Exception {
        String muValidationDataMsg = (String) orderMessage.get("mu_validation_data");
        Map muValidationData = JsonUtils.deserializeJson(Map.class, muValidationDataMsg);

        order.setMuValidationDataPatientprescription(muValidationData.get("patientPrescription").toString());
        order.setMuValidationDataPatientmedication(muValidationData.get("patientMedication").toString());
        order.setMuValidationDataPatientallergies(muValidationData.get("patientAllergies").toString());
        order.setMuValidationDataPatientproblems(muValidationData.get("patientProblems").toString());
        order.setMuValidationDataPatientname(muValidationData.get("patientName").toString());
        order.setMuValidationDataPatientdob(muValidationData.get("patientDOB").toString());
        order.setMuValidationDataPatientrace(muValidationData.get("patientRace").toString());
        order.setMuValidationDataPatientethnicity(muValidationData.get("patientEthnicity").toString());
        order.setMuValidationDataPatientpreferredlanguage(muValidationData.get("patientPreferredLanguage").toString());
        order.setMuValidationDataPatientlaboratorytest(muValidationData.get("patientLaboratoryTest").toString());
        order.setMuValidationDataPatientlaboratoryresults(muValidationData.get("patientLaboratoryResults").toString());
        order.setMuValidationDataPatientsmokingstatus(muValidationData.get("patientSmokingStatus").toString());
        order.setMuValidationDataPatientvitalsigns(muValidationData.get("patientVitalSigns").toString());
        order.setMuValidationDataPatientimmunizations(muValidationData.get("patientImmunizations").toString());
        order.setMuValidationDataPatientcognitivestatus(muValidationData.get("patientCognitiveStatus").toString());
        order.setMuValidationDataFunctionalStatus(muValidationData.get("functional_status").toString());
        order.setMuValidationDataPatientgender(muValidationData.get("patientGender").toString());
        order.setMuValidationDataPatientedumaterial(muValidationData.get("patientEduMaterial").toString());
        order.setMuValidationDataRemainder(muValidationData.get("Remainder").toString());
        order.setMuValidationDataPatientsummaryofcare(muValidationData.get("patientSummaryOfCare").toString());
        order.setMuValidationDataPatientsummaryofcareelectronic(muValidationData.get("patientSummaryOfCareElectronic").toString());
        order.setMuValidationDataPatientelectronicaccessvdt(muValidationData.get("patientElectronicAccessVDT").toString());
    }

    /**
     * Method to build or populate the order info information.
     *
     * @param order
     * @param orderMessage
     * @throws Exception
     */
    private void buildOrderInfo(Order order, Map<String, Object> orderMessage) throws Exception {
        String orderInfoMsg = (String) orderMessage.get("order_info");
        Map orderInfoData = JsonUtils.deserializeJson(Map.class, orderInfoMsg);

        order.setOrderInfo(orderInfoMsg);
        order.setOrderInfoReferralno((String) orderInfoData.get("referralNo"));
        order.setOrderInfoDispatchContactName((String) orderInfoData.get("dispatch_contact_name"));
        order.setOrderInfoDispatchContactNumber((String) orderInfoData.get("dispatch_contact_number"));
        order.setOrderInfoAccidentState((String) orderInfoData.get("accident_state"));
        order.setIsMedicationReconciliation((String) orderInfoData.get("isMedicationReconciliation"));
        order.setOrderInfoEmp((String) orderInfoData.get("emp"));
        order.setOrderInfoCurrentdate((String) orderInfoData.get("currentDate"));
        order.setOrderInfoSource((String) orderInfoData.get("source"));
        order.setOrderInfoJos((String) orderInfoData.get("jos"));
        order.setOrderInfoOa((String) orderInfoData.get("oa"));
        order.setOrderInfoPosMapCode((String) orderInfoData.get("pos_map_code"));
        order.setOrderInfoOrderingFacilityId((String) orderInfoData.get("ordering_facility_id"));
        order.setOrderInfoPatientroom((String) orderInfoData.get("patientRoom"));
        order.setOrderInfoPos((String) orderInfoData.get("pos"));
        order.setOrderInfoCreatedby((String) orderInfoData.get("createdby"));
        order.setOrderInfoRequestingdate((String) orderInfoData.get("requestingDate"));
        order.setOrderInfoDispatchAddress((String) orderInfoData.get("dispatch_address"));
        order.setOrderInfoIsRejected((String) orderInfoData.get("is_rejected"));
        order.setOrderInfoReferringProviderloginid((String) orderInfoData.get("referring_providerloginID"));
        order.setOrderInfoIspreorder((String) orderInfoData.get("isPreOrder"));
        order.setOrderInfoPatientAge((String) orderInfoData.get("patient_age"));
        order.setOrderInfoAa((String) orderInfoData.get("aa"));
        order.setOrderInfoStat((String) orderInfoData.get("stat"));
        order.setOrderInfoPosTypeCode((String) orderInfoData.get("pos_type_code"));
        order.setOrderInfoPatientlocation((String) orderInfoData.get("patientLocation"));
        order.setOrderInfoGoogleJobId((String) orderInfoData.get("google_job_id"));
        order.setOrderInfoIsquickapptFrom((String) orderInfoData.get("isquickappt_from"));
        order.setOrderInfoLastmuupdatedby((String) orderInfoData.get("lastMuUpdatedBy"));
        order.setOrderInfoTransport((String) orderInfoData.get("transport"));
        order.setOrderInfoOrderingFacility((String) orderInfoData.get("ordering_facility"));
        order.setOrderInfoLastmuupdatedby((String) orderInfoData.get("lastMuUpdatedBy"));
        order.setOrderInfoTransport((String) orderInfoData.get("transport"));
        order.setOrderInfoOrderingFacility((String) orderInfoData.get("ordering_facility"));
        order.setOrderInfoAppontmentreminder((String) orderInfoData.get("appontmentReminder"));
        order.setOrderInfoPatientemail((String) orderInfoData.get("patientEmail"));
        order.setOrderInfoPatientcondition((String) orderInfoData.get("patientCondition"));
    }


    /**
     * Method to build or populate patient info of the patient
     *
     * @param patient
     * @param patientMessage
     * @throws Exception
     */
    private void buildPatientInfo(Patient patient, Map<String, Object> patientMessage) throws Exception {
        String patientInfoMsg = (String) patientMessage.get("patient_info");
        Map patientInfoData = JsonUtils.deserializeJson(Map.class,patientInfoMsg);

        patient.setPatientInfoC2state((String) patientInfoData.get("c2State"));
        patient.setPatientInfoLicenseno((String) patientInfoData.get("licenseNo"));
        patient.setPatientInfoEmployeraddress((String) patientInfoData.get("employerAddress"));
        patient.setPatientInfoEnableVerterinary((String) patientInfoData.get("enableVerterinary"));
        patient.setPatientInfoEmployerstate((String) patientInfoData.get("employerState"));
        patient.setPatientInfoLanguage((String) patientInfoData.get("language"));
        patient.setPatientInfoC2workphone((String) patientInfoData.get("c2WorkPhone"));
        patient.setPatientInfoResonForDeath((String) patientInfoData.get("resonForDeath"));
        patient.setPatientInfoC2country((String) patientInfoData.get("c2country"));
        patient.setPatientInfoSsn((String) patientInfoData.get("ssn"));
        patient.setPatientInfoC1country((String) patientInfoData.get("c1country"));
        patient.setPatientInfoPatientLabOrders((String) patientInfoData.get("patient_lab_orders"));
        patient.setPatientInfoPatientMedications((String) patientInfoData.get("patient_medications"));
        patient.setPatientInfoPatientVital((String) patientInfoData.get("patient_vital"));
        patient.setPatientInfoOrderingfacility((String) patientInfoData.get("orderingFacility"));
        patient.setPatientInfoC1zip((String) patientInfoData.get("c1Zip"));
        patient.setPatientInfoC1homephone((String) patientInfoData.get("c1HomePhone"));
        patient.setPatientInfoEmployerphone((String) patientInfoData.get("employerPhone"));
        patient.setPatientInfoC2mobilephone((String) patientInfoData.get("c2MobilePhone"));
        patient.setPatientInfoHeight((String) patientInfoData.get("height"));
        patient.setPatientInfoDeathreason((String) patientInfoData.get("deathReason"));
        patient.setPatientInfoEthnic((String) patientInfoData.get("ethnic"));
        patient.setPatientInfoC1addressline1((String) patientInfoData.get("c1AddressLine1"));
        patient.setPatientInfoLicensestate((String) patientInfoData.get("licenseState"));
        patient.setPatientInfoEthnic((String) patientInfoData.get("ethnic"));
        patient.setPatientInfoC1addressline1((String) patientInfoData.get("c1AddressLine1"));
        patient.setPatientInfoLicensestate((String) patientInfoData.get("licenseState"));
        patient.setPatientInfoPatientAllergies((String) patientInfoData.get("patient_allergies"));
        patient.setPatientInfoAlt((String) patientInfoData.get("alt"));
        patient.setPatientInfoWeight((String) patientInfoData.get("weight"));
        patient.setPatientInfoPatientAllergies((String) patientInfoData.get("patient_allergies"));
        patient.setPatientInfoAlt((String) patientInfoData.get("alt"));
        patient.setPatientInfoWeight((String) patientInfoData.get("weight"));
        patient.setPatientInfoC1email((String) patientInfoData.get("c1Email"));
        patient.setPatientInfoC1addressline2((String) patientInfoData.get("c1AddressLine2"));
        patient.setPatientInfoC2addressline2((String) patientInfoData.get("c2AddressLine2"));
        patient.setPatientInfoC1mobilephone((String) patientInfoData.get("c1MobilePhone"));
        patient.setPatientInfoSmsconsent((String) patientInfoData.get("smsConsent"));
        patient.setPatientInfoAccountno((String) patientInfoData.get("accountno"));
        patient.setPatientInfoMaritalstatus((String) patientInfoData.get("maritalStatus"));
        patient.setPatientInfoCommpref((String) patientInfoData.get("commPref"));
        patient.setPatientInfoC2homephone((String) patientInfoData.get("c2HomePhone"));
        patient.setPatientInfoEmployername((String) patientInfoData.get("employerName"));
        patient.setPatientInfoRacial((String) patientInfoData.get("racial"));
        patient.setPatientInfoExpirydate((String) patientInfoData.get("expiryDate"));
        patient.setPatientInfoC1workphone((String) patientInfoData.get("c1WorkPhone"));
        patient.setPatientInfoProviderfacilities((String) patientInfoData.get("providerfacilities"));
        patient.setPatientInfoIsAnimal((String) patientInfoData.get("is_animal"));
        patient.setPatientInfoPatientflag((String) patientInfoData.get("patientFlag"));
        patient.setPatientInfoEmployerfax((String) patientInfoData.get("employerFax"));
        patient.setPatientInfoSetordfacilityaddress((String) patientInfoData.get("setOrdFacilityAddress"));
        patient.setPatientInfoEmployerzip((String) patientInfoData.get("employerZip"));
        patient.setPatientInfoShowexistpatient((String) patientInfoData.get("showExistPatient"));
        patient.setPatientInfoC2city((String) patientInfoData.get("c2City"));
        patient.setPatientInfoPatientProblems((String) patientInfoData.get("patient_problems"));
        patient.setPatientInfoC1state((String) patientInfoData.get("c1State"));
        patient.setPatientInfoEmployercity((String) patientInfoData.get("employerCity"));
        patient.setPatientInfoProvidername((String) patientInfoData.get("providername"));
        patient.setPatientInfoProviderid((String) patientInfoData.get("providerID"));
        patient.setPatientInfoC2email((String) patientInfoData.get("c2Email"));
        patient.setPatientInfoC2zip((String) patientInfoData.get("c2Zip"));
        patient.setPatientInfoC1city((String) patientInfoData.get("c1City"));
        patient.setPatientInfoSmokingstatus((String) patientInfoData.get("smokingStatus"));
    }


    /**
     * Method to build or populate patient info of the patient
     *
     * @param patient
     * @param patientMessage
     * @throws Exception
     */
    private void buildPortalInfo(Patient patient, Map<String, Object> patientMessage) throws Exception {
        String portalInfoMsg = (String) patientMessage.get("portal_info");
        Map portalInfoData = JsonUtils.deserializeJson(Map.class, portalInfoMsg);

        patient.setPortalInfoPassword((String) portalInfoData.get("password"));
        patient.setPortalInfoCreatedDt((String) portalInfoData.get("created_dt"));
        patient.setPortalInfoOutpatient((String) portalInfoData.get("outPatient"));
        patient.setPortalInfoLock((String) portalInfoData.get("lock"));
        patient.setPortalInfoActive((String) portalInfoData.get("active"));
        patient.setPortalInfoUsername((String) portalInfoData.get("username"));
        patient.setPortalInfoActivated((String) portalInfoData.get("activated"));
    }

    /**
     * Method to build or populate account history of the patient
     *
     * @param patient
     * @param patientMessage
     * @throws Exception
     */
    private void buildAccountHistoryInfo(Patient patient, Map<String, Object> patientMessage) throws Exception {
        List<String> accountHistoryMsg = (List<String>) patientMessage.get("account_no_history");
        Map accountHistoryData = JsonUtils.deserializeJson(Map.class, accountHistoryMsg.get(0));

        patient.setAccountNoHistoryAcc((String) accountHistoryData.get("acc"));
        patient.setAccountNoHistoryCreatedby((String) accountHistoryData.get("createdby"));
        patient.setAccountNoHistoryCreateddt((String) accountHistoryData.get("createddt"));
    }

    /**
     * Method to build or populate patient details of the patient
     *
     * @param patient
     * @param patientMessage
     * @throws Exception
     */
    private void buildPatientDetailsInfo(Patient patient, Map<String, Object> patientMessage) throws Exception {
        String patientDetailsMsg = (String)patientMessage.get("patient_details");
        Map patientDetailsData = JsonUtils.deserializeJson(Map.class, patientDetailsMsg);

        patient.setPatientDetailsPatientName((String) patientDetailsData.get("patient_name"));
        patient.setPatientDetailsBirthDate((String) patientDetailsData.get("birth_date"));
        patient.setPatientDetailsDicomPatientId((String) patientDetailsData.get("dicom_patient_id"));
        patient.setPatientDetailsPatientSex((String) patientDetailsData.get("patient_sex"));
        patient.setPatientDetailsFirstName((String) patientDetailsData.get("first_name"));
    }

}
