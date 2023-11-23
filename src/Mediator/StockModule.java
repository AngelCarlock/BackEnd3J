package Mediator;

public class StockModule extends AbstractModule {

    public static final String MODULE_NAME = "Stock";
    public static final String OPERATION_DECREMENT_STOCK = "DecrementStock";

    @Override
    public String getModulName() {
        return MODULE_NAME;
    }

    @Override
    public Object notifyMessage(ModuleMessage message) {
        switch (message.getMessageType()) {
            case OPERATION_DECREMENT_STOCK:
                return decrementStock(message);
            default:
                throw new RuntimeException("Operación no soportada '"
                        + message.getMessageType() + "'");
        }
    }

    private Void decrementStock(ModuleMessage message) {
        SaleOrder saleOrder = (SaleOrder) message.getPayload();
        for (Product product : saleOrder.getProductos()) {
            System.out.println("decrement product > " + product.getName());
        }

        ProductRequest productRequest = new ProductRequest();
        productRequest.setProducts(saleOrder.getProductos());

        ModuleMessage purchaseMessage = new ModuleMessage(MODULE_NAME,
                PurchaseModule.MODULE_NAME,
                PurchaseModule.OPERATION_PURCHASE_REQUEST, productRequest);
        mediator.mediate(purchaseMessage);
        return null;
    }
}