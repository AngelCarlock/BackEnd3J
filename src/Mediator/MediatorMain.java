package Mediator;

public class MediatorMain {

    public static void main(String[] args) {
        // Se crean instancias de los diferentes módulos y se activan
        new CRMModule().activate(); // Se crea y activa una instancia del módulo CRM
        new NotifyModule().activate(); // Se crea y activa una instancia del módulo de notificaciones
        new StockModule().activate();  // Se crea y activa una instancia del módulo de inventario
        new PurchaseModule().activate();  // Se crea y activa una instancia del módulo de compras

        // Se crea y activa una instancia del módulo de comercio electrónico
        ECommerceModule client = new ECommerceModule();
        client.activate();

        // Se crea una venta y se agregan productos a ella
        Sale sale = new Sale();
        for(int c=0;c<5;c++){
            sale.addProduct(new Product("Product" + (c+1)));
        }

        // Se utiliza el módulo de comercio electrónico para crear la venta llamando al método createSale()
        client.createSale(sale);
    }

}
