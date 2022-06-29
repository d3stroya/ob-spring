package com.d3stroya.springrestsocios;

import com.d3stroya.springrestsocios.entidades.Socio;
import com.d3stroya.springrestsocios.repositorio.SocioRepositorio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringRestSociosApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringRestSociosApplication.class, args);
		SocioRepositorio repositorio = context.getBean(SocioRepositorio.class);

		// Crear manualmente varios socios y guardarlos. Esto en la realidad vendría de la base de datos.
		Socio socio1 = new Socio(null, "Ana", "García", "37465981O", "657483910", 27, true);
		Socio socio2 = new Socio(null, "Juan", "Pérez", "09465936X", "673940617", 42, false);
		Socio socio3 = new Socio(null, "Amaia", "López", "84017562R", "73805923", 30, true);

		repositorio.save(socio1);
		repositorio.save(socio2);
		repositorio.save(socio3);
	}

}
