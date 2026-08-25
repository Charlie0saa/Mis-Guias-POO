//Integrantes:
//Cesar Daniel Trejo Rodriguez carnet: TR262213
//Edwin Fernando Amaya Navarro         “AN262051”
//Marcos Ezequiel Ayala Palacios       “AP260351”
//Carlos Josue Azucena Ayala           “AA260854”
//Jorge Alberto Orellana Henriquez     “OH240812”

package mediateca;

public abstract class MaterialAudioVisual extends Material {

    protected String duracion;
    protected String genero;

    public MaterialAudioVisual(String codigo, String titulo, int totaldeunidades, String duracion, String genero) {
        super(codigo, titulo, totaldeunidades);
        setDuracion(duracion);
        setGenero(genero);
    }

    public String getDuracion() { return duracion; }
    public void setDuracion(String duracion) {
        this.duracion = (duracion != null && !duracion.trim().isEmpty()) ? duracion : "00:00";
    }

    public String getGenero() { return genero; }
    public void setGenero(String genero) {
        this.genero = (genero != null && !genero.trim().isEmpty()) ? genero : "Varios";
    }
}