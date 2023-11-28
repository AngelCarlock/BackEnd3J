package Memento;

import java.util.LinkedList;

public class EmployeeCaretaker {
    private int currentIndex = -1;
    private final LinkedList<EmployeeMemento> states = new LinkedList<>();

    // Método para agregar un nuevo memento a la lista de estados
    public void addNewMemento(EmployeeMemento m) {
        states.add(m);
        currentIndex++;
    }

    // Método para obtener el memento actual
    public EmployeeMemento getCurrentMemento() {
        return states.get(currentIndex);
    }

    // Método para obtener el memento siguiente al actual
    public EmployeeMemento getNextMemento() {
        int newIndex = currentIndex +1;
        if( newIndex >= states.size()){
            return null;
        }
        currentIndex = newIndex;
        return states.get(currentIndex);
    }

    // Método para obtener el memento anterior al actual
    public EmployeeMemento getPreviousMemento() {
        int newIndex = currentIndex-1;

        if(newIndex <= -1 || newIndex >= states.size()-1){
            return null;
        }
        currentIndex= newIndex;
        return states.get(currentIndex);
    }
}
