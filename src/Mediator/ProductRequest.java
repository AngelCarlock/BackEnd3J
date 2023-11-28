package Mediator;

import java.util.ArrayList;
import java.util.List;

public class ProductRequest {
    public List<Product> products = new ArrayList<>();

    // Método para obtener la lista de productos
    public List<Product> getProducts() {
        return products;
    }
    // Método para establecer la lista de productos
    public void setProducts(List<Product> products) {
        this.products = products;
    }
}