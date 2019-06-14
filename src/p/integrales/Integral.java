/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.integrales;

import p.operaciones.Postfija;
import p.operaciones.Prefija;

/**
 *
 * @author CStart_U
 */
public class Integral {
    private String funcion;
    private double a, b;
    final int n=30;

    public Integral(String funcion, double a, double b) {
        this.funcion = funcion;
        this.a = a;
        this.b = b;
    }
    
    public double simpson(){
        double h=(b-a)/n;
        double resultado = 0, suma;
        for (int i = 0; i < n / 3 && (a + h * (3 * i + 3)) <= b; i++) {
            suma = 3 * h / 8 * (funcion((a + 3 * h * i)) + 3 * funcion((a + h * (3 * i + 1))) + 3 * funcion((a + h * (3 * i + 2))) + funcion((a + h * (3 * i + 3))));
            resultado += suma;
        }
        return resultado;
    }
    
    private double funcion(double dato){
        String[] f=funcion.split(" ");
        for(int i=0; i<f.length; i++){
            if("x".equals(f[i])){
                f[i]=Double.toString(dato);
            }
        }
        String prefija=Prefija.obtenerPrefija(f);
        System.out.println(prefija);
        return 0.0;//Postfija.obtenerResultado(prefija);
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }
}
