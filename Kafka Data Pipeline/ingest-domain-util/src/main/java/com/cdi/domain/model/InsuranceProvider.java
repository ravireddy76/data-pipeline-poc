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
 * InsuranceProvider entity is used to map the data of
 * <p>
 * <i> <b>Table = insurance_providers </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "insurance_providers", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class InsuranceProvider extends BaseEntity {

    @Nationalized
    @Column(name="alert")
    private String alert;

    @Column(name="all_facilities")
    private boolean allFacilities;

    @Column(name="allowed_fee_schedule_id")
    private long allowedFeeScheduleId;

    @Column(name="billing_fee_schedule_id")
    private long billingFeeScheduleId;

    @Column(name="company_id")
    private int companyId;

    @Column(name="deleted_dt")
    private OffsetDateTime deletedDt;

    @Column(name="facility_id")
    private int facilityId;

    @Column(name="fee_schedule_id")
    private long feeScheduleId;

    @Column(name="has_deleted")
    private boolean hasDeleted;

    @Nationalized
    @Column(name="insurance_code")
    private String insuranceCode;

    @Nationalized
    @Column(name="insurance_info")
    private String insuranceInfo;

    @Nationalized
    @Column(name="insurance_info_address1")
    private String insuranceInfoAddress1;

    @Nationalized
    @Column(name="insurance_info_address2")
    private String insuranceInfoAddress2;

    @Nationalized
    @Column(name="insurance_info_authchcode")
    private String insuranceInfoAuthchcode;

    @Nationalized
    @Column(name="insurance_info_authchdescription")
    private String insuranceInfoAuthchdescription;

    @Nationalized
    @Column(name="insurance_info_authclearinghouse")
    private String insuranceInfoAuthclearinghouse;

    @Nationalized
    @Column(name="insurance_info_authrequesttemplate")
    private String insuranceInfoAuthrequesttemplate;

    @Nationalized
    @Column(name="insurance_info_authrequesttemplatetype")
    private String insuranceInfoAuthrequesttemplatetype;

    @Nationalized
    @Column(name="insurance_info_b2breceiver")
    private String insuranceInfoB2breceiver;

    @Nationalized
    @Column(name="insurance_info_billingmethod")
    private String insuranceInfoBillingmethod;

    @Nationalized
    @Column(name="insurance_info_billingmethodby")
    private String insuranceInfoBillingmethodby;

    @Nationalized
    @Column(name="insurance_info_billingmethodtype")
    private String insuranceInfoBillingmethodtype;

    @Nationalized
    @Column(name="insurance_info_city")
    private String insuranceInfoCity;

    @Nationalized
    @Column(name="insurance_info_claim_req_temp_prov")
    private String insuranceInfoClaimReqTempProv;

    @Nationalized
    @Column(name="insurance_info_claim_req_type_prov")
    private String insuranceInfoClaimReqTypeProv;

    @Nationalized
    @Column(name="insurance_info_claimchcode")
    private String insuranceInfoClaimchcode;

    @Nationalized
    @Column(name="insurance_info_claimchdescription")
    private String insuranceInfoClaimchdescription;

    @Nationalized
    @Column(name="insurance_info_claimclearinghouse")
    private String insuranceInfoClaimclearinghouse;

    @Nationalized
    @Column(name="insurance_info_claimrequesttemplate")
    private String insuranceInfoClaimrequesttemplate;

    @Nationalized
    @Column(name="insurance_info_claimrequesttemplatetype")
    private String insuranceInfoClaimrequesttemplatetype;

    @Nationalized
    @Column(name="insurance_info_country")
    private String insuranceInfoCountry;

    @Nationalized
    @Column(name="insurance_info_eligibilitychcode")
    private String insuranceInfoEligibilitychcode;

    @Nationalized
    @Column(name="insurance_info_eligibilitychdescription")
    private String insuranceInfoEligibilitychdescription;

    @Nationalized
    @Column(name="insurance_info_eligibilityclearinghouse")
    private String insuranceInfoEligibilityclearinghouse;

    @Nationalized
    @Column(name="insurance_info_eligibilityrequesttemplate")
    private String insuranceInfoEligibilityrequesttemplate;

    @Nationalized
    @Column(name="insurance_info_eligibilityrequesttemplatetype")
    private String insuranceInfoEligibilityrequesttemplatetype;

    @Nationalized
    @Column(name="insurance_info_extraphone1")
    private String insuranceInfoExtraphone1;

    @Nationalized
    @Column(name="insurance_info_extraphone1refnote")
    private String insuranceInfoExtraphone1refnote;

    @Nationalized
    @Column(name="insurance_info_extraphone2")
    private String insuranceInfoExtraphone2;

    @Nationalized
    @Column(name="insurance_info_extraphone2refnote")
    private String insuranceInfoExtraphone2refnote;

    @Nationalized
    @Column(name="insurance_info_extraphone3")
    private String insuranceInfoExtraphone3;

    @Nationalized
    @Column(name="insurance_info_extraphone3refnote")
    private String insuranceInfoExtraphone3refnote;

    @Nationalized
    @Column(name="insurance_info_faxNo")
    private String insuranceInfoFaxNo;

    @Nationalized
    @Column(name="insurance_info_isbatchmode")
    private String insuranceInfoIsbatchmode;

    @Nationalized
    @Column(name="insurance_info_iselectronicauthorization")
    private String insuranceInfoIselectronicauthorization;

    @Nationalized
    @Column(name="insurance_info_iselectronicverification")
    private String insuranceInfoIselectronicverification;

    @Nationalized
    @Column(name="insurance_info_ismedicarepayer")
    private String insuranceInfoIsmedicarepayer;

    @Nationalized
    @Column(name="insurance_info_isrealtime")
    private String insuranceInfoIsrealtime;

    @Nationalized
    @Column(name="insurance_info_legacytype")
    private String insuranceInfoLegacytype;

    @Nationalized
    @Column(name="insurance_info_medicareinsurancetype")
    private String insuranceInfoMedicareinsurancetype;

    @Nationalized
    @Column(name="insurance_info_medigapnumber")
    private String insuranceInfoMedigapnumber;

    @Nationalized
    @Column(name="insurance_info_partner_id")
    private String insuranceInfoPartnerId;

    @Nationalized
    @Column(name="insurance_info_payerid")
    private String insuranceInfoPayerid;

    @Nationalized
    @Column(name="insurance_info_phoneno")
    private String insuranceInfoPhoneno;

    @Nationalized
    @Column(name="insurance_info_soppayer")
    private String insuranceInfoSoppayer;

    @Nationalized
    @Column(name="insurance_info_state")
    private String insuranceInfoState;

    @Nationalized
    @Column(name="insurance_info_uselegacyid")
    private String insuranceInfoUselegacyid;

    @Nationalized
    @Column(name="insurance_info_website")
    private String insuranceInfoWebsite;

    @Nationalized
    @Column(name="insurance_info_zipcode")
    private String insuranceInfoZipcode;

    @Nationalized
    @Column(name="insurance_info_zipplus")
    private String insuranceInfoZipplus;

    @Nationalized
    @Column(name="insurance_name")
    private String insuranceName;

    @Column(name="is_active")
    private boolean isActive;

    @Column(name="LastAction")
    private String lastAction;

    @Column(name="LastModified")
    private Timestamp lastModified;

    @Column(name="provider_payer_type_id")
    private long providerPayerTypeId;

}
