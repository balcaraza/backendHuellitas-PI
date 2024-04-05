
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
      .then((data) => {
                    createProducts(data);
                    // Guardar los datos en el localStorage
                    localStorage.setItem('todosProductos', JSON.stringify(data));
                })
                .catch((err) => console.log("Error en el JSON"));
        })
        .catch((err) => console.log("Ocurrio un error en la solicitud", err));
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

const producto = document.querySelectorAll(".card");

const actualizarFavoritos = () => {
    localStorage.setItem("favoritos", JSON.stringify(favoritos));
};

const cargaFavoritos = () => {
    const almacenarFavoritos = localStorage.getItem("favoritos");

    if (almacenarFavoritos) {
        favoritos = JSON.parse(almacenarFavoritos);
        showHTML();
    }
};

const toggleFavoriteAndCart = (product, isFavorite, isCart) => {
    const index = favoritos.findIndex(element => element.id_producto === product.id);
    if (isFavorite) {
        if (index > -1) {
            favoritos.splice(index, 1);
        }
    } else {
        if (index === -1) {
            favoritos.push(product);
        }
    }
    localStorage.setItem("favoritos", JSON.stringify(favoritos));

    // Aquí puedes agregar la lógica para manejar el carrito de manera similar a como se hace con los favoritos
}

const showHTML = () => {
    producto.forEach(produc => {
        const productoId = produc.id_producto;

        const esFavorito = favoritos.some(favoritos => favoritos.id_producto === productoId);

        const favoritoBotonActivo = produc.querySelector("#corazon-lleno");
        const favoritoBotonDesactivado = produc.querySelector("#corazon-vacio");

        if (favoritoBotonActivo && favoritoBotonDesactivado) {
            favoritoBotonActivo.classList.toggle("active", esFavorito);
            favoritoBotonDesactivado.classList.toggle("active", esFavorito);
        }
    });
}

document.addEventListener("DOMContentLoaded", function () {
    const btnFavorite = document.querySelectorAll(".button-favorite");
    btnFavorite.forEach(boton => {
        boton.addEventListener('click', (e) => {
            const card = e.target.closest(".card");
            const productos = {
                id: card.id_producto,
                description: card.querySelector(".card-body p").textContent,
                precio: card.querySelector(".card-precio h5").textContent,
                img: card.querySelector(".card-img-top").src
            }
            toggleFavoriteAndCart(productos, true, false);
            showHTML();
            actualizarFavoritos();
        });
    });
    cargaFavoritos();
});

const handleAddToCart = (e) => {
    const card = e.target.closest(".card");
    const product = {
        id: card.id_producto,
        description: card.querySelector(".card-body p").textContent,
        price: card.querySelector(".card-precio h5").textContent,
        img: card.querySelector(".card-img-top").src
    };

    let cart = JSON.parse(localStorage.getItem("cart")) || [];
    cart.push(product);
    localStorage.setItem("cart", JSON.stringify(cart));

    updateUI(card, true, false);
}

const addToCartButtons = document.querySelectorAll(".button-addcarrito");
addToCartButtons.forEach(button => {
    button.addEventListener("click", handleAddToCart);
});

const updateUI = (card, isCart, isFavorite) => {
    const cartButtonActive = card.querySelector("#carrito-lleno");
    const cartButtonInactive = card.querySelector("#carrito-vacio");
    const favoriteButtonActive = card.querySelector("#corazon-lleno");
    const favoriteButtonInactive = card.querySelector("#corazon-vacio");

    if (cartButtonActive && cartButtonInactive) {
        cartButtonActive.classList.toggle("active", isCart);
        cartButtonInactive.classList.toggle("active", isCart);
    }

    if (favoriteButtonActive && favoriteButtonInactive) {
        favoriteButtonActive.classList.toggle("active", isFavorite);
        favoriteButtonInactive.classList.toggle("active", isFavorite);
    }

    setTimeout(() => {
        cartButtonActive.classList.remove("active");
        cartButtonInactive.classList.remove("active");
        favoriteButtonActive.classList.remove("active");
        favoriteButtonInactive.classList.remove("active");
    }, 400);
}


    
    
