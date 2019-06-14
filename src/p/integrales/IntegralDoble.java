/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.integrales;

import p.operaciones.Prefija;
import p.operaciones.Postfija;

/**
 *
 * @author CStart_U
 */
public class IntegralDoble {

    private double a, b, c, d;
    private String fnxy;
    final int n = 600, o=600;

    public IntegralDoble(double a, double b, double c, double d, String fnxy) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.fnxy = fnxy;
    }

    public double resolver() {
        double resultado = 0;
        double h1 = (b - a) / o, h2 = (d - c) / n;
        String[] fn = fnxy.split(" ");
        String prefija = Prefija.obtenerPrefija(fn);
        System.out.println(prefija);
        for (int i = 0; i < o; i++) {
            for (int j = 0; j < n / 3; j++) {
                //resultado = resultado + h1 * h2 * (trapecio(i, j, h1, h2, p)+trapecio(i+1, j+1, h1, h2, p))/4;
                //resultado = resultado + 3 * h1 * h2 * (simpson(i, j, h1, h2, prefija) + simpson(i + 1, j + 1, h1, h2, prefija)) / 16;
                resultado = resultado + 3 * h1 * h2 * (simpson(i, j, h1, h2, prefija) + simpson(i + 1, j + 1, h1, h2, prefija)) / 16;
            }
        }
        return resultado;
    }

    public double simpson(int i, int j, double h1, double h2, String p) {
        return funcion(a + h1 * i, c + 3 * h2 * j, p) + 3 * funcion(a + h1 * i, c + h2 * (1 + 3 * j), p)
                + 3 * funcion(a + h1 * i, c + h2 * (2 + 3 * j), p) + funcion(a + h1 * i, c + h2 * (3 + 3 * j), p);
    }

    public double trapecio(int i, int j, double h1, double h2, String p) {
        return funcion(a + h1 * i, c + h2 * j, p) + funcion(a + h1 * i, c + (1 + j) * h2, p);
    }

    public double funcion(double x, double y, String prefija) {
        String[] fn = prefija.split(" ");
        for (int i = 0; i < fn.length; i++) {
            if ("x".equals(fn[i])) {
                fn[i] = Double.toString(x);
            } else if ("y".equals(fn[i])) {
                fn[i] = Double.toString(y);
            }
        }
        return Postfija.obtenerResultado(fn);
    }
}
