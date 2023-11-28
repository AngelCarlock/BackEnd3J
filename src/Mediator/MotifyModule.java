package Mediator;

class NotifyModule extends AbstractModule {

    public static final String MODULE_NAME = "Notification";
    public static final String OPERATION_NOTIFY = "Notify";

    // Método para obtener el nombre del módulo
    @Override
    public String getModulName() {
        return MODULE_NAME;
    }

    // Método para notificar un mensaje al módulo de notificación
    @Override
    public Void notifyMessage(ModuleMessage message) {
        switch (message.getMessageType()) {  // Utiliza un switch para determinar el tipo de mensaje
            case OPERATION_NOTIFY:
                return notify(message);
            default:
                throw new RuntimeException("Operación no soportada '"
                        + message.getMessageType() + "'");
        }
    }

    // Método privado para manejar la notificación de mensajes
    private Void notify(ModuleMessage message) {
        // Imprime un mensaje indicando que se ha enviado una notificación por correo electrónico
        System.out.println("Notificación por EMail enviada");
        return null;
    }

}
