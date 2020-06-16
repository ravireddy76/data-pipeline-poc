package com.di.poc.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

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

    @Nationalized
    @Column(name = "aa")
    private String aa;

    @Nationalized
    @Column(name = "appontmentReminder")
    private String appontmentReminder;

    @Nationalized
    @Column(name = "cognitiveStatus")
    private String cognitiveStatus;

    @Column(name = "company_id")
    private int companyId;

    @Nationalized
    @Column(name = "cpt_codes")
    private String cptCodes;

    @Nationalized
    @Column(name = "createdby")
    private String createdby;

    @Nationalized
    @Column(name = "currentDate")
    private String currentDate;

    @Column(name = "deleted_dt")
    private Timestamp deletedDt;

    @Nationalized
    @Column(name = "dischargeInstructions")
    private String dischargeInstructions;

    @Nationalized
    @Column(name = "dispatch_address")
    private String dispatchAddress;

    @Nationalized
    @Column(name = "dispatch_contact_name")
    private String dispatchContactName;

    @Nationalized
    @Column(name = "dispatch_contact_number")
    private String dispatchContactNumber;

    @Column(name = "duration")
    private int duration;

    @Nationalized
    @Column(name = "emp")
    private String emp;

    @Column(name = "facility_id")
    private int facilityId;

    @Nationalized
    @Column(name = "functionalStatus")
    private String functionalStatus;

    @Nationalized
    @Column(name = "google_job_id")
    private String googleJobId;

    @Column(name = "has_approved")
    private boolean hasApproved;

    @Column(name = "has_rescheduled")
    private boolean hasRescheduled;

    @Nationalized
    @Column(name = "history_info")
    private String historyInfo;

    @Nationalized
    @Column(name = "icd_codes")
    private String icdCodes;

    @Column(name = "in_hold")
    private boolean inHold;

    @Column(name = "is_quick_appt")
    private boolean isQuickAppt;

    @Nationalized
    @Column(name = "is_rejected")
    private String isRejected;

    @Nationalized
    @Column(name = "isMedicationReconciliation")
    private String isMedicationReconciliation;

    @Nationalized
    @Column(name = "isPreOrder")
    private String isPreOrder;

    @Nationalized
    @Column(name = "isquickappt_from")
    private String isquickapptFrom;

    @Nationalized
    @Column(name = "jos")
    private String jos;

    @Nationalized
    @Column(name = "lastMuUpdatedBy")
    private String lastMuUpdatedBy;

    @Nationalized
    @Column(name = "linked_rad_orders")
    private String linkedRadOrders;

    @Column(name = "modality_id")
    private int modalityId;

    @Column(name = "modality_room_id")
    private int modalityRoomId;

    @Column(name = "mu_last_updated")
    private Timestamp muLastUpdated;

    @Column(name = "mu_passed")
    private boolean muPassed;

    @Nationalized
    @Column(name = "mu_validation_data")
    private String muValidationData;

    @Nationalized
    @Column(name = "oa")
    private String oa;

    @Nationalized
    @Column(name = "order_guid")
    private String orderGuid;

    @Nationalized
    @Column(name = "order_source")
    private String orderSource;

    @Nationalized
    @Column(name = "order_status")
    private String orderStatus;

    @Nationalized
    @Column(name = "order_status_desc")
    private String orderStatusDesc;

    @Column(name = "order_status_last_changed_by")
    private int orderStatusLastChangedBy;

    @Column(name = "order_status_last_changed_dt")
    private Timestamp orderStatusLastChangedDt;

    @Nationalized
    @Column(name = "order_type")
    private String orderType;

    @Nationalized
    @Column(name = "orderContact")
    private String orderContact;

    @Column(name = "ordered_by")
    private int orderedBy;

    @Column(name = "ordered_dt")
    private Timestamp orderedDt;

    @Nationalized
    @Column(name = "ordering_facility")
    private String orderingFacility;

    @Nationalized
    @Column(name = "ordering_facility_id")
    private String orderingFacilityId;

    @Nationalized
    @Column(name = "ordering_providers")
    private String orderingProviders;

    @Nationalized
    @Column(name = "patient_age")
    private String patientAge;

    @Column(name = "patient_id")
    private long patientId;

    @Nationalized
    @Column(name = "patientCondition")
    private String patientCondition;

    @Nationalized
    @Column(name = "patientEmail")
    private String patientEmail;

    @Nationalized
    @Column(name = "patientLocation")
    private String patientLocation;

    @Nationalized
    @Column(name = "patientRoom")
    private String patientRoom;

    @Nationalized
    @Column(name = "phy_order_status")
    private String phyOrderStatus;

    @Nationalized
    @Column(name = "pos")
    private String pos;

    @Nationalized
    @Column(name = "pos_map_code")
    private String posMapCode;

    @Nationalized
    @Column(name = "pos_type_code")
    private String posTypeCode;

    @Column(name = "primary_patient_insurance_id")
    private long primaryPatientInsuranceId;

    @Column(name = "provider_id")
    private int providerId;

    @Nationalized
    @Column(name = "reading_providers")
    private String readingProviders;

    @Nationalized
    @Column(name = "referralNo")
    private String referralNo;

    @Nationalized
    @Column(name = "referring_provider_ids")
    private String referringProviderIds;

    @Nationalized
    @Column(name = "referring_providerloginID")
    private String referring_providerloginID;

    @Nationalized
    @Column(name = "referring_providers")
    private String referringProviders;

    @Nationalized
    @Column(name = "requestingDate")
    private String requestingDate;

    @Nationalized
    @Column(name = "scheduled_date")
    private String scheduledDate;

    @Column(name = "scheduled_dt")
    private Timestamp scheduledDt;

    @Column(name = "secondary_patient_insurance_id")
    private long secondaryPatientInsuranceId;

    @Nationalized
    @Column(name = "source")
    private String source;

    @Nationalized
    @Column(name = "stat")
    private String stat;

    @Column(name = "technologist_id")
    private int technologistId;

    @Nationalized
    @Column(name = "technologist_name")
    private String technologistName;

    @Column(name = "tertiary_patient_insurance_id")
    private long tertiaryPatientInsuranceId;

    @Nationalized
    @Column(name = "transactionCareIn")
    private String transactionCareIn;

    @Nationalized
    @Column(name = "transport")
    private String transport;

    @Column(name = "vehicle_id")
    private int vehicleId;

    @Nationalized
    @Column(name = "vehicle_name")
    private String vehicleName;

    @Column(name = "visit_no")
    private String visitNo;

}