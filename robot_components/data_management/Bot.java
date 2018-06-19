package robot_components.data_management;

import java.util.LinkedList;

public class Bot
{
	LinkedList<BotState> _states;
	BotState cState;
	
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
}
