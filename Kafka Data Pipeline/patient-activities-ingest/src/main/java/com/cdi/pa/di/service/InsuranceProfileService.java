package com.cdi.pa.di.service;


import com.cdi.domain.model.PatientInsurance;
import com.cdi.domain.model.StudyCpt;
import com.cdi.domain.repository.DataRepository;
import com.cdi.domain.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;

/**
 * InsuranceProfileService class used to consume message from kafka topics and ingest data into
 * target tables in MS SQL server.
 *
 * @author Temam G.
 * @CopyRight (C) All rights reserved to CDI Inc. It's Illegal to reproduce this code.
 */
@Service
@Slf4j
public class InsuranceProfileService {

    @Autowired
    private DataRepository dataRepository;

    /**
     * Method to listen study cpt and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_patient_insurances}")
    public void patientInsurancesListener(@Payload String messagePayload) throws Exception {
        log.info("InsuranceProfileService:patientInsurancesListener::Message: {}", messagePayload);

        /* Build the patient insurances from kafka message. */
        Map<String, Object> patientInsurancesMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        PatientInsurance patientInsurance = buildPatientInsurances(patientInsurancesMessage);

        /* Save or persist the data into the table. */
        dataRepository.save(patientInsurance);
        log.info("PatientInsurance is Saved/Updated for the id: {} ", patientInsurance.getId());
    }

    /**
     * Method to map and save PatientInsurance information.
     *
     * @param patientInsurancesMessage
     * @return PatientInsurance
     * @throws Exception
     */
    private PatientInsurance buildPatientInsurances(Map<String, Object> patientInsurancesMessage) throws ParseException {
        PatientInsurance patientInsurance = new PatientInsurance();
        Integer insuranceProviderId = (Integer) patientInsurancesMessage.get("insurance_provider_id");
        Long l = Long.valueOf(insuranceProviderId);
        Integer patientId = (Integer) patientInsurancesMessage.get("patient_id");
        Long ll = Long.valueOf(patientId);
        long id = new Long((Integer) patientInsurancesMessage.get("id")).longValue();
//        String dd = (String) patientInsurancesMessage.get("subscriber_dob");
        String subscriberDobData = (String) patientInsurancesMessage.get("subscriber_dob");
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        Date subscriberDob = (Date) format.parse(subscriberDobData);

        patientInsurance.setId(id);
        patientInsurance.setSubscriberState((String) patientInsurancesMessage.get("subscriber_state"));
        patientInsurance.setSubscriberDob(subscriberDob);
        patientInsurance.setSubscriberAddressLine1((String) patientInsurancesMessage.get("subscriber_address_line1"));
        patientInsurance.setPolicyNumber((String) patientInsurancesMessage.get("policy_number"));
        patientInsurance.setWorkPhoneNumber((String) patientInsurancesMessage.get("work_phone_number"));
        patientInsurance.setAssignBenefitsToPatient((boolean) patientInsurancesMessage.get("assign_benefits_to_patient"));
        patientInsurance.setHomePhoneNumber((String) patientInsurancesMessage.get("home_phone_number"));
        patientInsurance.setSubscriberRelationshipId((Integer) patientInsurancesMessage.get("subscriber_relationship_id"));
        patientInsurance.setSubscriberLastname((String) patientInsurancesMessage.get("subscriber_lastname"));
        patientInsurance.setPrecertificationFaxNumber((String) patientInsurancesMessage.get("precertification_fax_number"));
        patientInsurance.setGroupName((String) patientInsurancesMessage.get("group_name"));
        patientInsurance.setInsuranceProviderId(BigInteger.valueOf(l));
        patientInsurance.setMedicareInsuranceTypeCode((String) patientInsurancesMessage.get("medicare_insurance_type_code"));
        patientInsurance.setSubscriberZipcode((String) patientInsurancesMessage.get("subscriber_zipcode"));
        patientInsurance.setCoverageLevel((String) patientInsurancesMessage.get("coverage_level"));
        patientInsurance.setSubscriberNameSuffix((String) patientInsurancesMessage.get("subscriber_name_suffix"));
        patientInsurance.setGroupNumber((String) patientInsurancesMessage.get("group_number"));
        patientInsurance.setPatientId(BigInteger.valueOf(ll));
        patientInsurance.setSubscriberCity((String) patientInsurancesMessage.get("subscriber_city"));
        patientInsurance.setSubscriberMiddlename((String) patientInsurancesMessage.get("subscriber_middlename"));
        patientInsurance.setSubscriberFirstname((String) patientInsurancesMessage.get("subscriber_firstname"));
        patientInsurance.setSubscriberGender((String) patientInsurancesMessage.get("subscriber_gender"));
        patientInsurance.setPrecertificationPhoneNumber((String) patientInsurancesMessage.get("precertification_phone_number"));

        return patientInsurance;
    }
}
