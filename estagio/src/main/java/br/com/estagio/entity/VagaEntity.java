package br.com.estagio.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vaga", schema = "estagio")
public class VagaEntity implements Serializable{

private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vaga")
	private Long idVaga;

	@Column(name = "requisitos")
	private String requisitos;

	@Column(name = "valor_bolsa")
	private String valorBolsa;

	@Column(name = "beneficios")
	private String beneficios;

	@Column(name = "curso")
	private String curso;

	public Long getIdVaga() {
		return idVaga;
	}

	public void setIdVaga(Long idVaga) {
		this.idVaga = idVaga;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public String getValorBolsa() {
		return valorBolsa;
	}

	public void setValorBolsa(String valorBolsa) {
		this.valorBolsa = valorBolsa;
	}

	public String getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	
	

	

}
