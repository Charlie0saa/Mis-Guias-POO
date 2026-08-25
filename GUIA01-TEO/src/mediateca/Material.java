//Integrantes:
//Cesar Daniel Trejo Rodriguez carnet: TR262213
//Edwin Fernando Amaya Navarro         “AN262051”
//Marcos Ezequiel Ayala Palacios       “AP260351”
//Carlos Josue Azucena Ayala           “AA260854”
//Jorge Alberto Orellana Henriquez     “OH240812”

package mediateca;

public abstract class Material {

    protected String codigo;
    protected String titulo;
    protected int totaldeunidades;

    public Material(String codigo, String titulo, int totaldeunidades) {
        setCodigo(codigo);
        setTitulo(titulo);
        setTotaldeunidades(totaldeunidades);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo != null && !codigo.trim().isEmpty()) {
            this.codigo = codigo;
        } else {
            System.out.println(" Error: Código inválido.");
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo != null && !titulo.trim().isEmpty()) {
            this.titulo = titulo;
        } else {
            System.out.println(" Error: El título no puede estar vacío.");
            this.titulo = "Sin Título";
        }
    }

    public int getTotaldeunidades() {
        return totaldeunidades;
    }

    public void setTotaldeunidades(int totaldeunidades) {
        if (totaldeunidades >= 0) {
            this.totaldeunidades = totaldeunidades;
        } else {
            System.out.println(" Error: Las unidades disponibles no pueden ser negativas.");
            this.totaldeunidades = 0;
        }
    }

    public abstract String mostrarInfo();
}