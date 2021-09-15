package demoPrograms;

public class PriorityDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Priority p1 = new Priority(0);
		Priority p2 = new Priority(0);
		
		Thread t1 = new Thread(p1); 
		Thread t2 = new Thread(p2);
		
		t1.setName("John");
		t2.setName("Harry");
		
		t1.setPriority(Thread.MAX_PRIORITY); // John has maximum priority
		t2.setPriority(Thread.MIN_PRIORITY); // Harry has minimum priority
		
		t1.start();
		t2.start();
		
		System.out.println("Main Thread Exiting...");
	}

}
