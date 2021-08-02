package com.cdi.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * MacroNote entity is used to map the data of
 * <p>
 * <i> <b>Table = macro_notes </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "macro_notes", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class MacroNote extends BaseEntity {

    @Nationalized
    @Column(name = "description")
    private String description;

    @Nationalized
    @Column(name="macro_note")
    private String macroNote;

    @Column(name="all_appointment_types")
    private boolean allAppointmentTypes;

    @Column(name="all_facilities")
    private boolean allFacilities;

    @Column(name="all_macro_types")
    private boolean allMacroTypes;

    @Column(name="all_modaliteis")
    private boolean allModaliteis;

    @Column(name="company_id")
    private int companyId;

    @Column(name="created_by")
    private long createdBy;

    @Column(name="created_dt")
    private String createdDt;

    @Column(name="is_active")
    private boolean isActive;

    @Column(name = "lastaction")
    private String lastaction;

    @Column(name = "lastmodified")
    private Timestamp lastmodified;
}
