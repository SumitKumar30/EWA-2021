package synchronization;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RyanMonica sharedAccount = new RyanMonica();
		Thread t1 = new Thread(sharedAccount);
		Thread t2 = new Thread(sharedAccount);
		
		t1.setName("Monica");
		t2.setName("Ryan");
		
		t1.start();
		t2.start();
	}

}
