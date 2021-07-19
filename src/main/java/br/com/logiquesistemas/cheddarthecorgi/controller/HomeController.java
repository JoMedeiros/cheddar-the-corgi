package br.com.logiquesistemas.cheddarthecorgi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.logiquesistemas.cheddarthecorgi.dto.UrlLongRequest;
import br.com.logiquesistemas.cheddarthecorgi.dto.UsuarioDTO;
import br.com.logiquesistemas.cheddarthecorgi.model.Usuario;
import br.com.logiquesistemas.cheddarthecorgi.repository.UsuarioRepository;

@Controller
public class HomeController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping(value="/home")
	public String index(Model model) {
		model.addAttribute("urlLonga", new UrlLongRequest());
		return "home";
	}
	
	@PostMapping(value="/home")
	public String criarUrl(
			@ModelAttribute UrlLongRequest urlLonga, Model model) {
		model.addAttribute(urlLonga);
		// TODO: Salvar no banco
		return "home";
	}
	
	@GetMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@GetMapping(value="/registrar")
	public String registrar(Model model) {
		model.addAttribute("usuario", new UsuarioDTO());
		return "registrar";
	}
	
	@PostMapping(value="/registrar")
	public ResponseEntity<String> registrar(
			@ModelAttribute UsuarioDTO usuarioDto, Model model) {
		model.addAttribute(usuarioDto);
		Usuario usuario = new Usuario();
		usuario.setNome(usuarioDto.getNome());
		usuario.setSenha(
				new BCryptPasswordEncoder().encode(
						usuarioDto.getSenha())
		);
		usuarioRepository.save(usuario);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body("usuário cadastrado com sucesso.");
	}
}