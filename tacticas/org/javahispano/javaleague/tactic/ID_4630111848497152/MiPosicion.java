/**
 * 
 */
package org.javahispano.javaleague.tactic.ID_4630111848497152;

import org.javahispano.javacup.model.util.Position;

/**
 * @author adou
 *
 */
public class MiPosicion {

	double x, y, z;

	public MiPosicion() {
		x = y = z = 0;
	}

	public MiPosicion(MiPosicion p) {
		x = p.x;
		y = p.y;
		z = p.z;
	}

	public MiPosicion(Position p) {
		x = p.getX();
		y = p.getY();
		z = 0;
	}

	public MiPosicion(double x, double y) {
		this.x = x;
		this.y = y;
		this.z = 0;
	}

	public MiPosicion(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	public double distanciaSQ(double px, double py) {
		return (x - px) * (x - px) + (y - py) * (y - py);
	}

	public double distancia() {
		return this.distancia(new MiPosicion());
	}

	public double distancia(double px, double py) {
		return Math.sqrt((x - px) * (x - px) + (y - py) * (y - py));
	}

	public double distancia(MiPosicion p) {
		return Math.sqrt((x - p.x) * (x - p.x) + (y - p.y) * (y - p.y));
	}

	public double distancia(Position p) {
		return this.distancia(new MiPosicion(p));
	}

	public Position getPosicion() {
		return new Position(x, y);
	}

	public MiPosicion getDiffPosition(double dx, double dy) {
		return new MiPosicion(this.x + dx, this.y + dy);
	}

	private void moveDiff(double dx, double dy) {
		this.x += dx;
		this.y += dy;
	}

	private void moveDiff(double dx, double dy, boolean onGround) {
		if (onGround) {
			this.x += dx;
			this.y += dy;
		} else {
			this.x += dx;
			this.y += dy;
		}
	}
	
	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setZ(double z) {
		this.z = z;
	}

	@Override
	public String toString() {
		return "(" + this.x + ", " + this.y + ", " + this.z + ")";
	}
}
