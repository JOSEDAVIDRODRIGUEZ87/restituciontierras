package co.edu.poligran.proyecto.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "persona")
public class Persona {

	// Primary key
	@Id
	// auto_increment
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idp;

	@Column(name = "NOMBRES")
	private String nombres;

	@Column(name = "APELLIDOS")
	private String apellidos;

	@Column(name = "CEDULA")
	private String cedula;
	@Column(name = "CELULAR")
	private String celular;

	@Column(name = "DIRECCION")
	private String direccion;

	@Column(name = "CORREO")
	private String correo;

	@Column(name = "NIVELDERIESGO")
	private String nivederiesgo;

	@ManyToOne
	@JoinColumn(name = "DANE_ID")
	@JsonIgnore
	private Dane dane;

	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Documento> documento;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USUARIO_ID", unique = true)
	private Usuario usuario;

	public Persona() {
		super();
	}


	public Persona(int idp, String nombres, String apellidos, String cedula, String celular, String direccion,
			String correo, String nivederiesgo) {
		super();
		this.idp = idp;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.cedula = cedula;
		this.celular = celular;
		this.direccion = direccion;
		this.correo = correo;
		this.nivederiesgo = nivederiesgo;
	}


	public int getIdp() {
		return idp;
	}

	public void setIdp(int idp) {
		this.idp = idp;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Dane getDane() {
		return dane;
	}

	public void setDane(Dane dane) {
		this.dane = dane;
	}

	public Set<Documento> getDocumento() {
		return documento;
	}

	public void setDocumento(Set<Documento> documento) {
		this.documento = documento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public String getNivederiesgo() {
		return nivederiesgo;
	}


	public void setNivederiesgo(String nivederiesgo) {
		this.nivederiesgo = nivederiesgo;
	}

}
