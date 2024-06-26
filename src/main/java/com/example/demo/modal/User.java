package com.example.demo.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name ="Users")
public class User{
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String password;
 private String username;
 private String email;
 private Long mobileNumber;
}