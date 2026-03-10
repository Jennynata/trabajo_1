/**
 * Creacion de la clase Pila para manejar el historial de deshacer y rehacer en el editor de texto.
 * Esta clase implementa una pila simple utilizando un arreglo para almacenar los estados del texto.
 */
class Pila {
    private final String[] elementos;
    private int tope;
    private final int capacidad;

    public Pila(int capacidad) {
        this.capacidad = capacidad;
        this.elementos = new String[capacidad];
        this.tope = -1;
    }

    public boolean isEmpty() {
        return tope == -1;
    }

    public void push(String elemento) {
        if (tope < capacidad - 1) {
            elementos[++tope] = elemento;
        } else {
            System.out.println("Error: Historial lleno.");
        }
    }

    public String pop() {
        if (!isEmpty()) {
            return elementos[tope--];
        }
        return null;
    }

    public String peek() {
        if (!isEmpty()) {
            return elementos[tope];
        }
        return null;
    }

    // Método para limpiar la pila de rehacer cuando se escribe algo nuevo
    public void vaciar() {
        this.tope = -1;
    }
}

/**
 * Clase que gestiona las acciones de Deshacer y Rehacer.
 */
class EditorTexto {
    private final Pila pilaPrincipal;
    private final Pila pilaSecundaria;

    public EditorTexto(int capacidad) {
        pilaPrincipal = new Pila(capacidad);
        pilaSecundaria = new Pila(capacidad);
    }

    public void escribir(String texto) {
        pilaPrincipal.push(texto);
        // Al escribir algo nuevo, el historial de "Rehacer" debe limpiarse
        pilaSecundaria.vaciar(); 
        System.out.println("Texto guardado en el historial.");
    }

    public void deshacer() {
        if (!pilaPrincipal.isEmpty()) {
            String texto = pilaPrincipal.pop();
            pilaSecundaria.push(texto);
            System.out.println("Deshecho: " + texto);
        } else {
            System.out.println("No hay acciones para deshacer.");
        }
    }

    public void rehacer() {
        if (!pilaSecundaria.isEmpty()) {
            String texto = pilaSecundaria.pop();
            pilaPrincipal.push(texto);
            System.out.println("Rehecho: " + texto);
        } else {
            System.out.println("No hay acciones para rehacer.");
        }
    }

    public void mostrarTexto() {
        if (pilaPrincipal.isEmpty()) {
            System.out.println("El editor está vacío.");
        } else {
            System.out.println("--- Contenido Actual ---");
            System.out.println(pilaPrincipal.peek());
        }
    }
}