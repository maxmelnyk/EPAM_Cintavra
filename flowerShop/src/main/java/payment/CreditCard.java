package payment;

public class CreditCard extends Payment {
    private String creditCardNumber;
    private String expirationDate;
    private String cvv;

    public CreditCard(String paymentType, double amount, String creditCardNumber, String expirationDate, String cvv) {
        super(paymentType, amount);
        this.creditCardNumber = creditCardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getExperationDate() {
        return expirationDate;
    }

    public void setExperationDate(String experationDate) {
        this.expirationDate = experationDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return "CreditCard [creditCardNumber=" + creditCardNumber + ", expirationDate=" + expirationDate + ", cvv=" + cvv + "]";
    }

}
