package br.com.senai.sa6.services;

import java.sql.Date;
import java.util.List;

import br.com.senai.sa6.orm.Agendamento;

public interface AgendamentoService {
	List<Agendamento> buscarPorUserId(int id);
	void deletarAgendamento(int id);
	void salvarAgendamento(Agendamento agendamento);
	List<Agendamento> buscarPorData(Date date);
}
