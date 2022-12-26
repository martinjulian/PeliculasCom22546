<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/fe272570ff.js" crossorigin="anonymous"></script> 
        <title>Control de Peliculas</title>
    </head>
    <body>
        <jsp:include page="WEB-INF/paginas/comunes/cabecera.jsp"/>
        <jsp:include page="WEB-INF/paginas/comunes/botonesNavegacion.jsp"/>

        <jsp:include page="WEB-INF/paginas/operaciones/listarPeliculas.jsp"/>
        
        <jsp:include page="WEB-INF/paginas/comunes/pieDePagina.jsp"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html> 


