package com.orangeblue.myboard.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Role {
    
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleEnum name;

    @OneToMany(mappedBy = "role")
    private List<UserRole> userRole = new ArrayList<UserRole>();
    
}
