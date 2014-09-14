/**
 * 
 */
package org.javahispano.javaleague.javacup.shared;

/**
 * @author adou
 *
 */
public class BenchMark {
	private long benchMark;
	private long maxTimeIter;
	
	public BenchMark() {
	    long t1 = System.nanoTime();

	    int result = 0;
	    for (int i = 0; i < 1000 * 1000; i++) {    // sole loop
	        result += sum();
	    }

	    long t2 = System.nanoTime();
	    
	    benchMark = (t2 - t1);
	    
	    maxTimeIter = Long.MAX_VALUE;
	}
	
	private static int sum() {
	    int sum = 0;
	    for (int j = 0; j < 10 * 1000; j++) {
	        sum += j;
	    }
	    return sum;
	}

	/**
	 * @return the benchMark
	 */
	public long getBenchMark() {
		return benchMark;
	}

	/**
	 * @return the maxTimeIter
	 */
	public long getMaxTimeIter() {
		return maxTimeIter;
	}
	
	

}
