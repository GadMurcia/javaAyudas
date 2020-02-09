/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cristiangomez;

import java.util.Scanner;

/**
 *
 * @author delsas
 */
public class CristianGomez {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String alumnos[]
                = {"Joan##-7.0#4.8", "Leila#10#9.9#9.8", "Pere#3.7#-2.3#4.3",
                    "Jaume#7.5##15", "Anabel#4.5#5.6#"};
        String[] nombreM = new String[3];
        String[] nombrem = new String[3];
        double[] mayores = {0.0, 0.0, 0.0};
        double[] menores = {10.0, 10.0, 10.0};
        String[] promedios = new String[alumnos.length];
        String[] mejorePrimera = new String[alumnos.length];
        String[] mejoresSegunda = new String[alumnos.length];
        String[] mejoresTercera = new String[alumnos.length];
        /**
         * los '\n' significan un salto de línea. los '\t' significan una
         * tabulación. los for del tipo (String a : alumnos) { ... } significan
         * para cada String con nombre 'a' en el vector 'alumnos'. Es similar al
         * for (int i = 0; i < alumnos.length; i++) { String a = alumnos[i]; }
         */
        System.out.println("Los datos inicales son:");
        for (String a : alumnos) {
            String g = "";
            String val[] = a.split("#");
            for (String b : val) {
                g += b + "\t";
            }
            System.out.println(g);
        }

        System.out.println("\nPARTE A\n");
        for (int i = 0; i < alumnos.length; i++) {
            String alumno = alumnos[i];
            String vals[] = alumno.split("#");
            vals[1] = validar(vals[1], "primera", vals[0]) + "";
            vals[2] = validar(vals[2], "segunda", vals[0]) + "";
            if (vals.length < 4) {
                String v[] = vals;
                vals = new String[]{v[0], v[1], v[2], ""};
                vals[3] = validar("", "tercera", vals[0]) + "";
            }
            vals[3] = validar(vals[3], "tercera", vals[0]) + "";
            alumnos[i] = vals[0] + "#" + vals[1] + "#" + vals[2] + "#" + vals[3];
        }

        System.out.println("\nLos datos corregidos son: ");
        for (String a : alumnos) {
            String g = "";
            String val[] = a.split("#");
            for (String b : val) {
                g += b + "\t";
            }
            System.out.println(g);
        }

        System.out.println("\nPARTE B\n");
        /**
         * este es el for para ver los otros puntos
         */
        for (int i = 0; i < alumnos.length; i++) {
            String alumno = alumnos[i];
            String[] vals = alumno.split("#");
            double n1 = Double.valueOf(vals[1]);
            double n2 = Double.valueOf(vals[2]);
            double n3 = Double.valueOf(vals[3]);

            if (mayores[0] < n1) {
                mayores[0] = n1;
                nombreM[0] = vals[0];
            }
            if (mayores[1] < n2) {
                mayores[1] = n2;
                nombreM[1] = vals[0];
            }
            if (mayores[2] < n3) {
                mayores[2] = n3;
                nombreM[2] = vals[0];
            }

            if (menores[0] > n1) {
                menores[0] = n1;
                nombrem[0] = vals[0];
            }
            if (menores[1] > n2) {
                menores[1] = n2;
                nombrem[1] = vals[0];
            }
            if (menores[2] > n3) {
                menores[2] = n3;
                nombrem[2] = vals[0];
            }
            double pr = Math.round((n1 + n2 + n3) / 0.3);
//el 0.3 es para la aproximación a 1 cifra decimal
            promedios[i] = vals[0] + ": " + (pr / 10);
        }

        System.out.println("La  nota mayor de la primera evaluación es de "
                + nombreM[0] + " con nota de " + mayores[0]);
        System.out.println("La  nota menor de la primera evaluación es de "
                + nombrem[0] + " con nota de " + menores[0]);

        System.out.println("\nLa  nota mayor de la segunda evaluación es de "
                + nombreM[1] + " con nota de " + mayores[1]);
        System.out.println("La  nota menor de la segunda evaluación es de "
                + nombrem[1] + " con nota de " + menores[1]);

