//package com.dp.poc.model;
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.io.Serializable;
//import javax.persistence.*;
//import java.sql.Time;
//import java.util.Date;
//import java.sql.Timestamp;
//import java.sql.Array;
//
///**
// * ModalityRoom entity is used to map the data of
// * <p>
// * <i> <b>Table = modality_rooms </b> under <br/>
// * <b>Schema = poc_catalog </b> with in the enterprise application. </i>
// * </p>
// *
// * @author Ravi
// * @CopyRight (C) All rights reserved to Ravi POC World Inc. It's Illegal to reproduce this code.
// */
//@Entity
//@Table(name = "modality_rooms", schema = "poc_catalog")
//@Data
//@NoArgsConstructor
//public class ModalityRoom {
//
//	@Id
//	@Column(name = "id")
//	private Integer id;
//
//	@Column(name="allow_scheduling")
//	private Boolean allowScheduling;
//
//	@Column(name="application_entity_id")
//	private Array applicationEntityId;
//
//	@Column(name="color_code")
//	private String colorCode;
//
//	@Column(name="deleted_dt")
//	private Timestamp deletedDt;
//
//	@Column(name="display_order")
//	private Integer displayOrder;
//
//	@Column(name="facility_id")
//	private Integer facilityId;
//
//	@Column(name="fri_from_time")
//	private Time friFromTime;
//
//	@Column(name="fri_to_time")
//	private Time friToTime;
//
//	@Temporal(TemporalType.DATE)
//	@Column(name="from_date")
//	private Date fromDate;
//
//	@Column(name="has_deleted")
//	private Boolean hasDeleted;
//
//	@Column(name="is_active")
//	private Boolean isActive;
//
//	@Column(name="modalities")
//	private Array modalities;
//
//	@Column(name="modality_room_code")
//	private String modalityRoomCode;
//
//	@Column(name="modality_room_name")
//	private String modalityRoomName;
//
//	@Column(name="mon_from_time")
//	private Time monFromTime;
//
//	@Column(name="mon_to_time")
//	private Time monToTime;
//
//	@Column(name="more_info")
//	private Object moreInfo;
//
//	@Column(name="sat_from_time")
//	private Time satFromTime;
//
//	@Column(name="sat_to_time")
//	private Time satToTime;
//
//	@Column(name="sun_from_time")
//	private Time sunFromTime;
//
//	@Column(name="sun_to_time")
//	private Time sunToTime;
//
//	@Column(name="thu_from_time")
//	private Time thuFromTime;
//
//	@Column(name="thu_to_time")
//	private Time thuToTime;
//
//	@Temporal(TemporalType.DATE)
//	@Column(name="to_date")
//	private Date toDate;
//
//	@Column(name="tue_from_time")
//	private Time tueFromTime;
//
//	@Column(name="tue_to_time")
//	private Time tueToTime;
//
//	@Column(name="wed_from_time")
//	private Time wedFromTime;
//
//	@Column(name="wed_to_time")
//	private Time wedToTime;
//
//}