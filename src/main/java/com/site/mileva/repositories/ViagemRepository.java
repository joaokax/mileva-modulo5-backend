package com.site.mileva.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.site.mileva.entities.Viagem;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Long> {

}
