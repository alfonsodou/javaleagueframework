package org.javahispano.javaleague.tactic.ID_4630111848497152;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.javahispano.javacup.model.Tactic;
import org.javahispano.javacup.model.TacticDetail;
import org.javahispano.javacup.model.command.Command;
import org.javahispano.javacup.model.command.CommandHitBall;
import org.javahispano.javacup.model.command.CommandMoveTo;
import org.javahispano.javacup.model.engine.GameSituations;
import org.javahispano.javacup.model.util.Constants;
import org.javahispano.javacup.model.util.Position;

public class Pringaos implements Tactic {
	Position alineacion1[] = new Position[] {
			new Position(0.2595419847328244, -50.41044776119403),
			new Position(-19.46564885496183, -31.6044776119403),
			new Position(0.2595419847328244, -31.082089552238806),
			new Position(19.984732824427482, -31.6044776119403),
			new Position(7.526717557251908, -11.753731343283583),
			new Position(-8.564885496183205, -11.753731343283583),
			new Position(-24.65648854961832, -2.3507462686567164),
			new Position(23.099236641221374, -2.873134328358209),
			new Position(-14.274809160305344, 30.559701492537314),
			new Position(-0.7786259541984732, 8.097014925373134),
			new Position(12.717557251908397, 29.51492537313433) };

	Position alineacion2[] = new Position[] {
			new Position(0.2595419847328244, -50.41044776119403),
			new Position(-11.16030534351145, -31.082089552238806),
			new Position(11.16030534351145, -31.6044776119403),
			new Position(27.251908396946565, -27.94776119402985),
			new Position(-29.84732824427481, -26.902985074626866),
			new Position(8.564885496183205, -7.574626865671642),
			new Position(-10.641221374045802, -7.052238805970149),
			new Position(27.251908396946565, 4.440298507462686),
			new Position(-29.32824427480916, 3.3955223880597014),
			new Position(-0.2595419847328244, 19.067164179104477),
			new Position(-0.2595419847328244, 35.78358208955224) };

	Position alineacion3[] = new Position[] {
			new Position(0.2595419847328244, -50.41044776119403),
			new Position(-11.16030534351145, -31.082089552238806),
			new Position(11.16030534351145, -31.6044776119403),
			new Position(26.732824427480914, -20.111940298507463),
			new Position(-29.32824427480916, -21.67910447761194),
			new Position(0.2595419847328244, -0.26119402985074625),
			new Position(-18.946564885496183, -0.26119402985074625),
			new Position(18.946564885496183, -0.26119402985074625),
			new Position(-19.46564885496183, 35.78358208955224),
			new Position(-0.2595419847328244, 19.067164179104477),
			new Position(18.946564885496183, 35.26119402985075) };

	Position alineacion4[] = new Position[] {
			new Position(0.2595419847328244, -50.41044776119403),
			new Position(-11.16030534351145, -31.082089552238806),
			new Position(11.16030534351145, -31.6044776119403),
			new Position(25.202797202797203, -21.61764705882353),
			new Position(-26.391608391608393, -21.855203619909503),
			new Position(15.692307692307693, -0.47511312217194573),
			new Position(-14.74125874125874, 0.0),
			new Position(-1.4265734265734267, 16.866515837104075),
			new Position(-13.79020979020979, 32.07013574660634),
			new Position(-0.4755244755244755, 37.05882352941177),
			new Position(15.692307692307693, 31.83257918552036) };

	Position alineacion5[] = new Position[] {
			new Position(0.2595419847328244, -50.41044776119403),
			new Position(-11.16030534351145, -35.78358208955224),
			new Position(12.717557251908397, -35.26119402985075),
			new Position(28.290076335877863, -28.470149253731343),
			new Position(-28.290076335877863, -28.470149253731343),
			new Position(14.793893129770993, -18.544776119402986),
			new Position(-17.389312977099234, -19.58955223880597),
			new Position(-23.618320610687025, -0.7835820895522387),
			new Position(5.969465648854961, -5.485074626865671),
			new Position(0.2595419847328244, -0.26119402985074625),
			new Position(22.580152671755727, -1.3059701492537314) };

	Position alineacion6[] = new Position[] {
			new Position(0.2595419847328244, -50.41044776119403),
			new Position(-11.16030534351145, -35.78358208955224),
			new Position(12.717557251908397, -35.26119402985075),
			new Position(28.290076335877863, -28.470149253731343),
			new Position(-28.290076335877863, -28.470149253731343),
			new Position(14.793893129770993, -18.544776119402986),
			new Position(-17.389312977099234, -19.58955223880597),
			new Position(-23.618320610687025, -0.7835820895522387),
			new Position(6.4885496183206115, -6.529850746268657),
			new Position(-6.4885496183206115, -6.529850746268657),
			new Position(22.580152671755727, -1.3059701492537314) };

