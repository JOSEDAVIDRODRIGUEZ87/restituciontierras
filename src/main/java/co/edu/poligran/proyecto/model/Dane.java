package co.edu.poligran.proyecto.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "dane")
public class Dane {

	// Primary key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idd;

	@Column(name = "REGION")
	private String region;

	@Column(name = "CODDANEDEP")
	private int coddanedep;

	@Column(name = "DEPARTAMENTO")
	private String departamento;

	@Column(name = "CODDANEMUN")
	private String codddanemun;

	@Column(name = "MUNICIPIO")
	private String municipio;

	@OneToMany(mappedBy = "dane", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Persona> persona;

	public Dane() {
	}

	public Dane(int idd, String region, int coddanedep, String departamento, String codddanemun, String municipio) {
		super();
		this.idd = idd;
		this.region = region;
		this.coddanedep = coddanedep;
		this.departamento = departamento;
		this.codddanemun = codddanemun;
		this.municipio = municipio;
	}

	public int getIdd() {
		return idd;
	}

	public void setIdd(int idd) {
		this.idd = idd;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getCoddanedep() {
		return coddanedep;
	}

	public void setCoddanedep(int coddanedep) {
		this.coddanedep = coddanedep;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getCodddanemun() {
		return codddanemun;
	}

	public void setCodddanemun(String codddanemun) {
		this.codddanemun = codddanemun;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public Set<Persona> getPersona() {
		return persona;
	}

	public void setPersona(Set<Persona> persona) {
		this.persona = persona;
	}

}
