package PrestacionesMarcos;

public class Camion extends Vehiculo {
    private double capacidadCargaTon;
    private int numeroEjes;

    public Camion(String placa, String marca, String modelo, int anioFabricacion, boolean disponible, double capacidadCargaTon, int numeroEjes) {
        super(placa, marca, modelo, anioFabricacion, disponible);
        this.capacidadCargaTon = capacidadCargaTon;
        this.numeroEjes = numeroEjes;
    }

    public double getCapacidadCargaTon() {
        return capacidadCargaTon;
    }

    public void setCapacidadCargaTon(double capacidadCargaTon) {
        this.capacidadCargaTon = capacidadCargaTon;
    }

    public int getNumeroEjes() {
        return numeroEjes;
    }

    public void setNumeroEjes(int numeroEjes) {
        this.numeroEjes = numeroEjes;
    }

    @Override
    public String mostrarInformacion() {
        return "=== CAMIÓN ===" +
                "\nPlaca: " + getPlaca() +
                "\nMarca: " + getMarca() +
                "\nModelo: " + getModelo() +
                "\nAño de Fabricación: " + getAnioFabricacion() +
                "\nDisponibilidad: " + (isDisponible() ? "Sí" : "No") +
                "\nCapacidad de Carga: " + capacidadCargaTon + " Toneladas" +
                "\nNúmero de Ejes: " + numeroEjes;
    }

    @Override
    public double calcularCostoMantenimiento() {
        double costoBase = 350.0;
        return costoBase + (capacidadCargaTon * 45.0) + (numeroEjes * 25.0);
    }

    @Override
    public String tipoMantenimiento() {
        return "Mantenimiento Pesado de Carga (Revisión de transmisión, sistema de frenos neumático y suspensión).";
    }
}