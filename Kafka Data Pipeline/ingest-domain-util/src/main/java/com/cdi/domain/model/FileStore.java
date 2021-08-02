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
 * FileStore entity is used to map the data of
 * <p>
 * <i> <b>Table = file_stores </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "file_stores", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class FileStore extends BaseEntity {

    @Column(name="company_id")
    private int companyId;

    @Nationalized
    @Column(name="deleted_dt")
    private String deletedDt;

    @Nationalized
    @Column(name="file_store_name")
    private String fileStoreName;

    @Column(name="has_deleted")
    private boolean hasDeleted;

    @Column(name="has_registered")
    private boolean hasRegistered;

    @Column(name="is_default")
    private boolean isDefault;

    @Column(name="LastAction")
    private String lastAction;

    @Column(name="LastModified")
    private Timestamp lastModified;

    @Nationalized
    @Column(name="notes")
    private String notes;

    @Nationalized
    @Column(name="root_directory")
    private String rootDirectory;

    @Nationalized
    @Column(name="server_status")
    private String serverStatus;

}
