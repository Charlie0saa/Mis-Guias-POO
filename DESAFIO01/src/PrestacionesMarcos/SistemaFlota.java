package PrestacionesMarcos;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class SistemaFlota {

    private static List<Vehiculo> listaVehiculos = new ArrayList<>();

    public static void main(String[] args) {
        int opcion = 0;

        do {
            String menu = "=== SISTEMA DE GESTIÓN DE FLOTA DE VEHÍCULOS ===\n\n" +
                    "1. Registrar Vehículo\n" +
                    "2. Mostrar Todos los Vehículos\n" +
                    "3. Calcular Costo de Mantenimiento\n" +
                    "4. Consultar Disponibilidad\n" +
                    "5. Salir\n\n" +
                    "Seleccione una opción:";

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

        try {
            String placa = JOptionPane.showInputDialog(null, "Ingrese la Placa:");
            if (placa == null || placa.trim().isEmpty()) return;

            String marca = JOptionPane.showInputDialog(null, "Ingrese la Marca:");
            if (marca == null || marca.trim().isEmpty()) return;

            String modelo = JOptionPane.showInputDialog(null, "Ingrese el Modelo:");
            if (modelo == null || modelo.trim().isEmpty()) return;

            int anio = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el Año de Fabricación:"));

            int respDisp = JOptionPane.showConfirmDialog(null, "¿Está disponible?", "Disponibilidad", JOptionPane.YES_NO_OPTION);
            boolean disponible = (respDisp == JOptionPane.YES_OPTION);

            switch (tipo) {
                case 0: // Automóvil
                    int pasajeros = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de pasajeros:"));
                    int respSeguro = JOptionPane.showConfirmDialog(null, "¿Tiene seguro vigente?", "Seguro", JOptionPane.YES_NO_OPTION);
                    boolean seguro = (respSeguro == JOptionPane.YES_OPTION);

                    listaVehiculos.add(new Automovil(placa, marca, modelo, anio, disponible, pasajeros, seguro));
                    JOptionPane.showMessageDialog(null, "Automóvil registrado con éxito.");
                    break;

                case 1: // Camión
                    double capacidad = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la capacidad de carga (Toneladas):"));
                    int ejes = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de ejes:"));

                    listaVehiculos.add(new Camion(placa, marca, modelo, anio, disponible, capacidad, ejes));
                    JOptionPane.showMessageDialog(null, "Camión registrado con éxito.");
                    break;

                case 2: // Motocicleta
                    int cilindrada = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cilindrada (cc):"));
                    int respReparto = JOptionPane.showConfirmDialog(null, "¿Está asignada a reparto urbano?", "Reparto Urbano", JOptionPane.YES_NO_OPTION);
                    boolean reparto = (respReparto == JOptionPane.YES_OPTION);

                    listaVehiculos.add(new Motocicleta(placa, marca, modelo, anio, disponible, cilindrada, reparto));
                    JOptionPane.showMessageDialog(null, "Motocicleta registrada con éxito.");
                    break;
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar valores numéricos. Registro cancelado.", "Error de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void mostrarVehiculos() {
        if (listaVehiculos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay vehículos registrados en el sistema.", "Lista Vacía", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder reporte = new StringBuilder("=== REGISTRO GENERAL DE VEHÍCULOS ===\n\n");
        for (Vehiculo v : listaVehiculos) {
            reporte.append(v.mostrarInformacion())
                    .append("\n-----------------------------------\n");
        }

        JOptionPane.showMessageDialog(null, reporte.toString(), "Flota de Vehículos", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void calcularMantenimiento() {
        if (listaVehiculos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay vehículos registrados.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String placaBuscada = JOptionPane.showInputDialog(null, "Ingrese la placa del vehículo a consultar:");
        if (placaBuscada == null || placaBuscada.trim().isEmpty()) return;

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

        String placaBuscada = JOptionPane.showInputDialog(null, "Ingrese la placa del vehículo a consultar:");
        if (placaBuscada == null || placaBuscada.trim().isEmpty()) return;

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
}