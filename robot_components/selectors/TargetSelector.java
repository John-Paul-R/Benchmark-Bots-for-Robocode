package robot_components.selectors;

import robot_components.data_management.Bot;
import robot_components.data_management.DataManager;
import robot_components.data_management.Enemy;

public abstract class TargetSelector
{
	protected DataManager _data;
	protected Enemy _target;
	protected String _targetName;

	public TargetSelector(DataManager data)
	{
		_data = data;
	}
	
	public abstract void chooseTarget();
	public abstract String getTargetName();
	public abstract Enemy getTarget();
}
