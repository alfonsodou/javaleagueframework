/**
 * 
 */
package org.javahispano.javaleague.tactic.ID_4630111848497152;

import org.javahispano.javacup.model.util.Position;

/**
 * @author adou
 *
 */
class Pases {
	Position pos;
	double score;
	double angle;
	double power;
	int iteraciones;
	int id_player_source;
	int id_player_target;

	public Pases(Position p, double s) {
		pos = p;
		score = s;
		angle = 0;
		power = 0;
		iteraciones = 0;
	}

	public Pases(Position p, double s, double a, double po, int it, int source,
			int target) {
		pos = p;
		score = s;
		angle = a;
		power = po;
		iteraciones = it;
		id_player_source = source;
		id_player_target = target;
	}

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public void addScore(double score) {
		this.score += score;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}

	public int getIteraciones() {
		return iteraciones;
	}

	public void setIteraciones(int iteraciones) {
		this.iteraciones = iteraciones;
	}

	public int getId_player_source() {
		return id_player_source;
	}

	public void setId_player_source(int id_player_source) {
		this.id_player_source = id_player_source;
	}

	public int getId_player_target() {
		return id_player_target;
	}

	public void setId_player_target(int id_player_target) {
		this.id_player_target = id_player_target;
	}

}
