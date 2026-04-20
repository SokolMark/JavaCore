package Product;

import java.util.Objects;

public class Product {
    private String title;
    private int price;
    private ProductType type;

    public Product(String title, ProductType type, int price) {
        this.title = title;
        this.type = type;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && Objects.equals(title, product.title) && Objects.equals(type, product.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price, type);
    }

    @Override
    public String toString() {
        return "Product{" +
               "title='" + title + '\'' +
               ", price=" + price +
               ", type='" + type + '\'' +
               '}';
    }
}
