package bingo.enhance.multithread.chapter4;

import java.util.ArrayList;
import java.util.List;


public class ThreadPriority {
	private volatile static boolean notStart = true;
	private volatile static boolean notEnd = true;
	
	public static void main(String[] args) throws InterruptedException {
		List<Job> list = new ArrayList<Job>();
		for (int i = 0; i < 10; i++) {
			int priority = i<5?Thread.MIN_PRIORITY:Thread.MAX_PRIORITY;
			Job job = new Job(priority);
			list.add(job);
			Thread t = new Thread(job,"Thread-"+priority);
			t.setPriority(priority);
			t.start();
		}
		notStart = false;
		Thread.sleep(5, 10);
		notEnd = false;
		
		for (Job job : list) {
			System.out.println("info: "+job.priority +"--"+ job.count);
		}
	}
	
	static class Job implements Runnable{
		private int priority ;
		private int count;
		
		public Job(int priority){
			this.priority = priority;
		}
		@Override
		public void run() {
			while(notStart){
				Thread.yield();
			}
			while(notEnd){
				this.count ++;
			}
		}
	}

}
