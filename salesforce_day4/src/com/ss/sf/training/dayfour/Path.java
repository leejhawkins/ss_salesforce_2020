/**
 * 
 */
package com.ss.sf.training.dayfour;

/**
 * @author leejh
 *
 */
public class Path {
	
	private volatile String rootDirectory;
	
	private volatile static Path instance = null;
	
	private Path() {
	 rootDirectory = new String();
	}
	
	public static Path getInstance() {
		if (instance == null) {
			synchronized (Path.class) {
				if (instance == null) {
					instance = new Path();
				}
			}
		}
		return instance;
	}
	
	public Path add(String subDirectory) {
		rootDirectory = this.rootDirectory + "/" + subDirectory;
		return this;
		
	}

}
