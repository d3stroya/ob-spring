# Cifrado
Proceso de codificar la información de su representación original (texto plano) a texto cifrado, de manera que solo se pueda descifrar usando una clave.

## Historia del cifrado
https://cs.wellesley.edu/~webdb/readings/bcrypt/bcrypt.html

1. Almacenar contraseñas en texto plano
2. Almacenar contraseñas cifradas con una función hash
3. Almacenar contraseñas cifradas con una función hash más un salt
4. Almacenar contraseñas cifradas con una función adaptativa más un factor de trabajo
La seguridad se gana haciendo que la validación de contraseñas sea costosa computacionalmente.

## Algoritmos en Spring Security
Hacen lo mismo, pero el proceso matemático es distinto:
* BCrypt
* PBKF2
* scrypt
* argon2