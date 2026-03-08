/**
 * Creacion de la clase Pila para manejar el historial de deshacer y rehacer en el editor de texto.
 * Esta clase implementa una pila simple utilizando un arreglo para almacenar los estados del texto.
 */
class Pila {
    private String[] elementos;
    private int tope;
    private int capacidad;

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