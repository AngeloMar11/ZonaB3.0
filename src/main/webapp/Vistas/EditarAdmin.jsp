<%@ page import="org.ZonaBarber.webapp.models.beans.Trabajador" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="Vistas/css/AdminPage.css">
    <link rel="stylesheet" href="Vistas/css/adminEditar.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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
            <div class="menu-inicio">
                <%
                    String nombre = (String) session.getAttribute("nombreUsuario");
                    String nombreS = nombre;
                %>
                <h4 class="m-0"><%=nombreS%>
                </h4>
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
        <button id="sidebarCollapse" type="button" class="btn btn-light bg-white rounded-pill shadow-sm px-4 mb-4"><i
                class="fa fa-bars mr-2"></i><small class="text-uppercase font-weight-bold">Opciones</small></button>
        <button id="perfil" type="button" class="btn btn-light bg-white rounded-pill shadow-sm px-4 mb-4"
                onclick="mostrarPerfilMenu()">
            <i class="fa fa-bars mr-2"></i>
            <small class="text-uppercase font-weight-bold">Perfil</small>
        </button>
        <ul id="perfil-menu" class="menu  rounded" style="display: none;">
            <li class=" rounded-pill  font-italic bg-light bi-arrow-right-square"><a> Cerrar sesión</a></li>
            <li class=" rounded-pill font-italic bg-light bi-arrow-right-square"><a> Editar perfil</a></li>
        </ul>

    </div>


    <h2 class="display-4 text-white">Buscar Empleado</h2>


    <p class="lead text-white mb-0">Datos</p> <br>
    <div class="container">


        <form action="<%=request.getContextPath()%>/editarEmpl" method="post">
            <label for="nombre" class="font-italic"><strong>Número de documento:</strong></label><br>
            <input type="text" name="NumDocument" class="nombre font-italic" id="nombre" maxlength="20">
            <br><br>
            <button type="submit" name="btnbuscar" class="btn btn-light bg-white rounded-pill shadow-sm px-4 mb-4">
                <small class="text-uppercase font-weight-bold">Buscar</small>
            </button>
            <div class="form-group">
                <table class="table">
                    <thead class="thead-dark">
                    <tr>
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellido</th>
                        <th scope="col">Correo</th>
                        <th scope="col">Cédula</th>
                        <th scope="col">Tipo de empleado</th>
                        <th scope="col">Número de teléfono</th>
                        <th scope="col">Acciones</th>
                    </tr>
                    </thead>
                    <tbody>
                    <% List<Trabajador> trabajadores = (List<Trabajador>) request.getAttribute("trabajadores");
                        if (trabajadores != null && trabajadores.size() > 0) {
                            for (Trabajador trabajador : trabajadores) { %>
                    <tr>
                        <td><%=trabajador.getEmplNombre()%>
                        </td>
                        <td><%=trabajador.getEmplApellido()%>
                        </td>
                        <td><%=trabajador.getEmplCorreo()%>
                        </td>
                        <td><%=trabajador.getEmplNumIdent()%>
                        </td>
                        <% String tipoEmpleado;
                            if (trabajador.getEmplTipoEmpl().toString().equals("1")) {
                                tipoEmpleado = "Administrador";
                            } else {
                                tipoEmpleado = "Empleado";
                            } %>
                        <td><%=tipoEmpleado%>
                        </td>
                        <td><%=trabajador.getEmplNumeroTel()%>                    </td>
                        <td>
                            <div class="opciones-menu-<%=trabajador.getEmplNumIdent()%>">
                                <button class="btn btn-secondary dropdown-toggle" type="button"
                                        onclick="mostrarOpciones('<%=trabajador.getEmplNumIdent()%>')">
                                    Opciones
                                </button>
                                <ul id="opciones-menu-<%=trabajador.getEmplNumIdent()%>" class="menu  rounded"
                                    style="display: none;">
                                    <li>
                                        <button class="buttonedit-<%=trabajador.getEmplNumIdent()%>" type="button"
                                                style="border-width: 0px"
                                                onclick="mostrarDatos('<%=trabajador.getEmplNombre()%>',
                                                        '<%=trabajador.getEmplApellido()%>', '<%=trabajador.getEmplCorreo()%>','<%=trabajador.getEmplNumIdent()%>',
                                                        '<%=trabajador.getEmplNumeroTel()%>',
                                                        '<%=tipoEmpleado%>')">Editar
                                        </button>
                                    </li>
                                    <li>
                                        <button class="buttonelim-<%=trabajador.getEmplNumIdent()%>" type="button"
                                                style="border-width: 0px"
                                                onclick="mostrarDatos2('<%=trabajador.getEmplNombre()%>','<%=trabajador.getEmplApellido()%>',
                                                        '<%=trabajador.getEmplNumIdent()%>')">Eliminar</button>
                                    </li>
                                </ul>
                            </div>
                        </td>
                    </tr>
                    <% }
                    } %>
                    </tbody
    >

                </table>
                <button type="submit" name="btnmostrart"
                        class="btn btn-light bg-white rounded-pill shadow-sm px-4 mb-4">
                    <small class="text-uppercase font-weight-bold">Mostrar Todo</small>
                </button>
            </div>

        </form>
    </div>
    <div id="miModal" class="modal" style="display: none">
        <%--@declare id="correo"--%>
        <button id="closeBtn" class="close" onclick="closeModal()">&times;</button>
        <br>
        <p class="modal-header font-italic" style="position: center">
            Editar Perfil
        </p>
        <form action="<%=request.getContextPath()%>/editarEmpl" method="post">
            <%--@declare id="apellido"--%><label for="nombre-input" class="font-italic"><strong>Nombre:</strong></label><br>
            <input type="text" id="nombre-input" name="Emplnombre" maxlength="20" readonly><br>
            <label for="apellido-input" class="font-italic"><strong>Apellido:</strong></label><br>
            <input type="text" id="apellido-input" name="Emplapellido" maxlength="20" readonly><br>
            <label for="correo-input" class="font-italic"><strong>Correo:</strong></label><br>
            <input type="text" id="correo-input" name="Emplacorreo" maxlength="20" required><br>
                <label for="cedula-input" class="font-italic"><strong>Cédula:</strong></label><br>
                <input type="text" id="cedula-input" name="EmplNumIdent" maxlength="20" readonly><br>
            <label for="telefono-input" class="font-italic"><strong>Teléfono:</strong></label><br>
            <input type="text" id="telefono-input" name="EmpltelefonoE" maxlength="20" required><br>
            <label for="tipoEmpleado-input" class="font-italic"><strong>Tipo de usuario:</strong></label><br>
            <select name="EmpltipoUsuario" id="tipoEmpleado-input" class="tipoUsuarioE font-italic"required>
                <option value="nn">---Seleccione---</option>
                <option value="1">Administrador</option>
                <option value="2">Empleado</option>
            </select>
            <br><br>
            <button type="submit" name="btnaplicar" class="btn btn-light bg-white rounded-pill shadow-sm px-4 mb-4">
                <small class="text-uppercase font-weight-bold">Aplicar</small>
            </button>
        </form>
    </div>
    <div id="miModal2" class="modal" style="max-height: 420px; display: none" >
        <%--@declare id="correo"--%>
        <button id="closeBtn" class="close" onclick="closeModal2()">&times;</button>
        <br>
        <p class="modal-header font-italic" style="position: center">
            Eliminar Perfil
        </p>
        <form action="<%=request.getContextPath()%>/editarEmpl" method="post">
            <%--@declare id="apellido"--%><label for="nombr-input" class="font-italic"><strong>Nombre:</strong></label><br>
            <input type="text" id="nombr-input" name="Emplnombre" maxlength="20" readonly><br>
            <label for="apellid-input" class="font-italic"><strong>Apellido:</strong></label><br>
            <input type="text" id="apellid-input" name="Emplapellido" maxlength="20" readonly><br>
            <label for="cedul-input" class="font-italic"><strong>Cédula:</strong></label><br>
            <input type="text" id="cedul-input" name="EmplNumIdent" maxlength="20" readonly><br>
            <br>
                <button type="submit" name="btneliminar" class="btn btn-light bg-white rounded-pill shadow-sm px-4 mb-4" onclick="confirmarEliminacion()">
                    <small class="text-uppercase font-weight-bold">Eliminar</small>
                </button>
        </form>
    </div>
</div>
</div>


<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="Vistas/js/AdminPage.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="Vistas/js/adminedit.js"></script>
</body>

</html>