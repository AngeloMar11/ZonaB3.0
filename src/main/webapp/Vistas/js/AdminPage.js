$(function () {
  // Sidebar toggle behavior
  $('#sidebarCollapse').on('click', function () {
    $('#sidebar, #content').toggleClass('active');
  });
});

// obtener el enlace de "Crear Usuario"
var crearUsuarioLink = document.querySelector('.nav-link.text-dark.font-italic.bg-light');

// agregar un evento onclick
crearUsuarioLink.addEventListener('click', function () {
  // obtener el contenedor de opciones adicionales
  var opcionesAdicionales = document.getElementById('opciones-adicionales');

  // si las opciones adicionales están ocultas, mostrarlas; de lo contrario, ocultarlas
  if (opcionesAdicionales.style.display === 'none') {
    opcionesAdicionales.style.display = 'block';
  } else {
    opcionesAdicionales.style.display = 'none';
  }
});


function mostrarPerfilMenu() {
  var perfilMenu = document.getElementById("perfil-menu");
  if (perfilMenu.style.display === "none") {
    perfilMenu.style.display = "block";
    perfilMenu.classList.add("animacion-despliegue");
  } else {
    perfilMenu.style.display = "none";
    perfilMenu.classList.remove("animacion-despliegue");
  }
}
function validarCampos() {
  let nombre = document.getElementById("nombre").value;
  if (nombre == "") {
    document.getElementById("nombreError").innerHTML = "Por favor, ingrese su nombre";
    return false;
  } else {
    document.getElementById("nombreError").innerHTML = "";
    return true;
  }
}
function validarCampos() {
  // Obtener valores de los campos del formulario
  let nombre = document.getElementById("nombre").value;
  let apellido = document.getElementById("apellido").value;
  let genero = document.getElementById("genero").value;
  let tipo_identificacion = document.querySelector('input[name="tipo_identificacion"]:checked');
  let identificacion = document.getElementById("identificacion").value;
  let correo = document.getElementById("correo").value;
  let contraseña = document.getElementById("contraseña").value;

  // Validar que el campo nombre no esté vacío
  if (nombre == "") {
    document.getElementById("nombre-error").style.display = "block";

    // Validar que el campo apellido no esté vacío
    if (apellido == "") {
      document.getElementById("apellido-error").style.display = "block";
      // Validar que se haya seleccionado una opción en el campo género
      if (genero == "") {
        document.getElementById("genero-error").style.display = "block";
        // Validar que se haya seleccionado una opción en el campo tipo_identificacion
        if (!tipo_identificacion) {
          document.getElementById("tipo-identificacion-error").style.display = "block";
          // Validar que el campo identificacion no esté vacío
          if (identificacion == "") {
            document.getElementById("identificacion-error").style.display = "block";
            // Validar que el campo correo no esté vacío y contenga un formato de correo electrónico válido
            if (correo == "" || !/\S+@\S+\.\S+/.test(correo)) {
              document.getElementById("correo-error").style.display = "block";
              // Validar que el campo contraseña no esté vacío y tenga al menos 8 caracteres
              if (contraseña == "" || contraseña.length < 8) {
                document.getElementById("contraseña-error").style.display = "block";
                return false;
              } else {
                document.getElementById("contraseña-error").style.display = "none";
              }
              return false;
            } else {
              document.getElementById("correo-error").style.display = "none";
            }

            return false;
          } else {
            document.getElementById("identificacion-error").style.display = "none";
          }

          return false;
        } else {
          document.getElementById("tipo-identificacion-error").style.display = "none";
        }
        return false;
      } else {
        document.getElementById("genero-error").style.display = "none";
      }
      return false;
    } else {
      document.getElementById("apellido-error").style.display = "none";
    }
    return false;
  } else {
    document.getElementById("nombre-error").style.display = "none";
  }






  // Si todos los campos están llenos y válidos, se retorna true
  return true;
}
