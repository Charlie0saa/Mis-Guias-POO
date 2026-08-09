//Integrantes:
//Cesar Daniel Trejo Rodriguez carnet: TR262213
//Edwin Fernando Amaya Navarro         “AN262051”
//Marcos Ezequiel Ayala Palacios       “AP260351”
//Carlos Josue Azucena Ayala           “AA260854”
//Jorge Alberto Orellana Henriquez     “OH240812”

package mediateca;

public abstract class MaterialEscrito extends Material {

    protected String editorial;

    public MaterialEscrito(String codigo, String titulo, int totaldeunidades, String editorial) {
        super(codigo, titulo, totaldeunidades);
        setEditorial(editorial);
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = (editorial != null && !editorial.trim().isEmpty()) ? editorial : "Pendiente";
    }
}