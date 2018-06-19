package robot_components.move;

import robocode.AdvancedRobot;

import robot_components.data_management.DataManager;
import robot_components.Manager;

public abstract class Mover implements Manager
{
	protected AdvancedRobot _self;
	protected DataManager _data;
	
	public Mover(AdvancedRobot self, DataManager data)
	{
		_self = self;
		_data = data;
	}
}
