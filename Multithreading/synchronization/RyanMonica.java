package synchronization;

public class RyanMonica implements Runnable{
	BankAccount account;
	
	RyanMonica(){
		account = new BankAccount();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 3; i++) {
			try {
				makeWithdrawl(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	void makeWithdrawl(int amount) throws InterruptedException {
		// Step 1: Check the balance 
		if(account.getBalance() >= amount) {
			System.out.println(Thread.currentThread().getName()+" is going to withdraw "+amount+" rupees");
			
			System.out.println(Thread.currentThread().getName()+" is goin to sleep....");
			
			// Step 2: Ryan/Monica goes to sleep
			Thread.sleep(2000);
			
			System.out.println(Thread.currentThread().getName()+" is going to withdraw");
			// Step 3: Withdraw money
			if(account.getBalance() >= amount) {
				account.withdraw(amount);
				System.out.println("Account balance is: "+account.getBalance());
				System.out.println(Thread.currentThread().getName()+" has withdrawn: "+amount+" rupees");
			}else {
				System.out.println("Insufficient Balance for "+Thread.currentThread().getName());
			}
			
			
			
		}else {
			System.out.println("Insufficient Balance for "+Thread.currentThread().getName());
		}
		
		
	}
	
}
