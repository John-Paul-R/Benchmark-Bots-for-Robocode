package robot_components.radar;

import java.awt.geom.Point2D;

import robocode.AdvancedRobot;
import robot_components.Utils;
import robot_components.data_management.Bot;
import robot_components.data_management.DataManager;

public class Lock extends Radar
{

	public Lock(AdvancedRobot self, DataManager data) {
		super(self, data);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() 
	{
		Bot target = _data.getTarget();
		final double FACTOR = 2;
		if (target != null)
    	{
			double absBearing = (target.getBearing(_data.getSelf().getLocation()));
			_self.setTurnRadarRightRadians( FACTOR * robocode.util.Utils.normalRelativeAngle(absBearing - _self.getRadarHeadingRadians()) );
    	}
		else
		{
			_self.setTurnRadarRightRadians(Double.POSITIVE_INFINITY);
		}
	}

}
