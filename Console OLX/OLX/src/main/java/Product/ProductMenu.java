package Product;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductMenu {

    private final Scanner sc = new Scanner(System.in);

    private final ProductStorage storage;

    public ProductMenu(ProductStorage storage) {
        this.storage = storage;
    }

    public void createProduct() {
        System.out.println("Create a new product");

        System.out.print("Enter product title: ");
        String title = sc.nextLine();

        System.out.println();

        System.out.print("Enter product type: ");
        String stringType = sc.nextLine();
        stringType = stringType.toUpperCase();

        ProductType type = ProductType.valueOf(stringType);

        System.out.println();

        System.out.print("Enter product price: ");
        int price = sc.nextInt();

        System.out.println();

        Product product = new Product(title, type, price);

        storage.addProduct(type, product);

        System.out.println("Product created" + product);
    }

    public void removeProduct() {

        while (true) {
            try {
                System.out.print("Write a type of product");
                String stringType = sc.nextLine();

                ProductType type = ProductType.valueOf(stringType.toUpperCase());
                if (storage.getProducts().containsKey(type)) {
                    break;
                }

                System.out.print("Write a name of product");
                String name = sc.nextLine();

                if (storage.getProducts().containsKey(type)) {
                    for (Product product : storage.getProducts().get(type)) {
                        if (product.equals(name)) {
                            break;
                        }
                    }
                }
                System.out.println();

                storage.deleteProduct(name, type);

                System.out.println("Product deleted");
                System.out.println(storage.getProducts());
            } catch (InputMismatchException e) {
                throw new InputMismatchException("Wrong input");
            }
        }
    }
}
