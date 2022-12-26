package controller;

import data.PeliculaDAO;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Pelicula;

@WebServlet("/servletControlador")
public class ServletControlador extends HttpServlet{

    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException{
        String accionJava = req.getParameter("accion");
        if(accionJava!=null){
            switch(accionJava){
                case"editar":
                    editarPelicula(req,res);
                    break;
                case"eliminar":
                    eliminarPelicula(req,res);
                    break;
                    
                default:
                    accionDefault(req,res);
                    break;
            }
            }else{
            accionDefault(req,res);
                    
                    }
        }
        
      
        
    
      
   
    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException{
        String accionJava = req.getParameter("accion");
        
        if(accionJava!= null){
            switch (accionJava){
                case "insertar":
                    insertarPelicula(req,res);
                    break;
                case "modificar":
                    modificarPelicula(req,res);
                    break;

                default:
                  accionDefault(req,res);
                    break;
            }
        }else{
           accionDefault(req,res);
        }
    }
    
    private double calcularDuracion(List<Pelicula>peliculasLista){
        double cantidad = 0 ;
        for (int i =0;i<peliculasLista.size(); i++){
            cantidad += peliculasLista.get(i).getDuracion();    
        }
        BigDecimal cantRedondeado = BigDecimal.valueOf(cantidad);
        return cantRedondeado.setScale(2,RoundingMode.HALF_UP).doubleValue();
        
    }
    private void accionDefault( HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException{
                List<Pelicula> peliculas = new PeliculaDAO().seleccionar();
        peliculas.forEach(System.out::println);
        
        HttpSession session = req.getSession();
        
        session.setAttribute("peliculas",peliculas);
        session.setAttribute("totalPeliculas",peliculas.size());
        session.setAttribute("duracionTotal",calcularDuracion(peliculas));
        res.sendRedirect("peliculas.jsp");
         
    }
    
    private void insertarPelicula( HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException{
        String nombre = req.getParameter("nombre");
        String autor = req.getParameter("autor");
        double duracion = 0;
        double precio = 0;
        int copias = 0;
        String duracionString = req.getParameter("duracion");
        if(duracionString!=null && !duracionString.equals("")){
             duracion = Double.parseDouble(duracionString);
        }
        String precioString= req.getParameter("precio");
        if(precioString!=null && !precioString.equals("")){
             precio = Double.parseDouble(precioString);           
        }
        String copiasString =req.getParameter("copias");
        if(copiasString !=null && !copiasString.equals("")){
             copias = Integer.parseInt(copiasString);
        }    
        Pelicula pelicula = new Pelicula(nombre,autor,duracion,precio,copias);
        int regMod = new PeliculaDAO().insertar(pelicula);
        System.out.println("registros guardados: "+regMod);
        
        accionDefault(req,res);
    }
    
    private void editarPelicula( HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException{
        
        int idpelicula = Integer.parseInt(req.getParameter("idPelicula"));
        
        Pelicula pelicula = new PeliculaDAO().seleccionarPorId(idpelicula);
        
        req.setAttribute("pelicula", pelicula);
        
        String jspEditar="/WEB-INF/paginas/operaciones/editarPelicula.jsp";
        
        req.getRequestDispatcher(jspEditar).forward(req, res);
    }
    
 
        
    
private void modificarPelicula( HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException{
            
        int idpelicula = Integer.parseInt(req.getParameter("idPelicula"));
        
        String nombre = req.getParameter("nombre");
        String autor = req.getParameter("autor");
        double duracion = 0;
        double precio = 0;
        int copias = 0;
        String duracionString = req.getParameter("duracion");
        if(duracionString!=null && !duracionString.equals("")){
             duracion = Double.parseDouble(duracionString);
        }
        String precioString= req.getParameter("precio");
        if(precioString!=null && !precioString.equals("")){
             precio = Double.parseDouble(precioString);           
        }
        String copiasString =req.getParameter("copias");
        if(copiasString !=null && !copiasString.equals("")){
             copias = Integer.parseInt(copiasString);
        }    
        Pelicula pelicula = new Pelicula(idpelicula, nombre, autor, duracion, precio, copias);
        int regMod = new PeliculaDAO().actualizar(pelicula);
        System.out.println("registros actualizados: "+regMod);
       
        
        accionDefault(req,res);
    }
private void eliminarPelicula( HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException{

      int idpelicula = Integer.parseInt(req.getParameter("idPelicula"));
      int regBorrados= new PeliculaDAO().eliminar(idpelicula);
      System.out.println("registros eliminados: " + regBorrados);
      accionDefault(req,res);
      
    }
}

 