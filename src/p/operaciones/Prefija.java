/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.operaciones;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author CStart_U
 */
public class Prefija {

    public static String obtenerPrefija(String[] interfija) {
        Queue<String> num = new LinkedList<>();
        Queue<String> def = new LinkedList<>();
        ArrayList<String> operadores = new ArrayList();
        for (String j : interfija) {
            if (Postfija.esNumero(j) || "x".equals(j) || "y".equals(j)) {
                num.add(j);
            } else if (operadores.isEmpty()) {
                def.add(j);
                operadores.add(j);
                def.add(num.poll());
            } else {
                String op = operadores.remove(0);
                if ("+".equals(j) || "-".equals(j)) {
                    def.add(num.poll());
                    num = def;
                    def = new LinkedList<>();
                    def.add(j);
                    for (int i = 0; !num.isEmpty(); i++) {
                        def.add(num.poll());
                    }
                    operadores.add(j);
                } else if ("*".equals(j) || "/".equals(j)) {
                    if (op.equals("^") || op.equals(")")) {
                        def.add(num.poll());
                        num = def;
                        def = new LinkedList<>();
                        def.add(j);
                        for (int i = 0; !num.isEmpty(); i++) {
                            def.add(num.poll());
                        }
                        operadores.add(j);
                    } else {
                        def.add(j);
                        operadores.add(j);
                        def.add(num.poll());
                    }
                } else if ("^".equals(j)) {
                    if (op.equals(")")) {
                        def.add(num.poll());
                        num = def;
                        def = new LinkedList<>();
                        def.add(j);
                        for (int i = 0; !num.isEmpty(); i++) {
                            def.add(num.poll());
                        }
                        operadores.add(j);
                    } else {
                        def.add(j);
                        operadores.add(j);
                        def.add(num.poll());
                    }
                } else if ("(".equals(j)) {
                    
                }else if("[".equals(j)){
                    
                }
            }
        }
        def.add(num.poll());
        String prefija = "";
        for (String def1 : def) {
            prefija = prefija.concat(def1 + " ");
        }
        return prefija;
    }
}
