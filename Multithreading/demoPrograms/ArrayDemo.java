package demoPrograms;

public class ArrayDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// currentThread() --> returns the reference to "main" thread object
				Thread thread = Thread.currentThread();
				
				// changing the default name of "main" thread
				thread.setName("John");
				
				String[] str = new String[6]; // size is static 
				str[0] = "Facebook";
				str[1] = "Amazon";
				str[2] = "Apple";
				str[3] = "Google";
				str[4] = "Tesla";
				str[5] = "Netflix";
				
				System.out.println("List of companies are: ");
				for(int i = 0 ; i< str.length; i++) {
					System.out.println(str[i]);	
					
					// pause the current thread (John) for 2 seconds
					try {
						Thread.sleep(2000); // sleep() methods throws Interrupted exception
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Main thread exiting... "+thread.getName());
	}

}
