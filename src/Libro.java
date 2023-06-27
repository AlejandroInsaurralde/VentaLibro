public class Libro {
    private int id;
    private String genero;
    private String titulo;
    private String Autor;
    private String Editorial;
    private Estado Estado;
    private double Precio;

    //Constructores

    public Libro() {
    }

    public Libro(int id, String genero, String titulo, String autor, String editorial, Estado estado, double precio) {
        this.id = id;
        this.genero = genero;
        this.titulo = titulo;
        this.Autor = autor;
        this.Editorial = editorial;
        this.Estado = estado;
        this.Precio = precio;
    }

    //Getter and setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getEditorial() {
        return Editorial;
    }

    public void setEditorial(String editorial) {
        Editorial = editorial;
    }

    public Estado getEstado() {
        return Estado;
    }

    public void setEstado(Estado estado) {
        Estado = estado;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }
}
