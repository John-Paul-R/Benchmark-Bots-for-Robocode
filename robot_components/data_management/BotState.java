package robot_components.data_management;

public class BotState 
{
	private double _x;
	private double _y;
	private double _energy;
	private double _heading;
	private double _velocity;
	long _time;
	
	public BotState(double x, double y, double energy, double headingRadians, double velocity, long time) 
	{
		_x = x;
		_y = y;
		_energy = energy;
		_heading = headingRadians;
		_velocity = velocity;
		_time = time;
	}
	
	public double getX() {
		return _x;
	}

	public double getY() {
		return _y;
	}

	public double getEnergy() {
		return _energy;
	}

	public double getHeading() {
		return _heading;
	}

	public double getVelocity() {
		return _velocity;
	}

	public long getTime() {
		return _time;
	}
}
