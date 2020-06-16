//package com.di.poc.model;
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.sql.Timestamp;
//
///**
// * AppointmentType entity is used to map the data of
// * <p>
// * <i> <b>Table = appointment_types </b> under <br/>
// * <b>Schema = trans_data </b> with in the enterprise application. </i>
// * </p>
// *
// * @author Ravi
// * @CopyRight (C) All rights reserved to Ravi POC World Inc. It's Illegal to reproduce this code.
// */
//@Entity
//@Table(name = "appointment_types", schema = "trans_data")
//@Data
//@NoArgsConstructor
//public class AppointmentType  {
//	@Id
//	@Column(name = "id")
//	private int id;
//
//	@Column(name="code")
//	private Object code;
//
//	@Column(name="description")
//	private Object description;
//
//	@Column(name="duration")
//	private int duration;
//
//	@Column(name="ref_code")
//	private String refCode;
//
//	@Column(name="name")
//	private String name;
//
//	@Column(name="exam_count")
//	private int examCount;
//
//	@Column(name="exam_prep_instructions")
//	private Object examPrepInstructions;
//
//	@Column(name="facility_ids")
//	private Object facilityIds;
//
//	@Column(name="is_active")
//	private boolean isActive;
//
//	@Column(name="is_group_appt")
//	private boolean isGroupAppt;
//
//	private Object keywords;
//
//	@Column(name="lead_time")
//	private Timestamp leadTime;
//
//	@Column(name="modality_ids")
//	private Object modalityIds;
//
//	@Column(name="modality_room_durations")
//	private Object modalityRoomDurations;
//
//	@Column(name="modality_room_ids")
//	private Object modalityRoomIds;
//
//}