
let itemsContainer = document.getElementById("list-items");

//Arreglo de los productos favoritos
let favoritos = []
//Los id de kits son de 1-6
let productos = [
  {
    id: "1",
    img: "./src/img/kits/kits2.jpg",
    description: "<b>Kit PetPaseador</b><br> Sartén para comida o agua <br> Correa rosa <br> Dos Pelotas",
    precio: "200",
  },
  {
    id: "2",
    img: "./src/img/kits/kits3.jpg",
    description: "<b>Kit PrimerMichi</b> <br> Arenero <br> Rascador <br> Jaula transportadora (Kennel)",
    precio: "350",
  },
  {
    id: "3",
    img: "./src/img/kits/kits4.png",
    description: "<b>Kit Fashion</b> <br> Suéter de Toy Story <br> Pechera <br> Cepillo",
    precio: "150",
  },
  {
    id: "4",
    img: "./src/img/kits/kits1.1.png",
    description: "<b>Kit PetCare</b> <br> Cepillo <br> Corta garras <br> Bolsa color rosa",
    precio: "250",
  },
  {
    id: "5",
    img: "./src/img/kits/kits5.1.png",
    description: "<b>Kit PetCute</b> <br>Sartén para comida o agua <br> Suéter rosa de Mimi <br> Peluche de dinosaurio",
    precio: "150",
  },
  {
    id: "6",
    img: "./src/img/kits/kits6.1.png",
    description: "<b>Kit Pink</b> <br> Cepillo<br> Correa rosa <br> Sartén para comida o agua <br> Corta garras",
    precio: "250",
  },

  //apartir de aqui empiezan los productos 
  { 
    id: "7",
    img: "./src/img/Productos/RopaMinie.jpg",
    description: "Ropa para mascota, disney minnie mouse, camisa textil, rosa y grande",
    precio: "145.80"
  },
  {
    id: "8",
    img: "./src/img/Productos/CepilloLimpieza.jpg",
    description: "Cepillo de limpieza para mascotas sintético azul 19.7x10.6x5 Cm",
    precio: "79.90"
  },

  {
    id: "9",
    img: "./src/img/Productos/TazonPanda.jpg",
    description: "Tazón para mascota, panda animal de plástico y color blanco",
    precio: "99.90"
  },
  {
    id: "10",
    img: "./src/img/Productos/PelucheDinosaurio.jpg",
    description: "Peluche para mascota de dinosaurio, 100% Poliéster 35.5x13 Cm",
    precio: "129.90"
  },
  {
    id: "11",
    img: "./src/img/Productos/JugueteFutbol.jpg",
    description: "Juguete para mascota con sonido",
    precio: "29.90"
  },
  {
    id: "12",
    img: "./src/img/Productos/toallitaAzul1.jpg",
    description: "Toalla de baño con capucha, absorbente de alta calidad",
    precio: "150"
  },
  {
    id: "13",
    img: "./src/img/Productos/casaGatos3.jpg",
    description: "Casa para gatos, color morada con rascadero",
    precio: "350"
  },
  {
    id: "14",
    img: "./src/img/Productos/ChalecoArnes.jpg",
    description: "Chaleco con arnés para mascotas 100% poliéster azul 25x35",
    precio: "99.90"
  },
  {
    id: "15",
    img: "./src/img/Productos/DisfrazLaGarra.jpg",
    description: "Disfraz para mascota, de disney alíen toy story, textil de color verde y grande",
    precio: "149.90"
  },
  {
    id: "16",
    img: "./src/img/Productos/TazonRosa.jpg",
    description: "Tazón para mascota de disney minnie mouse, plástico y de color rosa",
    precio: "99.90"
  },
  {
    id: "17",
    img: "./src/img/Productos/cama4.jpg",
    description: "Cama Resistente con Relleno Suave y Color cafe",
    precio: "299"
  },
  {
    id: "18",
    img: "./src/img/Productos/collarPerro2.jpg",
    description: "Collar de piel, color cafe, grabado",
    precio: "250"
  },
];
let productosJSON = JSON.stringify(productos);
localStorage.setItem("productos", productosJSON);


productos.forEach(function (item) {
  // Crear el HTML para cada elemento
  let itemHTML = `
        <div class="card" id="${item.id}">
            <div>
                <img style="max-height:300px" src="${item.img}" class="card-img-top" alt="...">
                <button class="button-favorite">
                <i class="fa-regular fa-heart" id="corazon-vacio"></i>
                <i class="fa-solid fa-heart" id="corazon-lleno"></i>
                </button> 
                <button class="button-addcarrito">
                <i class="fa-solid fa-cart-shopping" style="color: #bababa;" id="carrito-vacio"></i>
                <i class="fa-solid fa-cart-shopping" id="carrito-lleno" ></i>
                </button> 
            </div>
            <div class="card-body">
                <p class="card-descripcion">${item.description}</p>
            </div>
            <div class="card-precio">
              <h5 class="">$${item.precio}</h5>
            </div>
        </div>`;

  // Insertar el HTML generado en el contenedor
  itemsContainer.insertAdjacentHTML("beforeend", itemHTML);
});

const token = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtb25zZUBnbWFpbC5jb20iLCJyb2xlIjoidXNlciIsImlhdCI6MTcxMjI5MDg3MiwiZXhwIjoxNzEyMzI2ODcyfQ.MVgMthcc6yrHShhlIBvuNTn3a_DovqTuLxnbd3-tK0s';

fetch('http://localhost:8080/api/products/', {
    method: 'GET',
    headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + token // Sin los dos puntos después de "Bearer"
    }
})
.then(response => response.json())
.then(data => {
    console.log('Success:', data);
})
.catch(error => {
    console.error('Error:', error);
});



localStorage.setItem("productos", productosJSON);
nuevoProducto = JSON.parse(localStorage.getItem("productosNuevos")) || [];
nuevoProducto.forEach(function (item) {
  let nuevoItemHTML = `
        <div class="card">
            <div>
                <img style="max-height:300px" src="${item.img}" class="card-img-top" alt="...">
                <button class="button-favorite">
                    <i class="fa-regular fa-heart"></i>
                </button> 
                <button class="button-addcarito">
                <i class="fa-solid fa-cart-shopping" style="color: #bababa;" id="carrito-vacio"></i>
                <i class="fa-solid fa-cart-shopping" id="carrito-lleno" ></i>
                </button>                 
            </div>
            <div class="card-body">
                <p class="card-descripcion">${item.description}</p>
            </div>
            <div class="card-precio">
              <h5 class="">$${item.precio}</h5>
            </div>
        </div>`;

  // Insertar el HTML generado en el contenedor
  itemsContainer.insertAdjacentHTML("beforeend", nuevoItemHTML);

});
//Hacer una sola key en el localstorage con todos los productos
productos = JSON.parse(localStorage.getItem('productos')) || [];
let todosProductos = productos.concat(nuevoProducto);
localStorage.setItem('todosProductos', JSON.stringify(todosProductos));

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


    
    
/*
fetch('https://manahuiaapi.onrender.com/api/viajes/', {
                method: 'POST',
                headers:{
                    'Content-Type': 'application/json',
                    "Authorization": "Bearer: " + token
                },
                body: JSON.stringify(data),
            })*/