package clasesestaticas;

public class MateComplejos {

    public static NumComplejo Suma(NumComplejo n1, NumComplejo n2) {
        NumComplejo res = new NumComplejo();
        res.setReal(n1.getReal() + n2.getReal());
        res.setIma(n1.getIma() + n2.getIma());
        return res;
    }

    public static NumComplejo Resta(NumComplejo n1, NumComplejo n2) {
        NumComplejo res = new NumComplejo();
        res.setReal(n1.getReal() - n2.getReal());
        res.setIma(n1.getIma() - n2.getIma());
        return res;
    }

    public static NumComplejo Multiplicar(NumComplejo n1, NumComplejo n2) {
        double r = (n1.getReal() * n2.getReal()) - (n1.getIma() * n2.getIma());
        double i = (n1.getReal() * n2.getIma()) + (n1.getIma() * n2.getReal());
        return new NumComplejo(r, i);
    }

    public static NumComplejo Division(NumComplejo n1, NumComplejo n2) {
        double denominador = Math.pow(n2.getReal(), 2) + Math.pow(n2.getIma(), 2);
        if (denominador == 0) {
            System.out.println("Error: Division por cero.");
            return new NumComplejo(0, 0);
        }
        double r = ((n1.getReal() * n2.getReal()) + (n1.getIma() * n2.getIma())) / denominador;
        double i = ((n1.getIma() * n2.getReal()) - (n1.getReal() * n2.getIma())) / denominador;
        return new NumComplejo(r, i);
    }

    public static NumComplejo Potencia(NumComplejo n, int exp) {
        if (exp == 0) return new NumComplejo(1, 0);
        NumComplejo res = new NumComplejo(n.getReal(), n.getIma());
        for (int k = 1; k < exp; k++) {
            res = Multiplicar(res, n);
        }
        return res;
    }
}