package PrestacionesMarcos;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class SistemaFlota {

    private static List<Vehiculo> listaVehiculos = new ArrayList<>();
    private static final int ANIO_ACTUAL = 2026;

    public static void main(String[] args) {
        int opcion = 0;

        do {
            //menu de marcos para seleccionar los que se desea hacer
            String menu = "********** SISTEMA DE MARCOSPRESTACIONES **********\n\n" +
                    "Digite el numero correspondiente a la opcion del 1 - 6\n\n"+
                    "1. Registrar Vehículo\n" +
                    "2. Mostrar Todos los Vehículos\n" +
                    "3. Calcular Costo de Mantenimiento\n" +
                    "4. Consultar Disponibilidad\n" +
                    "5. Salir\n\n" +
                    "Seleccione una opción:";

            //lo que se ejecuta al iniciar
            String entrada = JOptionPane.showInputDialog(null, menu, "Menú Principal", JOptionPane.QUESTION_MESSAGE);

            if (entrada == null) {
                break;
            }

            try {
                opcion = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            switch (opcion) {
                case 1:
                    registrarVehiculo();
                    break;
                case 2:
                    mostrarVehiculos();
                    break;
                case 3:
                    calcularMantenimiento();
                    break;
                case 4:
                    consultarDisponibilidad();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...", "Finalizado", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }

        } while (opcion != 5);
    }

    public static void registrarVehiculo() {
        String[] opciones = {"Automóvil", "Camión", "Motocicleta"};
        int tipo = JOptionPane.showOptionDialog(
                null,
                "Seleccione el tipo de vehículo a registrar:",
                "Registrar Vehículo",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if (tipo == JOptionPane.CLOSED_OPTION) {
            return;
        }

        //validaciones para cuidar que no se ingrese un valor que no existe
        String placa = pedirTextoValido("Ingrese la Placa del vehículo:", "Placa");
        if (placa == null) return; // Usuario canceló

        String marca = pedirTextoValido("Ingrese la Marca del vehículo:", "Marca");
        if (marca == null) return;

        String modelo = pedirTextoValido("Ingrese el Modelo del vehículo:", "Modelo");
        if (modelo == null) return;

        Integer anio = pedirEnteroEnRango("Ingrese el Año de Fabricación:", "Año de Fabricación", 1900, ANIO_ACTUAL);
        if (anio == null) return;

        int respDisp = JOptionPane.showConfirmDialog(null, "¿Está disponible el vehículo actualmente?", "Disponibilidad", JOptionPane.YES_NO_OPTION);
        boolean disponible = (respDisp == JOptionPane.YES_OPTION);

        // tipo de vehiculos aqui
        switch (tipo) {
            case 0: // Automóvil
                Integer pasajeros = pedirEnteroEnRango("Ingrese el número de pasajeros (mínimo 1):", "Número de Pasajeros", 1, 100);
                if (pasajeros == null) return;

                int respSeguro = JOptionPane.showConfirmDialog(null, "¿Tiene el seguro vigente?", "Seguro Vigente", JOptionPane.YES_NO_OPTION);
                boolean seguro = (respSeguro == JOptionPane.YES_OPTION);

                listaVehiculos.add(new Automovil(placa, marca, modelo, anio, disponible, pasajeros, seguro));
                JOptionPane.showMessageDialog(null, "Automóvil registrado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                break;

            case 1: // Camión
                Double capacidad = pedirDoublePositivo("Ingrese la capacidad de carga en toneladas (mayor a 0):", "Capacidad de Carga");
                if (capacidad == null) return;

                Integer ejes = pedirEnteroEnRango("Ingrese el número de ejes (mínimo 1):", "Número de Ejes", 1, 20);
                if (ejes == null) return;


                //LISTA DE VEHICULOS
                listaVehiculos.add(new Camion(placa, marca, modelo, anio, disponible, capacidad, ejes));
                JOptionPane.showMessageDialog(null, "Camión registrado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                break;

            case 2: // Motocicleta
                Integer cilindrada = pedirEnteroEnRango("Ingrese la cilindrada:", "Cilindrada", 50, 3000);
                if (cilindrada == null) return;

                int respReparto = JOptionPane.showConfirmDialog(null, "¿Está asignada a reparto urbano?", "Reparto Urbano", JOptionPane.YES_NO_OPTION);
                boolean reparto = (respReparto == JOptionPane.YES_OPTION);

                //LISTA DE VEHICULOS
                listaVehiculos.add(new Motocicleta(placa, marca, modelo, anio, disponible, cilindrada, reparto));
                JOptionPane.showMessageDialog(null, "Motocicleta registrada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }

    public static void mostrarVehiculos() {
        if (listaVehiculos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay vehículos registrados en el sistema.", "Lista Vacía", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder reporte = new StringBuilder("***** REGISTRO GENERAL DE VEHÍCULOS *****\n\n");
        for (Vehiculo v : listaVehiculos) {
            reporte.append(v.mostrarInformacion())
                    .append("\n-----------------------------------\n");
        }

        JOptionPane.showMessageDialog(null, reporte.toString(), "marcosprestaciones Flota de Vehículos", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void calcularMantenimiento() {
        if (listaVehiculos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay vehículos registrados.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String placaBuscada = pedirTextoValido("Ingrese la placa del vehículo a consultar:", "Calcular Mantenimiento");
        if (placaBuscada == null) return;

        Vehiculo encontrado = buscarVehiculoPorPlaca(placaBuscada);

        if (encontrado != null) {
            String mensaje = "Placa: " + encontrado.getPlaca() +
                    "\nTipo de Mantenimiento: " + encontrado.tipoMantenimiento() +
                    "\nCosto Mensual Calculado: $" + String.format("%.2f", encontrado.calcularCostoMantenimiento());

            JOptionPane.showMessageDialog(null, mensaje, "Costo de Mantenimiento", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún vehículo con la placa especificada.", "No Encontrado", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void consultarDisponibilidad() {
        if (listaVehiculos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay vehículos registrados.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String placaBuscada = pedirTextoValido("Ingrese la placa del vehículo a consultar:", "Consultar Disponibilidad");
        if (placaBuscada == null) return;

        Vehiculo encontrado = buscarVehiculoPorPlaca(placaBuscada);

        if (encontrado != null) {
            JOptionPane.showMessageDialog(null, encontrado.estaDisponible(), "Consulta de Disponibilidad", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún vehículo con la placa especificada.", "No Encontrado", JOptionPane.WARNING_MESSAGE);
        }
    }

    private static Vehiculo buscarVehiculoPorPlaca(String placa) {
        for (Vehiculo v : listaVehiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa.trim())) {
                return v;
            }
        }
        return null;
    }
    ///
    private static String pedirTextoValido(String mensaje, String titulo) {
        while (true) {
            String input = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
            if (input == null) return null; // Usuario hizo clic en Cancelar
            if (!input.trim().isEmpty()) {
                return input.trim();
            }
            JOptionPane.showMessageDialog(null, "El campo no puede estar vacío. Por favor intente nuevamente.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static Integer pedirEnteroEnRango(String mensaje, String titulo, int min, int max) {
        while (true) {
            String input = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
            if (input == null) return null; // Usuario hizo clic en Cancelar
            try {
                int valor = Integer.parseInt(input.trim());
                if (valor >= min && valor <= max) {
                    return valor;
                } else {
                    JOptionPane.showMessageDialog(null, "El valor debe estar entre " + min + " y " + max + ".", "Error de Rango", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número entero válido.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static Double pedirDoublePositivo(String mensaje, String titulo) {
        while (true) {
            String input = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
            if (input == null) return null; // Usuario hizo clic en Cancelar
            try {
                double valor = Double.parseDouble(input.trim());
                if (valor > 0) {
                    return valor;
                } else {
                    JOptionPane.showMessageDialog(null, "El valor debe ser mayor a 0.", "Error de Rango", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número decimal válido.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}