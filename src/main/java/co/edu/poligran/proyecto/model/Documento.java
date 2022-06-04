package co.edu.poligran.proyecto.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "documento")
public class Documento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iddoc;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "TIPO")
	private String tipo;

	@Column(name = "CANTIDAD")
	private int cantidad;

	@ManyToOne
	@JoinColumn(name = "PERSONA_ID")
	@JsonIgnore
	private Persona persona;

	public Documento() {
	}

	public Documento(int iddoc, String nombre, String tipo, int cantidad) {
		super();
		this.iddoc = iddoc;
		this.nombre = nombre;
		this.tipo = tipo;
		this.cantidad = cantidad;
	}

	public int getIddoc() {
		return iddoc;
	}

	public void setIddoc(int iddoc) {
		this.iddoc = iddoc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
