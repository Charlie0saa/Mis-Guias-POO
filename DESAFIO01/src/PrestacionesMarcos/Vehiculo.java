package PrestacionesMarcos;

public abstract class Vehiculo implements Mantenible {
    private String placa;
    private String marca;
    private String modelo;
    private int anioFabricacion;
    private boolean disponible;

    public Vehiculo(String placa, String marca, String modelo, int anioFabricacion, boolean disponible) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.disponible = disponible;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public abstract String mostrarInformacion();

    public String estaDisponible() {
        if (disponible) {
            return "El vehículo con placa " + placa + " está DISPONIBLE para asignación de ruta.";
        } else {
            return "El vehículo con placa " + placa + " NO está disponible en este momento.";
        }
    }
}