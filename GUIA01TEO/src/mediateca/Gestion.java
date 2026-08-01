package mediateca;

import java.util.ArrayList;

public class Gestion {
    private ArrayList<Formato> materiales;

    public Gestion() {
        materiales = new ArrayList<>();
    }

    public ArrayList<Formato> listarMateriales() {
        return materiales;
    }

    public Formato buscarMaterial(String codigo) {
        for (Formato f : materiales) {
            if (f.getCodigo().equalsIgnoreCase(codigo)) {
                return f;
            }
        }
        return null;
    }

    public boolean agregarMaterial(Formato f) {
        // Se añade el objeto al ArrayList y se confirma la inserción
        materiales.add(f);
        return true;
    }

    public boolean modificarMaterial(String codigo, Formato nuevo) {
        // 1. Buscamos el índice del material existente a partir de su código
        int posicion = materiales.indexOf(buscarMaterial(codigo));

        // 2. Si la posición es distinta de -1, el elemento existe y se reemplaza
        if (posicion != -1) {
            materiales.set(posicion, nuevo);
            return true;
        }

        return false;
    }

    public boolean borrarMaterial(String codigo) {
        Formato f = buscarMaterial(codigo);

        // Si f no es nulo, procedemos a removerlo de la lista
        if (f != null) {
            materiales.remove(f);
            return true;
        }

        return false;
    }
}