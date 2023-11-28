package Mediator;

public class ECommerceModule extends AbstractModule {

    public static final String MODULE_NAME = "ECommerce"; // Constante que define el nombre del módulo
    public static final String OPERATION_COMPLETE_ORDER = "CompleteOrder";  // Constante que define el tipo de mensaje "CompleteOrder"


    @Override
    public String getModulName() {
        return MODULE_NAME;
    } // Método que devuelve el nombre del módulo


    @Override
    public Object notifyMessage(ModuleMessage message) {
        switch (message.getMessageType()) {
            case OPERATION_COMPLETE_ORDER:
                return compleOrder(message);  // Método que se llama cuando se recibe un mensaje de tipo "CompleteOrder"
            default:

                throw new RuntimeException("Operación no soportada '" +
                        message.getMessageType() + "'"); // Se lanza una excepción si se recibe un tipo de mensaje no soportado
        }
    }

    private String compleOrder(ModuleMessage message){
        // Método privado que completa una orden de venta a partir de un mensaje recibido
        SaleOrder saleOrder = (SaleOrder)message.getPayload();  // Se obtiene el objeto SaleOrder del mensaje
        System.out.println("Orden completada exitosamente > " );

        ModuleMessage crmMessage = new ModuleMessage(MODULE_NAME,
                NotifyModule.MODULE_NAME, NotifyModule.OPERATION_NOTIFY,
                saleOrder);  // Se crea un nuevo mensaje para notificar al módulo de notificaciones
        mediator.mediate(crmMessage);  // Se envía el mensaje al ModuleMediator para que lo envíe al módulo de notificaciones
        return saleOrder.getId(); // Se devuelve el ID de la orden de venta
    }

    public String createSale(Sale sale){
        ModuleMessage crmMessage = new ModuleMessage(MODULE_NAME,
                CRMModule.MODULE_NAME, CRMModule.OPERATION_CREATE_ORDER, sale); // Se crea un nuevo mensaje para crear una orden de venta en el módulo CRM

        return mediator.mediate(crmMessage).toString();  // Se envía el mensaje al ModuleMediator para que lo envíe al módulo CRM y se devuelve el resultado convertido a String
    }

}
