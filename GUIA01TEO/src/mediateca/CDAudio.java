package mediateca;

public class CDAudio extends Formato {
    private String artista;
    private String genero;
    private String duracion;
    private int Numerodecanciones;

    public CDAudio(String codigo, String titulo, String artista, String genero, String duracion, int Numerodecanciones, int unidadesDisponibles) {
        super(codigo, titulo, unidadesDisponibles);
        setArtista(artista);
        setGenero(genero);
        setDuracion(duracion);
        setNumerodecanciones(Numerodecanciones);
    }

    public String getArtista() { return artista; }
    public void setArtista(String artista) {
        this.artista = (artista != null && !artista.trim().isEmpty()) ? artista : "Desconocido";
    }

    public String getGenero() { return genero; }
    public void setGenero(String genero) {
        this.genero = (genero != null && !genero.trim().isEmpty()) ? genero : "Varios";
    }

    public String getDuracion() { return duracion; }
    public void setDuracion(String duracion) {
        this.duracion = (duracion != null && !duracion.trim().isEmpty()) ? duracion : "00:00";
    }

    public int getNumerodecanciones() { return Numerodecanciones; }
    public void setNumerodecanciones(int Numerodecanciones) {
        this.Numerodecanciones = (Numerodecanciones > 0) ? Numerodecanciones : 1;
    }

    @Override
    public String mostrarInfo() {
        return String.format("[CD AUDIO] Código: %s | Título: %s | Artista: %s | Género: %s | Duración: %s | Canciones: %d | Unidades: %d",
                getCodigo(), getTitulo(), getArtista(), getGenero(), getDuracion(), getNumerodecanciones(), getTotaldeunidades());
    }
}