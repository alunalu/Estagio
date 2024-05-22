package br.com.estagio.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "aluno", schema = "estagio")
public class AlunoEntity implements Serializable{

private static final long serialVersionUID = 1L;

       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       @Column(name = "id_aluno")
       private Long idAluno;
       
       @Column(name = "nome")
       private String nome;

       @Column(name = "telefone")
       private String telefone;

       @Column(name = "periodo")
       private String periodo;

       @OneToOne()
       @JoinColumn(name = "escola_id", referencedColumnName = "id_escola")
       private EscolaEntity escola;
       
       @OneToOne()
       @JoinColumn(name = "curso_id", referencedColumnName = "id_curso")
       private CursoEntity curso;
       
       @ManyToMany
   	   @JoinTable(name="aluno_vaga",
   	   joinColumns= {@JoinColumn(name="aluno_id", referencedColumnName = "id_aluno")},
   	   inverseJoinColumns={@JoinColumn(name="vaga_id" , referencedColumnName = "id_vaga")})
   	   private List<VagaEntity> vagas;

	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public EscolaEntity getEscola() {
		return escola;
	}

	public void setEscola(EscolaEntity escola) {
		this.escola = escola;
	}

	public CursoEntity getCurso() {
		return curso;
	}

	public void setCurso(CursoEntity curso) {
		this.curso = curso;
	}

	public List<VagaEntity> getVagas() {
		return vagas;
	}

	public void setVagas(List<VagaEntity> vagas) {
		this.vagas = vagas;
	}

	
	
	

}
