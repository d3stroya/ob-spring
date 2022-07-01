## Construir la API REST
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

## Subir la API REST a la nube
1. Entrar en Heroku.com > New > Create new app
2. Crear un nuevo archivo a nivel de proyecto con el nombre "system.properties" para indicarle a Heroku qué versión de Java debe usar.
3. Instalar Git y configurar: git config --global user.name "[username]" y git config --global user.email "[email]". Deben ser los mismos datos que el usuario de Github.
4. Crear archivo .gitignore para no subir archivos internos del IDE --> gitignore.io. Copiar el resultado y reemplazarlo en .gitignore.
5. Subir el proyecto a Github: Menú > VCS o Git > Share Project on GitHub