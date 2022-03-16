import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class proyecto {
    static String nombreLectura = "in";
    static String nombreEscritura = "out";

    /**
     * Función para leer el archivo bajo el formato establecido en el proyecto. El
     * nombre se cambia en la variable global "nombreLectura". (No modificar)
     * 
     * @throws FileNotFoundException
     */
    public static Input input() throws FileNotFoundException {
        File fichero = new File(nombreLectura + ".txt");
        Scanner s = null;
        String[] data;
        s = new Scanner(fichero);
        int n = Integer.parseInt(s.nextLine());
        data = s.nextLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; ++i)
            a[i] = Integer.parseInt(data[i]);
        data = s.nextLine().split(" ");
        int[] b = new int[n];
        for (int i = 0; i < n; ++i)
            b[i] = Integer.parseInt(data[i]);
        data = s.nextLine().split(" ");
        int[] ab = new int[n - 1];
        for (int i = 0; i < n - 1; ++i)
            ab[i] = Integer.parseInt(data[i]);
        data = s.nextLine().split(" ");
        int[] ba = new int[n - 1];
        for (int i = 0; i < n - 1; ++i)
            ba[i] = Integer.parseInt(data[i]);
        s.close();
        return new Input(n, a, b, ab, ba);

    }

    /**
     * Función para escribir sobre el archivo según lo solicitado en el proyecto. El
     * nombre se cambia en la variable global "nombreEscritura". (No modificar)
     */
    public static void output(Output ans) {
        FileWriter fichero = null;
        try {

            fichero = new FileWriter(nombreEscritura + ".txt");
            String toWrite = "";
            toWrite += ans.n + "\n";
            toWrite += ans.time;
            for (int i = 0; i < ans.lines.length; ++i) {
                toWrite += "\n" + ans.lines[i];
            }
            fichero.write(toWrite);
            fichero.close();

        } catch (Exception ex) {
            System.out.println("Mensaje de la excepción: " + ex.getMessage());
        }
    }

    /**
     * Función donde deben introducir la lógica de su algoritmo. Pueden declarar
     * variables globales si lo consideran conveniente. Se adjunta la forma en la
     * que deben retornar la respuesta en el método "createAnswerObject"
     */
    public static Output solve(int n, int[] a, int[] b, int[] ab, int[] ba) {
        /**
         * Declaración de variables para la salida del algoritmo (No modificar)
         */
        int time = 0;
        char lines[] = new char[n];

        /**
         * Algoritmo
         */

        time = 10;
        for (int i = 0; i < n; ++i)
            lines[i] = 'a';

        /**
         * Fin del algoritmo
         */

        /**
         * Salida del algoritmo (No modificar)
         */
        return new Output(n, time, lines);
    }

    public static void main(String[] args) {
        try {
            Input in = input();
            int n = in.n;
            int[] a = in.a;
            int[] b = in.b;
            int[] ab = in.ab;
            int[] ba = in.ba;
            Output ans = solve(n, a, b, ab, ba);
            output(ans);
        } catch (Exception e) {
            System.out.println("Problemas con I/O, verifique el formato de su archivo!");
        }
    }

    /**
     * Clase creada para contener la salida de su algoritmo. (No modificar)
     */
    static class Output {
        int n;
        int time;
        char[] lines;

        public Output(int n, int time, char[] lines) {
            this.n = n;
            this.time = time;
            this.lines = lines;
        }

    }

    /**
     * Clase creada para contener la entrada de su algorimto. (No modificar)
     */
    static class Input {
        int n;
        int[] a;
        int[] b;
        int[] ab;
        int[] ba;

        public Input(int n, int[] a, int[] b, int[] ab, int[] ba) {
            this.n = n;
            this.a = a;
            this.b = b;
            this.ab = ab;
            this.ba = ba;
        }
    }
}