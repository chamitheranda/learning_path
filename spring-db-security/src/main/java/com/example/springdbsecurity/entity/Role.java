package com.example.springdbsecurity.entity;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @Column(name = "role_id", length = 40)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roleId ;

    @Column(name = "role", length = 230)
    private String role;

    public Role() {
    }

    public Role(int roleId, String role) {
        this.roleId = roleId;
        this.role = role;
    }

    public int getRoleId() {
        return roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
