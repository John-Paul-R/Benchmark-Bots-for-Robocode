package robot_components.radar;

import robocode.AdvancedRobot;
import robot_components.data_management.DataManager;

public class Spin extends Radar
{

	public Spin(AdvancedRobot self, DataManager data) {
		super(self, data);
	}

	@Override
	public void execute()
	{
		_self.setTurnRadarRight(Double.POSITIVE_INFINITY);
	}
	
}
