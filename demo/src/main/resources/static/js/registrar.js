// Call the dataTables jQuery plugin
$(document).ready(function() {//onready
});



    async function registrarUsuarios(){

        let datos = {};
        datos.nombre = document.getElementById("txtNombre").value;
        datos.apellido = document.getElementById("txtApellido").value;
        datos.email = document.getElementById("txtEmail").value;
        datos.password = document.getElementById("txtPassword").value;
        datos.repetirpassword = document.getElementById("txtRepeatPassword").value;

        let repetirPassword = document.getElementById("txtRepeatPassword").value;
        if(datos.password != repetirPassword){
            alert("Las contraseñas no coinciden");
            return;}

          const request = await fetch('api/usuarios', {
            method: 'POST',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
                 body: JSON.stringify(datos)
          });

    }

