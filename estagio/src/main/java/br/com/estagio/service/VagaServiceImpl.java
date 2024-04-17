package br.com.estagio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estagio.entity.AlunoEntity;
import br.com.estagio.entity.VagaEntity;
import br.com.estagio.repository.AlunoRepository;
import br.com.estagio.repository.VagaRepository;

@Service
public class VagaServiceImpl implements VagaService {
	
	@Autowired
	private VagaRepository vagaRepository;
	
	private String mensagem;
	
	@Override
	public String save(VagaEntity vagaEntity) throws Exception {
		
		if (vagaEntity.getRequisitos() == null) {
			this.mensagem = "Digite os requisitos da vaga.";
			throw new Exception("Preencha os requisitos da vaga.");
			
		} else if (vagaEntity.getValorBolsa() == null){
			this.mensagem = "Digite o valor da bolsa.";
			throw new Exception("Preencha o valor da bolsa");

		} else if (vagaEntity.getBeneficios() == null) {
			this.mensagem = "Digite os beneficios da vaga.";
			throw new Exception("Preencha os beneficios da vaga.");
		} else if (vagaEntity.getCurso() == null) {
			this.mensagem = "Digite o curso";
			throw new Exception("Preencha o curso");
		} else {
			vagaRepository.saveAndFlush(vagaEntity);
			this.mensagem = "Vaga cadastrada com sucesso";
		}
		return mensagem;
	}

	@Override
	public List<VagaEntity> findAll() {
		// TODO Auto-generated method stub
		return vagaRepository.findAll();
	}

	@Override
	public VagaEntity getOneByIdVaga(Long idVaga) throws Exception {
		// TODO Auto-generated method stub
		return vagaRepository.getOneByIdVaga(idVaga);
	}

	@Override
	public String deleteById(Long idVaga) throws Exception {
		try
		{
			vagaRepository.deleteById(idVaga);
			this.mensagem = "Vaga Excluido com sucesso";
			
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return mensagem;
	}

}
