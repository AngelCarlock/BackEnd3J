package Mediator;

public abstract class AbstractModule {

    protected ModuleMediator mediator; // Variable protegida que almacena una instancia

    public abstract String getModulName(); // Método abstracto que debe ser implementado por las clases derivadas para obtener el nombre del módulo

    public void activate() {
        mediator = ModuleMediator.getInstance(); // Asigna a la variable "mediator" una instancia única de ModuleMediator utilizando el patrón Singleton
        mediator.registModule(this); // Registra el módulo actual en el ModuleMediator
    }


    public abstract Object notifyMessage(ModuleMessage message); // Método abstracto que debe ser implementado por las clases derivadas para manejar un mensaje del módulo

}