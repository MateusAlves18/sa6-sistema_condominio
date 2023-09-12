package br.com.senai.sa6.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.sa6.orm.User;
import br.com.senai.sa6.repository.UserRepository;

@Service
public class UserServiceCRUD implements UserService {

	@Autowired
	UserRepository repository;

	@SuppressWarnings("null")
	@Override
	public User buscarUsuario(String name, String password) {
		User user = new User();
		user = repository.findByNameAndPassword(name, password);
		return user;
	}

	@Override
	public void adicionarUsuario(User user) {
		repository.save(user);
	}

}
