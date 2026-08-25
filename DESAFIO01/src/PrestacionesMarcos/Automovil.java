package PrestacionesMarcos;

public class Automovil extends Vehiculo {
    private int numeroPasajeros;
    private boolean seguroVigente;

    public Automovil(String placa, String marca, String modelo, int anioFabricacion, boolean disponible, int numeroPasajeros, boolean seguroVigente) {
        super(placa, marca, modelo, anioFabricacion, disponible);
        this.numeroPasajeros = numeroPasajeros;
        this.seguroVigente = seguroVigente;
    }

    public int getNumeroPasajeros() {
        return numeroPasajeros;
    }

    public void setNumeroPasajeros(int numeroPasajeros) {
        this.numeroPasajeros = numeroPasajeros;
    }

    public boolean isSeguroVigente() {
        return seguroVigente;
    }

    public void setSeguroVigente(boolean seguroVigente) {
        this.seguroVigente = seguroVigente;
    }

    @Override
    public String mostrarInformacion() {
        return "***** AUTOMÓVIL *****" +
                "\nPlaca: " + getPlaca() +
                "\nMarca: " + getMarca() +
                "\nModelo: " + getModelo() +
                "\nAño de Fabricación: " + getAnioFabricacion() +
                "\nDisponibilidad: " + (isDisponible() ? "Sí" : "No") +
                "\nNúmero de Pasajeros: " + numeroPasajeros +
                "\nSeguro Vigente: " + (seguroVigente ? "Sí" : "No");
    }

    @Override
    public double calcularCostoMantenimiento() {
        int antiguedad = 2026 - getAnioFabricacion();
        double costoBase = 150.0;
        return costoBase + (antiguedad * 15.0);
    }

    @Override
    public String tipoMantenimiento() {
        return "Mantenimiento Preventivo Ejecutivo (Alineación, balanceo, revisión de frenos y fluidos).";
    }
}