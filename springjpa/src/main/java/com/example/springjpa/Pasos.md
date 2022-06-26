SPRING DATA:
1. Crear una clase con:
   1. Atributos
   2. Constructores
   3. Getters y setters
   4. Método toString
2. Indicar que esa clase es una entidad. Esto permite almacenarlo en base de datos. Para ello, hay que escribir la anotación @Entity.
3. Indicar que el atributo id es un id, con la anotación @Id.
4. Generar un id automáticamente con la anotación @GeneratedValue(strategy = GenerationType.IDENTITY)
5. Crear una interfaz [nombreClase]Repository como repositoria para almacenar en base de datos. Hay que indicar que es un repositorio con la anotación @Repository.
6. Indicar que la interfaz hereda de JpaRepository, con los parámetos <T(clase), ID(tipo de dato del id)>. 