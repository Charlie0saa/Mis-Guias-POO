package misclases;

import java.text.DecimalFormat; // Punto 14

public class Tiempo { // Punto 13

    // Punto 22: Atributos privados (Encapsulados)
    private int hora;   // Rango: 0-23
    private int minuto; // Rango: 0-59
    private int segundo;// Rango: 0-59

    private void InicializarCampos() { //
        hora = 0; //
        minuto = 0; //
        segundo = 0; //
    }

    public Tiempo() { // Punto 15
        InicializarCampos(); //
    }

    public void establecerHora(int h, int m, int s) { //
        setHora(h);     // Punto 28: Usa los setters para validar
        setMinuto(m);   //
        setSegundo(s);  //
    }

    public String aStringUniversal() { //
        DecimalFormat dosDigitos = new DecimalFormat("00"); //
        return dosDigitos.format(hora) + ":" +
                dosDigitos.format(minuto) + ":" +
                dosDigitos.format(segundo); //
    }

    public String aStringEstandar() { //
        DecimalFormat dosDigitos = new DecimalFormat("00"); //
        return ((hora == 12 || hora == 0) ? 12 : hora % 12) + ":" +
                dosDigitos.format(minuto) + ":" +
                dosDigitos.format(segundo) +
                (hora < 12 ? " AM" : " PM"); //
    }

    // Punto 23 y 29: Métodos de propiedad (Getter y Setter) para HORA con validación
    public int getHora() {
        return hora; //
    }

    public void setHora(int hora) {
        if (hora >= 0 && hora < 24) { // Validación de rango 0-23
            this.hora = hora; //
        }
    }

    // Punto 26 y 30: Métodos para MINUTO con validación
    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        if (minuto >= 0 && minuto < 60) { // Validación de rango 0-59
            this.minuto = minuto; //
        }
    }

    // Punto 26 y 31: Métodos para SEGUNDO con validación
    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        if (segundo >= 0 && segundo < 60) { // Validación de rango 0-59
            this.segundo = segundo;
        }
    }
}