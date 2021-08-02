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
 * MacroNoteType entity is used to map the data of
 * <p>
 * <i> <b>Table = macro_note_types </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "macro_note_types", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MacroNoteType extends BaseEntity {

    @Column(name = "macro_note_id")
    private long macroNoteId;

    @Nationalized
    @Column(name = "macro_note_type")
    private String macroNoteType;

    @Column(name = "lastaction")
    private String lastaction;

    @Column(name = "lastmodified")
    private Timestamp lastmodified;
}
