package myException;

public class OutOfMoneyInAccount extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private double getMoney;

	public double getGetMoney() {
		return getMoney;
	}

	public void setGetMoney(double getMoney) {
		this.getMoney = getMoney;
	}

	public OutOfMoneyInAccount(double getMoney) {
		this.getMoney = getMoney;
	}

	public OutOfMoneyInAccount() {
		super();
	}

	@Override
	public String toString() {

		return String.format(
				"Số tiền cần rút %s lớn hơn số tiền hiện có trong tài khoản",
				getMoney);
	}

}
