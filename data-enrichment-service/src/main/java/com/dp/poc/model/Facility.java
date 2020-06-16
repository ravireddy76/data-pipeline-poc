//package com.dp.poc.model;
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.io.Serializable;
//import javax.persistence.*;
//import java.sql.Timestamp;
//
///**
// * Facility entity is used to map the data of
// * <p>
// * <i> <b>Table = facilities </b> under <br/>
// * <b>Schema = poc_catalog </b> with in the enterprise application. </i>
// * </p>
// *
// * @author Ravi
// * @CopyRight (C) All rights reserved to Ravi POC World Inc. It's Illegal to reproduce this code.
// */
//@Entity
//@Table(name = "facilities", schema = "poc_catalog")
//@Data
//@NoArgsConstructor
//public class Facility {
//
//    @Id
//	@Column(name = "id")
//    private Integer id;
//
//    @Column(name = "facility_code")
//    private String facilityCode;
//
//    @Column(name = "facility_info")
//    private Object facilityInfo;
//
//    @Column(name = "facility_name")
//    private String facilityName;
//
//    @Column(name = "is_active")
//    private Boolean isActive;
//
//    @Column(name = "deleted_dt")
//    private Timestamp deletedDt;
//
//    @Column(name = "arrival_status_code")
//    private String arrivalStatusCode;
//
//    @Column(name = "company_id")
//    private Integer companyId;
//
//    @Column(name = "enable_veterinary")
//    private Boolean enableVeterinary;
//
//    @Column(name = "file_store_id")
//    private Integer fileStoreId;
//
//    @Column(name = "fee_schedule_id")
//    private Long feeScheduleId;
//
//    @Column(name = "in_room_status_code")
//    private String inRoomStatusCode;
//
//    @Column(name = "max_tat")
//    private Integer maxTat;
//
//    @Column(name = "mrn_info")
//    private Object mrnInfo;
//
//    @Column(name = "mu_validation_fields")
//    private Object muValidationFields;
//
//    @Column(name = "place_of_service_id")
//    private Long placeOfServiceId;
//
//    @Column(name = "study_workflow_locations")
//    private Object studyWorkflowLocations;
//
//    @Column(name = "time_zone")
//    private String timeZone;
//
//}