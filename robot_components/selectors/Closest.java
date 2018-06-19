package robot_components.selectors;

import java.util.Map;

import robot_components.data_management.Bot;
import robot_components.data_management.DataManager;
import robot_components.data_management.Enemy;

public class Closest extends TargetSelector
{
	public Closest(DataManager data) 
	{
		super(data);
	}

	@Override
	public void chooseTarget() 
	{
        String cClosestName = "";
        Enemy cClosestEnemy = null;
        double cClosestDist = Integer.MAX_VALUE;
        for (Map.Entry<String, Enemy> entry : _data.getEnemies().entrySet())
        {
            if (entry.getValue().getDistance() < cClosestDist)
            {
                cClosestName = entry.getKey();
                cClosestEnemy = entry.getValue();
                cClosestDist = cClosestEnemy.getDistance();
            }
        }
        _target = cClosestEnemy;
        _targetName = cClosestName;
	}

	@Override
	public String getTargetName() 
	{
		return _targetName;
	}

	@Override
	public Enemy getTarget()
	{
		return _target;
	}
	
}
