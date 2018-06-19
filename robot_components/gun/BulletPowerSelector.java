package robot_components.gun;

import robot_components.data_management.*;

public abstract class BulletPowerSelector
{
	protected DataManager _data;
	
	public BulletPowerSelector(DataManager data)
	{
		_data = data;
	}
	
	public abstract double getPower(Enemy _target);
	public abstract double getPower(BotState target);
}
