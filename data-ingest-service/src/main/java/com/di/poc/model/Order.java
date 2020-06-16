package com.di.poc.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Order entity is used to map the data of
 * <p>
 * <i> <b>Table = orders </b> under <br/>
 * <b>Schema = trans_data </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to Ravi POC World Inc. It's Illegal to reproduce this code.
 */
@Entity
@Table(name = "orders", schema = "trans_data")
@Data
@NoArgsConstructor
public class Order {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "aa")
    private Object aa;

    @Column(name = "appontmentReminder")
    private Object appontmentReminder;

    @Column(name = "cognitiveStatus")
    private Object cognitiveStatus;

    @Column(name = "company_id")
    private int companyId;

    @Column(name = "cpt_codes")
    private Object cptCodes;

    @Column(name = "createdby")
    private Object createdby;

    @Column(name = "currentDate")
    private Object currentDate;

    @Column(name = "deleted_dt")
    private Timestamp deletedDt;

    @Column(name = "dischargeInstructions")
    private Object dischargeInstructions;

    @Column(name = "dispatch_address")
    private Object dispatchAddress;

    @Column(name = "dispatch_contact_name")
    private Object dispatchContactName;

    @Column(name = "dispatch_contact_number")
    private Object dispatchContactNumber;

    @Column(name = "duration")
    private int duration;

    @Column(name = "emp")
    private Object emp;

    @Column(name = "facility_id")
    private int facilityId;

    @Column(name = "functionalStatus")
    private Object functionalStatus;

    @Column(name = "google_job_id")
    private Object googleJobId;

    @Column(name = "has_approved")
    private boolean hasApproved;

    @Column(name = "has_rescheduled")
    private boolean hasRescheduled;

    @Column(name = "history_info")
    private Object historyInfo;

    @Column(name = "icd_codes")
    private Object icdCodes;

    @Column(name = "in_hold")
    private boolean inHold;

    @Column(name = "is_quick_appt")
    private boolean isQuickAppt;

    @Column(name = "is_rejected")
    private Object isRejected;

    @Column(name = "isMedicationReconciliation")
    private Object isMedicationReconciliation;

    @Column(name = "isPreOrder")
    private Object isPreOrder;

    @Column(name = "isquickappt_from")
    private Object isquickapptFrom;

    @Column(name = "jos")
    private Object jos;

    @Column(name = "lastMuUpdatedBy")
    private Object lastMuUpdatedBy;

    @Column(name = "linked_rad_orders")
    private Object linkedRadOrders;

    @Column(name = "modality_id")
    private int modalityId;

    @Column(name = "modality_room_id")
    private int modalityRoomId;

    @Column(name = "mu_last_updated")
    private Timestamp muLastUpdated;

    @Column(name = "mu_passed")
    private boolean muPassed;

    @Column(name = "mu_validation_data")
    private Object muValidationData;

    @Column(name = "oa")
    private Object oa;

    @Column(name = "order_guid")
    private Object orderGuid;

    @Column(name = "order_source")
    private Object orderSource;

    @Column(name = "order_status")
    private Object orderStatus;

    @Column(name = "order_status_desc")
    private Object orderStatusDesc;

    @Column(name = "order_status_last_changed_by")
    private int orderStatusLastChangedBy;

    @Column(name = "order_status_last_changed_dt")
    private Timestamp orderStatusLastChangedDt;

    @Column(name = "order_type")
    private Object orderType;

    @Column(name = "orderContact")
    private Object orderContact;

    @Column(name = "ordered_by")
    private int orderedBy;

    @Column(name = "ordered_dt")
    private Timestamp orderedDt;

    @Column(name = "ordering_facility")
    private Object orderingFacility;

    @Column(name = "ordering_facility_id")
    private Object orderingFacilityId;

    @Column(name = "ordering_providers")
    private Object orderingProviders;

    @Column(name = "patient_age")
    private Object patientAge;

    @Column(name = "patient_id")
    private long patientId;

    @Column(name = "patientCondition")
    private Object patientCondition;

    @Column(name = "patientEmail")
    private Object patientEmail;

    @Column(name = "patientLocation")
    private Object patientLocation;

    @Column(name = "patientRoom")
    private Object patientRoom;

    @Column(name = "phy_order_status")
    private Object phyOrderStatus;

    @Column(name = "pos")
    private Object pos;

    @Column(name = "pos_map_code")
    private Object posMapCode;

    @Column(name = "pos_type_code")
    private Object posTypeCode;

    @Column(name = "primary_patient_insurance_id")
    private long primaryPatientInsuranceId;

    @Column(name = "provider_id")
    private int providerId;

    @Column(name = "reading_providers")
    private Object readingProviders;

    @Column(name = "referralNo")
    private Object referralNo;

    @Column(name = "referring_provider_ids")
    private Object referringProviderIds;

    @Column(name = "referring_providerloginID")
    private Object referring_providerloginID;

    @Column(name = "referring_providers")
    private Object referringProviders;

    @Column(name = "requestingDate")
    private Object requestingDate;

    @Column(name = "scheduled_date")
    private Object scheduledDate;

    @Column(name = "scheduled_dt")
    private Timestamp scheduledDt;

    @Column(name = "secondary_patient_insurance_id")
    private long secondaryPatientInsuranceId;

    @Column(name = "source")
    private Object source;

    @Column(name = "stat")
    private Object stat;

    @Column(name = "technologist_id")
    private int technologistId;

    @Column(name = "technologist_name")
    private Object technologistName;

    @Column(name = "tertiary_patient_insurance_id")
    private long tertiaryPatientInsuranceId;

    @Column(name = "transactionCareIn")
    private Object transactionCareIn;

    @Column(name = "transport")
    private Object transport;

    @Column(name = "vehicle_id")
    private int vehicleId;

    @Column(name = "vehicle_name")
    private Object vehicleName;

    @Column(name = "visit_no")
    private Object visitNo;

}