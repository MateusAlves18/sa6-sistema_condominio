package br.com.senai.sa6.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.senai.sa6.orm.Agendamento;
import br.com.senai.sa6.orm.Json;
import br.com.senai.sa6.services.AgendamentoService;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	@Autowired
	AgendamentoService agendamentoService;

	@GetMapping("/dados/{date}")
	public Json Date(@PathVariable Date date) {
		Json data = new Json();
		data.setDate(date);
		List<Agendamento> agendamentos = agendamentoService.buscarPorData(date);
		List<Integer> horario = new ArrayList<>();
		for (Agendamento agendamento : agendamentos) {
			horario.add(agendamento.getHora());
		}
		data.setHorario(horario);
		return data;
	}

	
}
