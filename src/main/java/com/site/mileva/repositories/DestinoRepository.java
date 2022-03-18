package com.site.mileva.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.site.mileva.entities.Destino;

@Repository
public interface DestinoRepository extends JpaRepository<Destino, Long> {

}
