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
		
		/*double p = 0;
		for(int i = 0; i < 10000000; i++) {
			p += i * i;
		}*/
		
		// Obtiene las posiciones de tus jugadores
		Position[] jugadores = sp.myPlayers();
		for (int i = 0; i < jugadores.length; i++) {
			// Ordena a cada jugador que se ubique segun la alineacion1
			comandos.add(new CommandMoveTo(i, alineacion1[i]));
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
		// Instancia un generador aleatorio
		Random r = new Random();
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
				// inicia contador en cero
				int count = 0;
				int jugadorDestino;
				// Repetir mientras el jugador destino sea igual al jugador que
				// remata
				while (((jugadorDestino = r.nextInt(11)) == i
				// o mientras la coordenada y del jugador que remata
				// es mayor que la coordenada y del que recibe
						|| jugadores[i].getY() > jugadores[jugadorDestino]
								.getY())
						// Y mientras el contador es menor a 20
						&& count < 20) {
					// incrementa el contador
					count++;
				}
				// Si el receptor del balon es el que remata
				if (i == jugadorDestino) {
					while ((jugadorDestino = r.nextInt(jugadores.length)) == i) {
					}
				}
				// Ordena que el jugador que puede rematar que de un pase
				// al jugador destino
				comandos.add(new CommandHitBall(i, jugadores[jugadorDestino],
						1, r.nextInt(45)));
			}
		}
		// Retorna la lista de comandos
		return comandos;
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
