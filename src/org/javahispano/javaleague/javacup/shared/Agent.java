package org.javahispano.javaleague.javacup.shared;

public interface Agent {

	public MatchShared execute(Object l, Object v, long maxTimeIter)
			throws Exception;

	public boolean isTactic(Class<?> t) throws Exception;

	public String testTactic(Object l, Object v);
}