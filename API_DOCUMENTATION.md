# Documentación de la API

## GatoController

- `GET /User/{idUser}/Gato/{idGato}`: Obtener la información de un gato específico asociado a un usuario específico.
- `POST /User/{idUser}/Gato`: Crear un nuevo gato para un usuario específico.
- `PATCH /User/{idUser}/Gato/edit`: Actualizar la información parcial de un gato.
- `DELETE /User/{idUser}/Gato/{idGato}`: Eliminar un gato específico asociado a un usuario específico.
- `GET /User/{idUser}/Gato`: Obtener una lista de todos los gatos asociados a un usuario específico.

## UserController

- `GET /User/{id}`: Obtener la información de un usuario específico.
- `POST /User`: Crear un nuevo usuario.
- `PATCH /User/edit`: Actualizar la información parcial de un usuario.
- `DELETE /User/{id}`: Eliminar un usuario específico.
- `GET /User`: Obtener una lista de todos los usuarios.
- `POST /user/login`: Creación de un token de sesión, en el caso de que exista el usuario en la BD.
- `POST /user/checkToken`: Verificar la validez de un token de sesión.
