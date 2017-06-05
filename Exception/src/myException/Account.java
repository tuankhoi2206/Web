package myException;

public class Account {
	private String nameAccount;
	private double money;

	public String getNameAccount() {
		return nameAccount;
	}

	public void setNameAccount(String nameAccount) {
		this.nameAccount = nameAccount;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public Account() {
		super();
	}

	public Account(String nameAccount, double money) {
		this.nameAccount = nameAccount;
		this.money = money;
	}

	public boolean isGetMoney(double getMoney) throws OutOfMoneyInAccount {
		if (getMoney > money)
			throw new OutOfMoneyInAccount(getMoney);
		this.money -= getMoney;
		return true;
	}
}
