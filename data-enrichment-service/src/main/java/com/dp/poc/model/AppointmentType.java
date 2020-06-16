//package com.dp.poc.model;
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.sql.Time;
//import java.sql.Array;
//
///**
// * AppointmentType entity is used to map the data of
// * <p>
// * <i> <b>Table = appointment_types </b> under <br/>
// * <b>Schema = poc_catalog </b> with in the enterprise application. </i>
// * </p>
// *
// * @author Ravi
// * @CopyRight (C) All rights reserved to Ravi POC World Inc. It's Illegal to reproduce this code.
// */
//@Entity
//@Table(name = "appointment_types", schema = "poc_catalog")
//@Data
//@NoArgsConstructor
//public class AppointmentType {
//
//	@Id
//	@Column(name = "id")
//	private Integer id;
//
//	@Column(name="code")
//	private String code;
//
//	@Column(name="ref_code")
//	private String refCode;
//
//	@Column(name="name")
//	private String name;
//
//	@Column(name="description")
//	private String description;
//
//	@Column(name="keywords")
//	private String keywords;
//
//	@Column(name="facility_ids")
//	private Array facilityIds;
//
//	@Column(name="modality_ids")
//	private Array modalityIds;
//
//	@Column(name="modality_room_durations")
//	private Array modalityRoomDurations;
//
//	@Column(name="modality_room_ids")
//	private Array modalityRoomIds;
//
//	@Column(name="duration")
//	private Integer duration;
//
//	@Column(name="exam_prep_instructions")
//	private String examPrepInstructions;
//
//	@Column(name="is_active")
//	private Boolean isActive;
//
//	@Column(name="is_group_appt")
//	private Boolean isGroupAppt;
//
//	@Column(name="exam_count")
//	private Integer examCount;
//
//	@Column(name="lead_time")
//	private Time leadTime;
//
//}