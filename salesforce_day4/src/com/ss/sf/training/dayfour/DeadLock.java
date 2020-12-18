/**
 * 
 */
package com.ss.sf.training.dayfour;

/**
 * @author leejh
 *
 */
public class DeadLock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Line l1 = new Line(1,2,4,5);
		Line l2 = new Line(2,4,7,6);
		
		Runnable thread1 = new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("Thread 1 getting Line 1");
					synchronized (l1) {
						System.out.println("Thread 1 getting Line 2");
						Thread.sleep(100);
						synchronized (l2) {
							System.out.print("Line 1 is parallel to Line 2 :" + l1.parallelTo(l2));
							
						}
					}
				} catch(Exception e) {
					
				}				
			}			
		};
		Runnable thread2 = new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("Thread 2 getting Line 2");
					synchronized (l2) {
						System.out.println("Thread 2 getting Line 1");
						Thread.sleep(100);
						synchronized (l1) {
							System.out.print("Line 2 is parallel to Line 1 :" + l2.parallelTo(l1));
						}
					}
				} catch(Exception e) {
					
				}
				
			}
		};
		new Thread(thread1).start();
		new Thread(thread2).start();
		
		System.err.println("---End Program----");
	}

}
