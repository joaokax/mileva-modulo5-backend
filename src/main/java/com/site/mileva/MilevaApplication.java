package com.site.mileva;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.site.mileva.entities.Destino;
import com.site.mileva.entities.Usuario;
import com.site.mileva.entities.Viagem;
import com.site.mileva.repositories.DestinoRepository;
import com.site.mileva.repositories.UsuarioRepository;
import com.site.mileva.repositories.ViagemRepository;

@SpringBootApplication
public class MilevaApplication implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private DestinoRepository destinoRepository;
	
	@Autowired
	private ViagemRepository viagemRepository;

	public static void main(String[] args) {
		SpringApplication.run(MilevaApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		

		Usuario user1 = new Usuario(null, "Joao Kax", 22, "lukaxsilva.ls@gmail.com", "21976304549");  
		Usuario user2 = new Usuario(null, "Lucas", 25, "lucas_teste@email.com", "21988885555");
		
		Destino d1 = new Destino(null, "Rio de Janeiro");
		Destino d2 = new Destino(null, "São Paulo");
		Destino d3 = new Destino(null, "Foz do Iguaçu");
		
		Viagem v1 = new Viagem(null, "Santos Dumont", "Guarulhos", "13/03/2022", "16/02/2022", 234.88, user1, d2);
		Viagem v2 = new Viagem(null, "Congonhas", "Galeão", "24/05/2022", "27/05/2022", 344.55, user2, d1);

		
		user1.getViagens().addAll(Arrays.asList(v1));
		user2.getViagens().addAll(Arrays.asList(v2));
		
		d1.getViagens().addAll(Arrays.asList(v2));
		d2.getViagens().addAll(Arrays.asList(v1));
		
		usuarioRepository.save(user1);
		usuarioRepository.save(user2);
		
		destinoRepository.save(d1);
		destinoRepository.save(d2);
		destinoRepository.save(d3);
		
		viagemRepository.save(v1);
		viagemRepository.save(v2);
		

	}

}
