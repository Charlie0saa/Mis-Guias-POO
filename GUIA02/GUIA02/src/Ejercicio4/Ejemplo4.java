package Ejercicio4;

import javax.swing.*;
import java.util.Scanner;


public class Ejemplo4 {
    public static void main(String[] args) {

        Ejemplo4();
    }
    //<>
    public static void Ejemplo4() {
        String datos;
        double sueldo, afp=0, isss, totalre, nsueldo, renta;
        datos = JOptionPane.showInputDialog("Ingrese el sueldo del empleado (a)");
        sueldo = Double.parseDouble(datos);
        if(sueldo>300);
            afp = (sueldo*0.0625);

        JOptionPane.showMessageDialog(null,"Este empleado tiene un sueldo " +
                "de"+sueldo+"y el descuento de AFP es"+afp);
        datos= (String) JOptionPane.showInputDialog(null,"Ingrese el Sexo: \nSI es Masculino (M)\nSi es Femenino (F)",
                "Sexo del Empleado",JOptionPane.QUESTION_MESSAGE,
                null,//icono por defecto
                new Object[]{"M","F"},
                "F");
        if(datos == "M"){
            isss = sueldo*0.03;
            renta= sueldo*0.10;
            totalre=afp+isss+renta;
            nsueldo=sueldo-totalre;
            JOptionPane.showMessageDialog(null,"a este empleado se le detiene"+isss+
                    "en concepto de ISSS\nAdemas se le retiene:"+renta+
                    "En concepto de Renta\nLo que hace un total de"+totalre+
                    "\nY su nuevo Sueldo es de:"+nsueldo);
        }

    }
}
