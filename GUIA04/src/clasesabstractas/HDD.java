package clasesabstractas;

public class HDD extends UnidAlmac {
    private int rpm;
    private int platos;

    private void inicializarhdd() {
        // En GB: 256, 512, 1024(1 TB), 2048(2 TB) o 4096(4 TB)
        capac = 256;
        // rango: 150 - 180 MB/s
        rendim = 150; // 150 MB/s
        // rango: solamente 5400, 7200 (predeterminado), 10000
        rpm = 7200;
        // rango: de 1 a 5. predeterminado 4
        platos = 4;
    }

    public HDD() {
        inicializarhdd();
    }

    public HDD(int capac, int rendim, int rpm, int platos) {
        inicializarhdd();
        // intenta actualizar campos
        setCapac(capac);
        setRendim(rendim);
        setRpm(rpm);
        setPlatos(platos);
    }

    public int getCapac() {
        // devuelve valor de campo (en GigaBytes)
        return super.capac;
    }

    public void setCapac(int capac) {
        // verifica si capacidad recibida es apropiada
        // En GB: 256, 512, 1024 (1 TB), 2048 (2 TB) o 4096 (4 TB)
        switch (capac) {
            case 256: case 512:
            case 1024: case 2048: case 4096:
                super.capac = capac; // modifica campo
                break;
        }
    }

    public String getCapacidadHDD() {
        // retorna valor en GB (para 256 o 512 GB) o
        // en TB (para resto de valores aceptados)
        int totaltb; // total de TeraBytes
        String valorcapac = "";
        switch (capac) {
            case 256: case 512:
                valorcapac = String.valueOf(capac) + " GB";
                break;
            default:
                totaltb = capac / 1024;
                valorcapac = String.valueOf(totaltb) + " TB";
        }
        return valorcapac;
    }

    public int getRendim() {
        return rendim;
    }

    public void setRendim(int rendim) {
        // acepta valor solo entre (150 a 180 MB/s)
        if (rendim >= 150 && rendim <= 180) {
            super.rendim = rendim;
        }
    }

    public int getRpm() {
        return rpm;
    }

    public void setRpm(int rpm) {
        // rango: solamente 5400, 7200 (predeterminado), 10000
        switch (rpm) {
            case 5400: case 7200: case 10000:
                this.rpm = rpm;
                break;
        }
    }

    public int getPlatos() {
        return platos;
    }

    public void setPlatos(int platos) {
        if (platos >= 1 && platos <= 5) {
            this.platos = platos;
        }
    }

    @Override
    public String mostrarparametros() {
        String resul;
        resul = String.format(
                "Capacidad (%s), Rendimiento(%d MB/s), %d rpm, %d Platos",
                getCapacidadHDD(), rendim, rpm, platos
        );
        return resul;
    }
}