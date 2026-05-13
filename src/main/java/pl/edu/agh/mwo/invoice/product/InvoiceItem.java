package pl.edu.agh.mwo.invoice.product;

public class InvoiceItem {

    private final Product product;
    private int quantity;

    public InvoiceItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addMoreProduct(int number) {
        quantity = quantity + number;
    }

}


