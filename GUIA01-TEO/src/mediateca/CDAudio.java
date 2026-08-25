package mediateca;

public class CDAudio extends MaterialAudioVisual {
    private String artista;
    private int Numerodecanciones;

    public CDAudio(String codigo, String titulo, String artista, String genero, String duracion, int Numerodecanciones, int unidadesDisponibles) {
        super(codigo, titulo, unidadesDisponibles, duracion, genero);
        setArtista(artista);
        setNumerodecanciones(Numerodecanciones);
    }

    public String getArtista() { return artista; }
    public void setArtista(String artista) {
        this.artista = (artista != null && !artista.trim().isEmpty()) ? artista : "Desconocido";
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