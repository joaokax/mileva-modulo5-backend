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

import com.site.mileva.entities.Destino;
import com.site.mileva.entities.Usuario;
import com.site.mileva.entities.Viagem;
import com.site.mileva.repositories.DestinoRepository;
import com.site.mileva.repositories.UsuarioRepository;
import com.site.mileva.repositories.ViagemRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value ="/viagens")
public class ViagemController {
	
	@Autowired
	private ViagemRepository viagemRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private DestinoRepository destinoRepository;
	
	
	// GET
	@GetMapping
	public ResponseEntity<List<Viagem>> findAll() {
	
		List <Viagem> viagens = viagemRepository.findAll();
	
		return ResponseEntity.ok().body(viagens);
	}
	
	// GET POR ID
	@GetMapping(value ="/{id}")
	public ResponseEntity<Viagem> findById(@PathVariable Long id) {
		
		Viagem viagem = viagemRepository.findById(id).get();
		
		return ResponseEntity.ok().body(viagem);
	}
	
	// CREATE
			@PostMapping
			public Viagem create(@RequestBody Viagem viagem) {
				return viagemRepository.save(viagem);	
			}

	// UPDATE
			@PutMapping("{id}")
			public ResponseEntity<Viagem> update(@PathVariable long id, @RequestBody Viagem viagemDetails) {
			
			Viagem updateViagem = viagemRepository.findById(id).get();
			Usuario usuario = usuarioRepository.findById(viagemDetails.getUsuario().getId_usuario()).get();
	    	Destino destino = destinoRepository.findById(viagemDetails.getDestino().getId_destino()).get();

	    	updateViagem.setAeroportoPartida(viagemDetails.getAeroportoPartida());
	    	updateViagem.setAeroportoChegada(viagemDetails.getAeroportoChegada());
	    	updateViagem.setDataIda(viagemDetails.getDataVolta());
	    	updateViagem.setDataVolta(viagemDetails.getDataVolta());
	    	updateViagem.setValor(viagemDetails.getValor());

	    	updateViagem.setUsuario(usuario);
	    	updateViagem.setDestino(destino);
	    	
	        viagemRepository.save(updateViagem);

	        return ResponseEntity.ok(updateViagem);
	        
		}
		
		// DELETE
		@DeleteMapping("{id}")
	    public ResponseEntity<HttpStatus> delete(@PathVariable long id) {

	    	Viagem viagem = viagemRepository.findById(id).get();

	    	viagemRepository.delete(viagem);

	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	    }
		
	
}
