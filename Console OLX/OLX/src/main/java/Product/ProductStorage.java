package Product;

import java.util.*;

public class ProductStorage {
    private final Map<ProductType, Set<Product>> products = new HashMap<>();

    public Map<ProductType, Set<Product>> getProducts() {
        return products;
    }


    public void addProduct(ProductType type, Product product) {
        if (products.containsKey(type)) {
            products.get(type).add(product);
        } else {
            products.put(type, new HashSet<>());
        }
    }

    public void deleteProduct(String name, ProductType type) {
        if (products.containsKey(type)) {
            for (Product product : products.get(type)) {
                products.remove(product);
            }
        }
    }
}
