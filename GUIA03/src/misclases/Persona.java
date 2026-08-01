package misclases; //[cite: 7]

import javax.swing.JOptionPane; // Permite usar cuadros de diálogo interactivos[cite: 7]

public class Persona { //[cite: 7]
    // Declaración de Atributos (Privados)[cite: 7]
    private String nombre; //[cite: 7]
    private String apellido; //[cite: 7]
    private int edad; //

    // Definición de Métodos

    // 1. Constructor por defecto (sin parámetros)
    public Persona() { //
        nombre = "Rafael"; //
        apellido = "Torres"; //
        edad = 23; //
    }

    // 2. Sobrecarga de Método Constructor (con parámetros)
    public Persona(String nom, String apell, int edad) { //
        this.nombre = nom; //
        this.apellido = apell; //
        this.edad = edad; //
    }

    // 3. Método para ingresar/modificar datos mediante JOptionPane
    public void ingresoDatos() { //
        nombre = JOptionPane.showInputDialog("Ingrese el Nombre"); //
        apellido = JOptionPane.showInputDialog("Ingrese el Apellido"); //
        edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad")); //
    }

    // 4. Método para mostrar en consola los valores actuales del objeto
    public void mostrarDatos() { //
        System.out.println("Su nombre es: " + nombre); //
        System.out.println("Su Apellido es: " + apellido); //
        System.out.println("Su edad es: " + edad); //
        System.out.println("****************************"); //
    }
}