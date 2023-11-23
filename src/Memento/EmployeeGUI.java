package Memento;

import javax.swing.*;

public class EmployeeGUI extends javax.swing.JFrame {
    Employee employee = new Employee();
    private EmployeeCaretaker caretaker = new EmployeeCaretaker();
    private JTextField nameTxt;
    private JTextField lastNameTxt;
    private JTextField empNumberTxt;
    private JButton actualizarButton;
    private JButton cancelarButton;

    public EmployeeGUI() {
      initComponents();
          

    }

    private void initComponents() {

    }


    private void save(java.awt.event.ActionEvent evt) {
        employee.setName(nameTxt.getText());
        employee.setLastName(lastNameTxt.getText());
        employee.setEmployeeNumber(empNumberTxt.getText());

        caretaker.addNewMemento(employee.createMemento());
        JOptionPane.showMessageDialog(this, "Estado guardado");
    }

    private void previous(java.awt.event.ActionEvent evt) {

        EmployeeMemento menento = caretaker.getPreviousMemento();
        if(menento==null){
            JOptionPane.showMessageDialog(this, "No existen más estados");
            return;
        }
        employee.restoreMemento(menento);
        updateModel();
    }

    private void next(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        EmployeeMemento memento = caretaker.getNextMemento();
        if(memento==null){
            JOptionPane.showMessageDialog(this, "No existen más estados");
            return;
        }
        employee.restoreMemento(memento);
        updateModel();
    }

    private void updateModel(){
        nameTxt.setText(employee.getName());
        lastNameTxt.setText(employee.getLastName());
        empNumberTxt.setText(employee.getEmployeeNumber());
    }

}