<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="Vistas/css/AdminPage.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css" rel="stylesheet">
    
    <title>Document</title>
</head>
<body>
${fotoCliente}
    <div class="vertical-nav bg-white" id="sidebar">
        <div class="py-4 px-3 mb-4 bg-light">
          <div class="foto">
              <img src="<c:url value='${fotoCliente}'/>" alt="No lee la imagen" width="65" class="mr-3 rounded-circle img-thumbnail shadow-sm">
            <img id="logo"src="img/LogoZonaBarber.png" alt="">
            <div class="menu-inicio">
              <h4 class="m-0"><%=request.getAttribute("nombreCliente")%></h4>
              <p class="font-weight-light text-muted mb-0">Cliente</p>
            </div>
          </div>
        </div>

        <p class="text-gray font-weight-bold text-uppercase px-3 small pb-4 mb-0">Acciones</p>
      
        <ul class="nav flex-column bg-white mb-0">
          <li class="nav-item">
            <a href="#" class="nav-link text-dark font-italic bg-light">
             
                      <img src="img/people.png" alt="..." width="38">
                      Trabajadores
                      
                      <div id="opciones-adicionales" style="display: none;">
                        <br>
                        <!-- Aquí van las opciones adicionales -->
                        <p class="bi bi-arrow-right-square"> Crear Usuario</p>
                        <p class="bi bi-arrow-right-square"> Editar Usuario</p>
                    
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
                      Inventario
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
      </div>
      <!-- End vertical navbar -->
      
       
   
      <!-- Page content holder -->
      <div class="container">
        <img class="animation" src="img/carruel/Barber-rafiki.png" alt="tu-imagen">
      </div>
     
      
      <div class="page-content p-5" id="content">

        <!-- Toggle button -->
        <div class="perfil-menu-container">
          <button id="sidebarCollapse" type="button" class="btn btn-light bg-white rounded-pill shadow-sm px-4 mb-4"><i class="fa fa-bars mr-2"></i><small class="text-uppercase font-weight-bold">Opciones</small></button>
          <button id="perfil" type="button" class="btn btn-light bg-white rounded-pill shadow-sm px-4 mb-4" onclick="mostrarPerfilMenu()">
            <i class="fa fa-bars mr-2"></i>
            <small class="text-uppercase font-weight-bold">Perfil</small>
          </button>
          <ul id="perfil-menu" class="menu  rounded" style="display: none;">
            <li class=" rounded-pill  font-italic bg-light bi-arrow-right-square"><a > Cerrar sesión</a></li>
            <li class=" rounded-pill font-italic bg-light bi-arrow-right-square" ><a > Editar perfil</a></li>
          </ul>
         
        </div>
        
      
        
      
        <h2 class="display-3 text-white">Bienvenido <%=request.getAttribute("nombreCliente")%></h2>
        <p class="lead text-white mb-0">Cliente</p>
      
        <div class="separator"></div> 
         
      </div>
      
      <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
      <script src="Vistas/js/AdminPage.js"></script>

</body>
</html>