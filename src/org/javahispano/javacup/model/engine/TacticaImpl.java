package org.javahispano.javacup.model.engine;


import org.javahispano.javacup.model.command.Command;
import java.util.List;
import org.javahispano.javacup.model.Tactic;
import org.javahispano.javacup.model.util.Position;
import org.javahispano.javacup.model.TacticDetail;

/**Implementacion de una mascara de otra tactica, usada intenamente*/
final class TacticaImpl implements Tactic {

	final Tactic tac;
	final TacticaDetalleImpl detalle;

	public TacticaImpl(Tactic tac) throws Exception {
		this.tac = tac;
		detalle = new TacticaDetalleImpl(tac.getDetail());
	}

	@Override
	public TacticDetail getDetail() {
		return detalle;
	}

	@Override
	public List<Command> execute(GameSituations sp) throws Exception {
		return tac.execute(sp);
	}

	@Override
	public Position[] getStartPositions(GameSituations sp) throws Exception {
		return tac.getStartPositions(sp);
	}

	@Override
	public Position[] getNoStartPositions(GameSituations sp) throws Exception {
		return tac.getNoStartPositions(sp);
	}
}
