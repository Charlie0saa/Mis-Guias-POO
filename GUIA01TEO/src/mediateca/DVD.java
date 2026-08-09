package mediateca;

public class DVD extends MaterialAudioVisual {
    private String director;

    public DVD(String codigo, String titulo, String director, String duracion, String genero, int unidadesDisponibles) {
        super(codigo, titulo, unidadesDisponibles, duracion, genero);
        setDirector(director);
    }

    public String getDirector() { return director; }
    public void setDirector(String director) {
        this.director = (director != null && !director.trim().isEmpty()) ? director : "Desconocido";
    }

    @Override
    public String mostrarInfo() {
        return String.format("[DVD] Código: %s | Título: %s | Director: %s | Duración: %s | Género: %s | Unidades: %d",
                getCodigo(), getTitulo(), getDirector(), getDuracion(), getGenero(), getTotaldeunidades());
    }
}