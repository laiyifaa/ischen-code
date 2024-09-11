package algorithm;

class ProductA implements Product {
    @Override
    public void use() {
        System.out.println("Using Product A");
    }
}

class ProductB implements Product {
    @Override
    public void use() {
        System.out.println("Using Product B");
    }
}

public class ProductFactory {

    public static Product createProduct(String type) {
        switch (type) {
            case "A":
                return new ProductA();
            case "B":
                return new ProductB();
            default:
                throw new IllegalArgumentException("Unknown product type: " + type);
        }
    }
    public static void main(String[] args) {
        Product productA = ProductFactory.createProduct("A");
        productA.use();

        Product productB = ProductFactory.createProduct("B");
        productB.use();
    }
}

