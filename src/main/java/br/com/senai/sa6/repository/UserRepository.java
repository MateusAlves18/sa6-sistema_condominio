package br.com.senai.sa6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.senai.sa6.orm.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByNameAndPassword(String name,String password);
}
