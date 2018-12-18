package common.testproject;

public class Test {
	public static void main(String args[]){  
		System.out.println("Test Class ");  
/*		long start = System.currentTimeMillis();
		calc();
		long end = System.currentTimeMillis();
		long elapse = end-start;
		long elapsedTime = (elapse % 3600)/60;
		System.out.println("Time in sec :"+elapse);
		System.out.println("Total time taken : "+elapsedTime+" min");*/
		Test t = new Test();
		t.stopDecapThread.run();
	} 
	
	public static void calc(){
		long count=0; 
		for(int i =0;i<10000009;i++){
			count +=i;
		}
		System.out.println("count : "+count);
	}
	
	private Runnable stopDecapThread = () -> {
		try {
			System.out.println("Stopiing service sleeping.....");
			Thread.sleep(5000);
			System.out.println("Stopiing service.....");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	};
	
	
}
