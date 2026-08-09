package herencia;

public class Vehiculo {
    protected String tipovehiculo;
    protected String nombre;
    protected String marca;

    public Vehiculo() {
        tipovehiculo = "ninguno";
        nombre = "desconocido";
        marca = "pendiente";
    }

    public void verdatos() {
        System.out.println("Este es un vehiculo genérico, sin nombre ni marca");
    }

    public String getTipovehiculo() {
        return tipovehiculo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}