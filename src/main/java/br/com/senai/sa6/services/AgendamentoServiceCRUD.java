package br.com.senai.sa6.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.sa6.orm.Agendamento;
import br.com.senai.sa6.repository.AgendamentoRepository;

@Service
public class AgendamentoServiceCRUD implements AgendamentoService {

	@Autowired
	AgendamentoRepository repository;

	@Override
	public List<Agendamento> buscarPorUserId(int id) {
		return repository.findByUserIdOrderByDataAsc(id);
	}

	@Override
	public void deletarAgendamento(int id) {
		repository.deleteById(id);

	}

	@Override
	public List<Agendamento> buscarPorData(Date date) {
		return repository.findAllByDataOrderByHoraAsc(date);
	}

	@Override
	public void salvarAgendamento(Agendamento agendamento) {
		repository.save(agendamento);
		
	}

}
