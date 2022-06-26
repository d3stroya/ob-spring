package com.example.springjpa;

// Indicar que es un bean. Spring va a implementar esta interfaz en cualquier parte de la aplicación
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocheRepository extends JpaRepository<Coche, Long> {   // Hereda de JpaRepository, al que hay que indicar <T (clase), ID (tipo de dato del id)>. Permite cualquier operación en base de datos.
}
