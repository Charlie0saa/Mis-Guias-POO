package mediateca;

public class Revista extends Formato {

    private String editorial;
    private String periodicidad;
    private String fechaPublicacion;

    public Revista(String codigo, String titulo, String editorial, String periodicidad, String fechaPublicacion, int unidadesDisponibles) {
        super(codigo, titulo, unidadesDisponibles);
        setEditorial(editorial);
        setPeriodicidad(periodicidad);
        setFechaPublicacion(fechaPublicacion);
    }

    public String getEditorial() { return editorial; }
    public void setEditorial(String editorial) {
        this.editorial = (editorial != null && !editorial.trim().isEmpty()) ? editorial : "Pendiente";
    }

    public String getPeriodicidad() { return periodicidad; }
    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = (periodicidad != null && !periodicidad.trim().isEmpty()) ? periodicidad : "Mensual";
    }

    public String getFechaPublicacion() { return fechaPublicacion; }
    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = (fechaPublicacion != null && !fechaPublicacion.trim().isEmpty()) ? fechaPublicacion : "N/A";
    }

    @Override
    public String mostrarInfo() {
        return String.format("[REVISTA] Código: %s | Título: %s | Editorial: %s | Periodicidad: %s | Fecha: %s | Unidades: %d",
                getCodigo(), getTitulo(), getEditorial(), getPeriodicidad(), getFechaPublicacion(), getTotaldeunidades());
    }
}