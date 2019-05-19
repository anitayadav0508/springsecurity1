package org.spring.security.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "authority")
public class Authority implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userRole_id")
    private Long userRoleId;
    @Column(name = "user_role")
     private String UserRole;

    @ManyToOne
    @JoinColumn(name = "username_fk")
    private User user;


    public Authority(String userRole) {
        UserRole = userRole;
    }

    public Authority() {
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
