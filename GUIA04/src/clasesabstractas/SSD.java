package clasesabstractas;

public class SSD extends UnidAlmac {
    private char interfaz; //'s': SATA o 'p': PCI express

    public SSD() { // constructor
        this.interfaz = '-';
        setInterfaz('s'); // define valores para interfaz SATA
    }

    // sobrecarga de constructor
    public SSD(char interfaz, int capac, int rendim) {
        // define valores para interfaz SATA
        setInterfaz('s');
        // actualiza campos con parametros recibidos
        setInterfaz(interfaz);
        setCapac(capac);
        setRendim(rendim);
    }

    public char getInterfaz() {
        return interfaz;
    }

    public void setInterfaz(char interfaz) {
        // convierte parametro en minuscula
        interfaz = Character.toLowerCase(interfaz);
        // si nuevo tipo interfaz es distinto al actual
        if (interfaz != this.interfaz) {
            // inicializa resto de campos segun tipo interfaz
            switch (interfaz) {
                case 's': // 's': SSD SATA
                    // para SATA, estos son los valores iniciales:
                    this.interfaz = interfaz; // actualiza campo interfaz
                    capac = 256; // (256, 512) GB
                    rendim = 190; // (190 - 600) MB/s
                    break;
                case 'p': // 'p': PCIe (pci express)
                    // para PCIe, estos son los valores iniciales:
                    this.interfaz = interfaz; // actualiza campo interfaz
                    capac = 1; // (1 - 4) TB
                    rendim = 3500; // (3500 - 7000) MB/s
                    break;
            } // fin tipointerfaz
        }
    }

    public int getCapac() {
        return capac;
    }

    public void setCapac(int capac) {
        // verifica que capacidad este en rango segun tipo interfaz
        switch (getInterfaz()) {
            case 's': // SATA
                if (capac == 256 || capac == 512) // GB
                    super.capac = capac;
                break;
            case 'p': // PCIe
                if (capac >= 1 && capac <= 4) // TB
                    super.capac = capac;
                break;
        }
    }

    public int getRendim() {
        return super.rendim;
    }

    public void setRendim(int rendim) {
        // verifica que rendimiento este en rango segun tipo interfaz
        switch (getInterfaz()) {
            case 's': // SATA
                if (rendim >= 190 && rendim <= 600)
                    super.rendim = rendim;
                break;
            case 'p': // PCIe
                if (rendim >= 3500 && rendim <= 7000)
                    super.rendim = rendim;
                break;
        }
    }

    @Override
    public String mostrarparametros() {
        String resul = "";
        String nominterfaz;
        switch (interfaz) {
            case 's':
                nominterfaz = "SATA";
                resul = String.format(
                        "interface %s, Capacidad %d GB, Rendimiento(%d MB/s)",
                        nominterfaz, getCapac(), getRendim()
                );
                break;
            case 'p':
                nominterfaz = "PCIe";
                resul = String.format(
                        "interface %s, Capacidad %d TB, Rendimiento(%d MB/s)",
                        nominterfaz, getCapac(), getRendim()
                );
                break;
        }
        return resul;
    }
}