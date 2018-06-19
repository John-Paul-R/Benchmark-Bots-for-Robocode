package robot_components.gun;

import java.awt.geom.Point2D;

import robocode.AdvancedRobot;
import robocode.Rules;
import robot_components.Utils;
import robot_components.data_management.Bot;
import robot_components.data_management.DataManager;

public class Linear extends Gun
{
	Bot _target;

	public Linear(AdvancedRobot self, DataManager data, BulletPowerSelector powerSelector) 
	{
		super(self, data, powerSelector);
	}
	
	public void setTarget(Bot enemy)
	{
		_target = enemy;
	}
	@Override
	public Point2D.Double getAimLocation()
	{
		double time = -1;
    	double endX = 0;
    	double endY = 0;
    	final double eX = _target.getX()-_self.getX();//enemy X relative to _self
    	final double eY = _target.getY()-_self.getY();//enemy Y relative to _self
    	
    	final double eVelocityX = _target.getVelocity()*Math.sin(_target.getHeading());
    	final double eVelocityY = _target.getVelocity()*Math.cos(_target.getHeading());
    	final double bulletVelocity = Rules.getBulletSpeed(_powerSelector.getPower(_target));
    	
    	final double c = eX*eX + eY*eY;
    	final double a2 = bulletVelocity*bulletVelocity;
    	final double a = eVelocityX*eVelocityX + eVelocityY*eVelocityY - a2;
    	final double b = 2*(eX*eVelocityX + eY*eVelocityY);

    	final double discrim = b*b - 4*a*c;
    	if (discrim >= 0) //check to make sure solution exists. If solution exists, proceed with calculations.
    	{
    		final double t1 = (-b + Math.sqrt(b*b - 4*a*c))/(2*a);
    		final double t2 = (-b - Math.sqrt(b*b - 4*a*c))/(2*a);
    		time = (Math.min(t1, t2) >= 0 ? Math.min(t1, t2) : Math.max(t1, t2)) + (_self.getTime() - _target.getTime()); //Ternary operator: If the lower val root is greater than 0, return that value. else return the larger value // add the age of the data we are using for calculations to the time 
    	}
   		//assume enemy will stop at walls (constrain x & y values to battlefield)
    	Point2D.Double targetLocation = Utils.limitCoordinateToMap(endX, endY);
		return targetLocation;
	}
	@Override
	public void execute() 
	{
		Point2D.Double aimLocation = getAimLocation();
		super.aimToCoordinate(aimLocation);
	}


}
