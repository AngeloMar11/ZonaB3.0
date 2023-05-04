function mostrarOpciones(id) {
    var perfilMenu = document.getElementById("opciones-menu-" + id);
    if (perfilMenu.style.display === "none") {
        perfilMenu.style.display = "block";
        perfilMenu.classList.add("animacion-despliegue");
    } else {
        perfilMenu.style.display = "none";
        perfilMenu.classList.remove("animacion-despliegue");
    }
}
function openModal() {
        if (document.getElementById("miModal2").style.display !== "block") {
            document.getElementById("miModal").style.display = "block";
            document.body.style.overflow = "hidden";

        }

}
function openModal2() {
    document.getElementById("miModal2").style.display = "block";
    document.body.style.overflow = "hidden";
}
function openModal3(id) {

    console.log("Entro");
    document.getElementById("miModal3").style.display = "block";
    document.body.style.overflow = "hidden";
}

function mostrarDatos(nombre, apellido, correo, cedula, telefono, tipoEmpleado ) {

    console.log("Hola, mundo!");
    // Guardar los datos en variables
    var nombreInput = document.getElementById("nombre-input");
    var apellidoInput = document.getElementById("apellido-input");
    var correoInput = document.getElementById("correo-input");
    var cedulaInput = document.getElementById("cedula-input")
    var telefonoInput = document.getElementById("telefono-input");
    var tipoEmpleadoInput = document.getElementById("tipoEmpleado-input");


    nombreInput.value = nombre;
    apellidoInput.value = apellido;
    correoInput.value = correo;
    cedulaInput.value = cedula;
    telefonoInput.value = telefono;
    tipoEmpleadoInput.value = tipoEmpleado;

    // Mostrar el popup
    openModal();
}
function mostrarDatos2(nombre, apellido, cedula) {

    console.log("Hola, mundo!");
    // Guardar los datos en variables
    var nombrInput = document.getElementById("nombr-input");
    var apellidInput = document.getElementById("apellid-input");
    var cedulInput = document.getElementById("cedul-input")


    nombrInput.value = nombre;
    apellidInput.value = apellido;
    cedulInput.value = cedula;

    // Mostrar el popup
    openModal2();
}
function closeModal() {
    document.getElementById("miModal").style.display = "none";
    document.body.style.overflow = "auto";
}
function closeModal2() {
    document.getElementById("miModal2").style.display = "none";
    document.body.style.overflow = "auto";
}

function closeModal3() {
    document.getElementById("miModal3").style.display = "none";
    document.body.style.overflow = "auto";
}
function confirmarEliminacion() {
    if (confirm("¿Estás seguro de que deseas eliminar este registro?")) {
        document.querySelector('form').submit();
    }
}













