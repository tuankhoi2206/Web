package myException;

public class TestMain {
	public static void main(String[] args) {
		Account account = new Account("Tuan Khoi", 20000d);
		try {
			account.isGetMoney(30000d);
		} catch (OutOfMoneyInAccount e) {
			e.printStackTrace();
			System.out.println(e.toString());
		} 

		
	}
}
