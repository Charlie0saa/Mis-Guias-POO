package mediateca;

public class Libro extends MaterialEscrito {

    private String autor;
    private int Numerodepags;
    private String isbn;
    private int Añodepublicacion;

    public Libro(String codigo, String titulo, String autor, int Numerodepags, String editorial, String isbn, int Añodepublicacion, int unidadesDisponibles) {
        super(codigo, titulo, unidadesDisponibles, editorial);
        setAutor(autor);
        setNumerodepags(Numerodepags);
        setIsbn(isbn);
        setAñodepublicacion(Añodepublicacion);
    }

    public String getAutor() { return autor; }
    public void setAutor(String autor) {
        this.autor = (autor != null && !autor.trim().isEmpty()) ? autor : "Desconocido";
    }

    public int getNumerodepags() { return Numerodepags; }
    public void setNumerodepags(int Numerodepags) {
        this.Numerodepags = (Numerodepags > 0) ? Numerodepags : 1;
    }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) {
        this.isbn = (isbn != null && !isbn.trim().isEmpty()) ? isbn : "000-0000000000";
    }

    public int getAñodepublicacion() { return Añodepublicacion; }
    public void setAñodepublicacion(int Añodepublicacion) {
        this.Añodepublicacion = (Añodepublicacion > 0) ? Añodepublicacion : 2000;
    }

    @Override
    public String mostrarInfo() {
        return String.format("[LIBRO] Código: %s | Título: %s | Autor: %s | Págs: %d | Editorial: %s | ISBN: %s | Año: %d | Unidades: %d",
                getCodigo(), getTitulo(), getAutor(), getNumerodepags(), getEditorial(), getIsbn(), getAñodepublicacion(), getTotaldeunidades());
    }
}