        System.out.println("\nLa  nota mayor de la tercera evaluación es de "
                + nombreM[2] + " con nota de " + mayores[2]);
        System.out.println("La  nota menor de la tercera evaluación es de "
                + nombrem[2] + " con nota de " + menores[2]);

        System.out.println("\nLos promedios son:");
        for (String p : promedios) {
            System.out.println(p);
        }

        System.out.println("\nPARTE C\n");
        System.out.println("mejores 3 de cada evaluación:");
        for (int i = 0; i < alumnos.length; i++) {
            String[] vals = alumnos[i].split("#");
            mejorePrimera[i] = vals[0] + ": " + vals[1];
            mejoresSegunda[i] = vals[0] + ": " + vals[2];
            mejoresTercera[i] = vals[0] + ": " + vals[3];
        }
        //la burbuja para ordenarlos descendentes
        for (int y = 0; y < alumnos.length; y++) {
            for (int x = 0; x < alumnos.length; x++) {
                double v1 = Double.valueOf(mejorePrimera[y].split(": ")[1]);
                double v2 = Double.valueOf(mejorePrimera[x].split(": ")[1]);
                if (v1 > v2) {
                    String v = mejorePrimera[y];
                    mejorePrimera[y] = mejorePrimera[x];
                    mejorePrimera[x] = v;
                }

                v1 = Double.valueOf(mejoresSegunda[y].split(": ")[1]);
                v2 = Double.valueOf(mejoresSegunda[x].split(": ")[1]);
                if (v1 > v2) {
                    String v = mejoresSegunda[y];
                    mejoresSegunda[y] = mejoresSegunda[x];
                    mejoresSegunda[x] = v;
                }

                v1 = Double.valueOf(mejoresTercera[y].split(": ")[1]);
                v2 = Double.valueOf(mejoresTercera[x].split(": ")[1]);
                if (v1 > v2) {
                    String v = mejoresTercera[y];
                    mejoresTercera[y] = mejoresTercera[x];
                    mejoresTercera[x] = v;
                }
            }
        }
        System.out.println("\nmejores 3 de la primera evaluación");
        for (int i = 0; i < 3; i++) {
            System.out.println(mejorePrimera[i]);
        }

        System.out.println("\nmejores 3 de la segunda evaluación");
        for (int i = 0; i < 3; i++) {
            System.out.println(mejoresSegunda[i]);
        }

        System.out.println("\nmejores 3 de la tercera evaluación");
        for (int i = 0; i < 3; i++) {
            System.out.println(mejoresTercera[i]);
        }

        //la burbuja XD XD
        System.out.println("\n\nNota media descendente:");
        for (int y = 0; y < promedios.length; y++) {
            for (int x = 0; x < promedios.length; x++) {
                double v1 = Double.valueOf(promedios[y].split(": ")[1]);
                double v2 = Double.valueOf(promedios[x].split(": ")[1]);
                if (v1 > v2) {
                    String v = promedios[y];
                    promedios[y] = promedios[x];
                    promedios[x] = v;
                }
            }
        }
        //imprime las notas descendentes
        for (String p : promedios) {
            System.out.println(p);
        }
    }

    public static double validar(String nota, String eval, String nombre) {
        double n;
        if (!nota.isEmpty()) {
            n = Double.valueOf(nota);
        } else {
            System.out.println("He notado que " + nombre + " no tiene nota de la " + eval + " evaluación."
                    + "\nPor favor introduzca un valor.");
            n = new Scanner(System.in).nextDouble();
        }

        while (n < 0 || n > 10) {
            System.out.println("He notado que "
                    + nombre + " tiene como nota de la "
                    + eval + " evaluación un " + n + ", lo que no es válido.");
            System.out.println("La nota debe estar entre cero (0) y diez (10). Ingréselo de nuevo.");
            n = new Scanner(System.in).nextDouble();
        }
        return n;
    }

}
