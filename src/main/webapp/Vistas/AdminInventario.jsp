<%@ page import="org.ZonaBarber.webapp.models.beans.Trabajador" %><%@ page import="java.util.List" %>
<%@ page import="org.ZonaBarber.webapp.models.beans.Productos" %>
<%@ page import="java.util.Base64" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="Vistas/css/AdminPage.css">
    <link rel="stylesheet" href="Vistas/css/adminEditar.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js"></script>
    <title>Document</title>
</head>
<body>
<div class="vertical-nav bg-white" id="sidebar">
    <div class="py-4 px-3 mb-4 bg-light">
        <div class="foto">
            <img src="img/user.png" alt="..." width="65" class="mr-3 rounded-circle img-thumbnail shadow-sm">
            <img id="logo" src="img/LogoZonaBarber.png" alt="">
            <div class="menu-inicio"><%
                String nombre = (String) session.getAttribute("nombreUsuario");
                String nombreS = nombre;
            %> <h4 class="m-0"><%=nombreS%> </h4>
                <p class="font-weight-light text-muted mb-0">Administrador</p>
            </div>
        </div>
    </div>
    <p class="text-gray font-weight-bold text-uppercase px-3 small pb-4 mb-0">Acciones</p>
    <form action="<%=request.getContextPath()%>/adminMenu" method="post">
        <ul class="nav flex-column bg-white mb-0">
            <li class="nav-item">
                <a href="#" class="nav-link text-dark font-italic bg-light">

                    <img src="img/people.png" alt="..." width="38">
                    Trabajadores

                    <div id="opciones-adicionales" style="display: none;">
                        <br>
                        <!-- Aquí van las opciones adicionales -->
                        <button name="crearu" class="bi bi-arrow-right-square font-italic bg-light" id="buttoncrearu">
                            Crear Usuario
                        </button>
                        <br>
                        <button name="editaru" class="bi bi-arrow-right-square font-italic bg-light" id="buttoneditaru">
                            Editar Usuario
                        </button>
                    </div>
                </a>
            </li>
            <li class="nav-item">
                <a href="#" class="nav-link text-dark font-italic bg-light">

                    <img src="img/calendario.png" alt="..." width="38">
                    Horarios
                </a>
            </li>
            <li class="nav-item">
                <a href="#" class="nav-link text-dark font-italic bg-light">

                    <img src="img/inventario.png" alt="..." width="38">
                    <button name="invent" class=" font-italic bg-light" style="border-width: 0px; border: transparent" id="buttoninventario">
                        Inventario
                    </button>
                </a>
            </li>
            <li class="nav-item">
                <a href="#" class="nav-link text-dark font-italic bg-light">

                    <img src="img/etiqueta-de-descuento.png" alt="..." width="38">
                    Promociones
                </a>
            </li>
            <li class="nav-item">
                <a href="#" class="nav-link text-dark font-italic bg-light">

                    <img src="img/caja-registradora.png" alt="..." width="38">
                    Cierre caja
                </a>
            </li>
        </ul>
    </form>
</div>
<!-- End vertical navbar -->
<!-- Page content holder -->
<div class="container">
    <img class="animation" src="img/carruel/Barber-cuate.png" alt="tu-imagen">
