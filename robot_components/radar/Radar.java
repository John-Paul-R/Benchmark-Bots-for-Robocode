package robot_components.radar;

import robocode.AdvancedRobot;
import robot_components.Manager;
import robot_components.data_management.DataManager;

public abstract class Radar implements Manager
{
	protected AdvancedRobot _self;
	protected DataManager _data;
	
	public Radar(AdvancedRobot self, DataManager data)
	{
		_self = self;
		_data = data;
	}
}
