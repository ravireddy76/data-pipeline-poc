package com.cdi.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.OffsetDateTime;

/**
 * ProviderGroup entity is used to map the data of
 * <p>
 * <i> <b>Table = provider_groups </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "provider_groups", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProviderGroup extends BaseEntity {

    @Column(name = "company_id")
    private int companyId;

    @Column(name = "deleted_dt")
    private OffsetDateTime deletedDt;

    @Column(name = "fee_schedule_id")
    private BigInteger feeScheduleId;

    @Nationalized
    @Column(name = "group_code")
    private String groupCode;

    @Nationalized
    @Column(name = "group_info")
    private String groupInfo;

    @Nationalized
    @Column(name = "group_info_addressline1")
    private String groupInfoAddressline1;

    @Nationalized
    @Column(name = "group_info_addressline2")
    private String groupInfoAddressline2;

    @Nationalized
    @Column(name = "group_info_agreecode")
    private String groupInfoAgreecode;

    @Nationalized
    @Column(name = "group_info_city")
    private String groupInfoCity;

    @Nationalized
    @Column(name = "group_info_clianumber")
    private String groupInfoClianumber;

    @Nationalized
    @Column(name = "group_info_country")
    private String groupInfoCountry;

    @Nationalized
    @Column(name = "group_info_current_linked_resource")
    private String groupInfoCurrentLinkedResource;

    @Nationalized
    @Column(name = "group_info_ein")
    private String groupInfoEin;

    @Nationalized
    @Column(name = "group_info_email")
    private String groupInfoEmail;

    @Nationalized
    @Column(name = "group_info_etin")
    private String groupInfoEtin;

    @Nationalized
    @Column(name = "group_info_fax")
    private String groupInfoFax;

    @Nationalized
    @Column(name = "group_info_federal_tax_id")
    private String groupInfoFederalTaxId;

    @Nationalized
    @Column(name = "group_info_idencode")
    private String groupInfoIdencode;

    @Nationalized
    @Column(name = "group_info_linked_tech_code")
    private String groupInfoLinkedTechCode;

    @Nationalized
    @Column(name = "group_info_linked_tech_id")
    private String groupInfoLinkedTechId;

    @Nationalized
    @Column(name = "group_info_linked_tech_name")
    private String groupInfoLinkedTechName;

    @Nationalized
    @Column(name = "group_info_linked_vechicle_id")
    private String groupInfoLinkedVechicleId;

    @Nationalized
    @Column(name = "group_info_linked_vechicle_name")
    private String groupInfoLinkedVechicleName;

    @Nationalized
    @Column(name = "group_info_madicareupin")
    private String groupInfoMadicareupin;

    @Nationalized
    @Column(name = "group_info_medicaid_provider_number")
    private String groupInfoMedicaidProviderNumber;

    @Nationalized
    @Column(name = "group_info_medicare_provider_number")
    private String groupInfoMedicareProviderNumber;

    @Nationalized
    @Column(name = "group_info_npi_no")
    private String groupInfoNpiNo;

    @Nationalized
    @Column(name = "group_info_phone")
    private String groupInfoPhone;

    @Nationalized
    @Column(name = "group_info_pos_map")
    private String groupInfoPosMap;

    @Nationalized
    @Column(name = "group_info_report_password")
    private String groupInfoReportPassword;

    @Nationalized
    @Column(name = "group_info_sendfax")
    private String groupInfoSendfax;

    @Nationalized
    @Column(name = "group_info_ssn")
    private String groupInfoSsn;

    @Nationalized
    @Column(name = "group_info_state")
    private String groupInfoState;

    @Nationalized
    @Column(name = "group_info_statelicenseno")
    private String groupInfoStatelicenseno;

    @Nationalized
    @Column(name = "group_info_taxonomy_code")
    private String groupInfoTaxonomyCode;

    @Nationalized
    @Column(name = "group_info_zip")
    private String groupInfoZip;

    @Nationalized
    @Column(name = "group_info_zipplus")
    private String groupInfoZipplus;

    @Nationalized
    @Column(name = "group_name")
    private String groupName;

    @Nationalized
    @Column(name = "group_type")
    private String groupType;

    @Column(name = "has_deleted")
    private boolean hasDeleted;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "lastaction")
    private String lastaction;

    @Column(name = "lastmodified")
    private Timestamp lastmodified;

    @Column(name = "marketing_rep_id")
    private int marketingRepId;

    @Column(name = "place_of_service_id")
    private BigInteger placeOfServiceId;
}
