package enums;

public enum WrapperType {
    POLYETHYLENE(8.50), PAPER(10.50), LEAVES(15);
    private double price;

    WrapperType(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}