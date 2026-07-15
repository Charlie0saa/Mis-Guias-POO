package Ejercicio8;

import java.util.ArrayList;
import java.util.Collection;

public class Ejemplo1 {

    public static void main(String[] args) {

        ejemploarraylist();

    }

    public static void ejemploarraylist() {

        // listaMarcasCoches será un objeto Collection de la clase ArrayList
        Collection<String> listaMarcasCoches = new ArrayList<String>();

        // Agregando elementos
        listaMarcasCoches.add("Audi");
        listaMarcasCoches.add("Porsche");
        listaMarcasCoches.add("Aston Martin");
        listaMarcasCoches.add("Ferrari");
        listaMarcasCoches.add("Mercedes");
        listaMarcasCoches.add("Seat");

        System.out.printf("Total de %d elementos almacenados%n",
                listaMarcasCoches.size());

        System.out.println("Elementos existentes en la Coleccion:");
        System.out.println(listaMarcasCoches);

        System.out.println("\nSe borraran elementos Seat y Mercedes de la coleccion\n");

        listaMarcasCoches.remove("Seat");
        listaMarcasCoches.remove("Mercedes");

        System.out.println("Nuevo número de elementos almacenados: "
                + listaMarcasCoches.size());

        System.out.println("Elementos:");
        System.out.println(listaMarcasCoches);

    }

}