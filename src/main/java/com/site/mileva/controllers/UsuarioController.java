package com.site.mileva.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.site.mileva.entities.Usuario;
import com.site.mileva.repositories.UsuarioRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value ="/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	// GET
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {
	
		List <Usuario> usuarios = usuarioRepository.findAll();
	
		return ResponseEntity.ok().body(usuarios);
	}
	
	// GET POR ID
	@GetMapping(value ="/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id) {
		
		Usuario usuario = usuarioRepository.findById(id).get();
		
		return ResponseEntity.ok().body(usuario);
	}
	
	// CREATE
	@PostMapping
	public Usuario create(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);	
	}
	
	// UPDATE
	@PutMapping("{id}")
	public ResponseEntity<Usuario> update(@PathVariable long id, @RequestBody Usuario usuarioDetails) {
		
		Usuario updateUsuario = usuarioRepository.findById(id).get();

    	updateUsuario.setNome(usuarioDetails.getNome());
    	updateUsuario.setIdade(usuarioDetails.getIdade());
    	updateUsuario.setEmail(usuarioDetails.getEmail());
    	updateUsuario.setTelefone(usuarioDetails.getTelefone());

        usuarioRepository.save(updateUsuario);

        return ResponseEntity.ok(updateUsuario);
        
	}
	
	
	// DELETE
	@DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable long id) {

    	Usuario usuario = usuarioRepository.findById(id).get();

    	usuarioRepository.delete(usuario);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
	
	
}
