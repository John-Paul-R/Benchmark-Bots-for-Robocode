package robot_components.radar;

import java.awt.geom.Point2D;

import robocode.AdvancedRobot;
import robot_components.Utils;
import robot_components.data_management.Bot;
import robot_components.data_management.DataManager;
import robot_components.data_management.Enemy;

public class Lock extends Radar
{

	public Lock(AdvancedRobot self, DataManager data) {
		super(self, data);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() 
	{
		Enemy target = _data.getTargetEnemy();
		final double FACTOR = 2.1;
		if (target != null && target.getTime() == _data.getSelf().getTime())
    	{
			double absBearing = target.getBearing();
			_self.setTurnRadarRightRadians( FACTOR * robocode.util.Utils.normalRelativeAngle(absBearing - _self.getRadarHeadingRadians()) );
    	}
		else
		{
			System.out.println("Radar (Lock): TARGET IS NULL");
			_self.setTurnRadarRightRadians(Double.POSITIVE_INFINITY);
		}
	}

}
