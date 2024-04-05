
let itemsContainer = document.getElementById("list-items");

//Arreglo de los productos favoritos
let favoritos = []
//Los id de kits son de 1-6






//const token = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiYWxjYXJhemFAZ21haWwuY29tIiwicm9sZSI6InVzZXIiLCJpYXQiOjE3MTIyOTYxMTUsImV4cCI6MTcxMjU1NTMxNX0.L1qFNhkZX0bKqCA4dYCg_3vb_hX7v_oWGZJ0lwQKbYE';

/*fetch('https://huellitas-p4xw.onrender.com/api/products/', {
    method: 'GET',
    headers: {
        'Content-Type': 'application/json',
        
    }
})
.then(response => response.json())
.then(data => {
    console.log('Success:', data);
})
.catch(error => {
    console.error('Error:', error);
});*/

function getData(){
    let promesa= fetch("https://huellitas-p4xw.onrender.com/api/products/", {method:"GET"});
    promesa.then((res)=>{
        res.json()
        .then((data)=>createProducts(data))
        .catch((err)=>console.log("Error en el JSON")); 
    })
    .catch((err)=>console.log("Ocurrio un error en la solicitud",err));
}

function createProducts(products){
	products.forEach(item => {
let nuevoItemHTML = `
        <div class="card">
            <div>
                <img style="max-height:300px" src="${item.imagen}" class="card-img-top" alt="...">
                <button class="button-favorite">
                    <i class="fa-regular fa-heart"></i>
                </button> 
                <button class="button-addcarito">
                <i class="fa-solid fa-cart-shopping" style="color: #bababa;" id="carrito-vacio"></i>
                <i class="fa-solid fa-cart-shopping" id="carrito-lleno" ></i>
                </button>                 
            </div>
            <div class="card-body">
                <p class="card-descripcion">${item.descripcion}</p>
            </div>
            <div class="card-precio">
              <h5 class="">$${item.precio}</h5>
            </div>
        </div>`;

  // Insertar el HTML generado en el contenedor
  itemsContainer.insertAdjacentHTML("beforeend", nuevoItemHTML);
  
});
}
getData();




localStorage.setItem('todosProductos', JSON.stringify(data));

const producto = document.querySelectorAll(".card");

//Actualizar los favoritos en el localStorage
const actualizarFavoritos = () => {
  localStorage.setItem("favoritos", JSON.stringify(favoritos));
};

//Cargar los favoritos
const cargaFavoritos = () => {

  const almacenarFavoritos = localStorage.getItem("favoritos");

  // Si hay datos a almacenar 
  if (almacenarFavoritos) {
    favoritos = JSON.parse(almacenarFavoritos);
    showHTML();
  }
};

// Función para añadir o quitar un producto de la lista de favoritos
const toggleFavorite = (producto) => {
    // Busca el índice del producto en la lista de favoritos
    const index = favoritos.findIndex(element => element.id === producto.id);

    // Si el producto ya está en la lista de favoritos, lo elimina; de lo contrario, lo añade
  if (index > -1) {
    favoritos.splice(index, 1); // Elimina el producto de la lista de favoritos
    actualizarFavoritos(); // Actualiza el localStorage con los cambios
  } else {
    favoritos.push(producto); // Añade el producto a la lista de favoritos
    actualizarFavoritos(); // Actualiza el localStorage con los cambios
  };
};

// Función para mostrar los productos en el HTML y actualizar los botones de favoritos y carrito
const showHTML = () => {
  // Itera sobre cada producto
  producto.forEach(produc => {
    const productoId = produc.id;

    const esFavorito = favoritos.some(favoritos => favoritos.id === productoId);
    
    //const favoritoBoton = produc.querySelector(".button-favorite");
    const favoritoBotonActivo = produc.querySelector("#corazon-lleno");
    const favoritoBotonDesactivado = produc.querySelector("#corazon-vacio");

    if (favoritoBotonActivo && favoritoBotonDesactivado) {
      favoritoBotonActivo.classList.toggle("active", esFavorito);
      favoritoBotonDesactivado.classList.toggle("active", esFavorito);
    }

    console.log("=======================");
    console.log(productoId);
    console.log(esFavorito);
    //favoritoBoton.classList.toggle("favorite-active", esFavorito);
    
  })
}

//Agrega un evento que escucha el evento DOMContentLoaded al objeto document. El DOMContentLoaded se dispara cuando el HTML ha sido completamente cargado y analizado
document.addEventListener("DOMContentLoaded", function () {
  //Se seleccionan todos los elementos del DOM que tienen la clase .button-favorite y se almacenan en la variable btnFavorite
  const btnFavorite = document.querySelectorAll(".button-favorite");
  //Iterar sobre cada botón en la colección btnFavorite
  btnFavorite.forEach(boton => {
    boton.addEventListener('click', (e) => {
      //Para obtener un elemento especifico del html
      const card = e.target.closest(".card");
      // Crear un objeto con la información del producto basado en el elemento card
      const productos = {
        id: card.id,
        description: card.querySelector(".card-body p").textContent,
        precio: card.querySelector(".card-precio h5").textContent,
        img: card.querySelector(".card-img-top").src
      }
      toggleFavorite(productos);
      showHTML();
      actualizarFavoritos();
    });
  });
  cargaFavoritos();
});




///------------------------------------------ Agregar a array de Carrito-----------------
// Función para manejar el evento de clic en los botones de agregar al carrito
const handleAddToCart = (e) => {
  // Obtener la tarjeta (card) que contiene el botón presionado
  const card = e.target.closest(".card");
  
  // Crear un objeto con la información del producto basado en la tarjeta
  const product = {
    id: card.id,
    description: card.querySelector(".card-body p").textContent,
    precio: card.querySelector(".card-precio h5").textContent,
    img: card.querySelector(".card-img-top").src
  };
  
  // Obtener los productos en el carrito desde el localStorage o un arreglo vacío si no hay ninguno
  let carrito = JSON.parse(localStorage.getItem("carrito")) || [];

  // Agregar el producto al arreglo de productos en el carrito
  carrito.push(product);

  // Actualizar el localStorage con los productos en el carrito
  localStorage.setItem("carrito", JSON.stringify(carrito));

  // Llamar a la función para actualizar la interfaz del carrito
  updateCartUI(card, true);
 
}

// Agregar el evento de clic a todos los botones de agregar al carrito
const addToCartButtons = document.querySelectorAll(".button-addcarrito");
  addToCartButtons.forEach(button => {
  button.addEventListener("click", handleAddToCart);

});

//Funcion para actualizar la interfaz del catalogo cuando se agregan o eliminan productos del carrito
const updateCartUI = (car, esCarrito) => {
  //Obtener los elementos de los botones del carrito del html
  const carritoBotonActivo = car.querySelector("#carrito-lleno");
  const carritoBotonDesactivado = car.querySelector("#carrito-vacio");

  if(carritoBotonActivo && carritoBotonDesactivado){
    carritoBotonActivo.classList.toggle("active", esCarrito);
    carritoBotonDesactivado.classList.toggle("active", esCarrito);
  }
  // Después de un tiempo, quitar la iluminación del carrito
  setTimeout(() => {
    carritoBotonActivo.classList.remove("active");
    carritoBotonDesactivado.classList.remove("active");
}, 400);
}


    
    
