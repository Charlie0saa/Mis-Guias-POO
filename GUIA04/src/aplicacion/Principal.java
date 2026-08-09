package aplicacion;

import herencia.*;
import clasesestaticas.*;
import clasesabstractas.*;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        // demoherencia();
        // democlaseestatica();
        // demoabstraccion1();
        demoabstraccion2();
    }

    public static void demoherencia() {
        Barco velero, ronald;
        System.out.println("Demostracion del principio de herencia de clases\n");

        velero = new Barco("Paraiso", "Marca Leonard", Propulsion.VELAS);
        velero.verdatos();

        ronald = new Barco("Titanic", "Clase Olympic", Propulsion.MOTOR);
        ronald.setNombre("Portaaviones Ronald Reagan");
        ronald.setMarca("Clase Nimitz");
        ronald.verdatos();

        Moto honda = new Moto("Honda ATV", "Modelo 2024", 4, 420);
        honda.verdatos();
    }

    public static void democlaseestatica() {
        System.out.println("--- Demostracion de Clases Estaticas y Numeros Complejos ---\n");

        NumComplejo a = new NumComplejo(3, 4);
        NumComplejo b = new NumComplejo(1, -2);
        NumComplejo c = new NumComplejo(2, 3);

        System.out.println("Numero Complejo A: " + a.vervalor());
        System.out.println("Numero Complejo B: " + b.vervalor());
        System.out.println("Numero Complejo C: " + c.vervalor());
        System.out.println();

        NumComplejo suma = MateComplejos.Suma(a, b);
        System.out.printf("Suma de A + B: %s\n", suma.vervalor());

        NumComplejo resta = MateComplejos.Resta(a, b);
        System.out.printf("Resta de A - B: %s\n", resta.vervalor());

        NumComplejo mult = MateComplejos.Multiplicar(a, b);
        System.out.printf("Multiplicacion de A * B: %s\n", mult.vervalor());

        NumComplejo div = MateComplejos.Division(b, c);
        System.out.printf("Division de B / C: %s\n", div.vervalor());

        NumComplejo pot = MateComplejos.Potencia(b, 3);
        System.out.printf("Potencia de B^3: %s\n", pot.vervalor());
    }

    public static void demoabstraccion1() {
        // comprobara implementacion de herencia con abstracion de clase
        Scanner teclado = new Scanner(System.in);
        HDD Kington, Seagate; // objetos de clase derivada HDD
        Kington = new HDD(); // crea instancia con valores predeterminados

        // crea objeto, asignando valores especificos
        Seagate = new HDD(2048, 175, 5400, 3);

        // Imprime los valores almacenados en cada objeto de clase HDD
        System.out.println("Estado inicial de par de discos duros (HDD):");
        System.out.println("* Kington: " + Kington.mostrarparametros());
        System.out.println("* Seagate: " + Seagate.mostrarparametros());

        // intenta modificar algunos campos con valores dados por usuario
        System.out.print("\nIngrese la nueva capacidad (en GB) de Kington ? ");
        Kington.setCapac(teclado.nextInt());
        System.out.println("Nuevo estado del HDD Kington:");
        System.out.println("* Kington: " + Kington.mostrarparametros());

        System.out.print("\nAhora ingrese el nuevo rendimiento (en MB/s) de Seagate ? ");
        Seagate.setRendim(teclado.nextInt());
        System.out.println("Nuevo estado del HDD Seagate:");
        System.out.println("* Seagate: " + Seagate.mostrarparametros());
    }

    public static void demoabstraccion2() {
        Scanner teclado = new Scanner(System.in);
        SSD disco1, disco2;
        disco1 = new SSD(); // interfaz SATA predeterminada
        disco2 = new SSD('P', 3, 5000); // asigna interfaz PCIe

        System.out.println("Estado inicial de par de medios (SSD):");
        System.out.println("* SSD 1: " + disco1.mostrarparametros());
        System.out.println("* SSD 2: " + disco2.mostrarparametros());

        // intenta modificar algunos campos con valores dados por usuario
        System.out.print("\nIngrese la nueva capacidad (256 o 512) GB de SSD 1 ? ");
        disco1.setCapac(teclado.nextInt());
        System.out.println("Nuevo estado del SSD 1:");
        System.out.println("* SSD 1: " + disco1.mostrarparametros());

        System.out.print("\nIngrese letra (s: SATA o p: PCIe) para cambiar tipo Interfaz del SSD 2? ");
        disco2.setInterfaz(teclado.next().charAt(0));
        System.out.println("Nuevo estado del SSD 2:");
        System.out.println("* SSD 2: " + disco2.mostrarparametros());
    }
}