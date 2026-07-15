package EjerciciosC1;

import javax.swing.JOptionPane; //-para usar las ventanas xd

public class Ejercicio1 {

    public static void main(String[]args){

        ejemplo3();

    }
    public static void ejemplo3(){

        int result = JOptionPane.showConfirmDialog(
                null,
                "Replace existing selection?");
        System.out.println(
                "El numero devuelto por showConfirmDialog es:" + result);

        switch (result){

            case JOptionPane.YES_OPTION:
                System.out.println("Yes");
                break;
            case JOptionPane.NO_OPTION:
                System.out.println("No");
                break;
            case JOptionPane.CANCEL_OPTION:
                System.out.println("Cancel");
                break;
            case JOptionPane.CLOSED_OPTION:
                System.out.println("Closed");
                break;
        }
        System.exit(0);
    }
}
