package org.javahispano.javaleague.javacup.shared;

public interface Agent {

	public MatchShared execute(Object l, Object v, long maxTimeIter)
			throws Exception;

	public boolean isTactic(Class<?> t) throws Exception;

	public void testTactic(Object l, Object v) throws Exception;
}