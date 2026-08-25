package PrestacionesMarcos;

public class Motocicleta extends Vehiculo {
    private int cilindradaCC;
    private boolean repartoUrbano;

    public Motocicleta(String placa, String marca, String modelo, int anioFabricacion, boolean disponible, int cilindradaCC, boolean repartoUrbano) {
        super(placa, marca, modelo, anioFabricacion, disponible);
        this.cilindradaCC = cilindradaCC;
        this.repartoUrbano = repartoUrbano;
    }

    public int getCilindradaCC() {
        return cilindradaCC;
    }

    public void setCilindradaCC(int cilindradaCC) {
        this.cilindradaCC = cilindradaCC;
    }

    public boolean isRepartoUrbano() {
        return repartoUrbano;
    }

    public void setRepartoUrbano(boolean repartoUrbano) {
        this.repartoUrbano = repartoUrbano;
    }

    @Override
    public String mostrarInformacion() {
        return "***** MOTOCICLETA *****" +
                "\nPlaca: " + getPlaca() +
                "\nMarca: " + getMarca() +
                "\nModelo: " + getModelo() +
                "\nAño de Fabricación: " + getAnioFabricacion() +
                "\nDisponibilidad: " + (isDisponible() ? "Sí" : "No") +
                "\nCilindrada: " + cilindradaCC + " cc" +
                "\nAsignada a Reparto Urbano: " + (repartoUrbano ? "Sí" : "No");
    }

    @Override
    public double calcularCostoMantenimiento() {
        double costoBase = 75.0;
        if (repartoUrbano) {
            costoBase += 25.0;
        }
        return costoBase + (cilindradaCC * 0.05);
    }

    @Override
    public String tipoMantenimiento() {
        return "Mantenimiento Ligero Mensajería (Ajuste de kit de arrastre, cambio de aceite y presión de neumáticos).";
    }
}