</div>
<div class="page-content p-5" id="content">
    <!-- Toggle button -->
    <div class="perfil-menu-container">
        <button id="sidebarCollapse" type="button" class="btn btn-light bg-white rounded-pill shadow-sm px-4 mb-4">
            <i class="fa fa-bars mr-2"></i>
            <small class="text-uppercase font-weight-bold">Opciones</small>
        </button>
        <button id="perfil" type="button" class="btn btn-light bg-white rounded-pill shadow-sm px-4 mb-4" onclick="mostrarPerfilMenu()">
            <i class="fa fa-bars mr-2"></i>
            <small class="text-uppercase font-weight-bold">Perfil</small>
        </button>
        <ul id="perfil-menu" class="menu  rounded" style="display: none;">
            <li class=" rounded-pill  font-italic bg-light bi-arrow-right-square">
                <a> Cerrar sesión</a>
            </li>
            <li class=" rounded-pill font-italic bg-light bi-arrow-right-square">
                <a> Editar perfil</a>
            </li>
        </ul>
    </div>
    <h2 class="display-4 text-white">Inventario</h2>
    <p class="lead text-white mb-0">Productos</p>
    <br>
    <div class="container">
        <form action="<%=request.getContextPath()%>/inventarioBarber" method="post">
            <label for="NProducto" class="font-italic">
                <strong>Nombre de producto</strong>
            </label>
            <br>
            <input type="text" name="ProNombre" class="nombre font-italic" id="NProducto" maxlength="20">
            <br>
            <div id="container-suggestion"></div>
            <br>
            <button type="submit" name="btnbuscarI" class="btn btn-light bg-white rounded-pill shadow-sm px-4 mb-4">
                <small class="text-uppercase font-weight-bold">Buscar</small>
            </button>
            <button type="button" name="btnAgregarPro" class="btn btn-light bg-white rounded-pill shadow-sm px-4 mb-4">
                <small class="text-uppercase font-weight-bold" onclick="openModal3()">Agregar</small>
            </button>
            <div class="form-group">
                <table class="table">
                    <thead class="thead-dark">
                    <tr>
                        <th scope="col">Id de Producto</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Valor</th>
                        <th scope="col">Cantidad</th>
                        <th scope="col">Foto</th>
                    </tr>
                    </thead>
                    <tbody><% List
                            <Productos> productosList = (List
                            <Productos>) request.getAttribute("productos");
                        if (productosList != null && productosList.size() > 0) {
                            for (Productos productos : productosList) { %> <tr>
                        <td><%=productos.getProId()%> </td>
                        <td><%=productos.getProNombre()%> </td>
                        <td><%=productos.getProvalor()%> </td>
                        <td><%=productos.getProCantidad()%> </td>
                        <td><img src="data:image/jpeg;base64,<%=Base64.getEncoder().encodeToString(productos.getImageBytes())%>" alt="No encunetra" style="width: 50px; height: 50px"/></td>

                    </tr>

                    </tr><% }
                    } else { %>
                    <tr>
                        <td colspan="5">No hay productos registrados.</td>
                    </tr>
                    <% }
                    %> </tbody>
                </table>
                <button type="submit" name="btnmostrart" class="btn btn-light bg-white rounded-pill shadow-sm px-4 mb-4">
                    <small class="text-uppercase font-weight-bold">Mostrar Todo</small>
                </button>
            </div>
        </form>
    </div>

<div id="miModal3" class="modal" style="display: none">
    <%--@declare id="nombre-input"--%><%--@declare id="cedul-input"--%><button id="closeBtn" class="close" onclick="closeModal3()">&times;</button>
    <br>
    <p class="modal-header font-italic" style="text-align: center">
        Agregar Producto
    </p><form action="<%=request.getContextPath()%>/inventarioBarber" method="post">
    <%--@declare id="apellido"--%><label for="id-input" class="font-italic"><strong>Id Producto:</strong></label><br>
    <input type="text" id="id-input" name="ProId" maxlength="20" required><br>
    <label for="valor-input" class="font-italic"><strong>Nombre:</strong></label><br>
    <input type="text" id="valor-input" name="ProNombre" maxlength="20" required><br>
    <label for="cedul-input" class="font-italic"><strong>Valor:</strong></label><br>
    <input type="text" id="cantidad-input" name="ProValor" maxlength="20" required><br>
    <label for="cantidad-input" class="font-italic"><strong>Cantidad:</strong></label><br>
    <input type="text" id="-input" name="ProCantidad" maxlength="20" required><br>
    <label for="foto-input" class="font-italic"><strong>Foto:</strong></label><br>
    <input type="text" id="foto-input" name="ProFoto" maxlength="20" required><br>
    <br>
    <button type="submit" name="btnagregar" class="btn btn-light bg-white rounded-pill shadow-sm px-4 mb-4">
        <small class="text-uppercase font-weight-bold">Agregar nuevo producto</small>
    </button>
        </form>

</div>
</div>
<script>function openModal3(id) {

    console.log("Entro");
    document.getElementById("miModal3").style.display = "block";
    document.body.style.overflow = "hidden";
}</script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="Vistas/js/AdminPage.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="Vistas/js/adminedit.js"></script>
</body>
</html>