	public LinkedList<Command> comandos = new LinkedList<Command>();

	public Pringaos() {

	}

	public TacticDetail detalle = new PringaosDetalle();

	@Override
	public TacticDetail getDetail() {
		return detalle;
	}

	MiPosicion balonAnterior = new MiPosicion(new Position());
	MiPosicion balonActual = new MiPosicion(new Position());

	@Override
	public List<Command> execute(GameSituations sp) {
		// Limpia la lista de comandos
		comandos.clear();
		// Obtiene las posiciones de tus jugadores
		Position[] jugadores = sp.myPlayers();
		Position[] rivales = sp.rivalPlayers();

		balonAnterior = balonActual;
		balonActual.setX(sp.ballPosition().getX());
		balonActual.setY(sp.ballPosition().getY());
		balonActual.setZ(sp.ballAltitude());

		// Instancia un generador aleatorio
		Random r = new Random();

		Position nueva = new Position();
		double angulo;

		for (int i = 0; i < jugadores.length; i++) {
			if (sp.iteration() == 0) {
				comandos.add(new CommandMoveTo(i, alineacion4[i]));
			} else {
				int nearest = jugadores[i].nearestIndex(sp.rivalPlayers());
				int count;
				double distance = jugadores[i]
						.distance(sp.rivalPlayers()[nearest]);
				if (distance < Constants.JUGADORES_SEPARACION) {
					nueva = jugadores[i];
					count = 0;
					while ((distance < Constants.JUGADORES_SEPARACION)
							&& (count < 20)) {
						angulo = r.nextInt(360) * Math.PI / 180;
						nueva = jugadores[i].moveAngle(angulo,
								Constants.getVelocidad(sp.getMyPlayerSpeed(i)));
						if (nueva.isInsideGameField(0)) {
							distance = nueva
									.distance(sp.rivalPlayers()[nearest]);
						} else {
							distance = 0;
						}
						count++;
					}
					comandos.add(new CommandMoveTo(i, nueva));
				} else {
					comandos.add(new CommandMoveTo(i, alineacion4[i]));
				}
			}
		}

		// Si no saca el rival
		if (!sp.isRivalStarts()) {
			// Obtiene los datos de recuperacion del balon
			int[] recuperadores = sp.getRecoveryBall();
			// Si existe posibilidad de recuperar el balon
			if (recuperadores.length > 1) {
				// Obtiene las coordenadas del balon en el instante donde
				// se puede recuperar el balon
				double[] posRecuperacion = sp.getTrajectory(recuperadores[0]);
				// Recorre la lista de jugadores que pueden recuperar
				for (int i = 1; i < recuperadores.length; i++) {
					// Ordena a los jugadores recuperadores que se ubique
					// en la posicion de recuperacion
					comandos.add(new CommandMoveTo(
							recuperadores[i],
							new Position(posRecuperacion[0], posRecuperacion[1])));
				}
			}
		}

		// Recorre la lista de mis jugadores que pueden rematar
		for (int i : sp.canKick()) {
			// Si el jugador es de indice 8 o 10
			if (i == 8 || i == 10) {
				// condicion aleatoria
				if (r.nextBoolean()) {
					// Ordena que debe rematar al centro del arco
					comandos.add(new CommandHitBall(i, Constants.centroArcoSup,
							1, 12 + r.nextInt(6)));
				} else if (r.nextBoolean()) {
					// Ordena que debe rematar al poste derecho
					comandos.add(new CommandHitBall(i,
							Constants.posteDerArcoSup, 1, 12 + r.nextInt(6)));
				} else {
					// Ordena que debe rematar al poste izquierdo
					comandos.add(new CommandHitBall(i,
							Constants.posteIzqArcoSup, 1, 12 + r.nextInt(6)));
				}
			} else {
				double max_score = 0;
				int max_index = -1;

				LinkedList<Pases> pases = isPassSafeFromOpponent(sp, i);
				max_score = -1;
				max_index = -1;
				for (int c = 0; c < pases.size(); c++) {
					if (pases.get(c).getPos().getY() > sp.myPlayers()[i].getY()) {
						pases.get(c).addScore(1);
					}

					if (pases.get(c).getPos().getY() > 0) {
						pases.get(c).addScore(1);
					}

					pases.get(c).addScore(
							(double) (1.0 / pases.get(c).getIteraciones()));

					if (pases.get(c).getScore() > max_score) {
						max_score = pases.get(c).getScore();
						max_index = c;
					}
				}

				comandos.add(new CommandHitBall(i, jugadores[pases.get(
						max_index).getId_player_target()], pases.get(max_index)
						.getPower(), pases.get(max_index).getAngle()));
			}
		}

		// Retorna la lista de comandos
		return comandos;
	}

