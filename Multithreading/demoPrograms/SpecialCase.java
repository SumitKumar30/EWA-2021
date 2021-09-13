package demoPrograms;

public class SpecialCase extends Thread{

	public void run() {
		System.out.println("This is thread "+Thread.currentThread().getName()+" Running!");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpecialCase t1 = new SpecialCase();
		SpecialCase t2 = new SpecialCase();
		
		t1.start();
		t2.start();
		t2.start();
		System.out.println("This is thread "+Thread.currentThread().getName()+" Running!");
		
		System.out.println("Currently executing threads are: "+Thread.activeCount());
	}

}
