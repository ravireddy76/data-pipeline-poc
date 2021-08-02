package com.cdi.di.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.time.OffsetDateTime;

/**
 * ProviderContact entity is used to map the data of
 * <p>
 * <i> <b>Table = provider_contacts </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "provider_contacts", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProviderContact extends BaseEntity {

    @Column(name = "cc_notifications")
    private boolean ccNotifications;

    @Nationalized
    @Column(name = "contact_info")
    private String contactInfo;

    @Nationalized
    @Column(name = "contact_info_addr1")
    private String contactInfoAddr1;

    @Nationalized
    @Column(name = "contact_info_addr2")
    private String contactInfoAddr2;

    @Nationalized
    @Column(name = "contact_info_city")
    private String contactInfoCity;

    @Nationalized
    @Column(name = "contact_info_country")
    private String contactInfoCountry;

    @Nationalized
    @Column(name = "contact_info_delivery_cd")
    private String contactInfoDeliveryCd;

    @Nationalized
    @Column(name = "contact_info_delivery_film")
    private String contactInfoDeliveryFilm;

    @Nationalized
    @Column(name = "contact_info_delivery_paper")
    private String contactInfoDeliveryPaper;

    @Nationalized
    @Column(name = "contact_info_email")
    private String contactInfoEmail;

    @Nationalized
    @Column(name = "contact_info_fax_me")
    private String contactInfoFaxMe;

    @Nationalized
    @Column(name = "contact_info_faxno")
    private String contactInfoFaxno;

    @Nationalized
    @Column(name = "contact_info_meprinter")
    private String contactInfoMeprinter;

    @Nationalized
    @Column(name = "contact_info_mobno")
    private String contactInfoMobno;

    @Nationalized
    @Column(name = "contact_info_name")
    private String contactInfoName;

    @Nationalized
    @Column(name = "contact_info_offaxno")
    private String contactInfoOffaxno;

    @Nationalized
    @Column(name = "contact_info_officefax_me")
    private String contactInfoOfficefaxMe;

    @Nationalized
    @Column(name = "contact_info_ofphno")
    private String contactInfoOfphno;

    @Nationalized
    @Column(name = "contact_info_pagrno")
    private String contactInfoPagrno;

    @Nationalized
    @Column(name = "contact_info_phno")
    private String contactInfoPhno;

    @Nationalized
    @Column(name = "contact_info_provideralerts")
    private String contactInfoProvideralerts;

    @Nationalized
    @Column(name = "contact_info_report_password")
    private String contactInfoReportPassword;

    @Nationalized
    @Column(name = "contact_info_state")
    private String contactInfoState;

    @Nationalized
    @Column(name = "contact_info_state_name")
    private String contactInfoStateName;

    @Nationalized
    @Column(name = "contact_info_zip")
    private String contactInfoZip;

    @Nationalized
    @Column(name = "contact_info_zipplus")
    private String contactInfoZipplus;

    @Column(name = "deleted_dt")
    private OffsetDateTime deletedDt;

    @Column(name = "has_deleted")
    private boolean hasDeleted;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "is_primary")
    private boolean isPrimary;

    @Column(name = "lastaction")
    private String lastaction;

    @Column(name = "lastmodified")
    private Timestamp lastmodified;

    @Column(name = "marketing_rep_id")
    private int marketingRepId;

    @Nationalized
    @Column(name = "provider_contact_code")
    private String providerContactCode;

    @Column(name = "provider_group_id")
    private int providerGroupId;

    @Column(name = "provider_id")
    private int providerId;
}