	public int[] getRecoveryBall(Trayectoria tra, GameSituations sp) {
		int it = 0;
		boolean found = false;
		Position pJug;
		double dist0, dist;
		int idxFound = -1;
		double[] posBalon;
		int i = 0;
		int[] ret;

		ret = new int[2];
		ret[0] = -1;
		ret[1] = -1;
		while ((!found) && (it < 100)) {
			posBalon = tra.getPos(it);
			if (!(new Position(posBalon[0], posBalon[1])).isInsideGameField(2)) {
				return null;
			}

			if (posBalon[2] <= Constants.ALTO_ARCO) {
				for (i = 0; i < sp.myPlayers().length; i++) {
					if (posBalon[2] <= (sp.myPlayersDetail()[i].isGoalKeeper() ? Constants.ALTO_ARCO
							: Constants.ALTURA_CONTROL_BALON)) {
						pJug = sp.myPlayers()[i];
						dist0 = (double) it
								* Constants
										.getVelocidad(sp.getMyPlayerSpeed(i));
						dist = pJug.distance(new Position(posBalon[0],
								posBalon[1]));
						if ((dist0 >= dist) && (!sp.getOffSidePlayers()[i])) {
							found = true;
							idxFound = it;
							ret[0] = it;
							ret[1] = i;
						}
					}
				}
			}
			it++;
		}

		return ret;
	}

	public int getRecoveryBallRival(Trayectoria tra, GameSituations sp) {
		int it = 0;
		boolean found = false;
		Position pJug;
		double dist0, dist;
		int idxFound = -1;
		double[] posBalon;
		int i = 0;

		while ((!found) && (it < 100)) {
			posBalon = tra.getPos(it);
			if (!(new Position(posBalon[0], posBalon[1])).isInsideGameField(2)) {
				return -1;
			}

			if (posBalon[2] <= Constants.ALTO_ARCO) {
				for (i = 0; i < sp.rivalPlayers().length; i++) {
					if (posBalon[2] <= (sp.rivalPlayersDetail()[i]
							.isGoalKeeper() ? Constants.ALTO_ARCO
							: Constants.ALTURA_CONTROL_BALON)) {
						pJug = sp.rivalPlayers()[i];
						dist0 = (double) it
								* Constants.getVelocidad(sp
										.getRivalPlayerSpeed(i));
						dist = pJug.distance(new Position(posBalon[0],
								posBalon[1]));
						if (dist0 >= dist) {
							found = true;
							idxFound = it;
						}
					}
				}
			}
			it++;
		}

		return idxFound;
	}

	public LinkedList<Pases> isPassSafeFromOpponent(GameSituations sp,
			int player) {
		double angulo;
		double fuerza;
		double fuerzaTotal;
		double anguloH;
		double angulorad;
		Position p1 = sp.myPlayers()[player];
		LinkedList<Pases> pases;
		Trayectoria tra;

		pases = new LinkedList<Pases>();
		for (angulo = 0; angulo <= Constants.ANGULO_VERTICAL_MAX; angulo += 10) {
			angulorad = (angulo * Math.PI) / 180;
			for (fuerza = 0.2f; fuerza <= 1; fuerza += 0.2f) {
				fuerzaTotal = sp.getMyPlayerPower(player) * fuerza;
				for (anguloH = 0.0f; anguloH < 360; anguloH += 10) {
					tra = new Trayectoria(p1,
							Constants.getVelocidadRemate(fuerzaTotal),
							(anguloH * Math.PI) / 180, angulorad);
					double distance2 = p1.distance(new Position(
							tra.getPos(99)[0], tra.getPos(99)[1]));

					int iteracionesrival = getRecoveryBallRival(tra, sp);
					int[] iteraciones = getRecoveryBall(tra, sp);

					if ((iteraciones != null) && (iteraciones[0] != -1)
							&& (iteraciones[0] <= 99)) {

						if ((iteraciones[0] < iteracionesrival)
								|| ((iteracionesrival == -1) && (iteraciones[0] != -1))) {

							pases.add(new Pases(new Position(tra
									.getPos(iteraciones[0])[0], tra
									.getPos(iteraciones[0])[1]), 0, angulo,
									fuerza, iteraciones[0], player,
									iteraciones[1]));
						}
					}
				}
			}
		}

		return pases;
	}

	@Override
	public Position[] getStartPositions(GameSituations sp) {
		return alineacion5;
	}

	@Override
	public Position[] getNoStartPositions(GameSituations sp) {
		return alineacion6;
	}

}
