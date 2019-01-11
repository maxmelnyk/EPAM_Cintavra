package payment;

public class Cash extends Payment {
	private double changeDue;

	Cash(String paymentType, double amount, double changeDue) {
		super(paymentType, amount);
		this.changeDue = changeDue;
	}

	public double getChangeDue() {
		return changeDue;
	}

	public void setChangeDue(double changeDue) {
		this.changeDue = changeDue;
	}

	@Override
	public String toString() {
		return "Cash [changeDue=" + changeDue + "]";
	}
}