package Mediator;

public class Product {

    private String name;
    // Constructor de la clase <link>Product</link>
    public Product(String name) {
        this.name = name;
    }
    // Método para obtener el nombre del producto
    public String getName() {
        return name;
    }
    // Método para establecer el nombre del producto
    public void setName(String name) {
        this.name = name;
    }
}