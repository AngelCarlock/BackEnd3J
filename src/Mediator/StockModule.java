package Mediator;

public class StockModule extends AbstractModule {

    // Nombre del módulo de stock
    public static final String MODULE_NAME = "Stock";

    // Operación de decremento de stock
    public static final String OPERATION_DECREMENT_STOCK = "DecrementStock";

    @Override
    public String getModulName() {
        return MODULE_NAME;
    }


    @Override
    public Object notifyMessage(ModuleMessage message) {
        // Verificar el tipo de mensaje recibido
        switch (message.getMessageType()) {
            case OPERATION_DECREMENT_STOCK:
                return decrementStock(message);
            default:
                throw new RuntimeException("Operación no soportada '"
                        + message.getMessageType() + "'");
        }
    }

    private Void decrementStock(ModuleMessage message) {
        // Obtener la orden de venta desde el payload del mensaje
        SaleOrder saleOrder = (SaleOrder) message.getPayload();
        // Recorrer los productos de la orden de venta
        for (Product product : saleOrder.getProductos()) {
            System.out.println("decrement product > " + product.getName());
        }

        // Crear una solicitud de productos
        ProductRequest productRequest = new ProductRequest();
        productRequest.setProducts(saleOrder.getProductos());

        // Crear un mensaje para el módulo de compra
        ModuleMessage purchaseMessage = new ModuleMessage(MODULE_NAME,
                PurchaseModule.MODULE_NAME,
                PurchaseModule.OPERATION_PURCHASE_REQUEST, productRequest);
        // Mediar el mensaje de compra
        mediator.mediate(purchaseMessage);
        return null;
    }
}
