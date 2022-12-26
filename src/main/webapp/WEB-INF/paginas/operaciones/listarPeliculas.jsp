<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="es_AR"/>
<section id="Peliculas">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card"> 
                    <div class="card-header">
                        <h4>Listado de Peliculas</h4>
                    </div>

                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Autor</th>
                                <th>Duracion</th>
                                <th>Precio</th>
                                <th>copias</th>
                                <th>-</th>
                                
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="pelicula" items="${peliculas}" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${pelicula.nombre}</td>
                                    <td>${pelicula.autor}</td>
                                    <td>${pelicula.duracion}</td>
                                    <td><fmt:formatNumber value="${pelicula.precio}" type="currency"/></td> 
                                    
                                    <td>
                                        <a href="${pageContext.request.contextPath}/servletControlador?accion=editar&idPelicula=${pelicula.idpeliculas}" class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i>
                                            Editar                                            
                                        </a>
                                    </td> 
                                </tr>
                            </c:forEach>
                        </tbody>
                        
                    </table>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3>Cantidad Peliculas</h3>
                        <h4 class="display-4"><i class="fas fa-users"></i>${totalPeliculas}</h4>                        
                    </div>                
                </div>
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Duracion Total</h3>
                        <h4 class="display-4"><i class="fas fa-users"></i>${duracionTotal}</h4>                       
                    </div>                
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="/WEB-INF/paginas/operaciones/agregarPelicula.jsp"/> 