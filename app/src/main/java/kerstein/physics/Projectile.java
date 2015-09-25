package kerstein.physics;

public class Projectile {

	private double velocity;
	private double seconds;
	private double radians;

	public Projectile(double angle, double velocity, double seconds) {
		this.velocity = velocity;
		this.seconds = seconds;
		this.radians = Math.toRadians(angle);
	}

	public double getAnswerX() {
		return Math.sin(radians) * velocity * seconds;

	}

	public double getAnswerY() {
		return Math.cos(radians) * velocity * seconds - .5 * 9.8
				* (seconds * seconds);
	}

	public void setSeconds(double seconds) {
		this.seconds = seconds;
	}
}
