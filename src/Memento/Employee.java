package Memento;

public class Employee implements Cloneable {
    private String name;
    private String lastName;
    private String employeeNumber;

    // Constructor que recibe el nombre, apellido y número de empleado
    public Employee(String name, String lastName, String employeeNumber) {
        this.name = name;
        this.lastName = lastName;
        this.employeeNumber = employeeNumber;
    }
    // Constructor vacío
    public Employee() {
    }

    // Método para obtener el nombre del empleado
    public String getName() {
        return name;
    }

    // Método para establecer el nombre del empleado
    public void setName(String name) {
        this.name = name;
    }

    // Método para obtener el apellido del empleado
    public String getLastName() {
        return lastName;
    }

    // Método para establecer el apellido del empleado
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Método para obtener el número de empleado
    public String getEmployeeNumber() {
        return employeeNumber;
    }

    // Método para establecer el número de empleado
    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    // Método para crear un memento del estado actual del empleado
    public EmployeeMemento createMemento(){
        try {
            return new EmployeeMemento((Employee)this.clone());
        } catch (Exception e) {
            throw new RuntimeException("Error al clonar el empleado");
        }
    }

    // Método para restaurar el estado del empleado a partir de un memento
    public void restoreMemento(EmployeeMemento memento){
        Employee employee = memento.getMemento();
        this.name = employee.name;
        this.lastName = employee.name;
        this.employeeNumber = employee.employeeNumber;
    }
}


