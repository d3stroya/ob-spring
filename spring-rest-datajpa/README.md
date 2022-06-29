# SPRING BOOT
Proyecto Spring Boot con las dependencias / starters:
Para la persistencia:
* H2
* Spring Data JPA
Para web:
* Spring Web
* Spring Boot Dev Tools

## ¿Qué haremos?
Aplicación API REST con acceso a base de datos H2 para persistir la información.
El acceso se puede realizar desde Postman o Navegador

### Entidad Book
1. Book
   1. Crear la clase con sus: 
      1. atributos
      2. constructores
      3. getters y setters
      4. Añadir la anotación @Entity
      5. (Opcional). Cambiar el nombre de la tabla con @Tabla(name = "nombre")
2. BookRepository
   1. Crear la interfaz 
   2. Añadir la anotación @Repository 
   3. Añadir herencia: extends JpaRepository<Book, Long>
3. BookController
   1. Crear la clase 
   2. Añadir la anotación @RestController
   3. Configurar la url para poder acceder desde el navegador: @GetMapping("/url")
   4. (Hacer en cada proyecto). Configurar DevTools para refrescar la app automáticamente cuando haya cambios
      1. File > Settings > Advanced Settings > Allow auto-make to start even if developed application is currently running
      2. ... Build, execution, deployment > Compiler > Build project automatically
   5. Añadir repository
   6. Crear métodos CRUD con sus url
      1. Buscar todos los libros
      2. Buscar un solo libro
      3. Crear un libro
      4. Actualizar un libro existente
      5. Borrar un libro
      6. Borrar todos los libros

### Documentación con Swagger
1. Crear un paquete config y dentro la clase SwaggerConfig
2. Descargar Spring-fox-boot-starter desde mvnrepository.com y añadir la dependencia a pom.xml (https://mvnrepository.com/artifact/io.springfox/springfox-boot-starter/3.0.0)
3. Añadir la anotación @Configurations a la clase SwaggerConfig
4. En SwaggerConfig crear el método public Docket api(){} con la anotación @Bean. El método retorna un objeto Docket.
5. Añadir ApiInfo
6. Ya se puede consultar la documentación desde http://localhost:8080/swager-ui
7. Si da problemas, añadir a application.properties: spring.mvc.pathmatch.matching-strategy=ant_path_matcher.
8. Se pueden añadir más datos, por ejemplo @ApiOperation para describir lo que hace cada método.

### Testing
1. Dentro de test > java > [paquete del proyecto], crear un paquete y su clase test (controller > BookControlerTest).
2. Añadir la anotación @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT).
3. Crear las clases TestRestTemplate y @Autowired RestTemplateBuilder.
4. ASignar un puerto aleatorio: @LocalServerPort private int port.
5. Click derecho > Generate > SetUp Method
6. En la clase BookController, click derecho > Generate > Test > Seleccionar métodos deseados.