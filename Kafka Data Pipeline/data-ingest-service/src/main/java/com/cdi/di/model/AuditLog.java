package com.cdi.di.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * AuditLog entity is used to map the data of
 * <p>
 * <i> <b>Table = audit_log </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name="audit_log", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class AuditLog extends BaseEntity {

    @Nationalized
    @Column(name="audit_info")
    private String auditInfo;

    @Nationalized
    @Column(name="audit_info_login_type")
    private String auditInfoLoginType;

    @Nationalized
    @Column(name="audit_info_notes_number")
    private String auditInfoNotesNumber;

    @Nationalized
    @Column(name="audit_info_user_level")
    private String auditInfoUserLevel;

    @Nationalized
    @Column(name="audit_info_user_name")
    private String auditInfoUserName;

    @Nationalized
    @Column(name="audit_info_username")
    private String auditInfoUsername;

    @Nationalized
    @Column(name="client_ip")
    private String clientIp;

    @Column(name="company_id")
    private int companyId;

    @Nationalized
    @Column(name="detailed_info")
    private String detailedInfo;

    @Nationalized
    @Column(name="detailed_info_appointment_type_id")
    private String detailedInfoAppointmentTypeId;

    @Nationalized
    @Column(name="detailed_info_browser")
    private String detailedInfoBrowser;

    @Nationalized
    @Column(name="detailed_info_browswerversion")
    private String detailedInfoBrowswerversion;

    @Nationalized
    @Column(name="detailed_info_client_ip")
    private String detailedInfoClientIp;

    @Nationalized
    @Column(name="detailed_info_fromid")
    private String detailedInfoFromid;

    @Nationalized
    @Column(name="detailed_info_frompriority")
    private String detailedInfoFrompriority;

    @Nationalized
    @Column(name="detailed_info_ip")
    private String detailedInfoIp;

    @Nationalized
    @Column(name="detailed_info_new_values")
    private String detailedInfoNewValues;

    @Nationalized
    @Column(name="detailed_info_newvalues")
    private String detailedInfoNewvalues;

    @Nationalized
    @Column(name="detailed_info_old_values")
    private String detailedInfoOldValues;

    @Nationalized
    @Column(name="detailed_info_oldvalues")
    private String detailedInfoOldvalues;

    @Nationalized
    @Column(name="detailed_info_os")
    private String detailedInfoOs;

    @Nationalized
    @Column(name="detailed_info_patient_id")
    private String detailedInfoPatientId;

    @Nationalized
    @Column(name="detailed_info_patient_name")
    private String detailedInfoPatientName;

    @Nationalized
    @Column(name="detailed_info_portal")
    private String detailedInfoPortal;

    @Nationalized
    @Column(name="detailed_info_session_id")
    private String detailedInfoSessionId;

    @Nationalized
    @Column(name="detailed_info_told")
    private String detailedInfoTold;

    @Nationalized
    @Column(name="detailed_info_topriority")
    private String detailedInfoTopriority;

    @Nationalized
    @Column(name="hash_salt")
    private String hashSalt;

    @Nationalized
    @Column(name="hash_value")
    private String hashValue;

    @Nationalized
    @Column(name="LastAction")
    private String lastAction;

    @Column(name="LastModified")
    private Timestamp lastModified;

    @Nationalized
    @Column(name="log_description")
    private String logDescription;

    @Nationalized
    @Column(name="logged_dt")
    private String loggedDt;

    @Nationalized
    @Column(name="module_name")
    private String moduleName;

    @Column(name="order_id")
    private int orderId;

    @Column(name="patient_id")
    private int patientId;

    @Column(name="sa_id")
    private int saId;

    @Nationalized
    @Column(name="screen_name")
    private String screenName;

    @Column(name="study_id")
    private int studyId;

    @Column(name="unique_id")
    private long uniqueId;

    @Nationalized
    @Column(name="user_data")
    private String userData;

    @Nationalized
    @Column(name="user_data_args")
    private String userDataArgs;

    @Nationalized
    @Column(name="user_data_drawresult")
    private String userDataDrawresult;

    @Column(name="user_id")
    private int userId;
}
