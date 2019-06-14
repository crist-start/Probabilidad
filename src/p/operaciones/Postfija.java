/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.operaciones;

import java.util.Stack;

/**
 *
 * @author CStart_U
 */
public class Postfija {
    public static boolean esOperador(String a) {
        return a.equals("+") || a.equals("-") || a.equals("*") || a.equals("/") || a.equals("^");
    }

    public static boolean esNumero(String a) {
        try {
            Double.parseDouble(a);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static double obtenerResultado(String[] pf){
        Stack<Double> operar = new Stack<>();
        for (int i=pf.length-1; i>=0; i--) {
            if (esNumero(pf[i])) {
                operar.add(new Double(pf[i]));
            } else if (esOperador(pf[i])) {
                double a = operar.pop();
                double b = operar.pop();
                switch (pf[i]) {
                    case "+":
                        operar.add(a + b);
                        break;
                    case "-":
                        operar.add(a - b);
                        break;
                    case "*":
                        operar.add(a * b);
                        break;
                    case "/":
                        operar.add(a / b);
                        break;
                    case "^":
                        operar.add(Math.pow(a, b));
                        break;
                }
            } else {
                double a = (double) operar.pop();
                switch (pf[i]) {
                    case "sen":
                        operar.add(Math.sin(a));
                        break;
                    case "cos":
                        operar.add(Math.cos(a));
                        break;
                    case "tan":
                        operar.add(Math.tan(a));
                        break;
                    case "ln":
                        operar.add(Math.log(a));
                        break;
                    default:
                        System.out.println("Error de datos");
                }
            }
        }
        return operar.pop();
    }
}