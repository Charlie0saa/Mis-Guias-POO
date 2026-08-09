package operacionesbanco;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransaccionCuenta {
    private int idtransac;
    private LocalDateTime fechatransac;
    private double saldoinic;
    private double nuevosaldo;
    private double montotransac;
    private int estado;
    private char tipotransaccion;
    private String descripcion;

    public TransaccionCuenta(int numoperac, double saldoinicial) {
        this.idtransac = numoperac;
        this.saldoinic = saldoinicial;
        this.nuevosaldo = saldoinicial;
    }

    public void ejecutar(char tipooperac, double monto, String descripcion) {
        this.estado = 0;
        this.fechatransac = LocalDateTime.now();
        this.tipotransaccion = tipooperac;
        this.descripcion = descripcion;

        if (monto < 0) {
            this.estado = 2;
            return;
        }

        switch (tipooperac) {
            case 'r': case 'R':
                if (monto > saldoinic) {
                    this.estado = 1;
                    return;
                }
                this.montotransac = monto;
                this.nuevosaldo = saldoinic - monto;
                break;
            case 'd': case 'D':
                this.montotransac = monto;
                this.nuevosaldo = saldoinic + monto;
                break;
            default:
                this.estado = -1;
        }
    }

    public String getRegistro() {
        String titulooperac = "";
        DateTimeFormatter formatofecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fecha = (fechatransac != null) ? fechatransac.format(formatofecha) : "N/A";

        switch (this.tipotransaccion) {
            case 'd': case 'D':
                titulooperac = "Deposito";
                break;
            case 'r': case 'R':
                titulooperac = "Retiro";
                break;
        }

        return String.format("%4d. %-20s %-16s %-25s $%10.2f $%10.2f",
                idtransac, fecha, titulooperac, descripcion, montotransac, nuevosaldo);
    }

    public int getIdtransac() { return idtransac; }
    public LocalDateTime getFechatransac() { return fechatransac; }
    public double getSaldoinic() { return saldoinic; }
    public double getNuevosaldo() { return nuevosaldo; }
    public double getMontotransac() { return montotransac; }
    public int getEstado() { return estado; }
    public char getTipotransaccion() { return tipotransaccion; }
    public String getDescripcion() { return descripcion; }
}