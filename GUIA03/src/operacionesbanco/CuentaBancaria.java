package operacionesbanco;

import java.util.ArrayList;

public class CuentaBancaria {
    private Cliente titularcuenta;
    private double saldoactual;
    private int numtransac;
    private ArrayList<TransaccionCuenta> transacciones;

    private void inicializarcampos() {
        this.titularcuenta = null;
        this.numtransac = 0;
        this.saldoactual = 0;
        this.transacciones = new ArrayList<>();
    }

    public CuentaBancaria(Cliente propietario, double saldoinicial) {
        inicializarcampos();
        this.titularcuenta = propietario;

        TransaccionCuenta transacTemp = new TransaccionCuenta(++numtransac, 0);
        transacTemp.ejecutar('d', saldoinicial, "apertura de cuenta");
        this.saldoactual = transacTemp.getNuevosaldo();
        transacciones.add(transacTemp);
    }

    public void realizaroperacion(char tipooperac, double monto, String descrip) {
        TransaccionCuenta transacTemp = new TransaccionCuenta(numtransac + 1, saldoactual);
        transacTemp.ejecutar(tipooperac, monto, descrip);

        switch (transacTemp.getEstado()) {
            case 1:
                System.out.printf("ERROR: Saldo de cuenta insuficiente para retirar $ %.2f%n", monto);
                break;
            case 2:
                System.out.printf("ERROR: Monto $ %.2f requerido no puede ser negativo%n", monto);
                break;
            default:
                numtransac++;
                this.saldoactual = transacTemp.getNuevosaldo();
                transacciones.add(transacTemp);
                System.out.println("Transaccion ejecutada con exito");
                break;
        }
    }

    public void vertransacciones() {
        System.out.printf("\n* Titular de Cuenta: %s\n", titularcuenta.datosCliente());
        System.out.printf("* Saldo actual: $ %.2f\n", saldoactual);

        if (transacciones.isEmpty()) {
            System.out.println("Aun sin transacciones realizadas");
        } else {
            String titulos = String.format("%-5s %-20s %-16s %-25s %-10s %-11s",
                    "id", "fecha", "Tipo transaccion", "Descripcion", "Monto", "Saldo");
            System.out.println(titulos);

            for (TransaccionCuenta cuenta : transacciones) {
                System.out.println(cuenta.getRegistro());
            }
        }
    }

    public Cliente getTitularcuenta() { return titularcuenta; }
    public double getSaldoactual() { return saldoactual; }
    public int getNumtransac() { return numtransac; }
    public ArrayList<TransaccionCuenta> getTransacciones() { return transacciones; }
}