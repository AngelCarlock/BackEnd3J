package Memento;

import javax.swing.*;

// Constructor de la clase EmployeeGUI
public class EmployeeGUI extends javax.swing.JFrame {
    // Se crea una nueva instancia de la clase Employee y se asigna a la variable employee
    Employee employee = new Employee();

    // Se crea una nueva instancia de la clase EmployeeCaretaker y se asigna a la variable caretaker
    private EmployeeCaretaker caretaker = new EmployeeCaretaker();

    // Se crean instancias de los componentes de la interfaz de usuario
    private JTextField nameTxt;
    private JTextField lastNameTxt;
    private JTextField empNumberTxt;
    private JButton save;
    private JButton next;
    private JButton previous;

    public EmployeeGUI() {


    }


    // Método save() para guardar el estado del empleado

    private void save(java.awt.event.ActionEvent evt) {

        // Se obtienen los valores ingresados en los campos de texto y se asignan al objeto empleado
        employee.setName(nameTxt.getText());
        employee.setLastName(lastNameTxt.getText());
        employee.setEmployeeNumber(empNumberTxt.getText());
    // Se crea un nuevo memento a partir del empleado y se agrega al caretaker
        caretaker.addNewMemento(employee.createMemento());
        // Se muestra un mensaje de confirmación
        JOptionPane.showMessageDialog(this, "Estado guardado");
    }

    // Método previous() para restaurar el estado anterior del empleado
    private void previous(java.awt.event.ActionEvent evt) {
        // Se obtiene el memento anterior del caretaker
        EmployeeMemento menento = caretaker.getPreviousMemento();
        // Se verifica si existe un memento anterior
        if(menento==null){
            JOptionPane.showMessageDialog(this, "No existen más estados");
            return;
        }
        // Se restaura el estado del empleado a partir del memento
        employee.restoreMemento(menento);
        // Se actualiza la interfaz de usuario con el estado restaurado
        updateModel();

    }

    // Método next() para restaurar el siguiente estado del empleado
    private void next(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        // Se obtiene el siguiente memento del caretaker
        EmployeeMemento memento = caretaker.getNextMemento();
        // Se verifica si existe un siguiente memento
        if(memento==null){
            JOptionPane.showMessageDialog(this, "No existen más estados");
            return;
        }
        // Se restaura el estado del empleado a partir del memento
        employee.restoreMemento(memento);
        // Se actualiza la interfaz de usuario con el estado restaurado
        updateModel();
    }

    // Método updateModel() para actualizar la interfaz de usuario con el estado actual del empleado
    private void updateModel(){
        // Se actualizan los campos de texto con los valores del empleado
        nameTxt.setText(employee.getName());
        lastNameTxt.setText(employee.getLastName());
        empNumberTxt.setText(employee.getEmployeeNumber());
    }

}