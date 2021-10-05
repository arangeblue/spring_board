package com.orangeblue.myboard.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "USERS")
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseTime {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username",length = 50)
    private String username;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "users_boards")
    private int boardNum;

    @OneToMany(mappedBy = "user")
    List<Board> boards = new ArrayList<>();

    @OneToMany(
                mappedBy = "user", 
                targetEntity = UserRole.class,
                fetch = FetchType.LAZY
                )
    private List<UserRole> userRole = new ArrayList<UserRole>();

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private RoleEnum role;


    @Override
    public String toString() {
        return "User {" + " id='" + id + "'" + ", username='" + username + "'" + ", boardNum='" + boardNum + "'" + ", boards='"
                + boards + "'" + "}";
    }

    
    


}
