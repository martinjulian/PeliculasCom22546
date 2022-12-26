<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/fe272570ff.js" crossorigin="anonymous"></script> 
        <title>Editar Peliculas</title>
    </head>
    <body>
        <jsp:include page="../comunes/cabecera.jsp"/>
        <form action="${pageContext.request.contextPath}/servletControlador?accion=modificar&idPelicula=${pelicula.idpeliculas}" method="POST" class="was-validated">  
            <jsp:include page="../comunes/botonesNavegacionEditar.jsp"/>
            <section id="details"> 
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header"> 
                                    <h4>Modificar pelicula</h4> 

                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="nombre">Nombre</label>
                                        <input type="text" class="form-control" name="nombre"  value="${pelicula.nombre}" required/>                      
                                    </div>
                                    <div class="form-group">
                                        <label for="autor">Autor</label>
                                        <input type="text" class="form-control" name="autor" value="${pelicula.autor}" required/>                      
                                    </div>
                                    <div class="form-group">
                                        <label for="duracion">Duracion</label>
                                        <input type="number" class="form-control" name="duracion" step=".01" value="${pelicula.duracion}" required/>                      
                                    </div>
                                    <div class="form-group">
                                        <label for="precio">Precio</label>
                                        <input type="number" class="form-control" name="precio" step=".01" value="${pelicula.precio}" required/>                      
                                    </div>
                                    <div class="form-group">
                                        <label for="copias">Copias</label>
                                        <input type="number" class="form-control" name="copias" value="${pelicula.copias}" required/>                      
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form>





        <jsp:include page="../comunes/pieDePagina.jsp"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html> 
