package threadCommunication;

public class Monica extends Thread{
	BankAccount account;
	Monica(){
		account = new BankAccount();
	}
	public void run() {
		account.deposit(10000);
	}
}
