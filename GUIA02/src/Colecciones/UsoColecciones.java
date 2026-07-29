package Colecciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Arrays;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UsoColecciones {

    public static void main(String[] args) {
        // Descomenta el método que quieras probar:

         ejemploarraylist();
        // ejemplolist();
        //usodemap();
    }

    // Paso 68: Método ejemploarraylist
    public static void ejemploarraylist() {
        // ListaMarcasCoches sera objeto Collection de la clase ArrayList
        Collection<String> listaMarcasCoches = new ArrayList<String>();

        // Agregando elementos al objeto
        listaMarcasCoches.add("Audi");
        listaMarcasCoches.add("Porsche");
        listaMarcasCoches.add("Aston Martin");
        listaMarcasCoches.add("Ferrari");
        listaMarcasCoches.add("Mercedes");
        listaMarcasCoches.add("Seat");

        System.out.printf("Total de %d elementos almacenados%n", listaMarcasCoches.size()); // Obtiene tamaño de Collection

        // devuelve lista de elementos almacenados
        System.out.println("Elementos existentes en la Colección:\n" + listaMarcasCoches.toString());

        System.out.println("\nSe borraran elementos Seat y Mercedes de la coleccion\n");
        listaMarcasCoches.remove("Seat"); // Removiendo elemento por nombre
        listaMarcasCoches.remove("Mercedes"); // Removiendo elemento por nombre

        System.out.println("Nuevo número elementos almacenados: " + listaMarcasCoches.size());
        System.out.println("Elementos: \n" + listaMarcasCoches.toString());
    }

    // Paso 72: Método ejemplolist
    static void ejemplolist() {
        ArrayList<String> listaPersona = new ArrayList<String>();

        // Agregando elementos
        listaPersona.add("Marie Curie");
        listaPersona.add("Benjamin Franklin");
        listaPersona.add("Marco Antonio");
        listaPersona.add(1, "Juan Murillo");

        // Mostrar contenido de ArrayList
        System.out.println("USO DE ARRAYLIST");
        System.out.println("Contenido de listaPersona: " + listaPersona + "\n");

        // Obteniendo posición de un elemento
        int pos = listaPersona.indexOf("Benjamin Franklin");
        System.out.println("El indice de Benjamin Franklin es: " + pos);

        // Verificando si lista está vacía
        boolean check = listaPersona.isEmpty();
        System.out.println("Verificando si ArrayList está vacío: " + check);

        // Obteniendo tamaño de lista
        int size = listaPersona.size();
        System.out.println("El tamaño de listaPersona es: " + size);

        // Verificando si un elemento está incluido en la lista
        boolean elemento = listaPersona.contains("Marco Antonio");
        System.out.println("Verificando si 'Marco Antonio' está incluido en listaPersona: " + elemento);

        // Obteniendo elemento de una posición específica
        String item = listaPersona.get(0);
        System.out.println("El elemento con indice 0 es: " + item);

        // Recuperando elementos del ArrayList
        // Primera forma: Usando Lazo for
        System.out.println("\nRecuperando elementos del ArrayList con FOR");
        for (int i = 0; i < listaPersona.size(); i++) {
            System.out.println("Indice: " + i + " Elemento: " + listaPersona.get(i));
        }

        // Segunda forma: Usando Lazo foreach
        System.out.println("\nRecuperando elementos del ArrayList con FOREACH");
        for (String persona : listaPersona) {
            System.out.println("Elemento: " + persona);
        }

        // Tercera forma: Usando Iterator
        // hasNext(): devuelve true si hay mas elementos
        // next(): devuelve el siguiente elemento
        System.out.println("\nRecuperando elementos del ArrayList con ITERATOR");
        for (Iterator<String> it = listaPersona.iterator(); it.hasNext(); ) {
            System.out.println("Elemento: " + it.next());
        }

        // Reemplazando un elemento
        listaPersona.set(1, "Nikola Tesla");
        System.out.println("\nArrayList después de reemplazo: \n" + listaPersona);

        // Eliminando elemento en posicion 0
        listaPersona.remove(0);
        System.out.println("\nArrayList después de eliminar elemento 0:\n" + listaPersona);

        // Convirtiendo ArrayList en Array
        String[] simpleArray = listaPersona.toArray(new String[listaPersona.size()]);
        System.out.println("\nObjeto Array creado es: \n" + Arrays.toString(simpleArray));
    }

    // Paso 76: Método usodemap
    static void usodemap() {
        // Declarando HashMap
        HashMap<Integer, String> hmap = new HashMap<Integer, String>();

        // Agregando elementos
        hmap.put(12, "Crayolas");
        hmap.put(2, "Lápices");
        hmap.put(7, "Borradores");
        hmap.put(49, "Colores");
        hmap.put(3, "Boligrafos");

        // Mostrando contenido usando Iterator
        System.out.println("Contenido de HashMap:");
        Set set = hmap.entrySet();
        Iterator iterador = set.iterator();
        while (iterador.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterador.next();
            System.out.println("Clave: " + mentry.getKey() + " Valor: " + mentry.getValue());
        }

        // Obtener valor en base a clave
        String var = hmap.get(2);
        System.out.println("\nValor asociado a clave 2: " + var);

        // Remover elementos en base a clave
        hmap.remove(3);
        System.out.println("\nHashMap después de eliminar elemento con clave 3:");
        Set set2 = hmap.entrySet();
        Iterator iterador2 = set2.iterator();
        while (iterador2.hasNext()) {
            Map.Entry mentry2 = (Map.Entry) iterador2.next();
            System.out.println("Clave: " + mentry2.getKey() + " Valor: " + mentry2.getValue());
        }
    }
}