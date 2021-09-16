package threadCommunication;

public class ThreadCommunication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Ryan t1 = new Ryan(); Monica t2 = new Monica();
		 * 
		 * t1.setName("Ryan"); t2.setName("Monica");
		 * 
		 * t1.start(); t2.start();
		 */
		
		BankAccount account = new BankAccount();
		
		// Ryan Thread
		new Thread() {
			public void run() {
				account.makeWithdrawl(15000);
			}
		}.start();
		
		// Monica Thread
		new Thread() {
			public void run() {
				account.deposit(10000);
			}
		}.start();
		
		/*
		 * new Thread() { public void run() { account.deposit(10000); } }.start();
		 */
	}

}
