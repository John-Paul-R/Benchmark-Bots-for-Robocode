package robot_components.gun;

import java.awt.geom.Point2D;

import robocode.AdvancedRobot;
import robot_components.data_management.DataManager;
import robot_components.Manager;

public abstract class Gun implements Manager
{
	protected AdvancedRobot _self;
	protected DataManager _data;
	
	public Gun(AdvancedRobot self, DataManager data)
	{
		_self = self;
		_data = data;
	}
	
	public void aimToCoordinate(Point2D.Double coords)
	{
		_self.setTurnGunRightRadians(robocode.util.Utils.normalRelativeAngle(
				Math.atan2(coords.getX()-_self.getX(), coords.getY()-_self.getY())
				- _self.getGunHeadingRadians()));
	}
	
	public void setFireBullet(double bulletPower)
	{
		if (_self.getGunHeat() == 0)
		{
			_self.setFireBullet(bulletPower);
		}
	}
}
