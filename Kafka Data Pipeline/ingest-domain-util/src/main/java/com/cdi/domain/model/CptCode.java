package com.cdi.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * CptCode entity is used to map the data of
 * <p>
 * <i> <b>Table = cpt_codes </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "cpt_codes", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class CptCode extends BaseEntity {

    @Nationalized
    @Column(name="additional_info")
    private String additionalInfo;

    @Nationalized
    @Column(name="additional_info_collection")
    private String additionalInfoCollection;

    @Nationalized
    @Column(name="additional_info_friday_exam")
    private String additionalInfoFridayExam;

    @Nationalized
    @Column(name="additional_info_global_fee")
    private String additionalInfoGlobalFee;

    @Nationalized
    @Column(name="additional_info_handling_instructions")
    private String additionalInfoHandlingInstructions;

    @Nationalized
    @Column(name="additional_info_modifier")
    private String additionalInfoModifier;

    @Nationalized
    @Column(name="additional_info_monday_exam")
    private String additionalInfoMondayExam;

    @Nationalized
    @Column(name="additional_info_ndc_code")
    private String additionalInfoNdcCode;

    @Nationalized
    @Column(name="additional_info_ndc_measure")
    private String additionalInfoNdcMeasure;

    @Nationalized
    @Column(name="additional_info_preferred_container")
    private String additionalInfoPreferredContainer;

    @Nationalized
    @Column(name="additional_info_prof_fee")
    private String additionalInfoProfFee;

    @Nationalized
    @Column(name="additional_info_requires_copay")
    private String additionalInfoRequiresCopay;

    @Nationalized
    @Column(name="additional_info_requires_physician")
    private String additionalInfoRequiresPhysician;

    @Nationalized
    @Column(name="additional_info_sample_type")
    private String additionalInfoSampleType;

    @Nationalized
    @Column(name="additional_info_sample_volume")
    private String additionalInfoSampleVolume;

    @Nationalized
    @Column(name="additional_info_saturday_exam")
    private String additionalInfoSaturdayExam;

    @Nationalized
    @Column(name="additional_info_service_Type")
    private String additionalInfoServiceType;

    @Nationalized
    @Column(name="additional_info_specimen_stability")
    private String additionalInfoSpecimenStability;

    @Nationalized
    @Column(name="additional_info_sunday_exam")
    private String additionalInfoSundayExam;

    @Nationalized
    @Column(name="additional_info_tech_fee")
    private String additionalInfoTechFee;

    @Nationalized
    @Column(name="additional_info_thursday_exam")
    private String additionalInfoThursdayExam;

    @Nationalized
    @Column(name="additional_info_transport")
    private String additionalInfoTransport;

    @Nationalized
    @Column(name="additional_info_tuesday_exam")
    private String additionalInfoTuesdayExam;

    @Nationalized
    @Column(name="additional_info_wednesday_exam")
    private String additionalInfoWednesdayExam;

    @Nationalized
    @Column(name="ae_types")
    private String aeTypes;

    @Nationalized
    @Column(name="body_part")
    private String bodyPart;

    @Nationalized
    @Column(name="code_type")
    private String codeType;

    @Nationalized
    @Column(name="color_code")
    private String colorCode;

    @Nationalized
    @Column(name="company_id")
    private int companyId;

    @Nationalized
    @Column(name="created_dt")
    private Timestamp createdDt;

    @Nationalized
    @Column(name="deleted_dt")
    private String deletedDt;

    @Nationalized
    @Column(name="display_code")
    private String displayCode;

    @Nationalized
    @Column(name="display_description")
    private String displayDescription;

    @Column(name="duration")
    private int duration;

    @Nationalized
    @Column(name="exam_prep_instructions")
    private String examPrepInstructions;

    @Nationalized
    @Column(name="facilities")
    private String facilities;

    @Column(name="facility_id")
    private int facilityId;

    @Column(name="has_deleted")
    private boolean hasDeleted;

    @Nationalized
    @Column(name="icd_codes")
    private String icdCodes;

    @Column(name="is_active")
    private boolean isActive;

    @Column(name="is_batch")
    private boolean isBatch;

    @Column(name="is_default")
    private boolean isDefault;

    @Column(name="is_mammo_cpt")
    private boolean isMammoCpt;

    @Column(name="is_non_transcribable")
    private boolean isNonTranscribable;

    @Column(name="LastAction")
    private String lastAction;

    @Column(name="LastModified")
    private Timestamp lastModified;

    @Nationalized
    @Column(name="linked_cpt_codes")
    private String linkedCptCodes;

    @Column(name="linked_cpt_ids")
    private int linkedCptIds;

    @Nationalized
    @Column(name="mammo_type")
    private String mammoType;

    @Nationalized
    @Column(name="modalities")
    private String modalities;

    @Column(name="mwl_modalities")
    private String mwlModalities;

    @Nationalized
    @Column(name="notes")
    private String notes;

    @Nationalized
    @Column(name="orientation")
    private String orientation;

    @Nationalized
    @Column(name="ref_code")
    private String refCode;

    @Nationalized
    @Column(name="require_waiting_time")
    private String requireWaitingTime;

    @Nationalized
    @Column(name="require_waiting_time_hours")
    private String requireWaitingTimeHours;

    @Nationalized
    @Column(name="require_waiting_time_mins")
    private String requireWaitingTimeMins;

    @Column(name="ruv")
    private BigDecimal rvu;

    @Column(name="sde_study")
    private boolean sdeStudy;

    @Nationalized
    @Column(name="short_description")
    private String shortDescription;

    @Nationalized
    @Column(name="units")
    private String units;

    @Nationalized
    @Column(name="vehicle_id")
    private String vehicleId;

    @Nationalized
    @Column(name="waiting_time_days")
    private String waitingTimeDays;
}
