package demoPrograms;

public class Priority implements Runnable{
//	static int count;
	int count = 0;
	String threadName = "";
	static boolean stop; // shared among both thread
	Thread t;
	Priority(int count){
		this.count = count;
		stop = false;
	}
	
	@Override
	public void run() {
		// iterate for 10 Million times
		Thread curr = Thread.currentThread();
		
		System.out.println("Starting thread "+curr.getName());
		
		do {
				count++;
				System.out.println("count is: "+count);
		}while(stop == false && count < 1000000 );
		stop = true;
		System.out.println("Terminating "+curr.getName()+" count is: "+count);
	}
}
