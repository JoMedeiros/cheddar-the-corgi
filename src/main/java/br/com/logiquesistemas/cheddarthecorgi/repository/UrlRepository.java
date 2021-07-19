package br.com.logiquesistemas.cheddarthecorgi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.logiquesistemas.cheddarthecorgi.model.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {

}
