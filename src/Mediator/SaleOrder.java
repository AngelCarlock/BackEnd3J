package Mediator;

public class SaleOrder extends Sale {

    private String id;

    public SaleOrder(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

