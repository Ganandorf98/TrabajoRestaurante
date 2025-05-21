function cargarRestaurantes() {
    fetch('/api/')
        .then(response => response.json())
        .then(data => {
            const listaRestaurantes = document.getElementById("listaRestaurantes");
            listaRestaurantes.innerHTML = '';

            data.forEach(restaurante => {
                const li = document.createElement("li");
                li.classList.add("list-group-item");
                li.innerHTML = `
                <h3>${restaurante.nombre}</h3>
                    <p>Dirección: ${restaurante.dirección}</p>
                    <p>Tipo: ${restaurante.tipo}</p>
                    <button class="btn btn-sm btn-danger" onclick='eliminarRestaurante(${restaurante.cod_rest})'>Eliminar</button>
                    <h4>Platos:</h4>
                    <ul>
                        ${restaurante.platoList.map(plato => `
                            <li>
                                <h5>${plato.nombre} - $${plato.precio}</h5>
                                <img src="${plato.imagenUrl}" alt="${plato.nombre}" class="img-thumbnail" style="width: 200px;">
                            </li>
                        `).join('')}
                    </ul>
                    `;
                listaRestaurantes.appendChild(li);
            });
        });
}

function guardarRestaurante(event) {
    event.preventDefault();

    const id = document.getElementById("restauranteId").value;
    const nombre = document.getElementById("nombre").value;
    const dirección = document.getElementById("dirección").value;
    const tipo = document.getElementById("tipo").value;

    const restaurante = { nombre, dirección, tipo };
    console.log(restaurante);

    const method = id ? 'PUT' : 'POST';
    const url = id ? `/api/${id}` : '/api/';

    fetch(url, {
        method: method,
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(restaurante)
    }).then(() => {
        document.getElementById("formRestaurante").reset();
        cargarRestaurantes();
    });
}

function editarRestaurante(restaurante) {
    document.getElementById("restauranteId").value = restaurante.cod_rest;
    document.getElementById("nombre").value = restaurante.nombre;
    document.getElementById("direccion").value = restaurante.dirección;
    document.getElementById("tipo").value = restaurante.tipo;
}

function eliminarRestaurante(id) {
    if (confirm("¿Seguro que quieres eliminar este restaurante?")) {
        fetch(`/api/${id}`, { method: 'DELETE' })
            .then(() => cargarRestaurantes());
    }
}

