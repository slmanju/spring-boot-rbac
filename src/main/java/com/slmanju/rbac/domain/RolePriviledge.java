package com.slmanju.rbac.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "rbac_role_priviledge")
@IdClass(RolePriviledgeId.class)
public class RolePriviledge implements Serializable {

	private static final long serialVersionUID = 453216232153376637L;

    @Id
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @Id
    @ManyToOne
    @JoinColumn(name = "priviledge_id", referencedColumnName = "id")
    private Privilege privilege;

}
