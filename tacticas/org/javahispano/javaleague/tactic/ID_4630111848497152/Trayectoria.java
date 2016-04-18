/**
 * 
 */
package org.javahispano.javaleague.tactic.ID_4630111848497152;

import org.javahispano.javacup.model.trajectory.AbstractTrajectory;
import org.javahispano.javacup.model.trajectory.AirTrajectory;
import org.javahispano.javacup.model.util.Constants;
import org.javahispano.javacup.model.util.Position;

/**
 * @author adou
 *
 */
public class Trayectoria {
	public MiPosicion[] posiciones;
	public int longitud;

	public Trayectoria(Position balon, double velocidad, double angulo,
			double anguloVert) {
		longitud = 100;
		posiciones = new MiPosicion[longitud];
		AbstractTrajectory t = new AirTrajectory(velocidad
				* Math.cos(anguloVert), velocidad * Math.sin(anguloVert), 0, 0);
		for (int i = 0; i < longitud; i++) {
			double radio = t.getX((double) (i + 1) / 60d)
					* Constants.AMPLIFICA_VEL_TRAYECTORIA;
			Position p = new Position(balon.getX() + radio * Math.cos(angulo),
					balon.getY() + radio * Math.sin(angulo));
			posiciones[i].setX(p.getX());
			posiciones[i].setY(p.getY());
			posiciones[i].setZ(t.getY((double) (i + 1) / 60d)
					* Constants.AMPLIFICA_VEL_TRAYECTORIA * 2);
		}
	}
}
