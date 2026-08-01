package mediateca;

public class DVD extends Formato {
    private String director;
    private String duracion;
    private String genero;

    public DVD(String codigo, String titulo, String director, String duracion, String genero, int unidadesDisponibles) {
        super(codigo, titulo, unidadesDisponibles);
        setDirector(director);
        setDuracion(duracion);
        setGenero(genero);
    }

    public String getDirector() { return director; }
    public void setDirector(String director) {
        this.director = (director != null && !director.trim().isEmpty()) ? director : "Desconocido";
    }

    public String getDuracion() { return duracion; }
    public void setDuracion(String duracion) {
        this.duracion = (duracion != null && !duracion.trim().isEmpty()) ? duracion : "00:00";
    }

    public String getGenero() { return genero; }
    public void setGenero(String genero) {
        this.genero = (genero != null && !genero.trim().isEmpty()) ? genero : "Varios";
    }

    @Override
    public String mostrarInfo() {
        return String.format("[DVD] Código: %s | Título: %s | Director: %s | Duración: %s | Género: %s | Unidades: %d",
                getCodigo(), getTitulo(), getDirector(), getDuracion(), getGenero(), getTotaldeunidades());
    }
}