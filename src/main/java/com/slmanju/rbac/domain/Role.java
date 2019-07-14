package com.slmanju.rbac.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Data
@Entity
@Table(name = "rbac_role")
public class Role implements Serializable {

	private static final long serialVersionUID = 3502474277719725097L;
	
	@Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
	@Column(name = "role_code")
    private String code;
    @Column(name = "role_name")
    private String name;
    
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RolePriviledge> rolePriviledges = new ArrayList<>();
    
    public void addPrivilege(Privilege privilege) {
    	RolePriviledge rolePriviledge = new RolePriviledge();
    	rolePriviledge.setRole(this);
    	rolePriviledge.setPriviledge(privilege);

        rolePriviledges.add(rolePriviledge);
    }

}
