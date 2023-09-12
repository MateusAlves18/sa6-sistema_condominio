package br.com.senai.sa6.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.sa6.orm.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {
	List<Agendamento> findByUserIdOrderByDataAsc(int id);
	List<Agendamento> findAllByDataOrderByHoraAsc(Date data);
}
