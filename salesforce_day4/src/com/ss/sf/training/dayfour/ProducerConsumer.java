/**
 * 
 */
package com.ss.sf.training.dayfour;

import java.util.Arrays;

/**
 * @author leejh
 *
 */
public class ProducerConsumer {

	/**
	 * @param args
	 */
	public static void main(String[] args) { 
		
		int[] arr = new int [] {1,1,0,0};
		int count = 0;
		
		Runnable consumerThread = new Runnable() {
			@Override
			public void run() {
				try {
					
					synchronized (arr) {
						if(arr[0] == 0) {
							Thread.sleep(100);
						}
						for(int i = arr.length-1;i >= 0 ; i--) {
							if (arr[i] == 1) {
								arr[i] = 0;
								System.out.println(Arrays.toString(arr));
								break;
							}
						}

					}
				} catch(Exception e) {
					e.printStackTrace();
				}				
			}			
		};
		Runnable producerThread = new Runnable() {
			@Override
			public void run() {
				try {
					
					synchronized (arr) {
						if(arr[arr.length-1] == 1) {
							Thread.sleep(100);
						}
						
						for(int i = 0;i < arr.length ; i++) {
							if (arr[i] == 0) {
								arr[i] = 1;
								System.out.println(Arrays.toString(arr));
								break;
							}
						}

					}
				} catch(Exception e) {
					e.printStackTrace();
				}				
			}						
		};
		while (count<100) {
			new Thread(producerThread).start();
			new Thread(consumerThread).start();
			count++;
		}

	}

}
