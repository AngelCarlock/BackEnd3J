package Mediator;

import java.util.HashMap;
import java.util.Map;

public class ModuleMediator {

    private static ModuleMediator mediator;
    private static final Map<String, AbstractModule> modules = new HashMap<>();

    // Constructor privado para evitar la creación de instancias directamente
    private ModuleMediator() {
    }

    // Método estático para obtener la instancia única de ModuleMediator (siguiendo el patrón Singleton)
    public static synchronized ModuleMediator getInstance() {
        if (mediator == null) {
            mediator = new ModuleMediator();
        }
        return mediator;
    }

    // Método para registrar un módulo en el mediador
    public void registModule(AbstractModule module) {
        modules.put(module.getModulName(), module);
    }


    // Método para mediar un evento entre módulos
    public Object mediate(ModuleMessage mediateEvent) {
        // Verifica si el módulo de destino está registrado en el mediador
        if (!modules.containsKey(mediateEvent.getTarget())) {
            throw new RuntimeException("El módulo '"
                    + mediateEvent.getTarget() + "' no está registrado");
        }
        // Imprime información sobre el evento
        System.out.println("Mediate source > '" + mediateEvent.getSource()
                + "', target > '" + mediateEvent.getTarget()
                + "', messagetType > '"+mediateEvent.getMessageType()+"'");
        // Aquí se obtiene el módulo de destino y notificarle el mensaje
        AbstractModule module = modules.get(mediateEvent.getTarget());
        return module.notifyMessage(mediateEvent);
    }
}
