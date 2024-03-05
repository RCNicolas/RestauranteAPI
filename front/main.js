// main.js

async function obtenerPlatos() {
  try {
    const response = await fetch("http://localhost:8080/restaurant/plato");
    const platos = await response.json();
    return platos;
  } catch (error) {
    console.error("Error al obtener los platos:", error);
  }
}

async function mostrarPlatos() {
  const platos = await obtenerPlatos();

  const platosContainer = document.getElementById("platos-container");
  platosContainer.innerHTML = "";

  platos.forEach((plato) => {
    const platoDiv = document.createElement("div");
    platoDiv.innerHTML = `
    <img src="./imgs/PlatoRicoMMMmDeli.jpg" alt="" style="width: 200px;">

          <p>Nombre: ${plato.nombre}</p>
          <p>Descripción: ${plato.descripcion}</p>
          <p>Precio: ${plato.precio}</p>
          <button onclick="cargarPlatoEnFormulario(${plato.id}, '${plato.nombre}', '${plato.descripcion}', ${plato.precio})">Editar</button>
          <button onclick="eliminarPlato(${plato.id})">Eliminar</button>
          <hr>
      `;
    platosContainer.appendChild(platoDiv);
  });
}

function limpiarFormulario() {
  document.getElementById("plato-id").value = "";
  document.getElementById("nombre").value = "";
  document.getElementById("descripcion").value = "";
  document.getElementById("precio").value = "";
}

async function crearPlato() {
  const nombre = document.getElementById("nombre").value;
  const descripcion = document.getElementById("descripcion").value;
  const precio = parseFloat(document.getElementById("precio").value);

  try {
    const response = await fetch("http://localhost:8080/restaurant/plato", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ nombre, descripcion, precio }),
    });

    limpiarFormulario();
    mostrarPlatos();
  } catch (error) {
    console.error("Error al crear el plato:", error);
  }
}
async function actualizarPlato() {
  const id = parseInt(document.getElementById("plato-id").value);
  const nombre = document.getElementById("nombre").value;
  const descripcion = document.getElementById("descripcion").value;
  const precio = parseFloat(document.getElementById("precio").value);

  try {
    const response = await fetch(
      `http://localhost:8080/restaurant/plato/${id}`,
      {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ nombre, descripcion, precio }),
      }
    );

    limpiarFormulario();
    mostrarPlatos();
  } catch (error) {
    console.error("Error al actualizar el plato:", error);
  }
}
// Nueva función para cargar datos de un plato en el formulario
function cargarPlatoEnFormulario(id, nombre, descripcion, precio) {
  document.getElementById("plato-id").value = id;
  document.getElementById("nombre").value = nombre;
  document.getElementById("descripcion").value = descripcion;
  document.getElementById("precio").value = precio;
}
async function eliminarPlato(id) {
  try {
    const response = await fetch(
      `http://localhost:8080/restaurant/plato/${id}`,
      {
        method: "DELETE",
      }
    );

    if (response.ok) {
      console.log(`Plato con ID ${id} eliminado correctamente.`);
      mostrarPlatos(); // Actualizar la lista después de eliminar
    } else {
      console.error(`Error al eliminar el plato con ID ${id}.`);
    }
  } catch (error) {
    console.error("Error al eliminar el plato:", error);
  }
}

// Mostrar platos al cargar la página
mostrarPlatos();
