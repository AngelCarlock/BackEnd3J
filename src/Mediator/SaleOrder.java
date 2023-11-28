package Mediator;

public class SaleOrder extends Sale {

    // Identificador de la orden de venta
    private String id;

    // Constructor de la clase SaleOrder que recibe un id
    public SaleOrder(String id) {
        this.id = id;
    }

    // Método para obtener el id de la orden de venta
    public String getId() {
        return id;
    }

    // Método para establecer el id de la orden de venta
    public void setId(String id) {
        this.id = id;
    }
}

