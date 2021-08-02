package com.cdi.domain.model;

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
 * User entity is used to map the data of
 * <p>
 * <i> <b>Table = users </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "users", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User extends BaseEntity {

    @Column(name = "ad_user_id")
    private int adUserId;

    @Column(name = "all_facilities")
    private boolean allFacilities;

    @Nationalized
    @Column(name = "chat_status")
    private String chatStatus;

    @Column(name = "company_id")
    private int companyId;

    @Column(name = "default_facility_id")
    private int defaultFacilityId;

    @Column(name = "deleted_dt")
    private OffsetDateTime deletedDt;

    @Column(name = "expiration_dt")
    private OffsetDateTime expirationDt;

    @Column(name = "facilities")
    private int facilities;

    @Nationalized
    @Column(name = "first_name")
    private String firstName;

    @Nationalized
    @Column(name = "google_id")
    private String googleId;

    @Column(name = "has_deleted")
    private boolean hasDeleted;

    @Column(name = "is_active")
    private boolean isActive;

    @Nationalized
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "LastAction")
    private String lastAction;

    @Column(name = "LastModified")
    private Timestamp lastModified;

    @Nationalized
    @Column(name = "marketing_rep_info")
    private String marketingRepInfo;

    @Nationalized
    @Column(name = "marketing_rep_info_addressline1")
    private String marketingRepInfoAddressline1;

    @Nationalized
    @Column(name = "marketing_rep_info_addressline2")
    private String marketingRepInfoAddressline2;

    @Nationalized
    @Column(name = "marketing_rep_info_city")
    private String marketingRepInfoCity;

    @Nationalized
    @Column(name = "marketing_rep_info_country")
    private String marketingRepInfoCountry;

    @Nationalized
    @Column(name = "marketing_rep_info_email")
    private String marketingRepInfoEmail;

    @Nationalized
    @Column(name = "marketing_rep_info_fax")
    private String marketingRepInfoFax;

    @Nationalized
    @Column(name = "marketing_rep_info_groupname")
    private String marketingRepInfoGroupname;

    @Nationalized
    @Column(name = "marketing_rep_info_markrepvalue")
    private String marketingRepInfoMarkrepvalue;

    @Nationalized
    @Column(name = "marketing_rep_info_mobile")
    private String marketingRepInfoMobile;

    @Nationalized
    @Column(name = "marketing_rep_info_officefax")
    private String marketingRepInfoOfficefax;

    @Nationalized
    @Column(name = "marketing_rep_info_officephone")
    private String marketingRepInfoOfficephone;

    @Nationalized
    @Column(name = "marketing_rep_info_pager")
    private String marketingRepInfoPager;

    @Nationalized
    @Column(name = "marketing_rep_info_phone")
    private String marketingRepInfoPhone;

    @Nationalized
    @Column(name = "marketing_rep_info_state")
    private String marketingRepInfoState;

    @Nationalized
    @Column(name = "marketing_rep_info_zip")
    private String marketingRepInfoZip;

    @Nationalized
    @Column(name = "marketing_rep_info_zipplus")
    private String marketingRepInfoZipplus;

    @Nationalized
    @Column(name = "middle_initial")
    private String middleInitial;

    @Nationalized
    @Column(name = "one_time_access")
    private boolean oneTimeAccess;

    @Column(name = "ordering_facilities")
    private int orderingFacilities;

    @Nationalized
    @Column(name = "password")
    private String password;

    @Column(name = "password_changed_dt")
    private OffsetDateTime passwordChangedDt;

    @Nationalized
    @Column(name = "permissions")
    private String permissions;

    @Column(name = "provider_id")
    private int providerId;

    @Nationalized
    @Column(name = "salt")
    private String salt;

    @Nationalized
    @Column(name = "suffix")
    private String suffix;

    @Column(name = "user_group_id")
    private int userGroupId;

    @Nationalized
    @Column(name = "user_permissions")
    private String userPermissions;

    @Nationalized
    @Column(name = "user_permissions_ordering_facility")
    private String userPermissionsOrderingFacility;

    @Nationalized
    @Column(name = "user_settings")
    private String userSettings;

    @Nationalized
    @Column(name = "user_settings_all_ord_facilities")
    private String userSettingsAllOrdFacilities;

    @Nationalized
    @Column(name = "user_settings_allowemergencyaccess")
    private String userSettingsAllowemergencyaccess;

    @Nationalized
    @Column(name = "user_settings_assignclaimstofollowupqueue")
    private String userSettingsAssignclaimstofollowupqueue;

    @Nationalized
    @Column(name = "user_settings_culture")
    private String userSettingsCulture;

    @Nationalized
    @Column(name = "user_settings_dragon360")
    private String userSettingsDragon360;

    @Nationalized
    @Column(name = "user_settings_enableemergencyaccess")
    private String userSettingsEnableemergencyaccess;

    @Nationalized
    @Column(name = "user_settings_hideordermenu")
    private String userSettingsHideordermenu;

    @Nationalized
    @Column(name = "user_settings_rowstodisplay")
    private String userSettingsRowstodisplay;

    @Nationalized
    @Column(name = "user_settings_scheduledby")
    private String userSettingsScheduledby;

    @Nationalized
    @Column(name = "user_settings_searchbyassociatedpatients")
    private String userSettingsSearchbyassociatedpatients;

    @Nationalized
    @Column(name = "user_settings_searchbyassociatedproviders")
    private String userSettingsSearchbyassociatedproviders;

    @Nationalized
    @Column(name = "user_settings_sessioninterval")
    private String userSettingsSessioninterval;

    @Nationalized
    @Column(name = "user_settings_theme")
    private String userSettingsTheme;

    @Nationalized
    @Column(name = "user_settings_third_party_tools")
    private String userSettingsThirdPartyTools;

    @Nationalized
    @Column(name = "user_settings_usercanchangeaccountingdates")
    private String userSettingsUsercanchangeaccountingdates;

    @Nationalized
    @Column(name = "user_settings_usermustchangepassword")
    private String userSettingsUsermustchangepassword;

    @Nationalized
    @Column(name = "user_source")
    private String userSource;

    @Nationalized
    @Column(name = "user_type")
    private String userType;

    @Nationalized
    @Column(name = "username")
    private String username;

    @Nationalized
    @Column(name = "viewer_config")
    private String viewerConfig;

    @Nationalized
    @Column(name = "viewer_config_modalityoptions")
    private String viewerConfigModalityoptions;

    @Nationalized
    @Column(name = "viewer_config_viewoptions")
    private String viewerConfigViewoptions;
}
