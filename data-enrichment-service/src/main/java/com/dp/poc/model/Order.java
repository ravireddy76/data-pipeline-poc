package com.dp.poc.model;

import com.vladmihalcea.hibernate.type.array.IntArrayType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLHStoreType;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Order entity is used to map the data of
 * <p>
 * <i> <b>Table = orders </b> under <br/>
 * <b>Schema = poc_catalog </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to Ravi POC World Inc. It's Illegal to reproduce this code.
 */
@Entity
@Table(name = "orders", schema = "poc_catalog")
@Data
@NoArgsConstructor
@TypeDefs({
		@TypeDef(name = "string-array", typeClass = StringArrayType.class),
		@TypeDef(name = "int-array", typeClass = IntArrayType.class),
		@TypeDef(name = "json", typeClass = JsonStringType.class),
		@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class),
        @TypeDef(name = "hstore", typeClass = PostgreSQLHStoreType.class)
})
public class Order {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "cc_ros")
    private String ccRos;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "cpt_codes")
    @ElementCollection(targetClass = String.class)
    private List<String> cptCodes;

    @Column(name = "deleted_dt")
    private Timestamp deletedDt;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "facility_id")
    private Integer facilityId;

    @Column(name = "has_approved")
    private Boolean hasApproved;

    @Column(name = "has_rescheduled")
    private Boolean hasRescheduled;

	@Type(type = "jsonb")
	@Column(name = "history_info", columnDefinition = "jsonb")
    private String historyInfo;

    @Column(name = "icd_codes")
	@ElementCollection(targetClass = String.class)
    private List<String> icdCodes;

    @Column(name = "in_hold")
    private Boolean inHold;

    @Column(name = "is_quick_appt")
    private Boolean isQuickAppt;

    @Column(name = "linked_rad_orders")
	@ElementCollection(targetClass = BigInteger.class)
    private List<BigInteger> linkedRadOrders;

    @Column(name = "modality_id")
    private Integer modalityId;

    @Column(name = "modality_room_id")
    private Integer modalityRoomId;

    @Column(name = "mu_last_updated")
    private Timestamp muLastUpdated;

    @Column(name = "mu_passed")
    private Boolean muPassed;

    @Type(type = "jsonb")
    @Column(name = "mu_validation_data", columnDefinition = "jsonb")
    private Object muValidationData;

    @Column(name = "order_guid")
    private String orderGuid;

    @Type(type = "hstore")
    @Column(name = "order_info", columnDefinition = "hstore")
    private Map<String, String> orderInfo;

    @Column(name = "order_source")
    private String orderSource;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "order_status_desc")
    private String orderStatusDesc;

    @Column(name = "order_status_last_changed_by")
    private Integer orderStatusLastChangedBy;

    @Column(name = "order_status_last_changed_dt")
    private Timestamp orderStatusLastChangedDt;

    @Column(name = "order_type")
    private String orderType;

    @Column(name = "ordered_by")
    private Integer orderedBy;

    @Column(name = "ordered_dt")
    private Timestamp orderedDt;

    @Column(name = "ordering_providers")
	@ElementCollection(targetClass = Integer.class)
    private List<Integer> orderingProviders;

    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "primary_patient_insurance_id")
    private Long primaryPatientInsuranceId;

    @Column(name = "provider_id")
    private Integer providerId;

    @Column(name = "reading_providers")
	@ElementCollection(targetClass = Integer.class)
    private List<Integer> readingProviders;

    @Column(name = "referring_provider_ids")
	@ElementCollection(targetClass = Integer.class)
    private List<Integer> referringProviderIds;

    @Column(name = "referring_providers")
	@ElementCollection(targetClass = String.class)
    private List<String> referringProviders;

    @Temporal(TemporalType.DATE)
    @Column(name = "scheduled_date")
    private Date scheduledDate;

    @Column(name = "scheduled_dt")
    private Timestamp scheduledDt;

    @Column(name = "secondary_patient_insurance_id")
    private Long secondaryPatientInsuranceId;

    @Column(name = "technologist_id")
    private Integer technologistId;

    @Column(name = "tertiary_patient_insurance_id")
    private Long tertiaryPatientInsuranceId;

    @Column(name = "vehicle_id")
    private Integer vehicleId;

}