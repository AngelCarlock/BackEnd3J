package Mediator;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CRMModule extends AbstractModule { // La clase CRMModule que extiende la clase AbstractModule.


    //El módulo CRM implementa el método getModulName() para devolver el nombre del módulo y el método notifyMessage() para manejar mensajes recibidos.
    public static final String MODULE_NAME = "CRM"; // Constante que define el nombre del módulo

    public static final String OPERATION_CREATE_ORDER = "CreateOrder";  // Método que devuelve el nombre del módulo

    @Override
    public String getModulName() {
        return MODULE_NAME;
    }

//Cuando se recibe un mensaje de tipo "CreateOrder", se llama al método createSaleOrder() para crear una orden de venta.
    @Override
    public Object notifyMessage(ModuleMessage message) {
        switch (message.getMessageType()) {
            case OPERATION_CREATE_ORDER:
                return createSaleOrder(message); // Método que se llama cuando se recibe un mensaje de tipo "CreateOrder"
            default:
                throw new RuntimeException("Operación no soportada '"  // Se lanza una excepción si se recibe un tipo de mensaje no soportado
                        + message.getMessageType() + "'");
        }
    }

    //Dentro de este método, se realiza una serie de acciones, como crear una instancia de SaleOrder, asignar productos a la orden, enviar mensajes a otros módulos y esperar un tiempo antes de enviar otro mensaje.
    private String createSaleOrder(ModuleMessage event) {
        // Método privado que crea una orden de venta a partir de un mensaje recibido
        Sale sale = (Sale) event.getPayload(); // Se obtiene el objeto Sale del mensaj
        String ID = UUID.randomUUID().toString(); // Se genera un ID único para la orden de venta
        System.out.println("Orden de venta creada exitosamente");
        final SaleOrder saleOrder = new SaleOrder(ID); // Se crea una instancia de SaleOrder con el ID generado
        saleOrder.setProductos(sale.getProductos()); // Se asignan los productos de la venta a la orden de venta

        ModuleMessage stockEvent = new ModuleMessage(MODULE_NAME,
                StockModule.MODULE_NAME, StockModule.OPERATION_DECREMENT_STOCK,
                saleOrder);   // Se crea un nuevo mensaje para decrementar el stock en el módulo de stock
        mediator.mediate(stockEvent);  // Se envía el mensaje al ModuleMediator para que lo envíe al módulo de stock

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000 * 10);  // Se espera 10 segundos
                    ModuleMessage stockEvent = new ModuleMessage(MODULE_NAME,
                            ECommerceModule.MODULE_NAME,
                            ECommerceModule.OPERATION_COMPLETE_ORDER,
                            saleOrder);  // Se crea un nuevo mensaje para completar la orden en el módulo de comercio electrónico
                    mediator.mediate(stockEvent); // Se envía el mensaje al ModuleMediator para que lo envíe al módulo de comercio electrónico
                } catch (InterruptedException ex) {
                    Logger.getLogger(CRMModule.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
        }).start();  // Se inicia un nuevo hilo que espera 10 segundos y luego envía un mensaje al módulo de comercio electrónico

        return ID;  // Se devuelve el ID de la orden de venta
    }
}
