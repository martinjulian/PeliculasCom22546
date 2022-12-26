package data;

import static data.Conexion.close;
import static data.Conexion.getConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pelicula;


public class PeliculaDAO {
    
    
    private static final String SQL_SELECT = "SELECT * FROM peliculas";
    private static final String SQL_SELECT_BY_ID = "SELECT idpeliculas, nombre, autor, duracion, precio, copias FROM peliculas WHERE idpeliculas = ?";
   
    private static final String SQL_INSERT = "INSERT INTO peliculas(nombre, autor, duracion, precio, copias) VALUES(?, ?, ?, ?, ?)";
    
    private static final String SQL_UPDATE = "UPDATE peliculas SET nombre = ?, autor = ?, duracion = ?, precio = ?, copias = ? WHERE idpeliculas = ?";
    

    private static final String SQL_DELETE = "DELETE FROM peliculas WHERE idpeliculas = ?";
   
    
    public List<Pelicula> seleccionar()  {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pelicula pelicula = null;
        List<Pelicula> peliculas = new ArrayList();

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idpeliculas = rs.getInt(1);
                String nombre = rs.getString("nombre");
                String autor = rs.getString("autor");
                double duracion = rs.getDouble("duracion");
                double precio = rs.getDouble("precio");
                int copias = rs.getInt("copias");
                

                pelicula = new Pelicula (idpeliculas, nombre, autor, duracion, precio, copias);

                peliculas.add(pelicula);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PeliculaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return peliculas;
    }
    
    public int insertar(Pelicula pelicula) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, pelicula.getNombre());
            stmt.setString(2, pelicula.getAutor());
            stmt.setDouble(3, pelicula.getDuracion());
            stmt.setDouble(4, pelicula.getPrecio());
            stmt.setInt(5, pelicula.getCopias());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PeliculaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
 
    public int actualizar(Pelicula pelicula){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, pelicula.getNombre());
            stmt.setString(2, pelicula.getAutor());
            stmt.setDouble(3, pelicula.getDuracion());
            stmt.setDouble(4, pelicula.getPrecio());
            stmt.setInt(5, pelicula.getCopias()); 
            stmt.setInt(6, pelicula.getIdpeliculas());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PeliculaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
//    
//    public int actualizarNombre(String username,String newname){
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        int registros = 0;
//        Users user = seleccionarPorNombre(username);
//        user.setUsername(newname);
//        try {
//            conn = getConexion();
//            stmt = conn.prepareStatement(SQL_UPDATE);
//            stmt.setString(1, user.getUsername());
//            stmt.setString(2, user.getPassword());
//            stmt.setInt(3, user.getIduser());
//            registros = stmt.executeUpdate();
//        } catch (SQLException ex) {
//            ex.printStackTrace(System.out);
//        }
//        finally{
//            try {
//                close(stmt);
//                close(conn);
//            } catch (SQLException ex) {
//                ex.printStackTrace(System.out);
//            }
//        }
//        return registros;
//    }
//
//    
     public int eliminar(int idpeliculas){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            
            stmt = conn.prepareStatement(SQL_DELETE);
            
            stmt.setInt(1,idpeliculas);
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PeliculaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
     
    public Pelicula seleccionarPorId(int id)  {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pelicula pelicula = null;

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                int idpeliculas = rs.getInt("idpeliculas");
                String nombre = rs.getString("nombre");
                String autor = rs.getString("autor");
                double duracion = rs.getDouble("duracion");
                double precio = rs.getDouble("precio");
                int copias = rs.getInt("copias");
                
                

                pelicula = new Pelicula (idpeliculas, nombre, autor, duracion, precio, copias);

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PeliculaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return pelicula;
    }
    
    
}
