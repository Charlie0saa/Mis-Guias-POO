package Complementarios;

import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

public class EjerciciosComplementarios {

    // Campo estático requerido para el Ejercicio 4
    static HashMap<String, String> biblioteca = new HashMap<>();

    public static void main(String[] args) {
        // Descomenta el ejercicio que quieras probar:

         ejercicio1();
        // ejercicio2(1, -2, 5); // Ejemplo: 1x^2 - 2x + 5 = 0
        // ejercicio3("Carlos", 100.0);
        //ejercicio4();
    }

    // =========================================================================
    // EJERCICIO 1: Reemplazar el bloque if del ejemplo3 por una estructura switch
    // =========================================================================
    public static void ejercicio1() {
        int result = JOptionPane.showConfirmDialog(null, "Replace existing selection?");
        System.out.println("El numero devuelto por showConfirmDialog es: " + result);

        // Reemplazo de estructuras if por un solo switch[cite: 6]
        switch (result) {
            case JOptionPane.YES_OPTION:
                System.out.println("Yes");
                break;
            case JOptionPane.NO_OPTION:
                System.out.println("No");
                break;
            case JOptionPane.CANCEL_OPTION:
                System.out.println("Cancel");
                break;
            case JOptionPane.CLOSED_OPTION:
                System.out.println("Closed");
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
        System.exit(0);
    }

    // =========================================================================
    // EJERCICIO 2: Ecuación cuadrática y cálculo de raíces (Reales o Complejas)
    // =========================================================================

    // Método complementario que calcula y retorna el determinante (b^2 - 4ac)[cite: 6]
    public static double calcularDeterminante(double a, double b, double c) {
        return (b * b) - (4 * a * c);
    }

    public static void ejercicio2(double a, double b, double c) {
        if (a == 0) {
            System.out.println("El coeficiente 'a' no puede ser 0 para una ecuación cuadrática.");
            return;
        }

        double det = calcularDeterminante(a, b, c);
        System.out.println("\nEcuación: " + a + "x^2 + " + b + "x + " + c + " = 0");
        System.out.println("Determinante: " + det);

        if (det > 0) {
            // Raíces reales y distintas
            double x1 = (-b + Math.sqrt(det)) / (2 * a);
            double x2 = (-b - Math.sqrt(det)) / (2 * a);
            System.out.printf("Solución Real: x1 = %.4f, x2 = %.4f%n", x1, x2);
        } else if (det == 0) {
            // Raíz real única (repetida)
            double x = -b / (2 * a);
            System.out.printf("Solución Real Única: x = %.4f%n", x);
        } else {
            // Raíces complejas / imaginarias[cite: 6]
            double parteReal = -b / (2 * a);
            double parteImaginaria = Math.sqrt(-det) / (2 * a);
            System.out.printf("Solución Compleja:%n");
            System.out.printf("x1 = %.4f + %.4fi%n", parteReal, parteImaginaria);
            System.out.printf("x2 = %.4f - %.4fi%n", parteReal, parteImaginaria);
        }
    }

    // =========================================================================
    // EJERCICIO 3: Política de descuentos por color de bolita aleatoria
    // =========================================================================
    public static void ejercicio3(String cliente, double montoCompra) {
        String[] colores = {"café", "roja", "azul", "verde"};
        Random random = new Random();

        // Selección de bolita de forma aleatoria[cite: 6]
        String bolita = colores[random.nextInt(colores.length)];
        double porcentajeDescuento = 0.0;

        switch (bolita.toLowerCase()) {
            case "café":
                porcentajeDescuento = 0.10; // 10%[cite: 6]
                break;
            case "roja":
                porcentajeDescuento = 0.15; // 15%[cite: 6]
                break;
            case "azul":
                porcentajeDescuento = 0.25; // 25%[cite: 6]
                break;
            case "verde":
                porcentajeDescuento = 0.50; // 50%[cite: 6]
                break;
        }

        double descuento = montoCompra * porcentajeDescuento;
        double totalPagar = montoCompra - descuento;

        String mensaje = String.format(
                "Cliente: %s\n" +
                        "Monto Original: $%.2f\n" +
                        "Bolita obtenida: %s\n" +
                        "Descuento aplicado (%.0f%%): $%.2f\n" +
                        "Total a pagar: $%.2f",
                cliente, montoCompra, bolita.toUpperCase(), porcentajeDescuento * 100, descuento, totalPagar
        );

        JOptionPane.showMessageDialog(null, mensaje, "Resultado del Sorteo", JOptionPane.INFORMATION_MESSAGE);
    }

    // =========================================================================
    // EJERCICIO 4: CRUD de Biblioteca con HashMap, Expresiones Regulares e Intentos
    // =========================================================================

    // Validador de ISBN (soporta ISBN-10 o ISBN-13 con/sin guiones) mediante Expresión Regular[cite: 6]
    public static boolean validarISBN(String isbn) {
        String regex = "^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[0-9[- ]X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[0-9[- ]]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$";
        return Pattern.matches(regex, isbn) || isbn.matches("^[0-9]{10}$|^[0-9]{13}$");
    }

    // Método auxiliar para solicitar datos validando con un máximo de 3 intentos[cite: 6]
    public static String solicitarDatoConIntentos(String mensaje, boolean esISBN) {
        int intentos = 0;
        while (intentos < 3) { // Máximo 3 errores permitidos[cite: 6]
            String entrada = JOptionPane.showInputDialog(mensaje + (intentos > 0 ? " (Intento " + (intentos + 1) + "/3)" : ""));

            if (entrada == null) return null; // Si presiona cancelar

            entrada = entrada.trim();
            if (!entrada.isEmpty()) {
                if (!esISBN || validarISBN(entrada)) {
                    return entrada; // Entrada válida
                } else {
                    JOptionPane.showMessageDialog(null, "ISBN no válido. Verifique el formato.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El campo no puede estar vacío.", "Error", JOptionPane.WARNING_MESSAGE);
            }
            intentos++;
        }

        JOptionPane.showMessageDialog(null, "Ha superado el límite de 3 intentos fallidos. Operación cancelada.", "Cancelado", JOptionPane.ERROR_MESSAGE); //[cite: 6]
        return null;
    }

    // Métodos del CRUD (Crear, Leer, Actualizar, Eliminar)[cite: 6]
    public static void registrarLibro() {
        String isbn = solicitarDatoConIntentos("Ingrese el ISBN del libro:", true);
        if (isbn == null) return;

        if (biblioteca.containsKey(isbn)) {
            JOptionPane.showMessageDialog(null, "El ISBN ya está registrado en la biblioteca.");
            return;
        }

        String titulo = solicitarDatoConIntentos("Ingrese el título del libro:", false);
        if (titulo == null) return;

        biblioteca.put(isbn, titulo);
        JOptionPane.showMessageDialog(null, "Libro registrado exitosamente.");
    }

    public static void consultarLibros() {
        if (biblioteca.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La biblioteca está vacía.");
            return;
        }

        StringBuilder sb = new StringBuilder("=== LIBROS REGISTRADOS ===\n");
        for (Map.Entry<String, String> libro : biblioteca.entrySet()) {
            sb.append("ISBN: ").append(libro.getKey()).append(" | Título: ").append(libro.getValue()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public static void actualizarLibro() {
        if (biblioteca.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La biblioteca está vacía.");
            return;
        }

        String isbn = solicitarDatoConIntentos("Ingrese el ISBN del libro a actualizar:", true);
        if (isbn == null) return;

        if (!biblioteca.containsKey(isbn)) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún libro con ese ISBN.");
            return;
        }

        String nuevoTitulo = solicitarDatoConIntentos("Ingrese el nuevo título para el libro:", false);
        if (nuevoTitulo == null) return;

        biblioteca.put(isbn, nuevoTitulo);
        JOptionPane.showMessageDialog(null, "Título actualizado correctamente.");
    }

    public static void eliminarLibro() {
        if (biblioteca.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La biblioteca está vacía.");
            return;
        }

        String isbn = solicitarDatoConIntentos("Ingrese el ISBN del libro a eliminar:", true);
        if (isbn == null) return;

        if (biblioteca.remove(isbn) != null) {
            JOptionPane.showMessageDialog(null, "Libro eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún libro con ese ISBN.");
        }
    }

    // Menú principal del Ejercicio 4
    public static void ejercicio4() {
        boolean salir = false;

        while (!salir) {
            String menu = "=== GESTIÓN DE BIBLIOTECA ===\n"
                    + "1. Registrar Libro (Create)\n"
                    + "2. Consultar Libros (Read)\n"
                    + "3. Actualizar Libro (Update)\n"
                    + "4. Eliminar Libro (Delete)\n"
                    + "5. Salir\n\n"
                    + "Seleccione una opción:";

            String opcion = JOptionPane.showInputDialog(menu);
            if (opcion == null) break;

            switch (opcion) {
                case "1":
                    registrarLibro();
                    break;
                case "2":
                    consultarLibros();
                    break;
                case "3":
                    actualizarLibro();
                    break;
                case "4":
                    eliminarLibro();
                    break;
                case "5":
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
                    break;
            }
        }
    }
}