package model;

public class Pelicula {
    private int idpeliculas;
    private String nombre;
    private String autor;
    private double duracion;
    private double precio;
    private int copias;

    public Pelicula(int idpeliculas, String nombre, String autor, double duracion, double precio, int copias) {
        this.idpeliculas = idpeliculas;
        this.nombre = nombre;
        this.autor = autor;
        this.duracion = duracion;
        this.precio = precio;
        this.copias = copias;
    }

    public Pelicula(String nombre, String autor, double duracion, double precio, int copias) {
        this.nombre = nombre;
        this.autor = autor;
        this.duracion = duracion;
        this.precio = precio;
        this.copias = copias;
    }

    public Pelicula() {
    }
    

    
    public int getIdpeliculas() {
        return idpeliculas;
    }

    public void setIdpeliculas(int idpeliculas) {
        this.idpeliculas = idpeliculas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCopias() {
        return copias;
    }

    public void setCopias(int copias) {
        this.copias = copias;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "idpeliculas=" + idpeliculas + ", nombre=" + nombre + ", autor=" + autor + ", duracion=" + duracion + ", precio=" + precio + ", copias=" + copias + '}';
    }
    
    
}
