package threadCommunication;

public class Ryan extends Thread{
	BankAccount account;
	
	Ryan(){
		account = new BankAccount();
	}
	public void run() {
		account.makeWithdrawl(15000);
	}
}
