//
let sutotal2 = document.getElementById("sutotal2");
let subTotalPago = document.getElementById("subTotalPago");
let listaProductosCarrito = document.getElementById("listaProductosCarrito");
let btnConseguir = document.getElementById('btnConseguir');
//let carrito=new Array();//arreglo vacio de productos.
//1 definir el arreglo vacio de carrito (cubeta)
const carritoGuardado = localStorage.getItem("carrito");
const carrito = JSON.parse(carritoGuardado);
let total = 0.0;
//2 verificar si existe y esta vacia ->muestro mensaje
if (localStorage.getItem("carrito") !== null) {
  // El apartado 'miApartado' existe en el Local Storage

  // Verificar si el apartado 'miApartado' tiene información almacenada
  if (carrito && carrito.length > 0) {
    //
    // El apartado 'carrito' tiene información almacenada
    console.log("El apartado 'carrito' tiene información almacenada en el Local Storage");

    let cardCarrito = JSON.parse(localStorage.getItem("carrito")) || [];
    cardCarrito.forEach(function (item) {
      let nuevoItemHTML = `
            <div class="card lleno mb-3 tamanioCard " id="${item.id}">
            <div class="row g-0">
                <div class="col-md-4">
                    <img src="${item.img}" class="img-fluid mx-auto d-block" alt="productCarritoimag" ><!-- mx-auto d-block esta clase de bostrap resueve el problema de la imagen-->
                </div>
                <div class="col-md-8">
                    <div class="card-body ">
    
                        <hr>
                    <p class="styDescripcion">${item.description}</p>
        
                    <div class="acomodo">
                        <button class="styDelete final" >
                            <i class="fa-solid fa-trash" id="${item.id}"></i>
                        </button>
    
    
                        <h5 class="styPrecio">${item.precio}</h5>
                    </div>
    
                    </div>
                </div>
            </div>
            </div>`;

      listaProductosCarrito.insertAdjacentHTML("beforeend", nuevoItemHTML);
      let precioSinSimbolo = item.precio.slice(1);
      console.log(precioSinSimbolo);
      total += parseFloat(precioSinSimbolo);
    });
  } else {
   
    console.log("El apartado 'carrito' está vacío en el Local Storage");

    let nuevoItemHTML = `
        <div class="card d-block w-70">
            

        <img src="/src/img/c1415.png" class="card-img" alt="sincompra" style="opacity:0.7">
        <div class="card-img-overlay" >
        <h1 class="colorNCarrito text-center">¿Aún no has añadido nada genial a tu carrito? Haz click <a href="catalogo.html">aquí</a></h1>

        </div>
    
            
        </div>`;
    listaProductosCarrito.insertAdjacentHTML("beforeend", nuevoItemHTML);
    
    console.log(total);
  }
} else {
  // El apartado 'carrito' no existe en el Local Storage
  console.log("El apartado 'carrito' no existe en el Local Storage");

  let nuevoItemHTML = `
        <div class="card d-block w-70">
            

        <img src="/src/img/c1415.png" class="card-img" alt="sincompra" style="opacity:0.7">
        <div class="card-img-overlay" >
        <h1 class="colorNCarrito text-center">¿Aún no has añadido nada genial a tu carrito? Haz click <a href="catalogo.html">aquí</a></h1>

        </div>
    
            
        </div>`;
  listaProductosCarrito.insertAdjacentHTML("beforeend", nuevoItemHTML);
  console.log(total);
}
//3.1 si existe pero no esta vacia -> hacer calculos

//-----------------eliminar
function eleminardeCarrito(indiceElminar) {
  if (indiceElminar !== -1) {
    carrito.splice(indiceElminar, 1);
    localStorage.setItem("carrito", JSON.stringify(carrito));
    console.log("Se ha eliminado el elemento en el índice " + indiceElminar);
  } else {
    localStorage.setItem("carrito", JSON.stringify(carrito));
    console.log("No se encontró el elemento");
  }
}

document.addEventListener("DOMContentLoaded", function () {
  const btnDelete = document.querySelectorAll(".styDelete");
  btnDelete.forEach((boton) => {
    boton.addEventListener("click", (e) => {
      const card = e.target.closest(".card");
      const productoE = {
        id: card.id,
      };
      let elemento = carrito.findIndex((item) => item.id === productoE.id);
      // Obtener el ID del elemento que se va a eliminar
      // let idElementoAEliminar = boton.dataset.id;
      // Obtener el índice del elemento en el carrito
      // let indiceElementoAEliminar = carrito.findIndex(item => item.id === idElementoAEliminar);
      eleminardeCarrito(elemento);
      window.location.reload(); //acutaliza la ventana
    });
  });
});

let subtotal = total.toFixed(2);
let costoEnvio = 100;
//let costoEnvio = leerCarrito();

// Calcular el total sumando el subtotal y el costo de envío
let totalConEnvio = (parseFloat(total) + costoEnvio).toFixed(2);

// Crear un objeto JSON con los datos
const datos = {
    item2InnerHTML: "Subtotal: $" + subtotal,
    item3InnerHTML: "Costo de envío: $" + costoEnvio,
    item4InnerHTML: "Total: $" + totalConEnvio
};

// Convertir el objeto JSON a cadena
const datosJSON = JSON.stringify(datos);

// Guardar la cadena en el Local Storage bajo la clave 'aPagar'
localStorage.setItem('aPagar', datosJSON);

//-----------pie total----------
let item2InnerHTML = "Subtotal: $" + total.toFixed(2);
let item3InnerHTML = "Costo de envio: $" + leerCarrito();
let item4InnerHTML = "Total: $" + (parseFloat(total) + leerCarrito()).toFixed(2);

subTotalPago.insertAdjacentHTML("beforeend", `<div>${item2InnerHTML}</div>`); //Envio
subTotalPago.insertAdjacentHTML("beforeend", `<div>${item3InnerHTML}</div>`); //subtotal
subTotalPago.insertAdjacentHTML("beforeend", `<div>${item4InnerHTML}</div>`); //total
//sutotal2.insertAdjacentHTML("beforeend", `<div>${item4InnerHTML}</div>`);//tota
function sumarProductos(carrito) {
  let suma = 0;
  for (let index = 0; index < carrito.length; index++) {
    let element = carrito.precio[index];
    suma += element;
  }
}
//------------------

function leerCarrito() {
    let envio = 0;
    // Verificar si el elemento con id 'btnConseguir' existe en el DOM
    let btnConseguir = document.getElementById('btnConseguir');
    if (btnConseguir) {
      // El elemento existe, entonces podemos intentar acceder a su estilo
      if (carrito && carrito.length > 0) {
        envio = 100;
        // Mostrar el botón cuando el carrito no esté vacío
        btnConseguir.style.display = 'block';
      }
    } else {
      console.error('El elemento con id "btnConseguir" no está presente en el DOM.');
    }
    return envio;
  }
