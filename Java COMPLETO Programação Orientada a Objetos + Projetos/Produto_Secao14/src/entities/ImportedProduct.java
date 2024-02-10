package entities;

public class ImportedProduct extends Product {
    private Double customsFee;

    public ImportedProduct() {
        super();
    }

    public ImportedProduct(Double customsFee) {
        this.customsFee = customsFee;
    }

    public ImportedProduct(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public Double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(Double customsFee) {
        this.customsFee = customsFee;
    }

    // Returns the total fee
    public Double totalPrice() {
        super.setPrice(super.getPrice() + this.customsFee);
        return super.getPrice();
    }

    @Override
    public final String priceTag() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getName()).append(" $ ")
                .append(String.format("%.2f", this.totalPrice()))
                .append(" (Customs fee: $ ")
                .append(String.format("%.2f", this.customsFee))
                .append(")\n");
        return sb.toString();
    }
}
