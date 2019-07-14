package com.slmanju.rbac.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class UserRoleId implements Serializable {

	private static final long serialVersionUID = 2562526047619150112L;

	private Long user;
    private Long role;

}
