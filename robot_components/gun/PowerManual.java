package robot_components.gun;

import robot_components.data_management.Bot;
import robot_components.data_management.BotState;
import robot_components.data_management.DataManager;

public class PowerManual extends BulletPowerSelector
{
	private double _bulletPower;

	public PowerManual(DataManager data) 
	{
		super(data);
		_bulletPower = 2;
	}
	public PowerManual(DataManager data, double power) 
	{
		super(data);
		_bulletPower = power;
	}

	public void setPower(double power)
	{
		_bulletPower = power;
	}
	@Override
	public double getPower(Bot target)
	{
		return _bulletPower;
	}

	@Override
	public double getPower(BotState target)
	{
		return _bulletPower;
	}
}
