
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Definimos una capacidad de 20 acciones para el editor
        EditorTexto editor = new EditorTexto(20);
        int opcion = 0;

        do {
            System.out.println("\n============================");
            System.out.println("   SIMULADOR UNDO/REDO");
            System.out.println("============================");
            System.out.println("1. Escribir texto");
            System.out.println("2. Deshacer (Undo)");
            System.out.println("3. Rehacer (Redo)");
            System.out.println("4. Ver estado actual");
            System.out.println("5. Salir");
            System.out.print("Seleccione: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Escriba su línea de texto: ");
                    String texto = sc.nextLine();
                    editor.escribir(texto);
                    break;
                case 2:
                    editor.deshacer();
                    break;
                case 3:
                    editor.rehacer();
                    break;
                case 4:
                    editor.mostrarTexto();
                    break;
                case 5:
                    System.out.println("Cerrando editor...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        sc.close();
    }
}

