package threadCommunication;

public class RyanMonica implements Runnable{
	BankAccount bank;
	
	RyanMonica(){
		bank = new BankAccount();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(Thread.currentThread().getName() == "Ryan") {
			bank.makeWithdrawl(15000);
		}else if(Thread.currentThread().getName() == "Monica"){
			bank.deposit(10000);
		}
	}
	
}
