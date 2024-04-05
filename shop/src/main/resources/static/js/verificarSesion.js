let perfil = document.getElementById("user");
let cerrarSesion = document.getElementById("cerrarSesion");


function verificarBandera() {
    // Supongamos que la bandera se almacena en localStorage bajo el nombre "bandera"
    var banderaActivada = localStorage.getItem("bandera");

    // Verificar si la bandera está activada
    if (banderaActivada === "activada") {
        // Si la bandera está activada, ocultar el botón
        ocultarBoton();
    } else {
        // Si la bandera no está activada, mostrar el botón
        mostrarBoton();
    }
}

// Oculta el botón
function ocultarBoton() {
    var boton = document.getElementById("ingresar");
    boton.style.display = "none";
    perfil.style.display = "block";

}

// Muestra el botón
function mostrarBoton() {
    var boton = document.getElementById("ingresar");
    boton.style.display = "block";
}

// Llamar a la función verificarBandera cuando la página esté cargada
window.onload = function() {
    verificarBandera();
};
// Cerrar sesión
cerrarSesion.addEventListener("click", function () {
    localStorage.removeItem("bandera"); // Eliminar la bandera de sesión activa
    ingresar.style.display = "block"; // Mostrar el botón de ingresar en el navbar
    perfil.style.display = "none"; // Ocultar el dropdown del perfil
  });