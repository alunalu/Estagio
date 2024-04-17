package br.com.estagio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estagio.entity.VagaEntity;

@Repository
public interface VagaRepository extends JpaRepository<VagaEntity, Long> {
	
	VagaEntity getOneByIdVaga(Long idVaga);

}
