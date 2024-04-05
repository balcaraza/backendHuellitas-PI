const btnsFavorite=document.querySelectorAll('.favorite');
const products = document.querySelectorAll(".card-product");
let img = document.getElementById(".img-fav");

// Traer los datos de las cards de catalogo a favoritos
itemsContainer = document.getElementById("items-favoritos")

const traerFavoritosCatalogo = JSON.parse(localStorage.getItem("favoritos"));
const carrito = JSON.parse(localStorage.getItem("carrito"));//instancia de carrito

console.log(traerFavoritosCatalogo);

traerFavoritosCatalogo.forEach(function (item) { 
    // Crear el HTML para cada elemento
    let itemHTML = `
    <div class="card mb-3 card-product" id="${item.id}" style="max-width: 540px;">      
      <div class="row g-0">
        <div class="col-md-4 cont-img">        
          <img style="max-height:500px" src=${item.img} class="img-fluid card-img-top rounded-start img-fav fav" alt="...">            
        </div>
        <div class="col-md-8 contenedor-texto">
          <div class="card-body">
            <p class="card-text precio">${item.precio}</p>         
            <p class="card-text description">${item.description}</p>
          
            <div class="botones">
              <button class="favorite" onclick="removeFavorite('${item.id}')">
                <i class="fa-solid fa-heart" id="corazon-lleno"></i>
              </button>
              <button class="button-addcarito"> 
              <i class="fa-solid fa-cart-shopping" style="color: #bababa;" id="carrito-vacio"></i>
              <i class="fa-solid fa-cart-shopping" id="carrito-lleno" ></i>
              </button>
            </div>
          </div> 
        </div>
      </div>
    </div>`
  
    // Insertar el HTML generado en el contenedor
    itemsContainer.insertAdjacentHTML("beforeend", itemHTML);
  });
  
  // Funcion para remover un favorito de localStorage y actualizar la vista
function removeFavorite(id) {
  const index = traerFavoritosCatalogo.findIndex(item => item.id === id);
  if (index !== -1) {
      traerFavoritosCatalogo.splice(index, 1); // Elimina el elemento del arreglo
      localStorage.setItem("favoritos", JSON.stringify(traerFavoritosCatalogo)); // Actualiza localStorage
      document.getElementById(id).remove(); // Elimina la tarjeta del DOM
  }
}



//----------añadir a carrito ---- 
 //agregar al carrito 
const handleAddToCart= (e)=>{
  const card = e.target. closest(".card");
  const product = {
    id: card.id,
    description: card.querySelector('.contenedor-texto .card-body .description').textContent,
    precio: card.querySelector('.contenedor-texto .card-body .precio').textContent,
    img: card.querySelector('.card-img-top').src

  }
  console.log(product.id);
  const carrito = JSON.parse(localStorage.getItem("carrito")) || [];//NO LA QUITES O NO FUNCIONA
  carrito.push(product);
  localStorage.setItem("carrito", JSON.stringify(carrito));

  updateCartUI(card, true);

}


const agregarACarrito= document.querySelectorAll(".button-addcarito");
agregarACarrito.forEach(button => {
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
