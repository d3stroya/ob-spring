Maven > spring-deploy > Lifecycle
Al ejecutar una fase del lifecycle, se ejecutan todas las fases previas.
1. Package: se compila la aplicación y se generan los desplegables.
   1. Genera un .jar en la carpeta target.
   2. Según va evolucionando el proyecto, iremos cambiando la versión en pom.xml.
2. Clean: limpia target.
3. Podemos crear mensajes en application.properties e inyectarlos en el código java. Así, trabajaremos con varios application.properties, por ejemplo, uno para desarrollo y otro para producción, mientras mantenemos el mismo código java.
   1.Para seleccionar uno u otro:en application.properties --> spring.profiles.active=dev
   1. Permite crear varios perfiles, por ejemplo uno para el servidor prod y otro para el servidor de pruebas.
4. También se pueden cargar variables de entorno: