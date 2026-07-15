package Ejercicio9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Ejemplo1 {

    public static void main(String[] args) {

        //ejemplolist();
        usodemap();

    }

    public static void ejemplolist() {

        ArrayList<String> listaPersona = new ArrayList<>();

        // Agregando elementos
        listaPersona.add("Marie Curie");
        listaPersona.add("Benjamin Franklin");
        listaPersona.add("Marco Antonio");
        listaPersona.add(1, "Juan Murillo");

        // Mostrar contenido
        System.out.println("USO DE ARRAYLIST");
        System.out.println("Contenido de listaPersona: " + listaPersona + "\n");

        // Obteniendo posición de un elemento
        int pos = listaPersona.indexOf("Benjamin Franklin");
        System.out.println("El indice de Benjamin Franklin es: " + pos);

        // Verificando si la lista está vacía
        boolean check = listaPersona.isEmpty();
        System.out.println("Verificando si ArrayList está vacío: " + check);

        // Tamaño de la lista
        int size = listaPersona.size();
        System.out.println("El tamaño de listaPersona es: " + size);

        // Verificando si existe un elemento
        boolean elemento = listaPersona.contains("Marco Antonio");
        System.out.println("Verificando si 'Marco Antonio' está incluido en listaPersona: " + elemento);

        // Obtener elemento
        String item = listaPersona.get(0);
        System.out.println("El elemento con indice 0 es: " + item);

        // Recorrido con FOR
        System.out.println("\nRecuperando elementos del ArrayList con FOR");

        for (int i = 0; i < listaPersona.size(); i++) {

            System.out.println("Indice: " + i +
                    " - Elemento: " + listaPersona.get(i));

        }

        // Recorrido con FOREACH
        System.out.println("\nRecuperando elementos del ArrayList con FOREACH");

        for (String persona : listaPersona) {

            System.out.println("Elemento: " + persona);

        }

        // Reemplazar elemento
        listaPersona.set(1, "Nikola Tesla");

        System.out.println("\nArrayList después de reemplazo:");
        System.out.println(listaPersona);

        // Eliminar elemento
        listaPersona.remove(0);

        System.out.println("\nArrayList después de eliminar elemento 0:");
        System.out.println(listaPersona);

        // Convertir a Array
        String[] simpleArray =
                listaPersona.toArray(new String[listaPersona.size()]);

        System.out.println("\nObjeto Array creado es:");
        System.out.println(Arrays.toString(simpleArray));

    }

    public static void usodemap() {

        HashMap<Integer, String> hmap = new HashMap<>();

        hmap.put(12, "Crayolas");
        hmap.put(2, "Lápices");
        hmap.put(7, "Borradores");
        hmap.put(49, "Colores");
        hmap.put(3, "Boligrafos");

        System.out.println("Contenido de HashMap:");

        Set set = hmap.entrySet();
        Iterator iterador = set.iterator();

        while (iterador.hasNext()) {

            Map.Entry mentry = (Map.Entry) iterador.next();

            System.out.println("Clave: " + mentry.getKey()
                    + " - Valor: " + mentry.getValue());

        }

        String var = hmap.get(2);

        System.out.println("\nValor asociado a clave 2: " + var);

        hmap.remove(3);

        System.out.println("\nHashMap después de eliminar elemento con clave 3:");

        Set set2 = hmap.entrySet();
        Iterator iterador2 = set2.iterator();

        while (iterador2.hasNext()) {

            Map.Entry mentry2 = (Map.Entry) iterador2.next();

            System.out.println("Clave: " + mentry2.getKey()
                    + " - Valor: " + mentry2.getValue());

        }

    }

}