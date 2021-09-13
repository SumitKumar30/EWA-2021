package demoPrograms;

public class RunnableDemo implements Runnable {

	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+" is executing "+i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+" is terminating....");
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		RunnableDemo task1 = new RunnableDemo();
		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task1);
		Thread t3 = new Thread(task1);
		
//		RunnableDemo task2 = new RunnableDemo();
		
		Thread t4= new Thread(task1);
		
		t1.setName("Worker-1");
		t2.setName("Worker-2");
		t3.setName("Worker-3");
		t4.setName("Worker-4");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		Thread.currentThread().setName("Supervisor");
		
		for(int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName()+" is executing "+i);
			Thread.sleep(3000);
		}
		System.out.println(Thread.currentThread().getName()+" is terminating...");
	}

}
