<div class="modal fade" id="agregarPeliculaModal" tabindex="-1" aria-labelledby="agregarPeliculaModal" aria-hidden="true">
    <div class="modal-dialog moda-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5  class="modal-title">Agregar Peliculas</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>   
                </button>                
            </div>
            
            <form action="${pageContext.request.contextPath}/servletControlador?accion=insertar" method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" required/>                      
                    </div>
                    <div class="form-group">
                        <label for="autor">Autor</label>
                        <input type="text" class="form-control" name="autor" required/>                      
                    </div>
                    <div class="form-group">
                        <label for="duracion">Duracion</label>
                        <input type="number" class="form-control" name="duracion" step=".01" required/>                      
                    </div>
                    <div class="form-group">
                        <label for="precio">Precio</label>
                        <input type="number" class="form-control" name="precio" step=".01" required/>                      
                    </div>
                    <div class="form-group">
                        <label for="copias">Copias</label>
                        <input type="number" class="form-control" name="copias"  required/>                      
                    </div>
                </div> 
                 
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">
                        Guardar
                    </button>                   
                </div> 
            </form>
        </div>
    </div>
</div> 
            