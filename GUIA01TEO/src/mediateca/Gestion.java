//Integrantes:
//Cesar Daniel Trejo Rodriguez carnet: TR262213
//Edwin Fernando Amaya Navarro         “AN262051”
//Marcos Ezequiel Ayala Palacios       “AP260351”
//Carlos Josue Azucena Ayala           “AA260854”
//Jorge Alberto Orellana Henriquez     “OH240812”

package mediateca;

import java.util.ArrayList;

public class Gestion {
    private ArrayList<Material> materiales;

    public Gestion() {
        materiales = new ArrayList<>();
    }

    public ArrayList<Material> listarMateriales() {
        return materiales;
    }

    public Material buscarMaterial(String codigo) {
        for (Material m : materiales) {
            if (m.getCodigo().equalsIgnoreCase(codigo)) {
                return m;
            }
        }
        return null;
    }

    public boolean agregarMaterial(Material m) {
        materiales.add(m);
        return true;
    }

    public boolean modificarMaterial(String codigo, Material nuevo) {
        int posicion = materiales.indexOf(buscarMaterial(codigo));

        if (posicion != -1) {
            materiales.set(posicion, nuevo);
            return true;
        }

        return false;
    }

    public boolean borrarMaterial(String codigo) {
        Material m = buscarMaterial(codigo);

        if (m != null) {
            materiales.remove(m);
            return true;
        }

        return false;
    }
}