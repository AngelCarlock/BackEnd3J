package Mediator;
import java.util.ArrayList;
import java.util.List;

public class Sale {

    // Lista de productos de la venta
    protected List<Product> productos = new ArrayList<>();

    // Método para obtener la lista de productos
    public List<Product> getProductos() {
        return productos;
    }

    // Método para agregar un producto a la lista
    public void addProduct(Product product) {
        this.productos.add(product);
    }

    // Método para establecer la lista de productos
    public void setProductos(List<Product> productos) {
        this.productos = productos;
    }

}