package threadCommunication;

public class BankAccount {
	int balance = 10000; // initial amount
	
	int getBalance() {
		return this.balance;
	}
	synchronized void makeWithdrawl(int amount) {
		System.out.println("Available Balance: "+this.getBalance());
		System.out.println(Thread.currentThread().getName()+" is going to withdraw "+amount);
		while(this.getBalance() < amount) {
			System.out.println("Insufficient balance.. waiting for deposit!");
			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		{
			this.balance = this.getBalance() - amount;
			System.out.println(amount+" Withdrawn successfully");
			System.out.println("Balance amount: "+this.getBalance());
		}
	}
	
	synchronized void deposit(int amount) {
		System.out.println(Thread.currentThread().getName()+" is going to deposit: "+amount);
		this.balance = this.getBalance() + amount;
		System.out.println(amount+" Deposited successfully");
		System.out.println("Balance amount: "+this.getBalance());
		System.out.println("Transaction completed...");
		notifyAll();
	}
}
