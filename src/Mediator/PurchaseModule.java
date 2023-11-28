package Mediator;

public class PurchaseModule extends AbstractModule {

    public static final String MODULE_NAME = "Chopping";
    public static final String OPERATION_PURCHASE_REQUEST = "PurchaseRequest";

    // Método para obtener el nombre del módulo
    @Override
    public String getModulName() {
        return MODULE_NAME;
    }

    // Método para notificar un mensaje al módulo
    @Override
    public Object notifyMessage(ModuleMessage message) {
        switch (message.getMessageType()) {
            case OPERATION_PURCHASE_REQUEST:
                return purchaseRequest(message);
            default:
                throw new RuntimeException("Operación no soportada '"
                        + message.getMessageType() + "'");
        }
    }

    // Método para procesar una solicitud de compra
    private Void purchaseRequest(ModuleMessage message){
        return null;
    }
    }
