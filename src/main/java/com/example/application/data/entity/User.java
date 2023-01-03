package com.example.application.data.entity;

import com.example.application.data.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "User")
public class User extends AbstractEntity {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
    private String username;
    private String name;
    private String dni;
    private Date fechaNacimiento;
    @JsonIgnore
    private String hashedPassword;
    @Enumerated(EnumType.STRING)
    private Role roles;
    @Lob
    @Column(length = 1000000)
    private String profilePicture;
    
    public Integer getid() {
    	return id;
    }
    
    public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		if(dni == null) throw new IllegalArgumentException("El campo dni no puede estar vacío.");
		else this.dni = dni;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
    	if(username == null) throw new IllegalArgumentException("El campo username no puede estar vacío.");
		else this.username = username;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
    	if(name == null) throw new IllegalArgumentException("El campo name no puede estar vacío.");
		else this.name = name;
    }
    public String getHashedPassword() {
        return hashedPassword;
    }
    public void setHashedPassword(String hashedPassword) {
    	if(hashedPassword == null) throw new IllegalArgumentException("El campo hashedPassword no puede estar vacío.");
		else this.hashedPassword = hashedPassword;
    }
    public Role getRoles() {
        return roles;
    }
    public void setRoles(Role roles) {
        this.roles = roles;
    }
    public String getProfilePicture() {
        return profilePicture;
    }
    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
        
    private User(Integer id, String username, String name, String dni, Date fechaNac, String hashedPass, Role rol, String profilePicture) {
    	setUsername(username);
    	setName(name);
    	setDni(dni);
    	setFechaNacimiento(fechaNac);
    	setHashedPassword(hashedPass);
    	setRoles(rol);
    	setProfilePicture(profilePicture);
    	this.id=id;
    }
    
    public User(String username, String name, String dni, Date fechaNac, String hashedPass, Role user, String profilePicture) {this(null, username, name, dni, fechaNac, hashedPass, user, profilePicture);}

}