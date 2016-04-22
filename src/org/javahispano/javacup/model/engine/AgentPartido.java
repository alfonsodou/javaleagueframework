/**
 * 
 */
package org.javahispano.javacup.model.engine;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.javahispano.javacup.model.Tactic;
import org.javahispano.javacup.model.util.Compressor;
import org.javahispano.javacup.model.util.Serializer;
import org.javahispano.javaleague.javacup.shared.Agent;
import org.javahispano.javaleague.javacup.shared.MatchShared;

/**
 * @author adou
 * 
 */
public class AgentPartido implements Agent {

	@Override
	public MatchShared execute(Object l, Object v, long maxTimeIter) throws Exception {
		Partido partido;
		MatchShared matchShared = new MatchShared();

		partido = new Partido((Tactic) l, (Tactic) v, true, maxTimeIter);
		int iter = 0;
		for (int i = 0; partido.getEstado() != 7; i++) {
			partido.iterar();
			iter = partido.getIteracion();
			if (i > 10000) {
				throw new Exception("partido bloqueado");
			}
		}

		matchShared
				.setMatch(Compressor.compress(Serializer.serialize(partido.getPartidoGuardado()), partido.toString()));
		matchShared.setMatchBin(partido.getPartidoGuardado().binaryServe());
		matchShared.setGoalsLocal(partido.getGolesLocal());
		matchShared.setGoalsVisiting(partido.getGolesVisita());
		matchShared.setPosessionLocal(partido.getPosesionBalonLocal());
		matchShared.setTimeLocal(partido.getPartidoGuardado().getLocalTime());
		matchShared.setTimeVisita(partido.getPartidoGuardado().getVisitaTime());

		return matchShared;

	}

	@Override
	public boolean isTactic(Class<?> t) throws Exception {

		return Tactic.class.isAssignableFrom(t);
	}

	@Override
	public void testTactic(Object l, Object v, int num_iteraciones) throws Exception {
		Partido partido;

		partido = new Partido((Tactic) l, (Tactic) v, true);
		int iter = 0;
		for (int i = 0; partido.getEstado() != 7; i++) {
			partido.iterar();
			iter = partido.getIteracion();
			if (i > num_iteraciones) {
				break;
			}
		}
	}

	public String stackTraceToString(Throwable e) {
		String retValue = null;
		StringWriter sw = null;
		PrintWriter pw = null;
		try {
			sw = new StringWriter();
			pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			retValue = sw.toString();
		} finally {
			try {
				if (pw != null)
					pw.close();
				if (sw != null)
					sw.close();
			} catch (IOException ignore) {
			}
		}
		return retValue;
	}

}
