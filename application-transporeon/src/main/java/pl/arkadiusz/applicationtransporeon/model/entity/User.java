package pl.arkadiusz.applicationtransporeon.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users") // Table name "User" already exists in the public schema
public class User {

    @Id
    private String username;

    private String password;

    private String role;
}