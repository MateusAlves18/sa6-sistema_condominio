package br.com.senai.sa6.services;



import br.com.senai.sa6.orm.User;

public interface UserService {
	public User buscarUsuario(String name, String password);
	public void adicionarUsuario(User user);
}
