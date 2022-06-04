package co.edu.poligran.proyecto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuario")
public class Usuario {

	// Primary key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idu;

	@Column(name = "USERNAME")
	private String userName;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ACTIVE")
	private boolean active;

	@Column(name = "ROLES")
	private String roles;

	@OneToOne(mappedBy = "usuario")
	@JsonIgnore
	private Persona persona;

	public Usuario() {
	}

	public Usuario(int idu, String userName, String password, boolean active, String roles, Persona persona) {
		super();
		this.idu = idu;
		this.userName = userName;
		this.password = password;
		this.active = active;
		this.roles = roles;
		this.persona = persona;
	}

	public int getIdu() {
		return idu;
	}

	public void setIdu(int idu) {
		this.idu = idu;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	
}
