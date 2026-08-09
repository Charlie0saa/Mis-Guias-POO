package clasesestaticas;

public class NumComplejo {
    private double real;
    private double ima;

    public NumComplejo() {
        this.real = 0.0;
        this.ima = 0.0;
    }

    public NumComplejo(double real, double ima) {
        this.real = real;
        this.ima = ima;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getIma() {
        return ima;
    }

    public void setIma(double ima) {
        this.ima = ima;
    }

    public String vervalor() {
        if (ima >= 0) {
            return String.format("%.2f + %.2fi", real, ima);
        } else {
            return String.format("%.2f - %.2fi", real, Math.abs(ima));
        }
    }
}