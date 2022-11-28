package com.bandlogs.supermarketstore.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;


/**
 * created with love by mundiaem
 * created on 26/11/2022
 * Time: 16:46
 * ⚡  - Supermarket Store
 *
 * Id
 * Username
 * First_name
 * Second_name
 * address
 * Phone
 * Email
 * Password
 * role_id
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Builder
public class Users {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int Id;
    private String username;
    private String first_name;
    private String second_name;
    private String phone_number;
    private String email;
    private String password;
    @ManyToOne
    @JoinColumn(name="role_id", nullable=false)
    private Roles roles;




}
