package robot_components.data_management;

import java.awt.geom.Point2D;
import java.util.LinkedList;

import robot_components.Utils;

public class Bot
{
	private LinkedList<BotState> _states;
	private BotState cState;
	
	public Bot()
	{
		_states = new LinkedList<BotState>();
	}
	
	public void addState(BotState state) 
	{
		cState = state;
		_states.add(state);
	}
	
	public BotState getState()
	{
		return cState;
	}
	public BotState getState(int index)
	{
		return _states.get(index);
	}
	
	
	//Getters
	public double getX() {
		return cState.getX();
	}

	public double getY() {
		return cState.getY();
	}

	public double getEnergy() {
		return cState.getEnergy();
	}

	public double getHeading() {
		return cState.getHeading();
	}

	public double getVelocity() {
		return cState.getVelocity();
	}

	public long getTime() {
		return cState.getTime();
	}

	public int cIndex() 
	{
		return _states.size()-1;
	}
	public double getTurn()
	{
		double prevHeading = getState(cIndex()-1).getHeading();
		return  cState.getHeading() - prevHeading;
	}

	public double getBearing(Point2D.Double origin) {
		return Utils.pointToAngle(origin, new Point2D.Double(getX(), getY()));
	}

	public Point2D.Double getLocation() 
	{
		return cState.getLocation();
	}
}
