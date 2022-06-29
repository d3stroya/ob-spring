package com.d3stroya.springrestsocios.repositorio;

import com.d3stroya.springrestsocios.entidades.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocioRepositorio extends JpaRepository<Socio, Long> {
}
