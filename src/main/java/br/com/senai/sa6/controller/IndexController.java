package br.com.senai.sa6.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.senai.sa6.orm.Agendamento;
import br.com.senai.sa6.orm.User;
import br.com.senai.sa6.services.AgendamentoService;
import br.com.senai.sa6.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {
	@Autowired
	UserService service;
	@Autowired
	AgendamentoService agendamentoService;

	@GetMapping({ "/" })
	public String index(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("id");
		if (userId != null) {
			model.addAttribute("agendamentos", agendamentoService.buscarPorUserId(userId));
		}

		return "index";
	}

	@GetMapping({ "/login" })
	public String login(Model model) {

		return "login";
	}

	@GetMapping({ "/cadastro" })
	public String cadastro(Model model) {

		return "cadastro";
	}

	@PostMapping({ "/cadastro" })
	public String CadastroUser(HttpServletRequest request, HttpSession session, Model model) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		service.adicionarUsuario(user);
		session.setAttribute("user", user.getName());
		session.setAttribute("id", user.getId());
		return "redirect:/";
	}

	@PostMapping({ "/login" })
	public String loginUser(HttpServletRequest request, HttpSession session, Model model) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		User user = service.buscarUsuario(name, password);
		if (user != null) {
			session.setAttribute("user", user.getName());
			session.setAttribute("id", user.getId());
			return "redirect:/";
		}
		model.addAttribute("login", "Usuário ou Senha Inválidos");
		return "login";
	}

	@GetMapping({ "/logout" })
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping("/deletar/{id}")
	public String deletarItem(@PathVariable Integer id, HttpSession session) {
		agendamentoService.deletarAgendamento(id);
		return "redirect:/";
	}

	@PostMapping("/agendar")
	@ResponseBody
	public String processarFormulario(@RequestParam("data") Date data, @RequestParam("select") int select,
			@RequestParam("userId") int userId) {
		Agendamento agendamento = new Agendamento();
		User user = new User();
		agendamento.setData(data);
		agendamento.setHora(select);
		user.setId(userId);
		agendamento.setUser(user);
		agendamentoService.salvarAgendamento(agendamento);
		return "true";
	}
}
