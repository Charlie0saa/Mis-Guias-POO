package EjerciciosC1;

public class Ejercicio2 {

    //Δ=b2−4ac
    public static void main(String[]args){

        resolverEcuacion(-16, 0, 9);

    }

    public static double determinante(double a, double b, double c){

        return Math.pow(b,2) - (4*a*c);
    }

    public static void resolverEcuacion(double a, double b, double c){

        double delta = determinante(a, b, c);

        //<>
        //Δ=b2−4ac
        if(delta>0){
        double x1;
        double x2;

            x1 = (-b + Math.sqrt(delta)) / (2 * a);
            x2 = (-b - Math.sqrt(delta)) / (2 * a);

            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);

        }
        else if (delta==0) {

          double x;

            x = (-b) / (2 * a);

            System.out.println("x = " + x);

        }
        else{

            double parteImaginaria;
            double parteReal;

            parteReal = (-b) / (2 * a);

            parteImaginaria = Math.sqrt(-delta) / (2 * a);

            System.out.println("La ecuacion tiene raices imaginarias.");
            System.out.println("x1 = " + parteReal + " + " + parteImaginaria + "i");
            System.out.println("x2 = " + parteReal + " - " + parteImaginaria + "i");

        }


    }

}
