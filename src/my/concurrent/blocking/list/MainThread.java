package my.concurrent.blocking.list;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class MainThread {

	public static void main(String[] args) throws InterruptedException {
		LinkedBlockingDeque<String> list = new LinkedBlockingDeque<>();
		
		Client client = new Client(list);
		Thread thread =  new Thread(client);
		thread.start();
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<5;j++) {
				String request = list.take();
				System.out.println("Main: Request: "+request+" at "+new Date()+" Size: "+list.size());
			}
			TimeUnit.SECONDS.sleep(2);
		}
		System.out.println("Main: End of the program");
	}

}
