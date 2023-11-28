package Memento;

public class EmployeeMemento {

    // Constructor que recibe un objeto Employee y lo asigna al atributo employee
    public Employee employee;
    public EmployeeMemento(Employee employee){
        this.employee = employee;
    }

    // Método para obtener el objeto Employee almacenado en el memento
    public Employee getMemento(){
        return employee;
    }
}
