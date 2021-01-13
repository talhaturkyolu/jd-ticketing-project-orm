package com.befty.entity;

import com.befty.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;



@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
@Where(clause = "is_deleted=false")
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private String userName;
    // private String passWord;
    private boolean enabled;
    private String phone;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;




}