package com.das.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity
@Data
public class User {

 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Integer id;

 @NotEmpty(message = "Email is required.")
 @Email(message = "Enter Valid Email")
 private String email;

 @NotEmpty(message = "Password is required.")
 private String password;

}