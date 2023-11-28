package Memento;

public class MementoMain {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            // Método run() para ejecutar la aplicación
            public void run() {
                // Se crea una nueva instancia de la clase EmployeeGUI y se muestra en pantalla
                new EmployeeGUI().setVisible(true);


            }
        });
    }
}