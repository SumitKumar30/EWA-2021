package demoPrograms;

// User defined thread of type ThreadProgram  
public class ThreadProgram extends Thread {
	// overriding run() from Thread class
	// Running State: thread will start its execution
	public void run() {
		
		for(int i = 0; i < 5; i++) {
			System.out.println("This is "+Thread.currentThread().getName()+" executing "+i);	
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+" terminating...");
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
//		Thread mainThread = Thread.currentThread();
		
		// Creating a user defined thread object
		
		// New State : Create a thread object
		ThreadProgram t1 = new ThreadProgram();
		ThreadProgram t2= new ThreadProgram();
		ThreadProgram t3= new ThreadProgram();
		ThreadProgram t4= new ThreadProgram();
		
		t1.setName("John");
		t2.setName("Harry");
		t3.setName("Harold");
		// Runnable State: start the newly created thread object
		t1.start();
		t2.start();
		t3.start();
		
		
		// execution in main thread object
		for(int i = 0; i < 5; i++) {
			System.out.println("This is "+Thread.currentThread().getName()+" executing "+i);
			// pausing main thread for 2 s
			Thread.sleep(2000);
		}
		System.out.println("Main thread terminating.... ");
	}

}
