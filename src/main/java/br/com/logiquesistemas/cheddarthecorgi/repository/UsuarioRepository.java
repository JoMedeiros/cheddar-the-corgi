package br.com.logiquesistemas.cheddarthecorgi.repository;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.logiquesistemas.cheddarthecorgi.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	Usuario findByNome(String nome);
}
