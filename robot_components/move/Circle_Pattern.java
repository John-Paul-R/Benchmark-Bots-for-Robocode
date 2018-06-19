package robot_components.move;

import robocode.AdvancedRobot;
import robot_components.data_management.DataManager;

public class Circle_Pattern extends Mover
{
	public Circle_Pattern(AdvancedRobot self, DataManager data) {
		super(self, data);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() 
	{
		_self.setTurnRightRadians(Double.POSITIVE_INFINITY);
		_self.setMaxVelocity(6);
		_self.setMaxTurnRate(5);
		_self.setAhead(Double.POSITIVE_INFINITY);
	}

}
