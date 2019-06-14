/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.integrales;

import java.util.Scanner;

/**
 *
 * @author CStart_U
 */
public class Inicio2 {

    public static void main(String[] args) {
        //Integral conjunta=new Integral("x ^ 2 + 3 * x / 4", 1, 4);
        //System.out.println(conjunta.simpson());
        try {
            double a, b, c, d;
            Scanner scan = new Scanner(System.in);
            System.out.println("ingresa funcion a integrar separado por espacios: ");
            String funcion = scan.nextLine();
            System.out.print("Ingresa limite a: ");
            a=Double.parseDouble(scan.nextLine());
            System.out.print("Ingresa limite b: ");
            b=Double.parseDouble(scan.nextLine());
            System.out.print("Ingresa limite c: ");
            c=Double.parseDouble(scan.nextLine());
            System.out.print("Ingresa limite d: ");
            d=Double.parseDouble(scan.nextLine());
            IntegralDoble dxdy = new IntegralDoble(a, b, c, d, funcion);
            System.out.println("Resultado tras aplicar integral doble: "+dxdy.resolver());
        } catch (NumberFormatException e) {
            System.out.println("Ingresaste un numeero no valido");
        }
    }
}
