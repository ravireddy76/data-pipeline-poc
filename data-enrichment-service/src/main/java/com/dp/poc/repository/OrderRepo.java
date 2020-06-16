package com.dp.poc.repository;

import com.dp.poc.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * OrderRepo class used to query order data by query criteria.
 *
 * @author Ravi Reddy
 * @CopyRight (C) All rights reserved to Ravi POC World Inc. It's Illegal to reproduce this code.
 */
@Repository
@Transactional
public interface OrderRepo extends JpaRepository<Order, Integer> {

    final String QUERY_VALUE = "SELECT \n" +
            "    id,\n" +
            "    patient_id,\n" +
            "    cc_ros,\n" +
            "    facility_id,\n" +
            "    modality_id,\n" +
            "    modality_room_id ,\n" +
            "    ordered_by ,\n" +
            "    order_info ,\n" +
            "    ordered_dt ,\n" +
            "    scheduled_dt ,\n" +
            "    order_type,\n" +
            "    order_status,\n" +
            "    order_status_desc,\n" +
            "\torder_info -> 'aa'as aa,\n" +
            "\torder_info -> 'oa' as oa,\n" +
            "\torder_info -> 'emp' as emp,\n" +
            "\torder_info -> 'jos' as jos,\n" +
            "\torder_info -> 'pos' as pos,\n" +
            "\torder_info -> 'stat' as stat,\n" +
            "\torder_info -> 'source' as source,\n" +
            "\torder_info -> 'visit_no' as visit_no,\n" +
            "\torder_info -> 'createdby' as createdby,\n" +
            "\torder_info -> 'transport' as transport,\n" +
            "\torder_info -> 'isPreOrder' as isPreOrder,\n" +
            "\torder_info -> 'referralNo' as referralNo,\n" +
            "\torder_info -> 'currentDate' as currentDate,\n" +
            "\torder_info -> 'is_rejected' as is_rejected,\n" +
            "\torder_info -> 'patientRoom' as patientRoom,\n" +
            "\torder_info -> 'patient_age' as patient_age,\n" +
            "\torder_info -> 'orderContact' as orderContact,\n" +
            "\torder_info -> 'patientEmail' as patientEmail,\n" +
            "\torder_info -> 'pos_map_code' as pos_map_code,\n" +
            "\torder_info -> 'vehicle_name' as vehicle_name,\n" +
            "\torder_info -> 'google_job_id' as google_job_id,\n" +
            "\torder_info -> 'pos_type_code' as pos_type_code,\n" +
            "\torder_info -> 'requestingDate' as requestingDate,\n" +
            "\torder_info -> 'cognitiveStatus' as cognitiveStatus,\n" +
            "\torder_info -> 'lastMuUpdatedBy' as lastMuUpdatedBy,\n" +
            "\torder_info -> 'patientLocation' as patientLocation,\n" +
            "\torder_info -> 'dispatch_address' as dispatch_address,\n" +
            "\torder_info -> 'functionalStatus' as functionalStatus,\n" +
            "\torder_info -> 'isquickappt_from' as isquickappt_from,\n" +
            "\torder_info -> 'patientCondition' as patientCondition,\n" +
            "\torder_info -> 'phy_order_status' as phy_order_status,\n" +
            "\torder_info -> 'ordering_facility' as ordering_facility,\n" +
            "\torder_info -> 'technologist_name' as technologist_name,\n" +
            "\torder_info -> 'transactionCareIn' as transactionCareIn,\n" +
            "\torder_info -> 'appontmentReminder' as appontmentReminder,\n" +
            "\torder_info -> 'ordering_facility_id' as ordering_facility_id,\n" +
            "\torder_info -> 'dischargeInstructions' as dischargeInstructions,\n" +
            "\torder_info -> 'dispatch_contact_name' as dispatch_contact_name,\n" +
            "\torder_info -> 'dispatch_contact_number' as dispatch_contact_number,\n" +
            "\torder_info -> 'referring_providerloginID' as referring_providerloginID,\n" +
            "\torder_info -> 'isMedicationReconciliation' as isMedicationReconciliation,\n" +
            "    cpt_codes,\n" +
            "    icd_codes,\n" +
            "    referring_provider_ids,\n" +
            "    referring_providers,\n" +
            "    order_guid ,\n" +
            "    order_source,\n" +
            "    is_quick_appt,\n" +
            "    deleted_dt,\n" +
            "    company_id,\n" +
            "    duration,\n" +
            "    scheduled_date,\n" +
            "    in_hold ,\n" +
            "    has_rescheduled ,\n" +
            "    has_approved ,\n" +
            "    provider_id ,\n" +
            "    ordering_providers,\n" +
            "    linked_rad_orders,\n" +
            "    history_info,\n" +
            "    reading_providers,\n" +
            "    vehicle_id,\n" +
            "    technologist_id,\n" +
            "    mu_validation_data,\n" +
            "    mu_passed,\n" +
            "    mu_last_updated,\n" +
            "    primary_patient_insurance_id ,\n" +
            "    secondary_patient_insurance_id ,\n" +
            "    tertiary_patient_insurance_id ,\n" +
            "    order_status_last_changed_by ,\n" +
            "    order_status_last_changed_dt \n" +
            "FROM poc_catalog.orders";


    /**
     * Method to find all queried orders data.
     *
     * @return List
     */
    @Query(value = QUERY_VALUE, nativeQuery = true)
    public List<Order> findOrders();


}
