# SPRING BOOT
Proyecto Spring Boot con las dependencias / starters:
* H2
* Spring Data JPA
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