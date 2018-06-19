import robot_components.TargetSelector;
import robot_components.data_management.DataManager;
import robot_components.gun.*;
import robot_components.move.*;
import robot_components.radar.*;

import util.RobotConsoleWriter;
import util.Settings;

import java.util.Formatter;
import java.util.Map.Entry;
import java.util.Properties;

import robocode.AdvancedRobot;
import robocode.*;

public class ModularBot extends AdvancedRobot 
{
	//Formatted Output
	private RobotConsoleWriter console = new RobotConsoleWriter(System.out);
	//Managers
	private DataManager _data;
	private Gun _gun;
	private Mover _mover;
	private Radar _radar;
	//Target Selection (Updated automatically based on selected radar.  Can be overridden in bot_options.properties (May cause unexpected results))
	private TargetSelector _targetSelector;

	
	public void run() 
	{
		Properties settings = Settings.loadFromFile("bot_options.properties");
		_gun = Settings.getGun(this, _data);
		_mover = Settings.getMover(this, _data);
		_radar = Settings.getRadar(this, _data);
		_targetSelector = Settings.getTargeter(this, _data);
		
		console.println("< Modular Robot Configuration >");
		for (Entry<Object, Object> entry: settings.entrySet())
		{
			console.println(String.format(" > %s  :  %s", (String)entry.getKey(), (String)entry.getValue()));
		}
		
		//this is executed once per turn
		while(true)
		{
			long currentTime = getTime();
			_data.execute();
			_gun.execute();
			_mover.execute();
			console.updateTime(currentTime);
			
			
			execute();
		}
	}
	
	//Event Methods
	public void onBattleEnded(BattleEndedEvent e) 			{_data.onBattleEnded(e);}
	public void onBulletHitBullet(BulletHitBulletEvent e) 	{_data.onBulletHitBullet(e);}
	public void onBulletHit(BulletHitEvent e) 				{_data.onBulletHit(e);}
	public void onBulletMissed(BulletMissedEvent e)			{_data.onBulletMissed(e);}
	public void onDeath(DeathEvent e) 						{_data.onDeath(e);}
	public void onHitByBullet(HitByBulletEvent e) 			{_data.onHitByBullet(e);}
	public void onHitRobot(HitRobotEvent e) 				{_data.onHitRobot(e);}
	public void onHitWall(HitWallEvent e) 					{_data.onHitWall(e);}
	public void onKey(KeyEvent e) 							{_data.onKey(e);}
	public void onMessage(MessageEvent e) 					{_data.onMessage(e);}
	public void onMouse(MouseEvent e) 						{_data.onMouse(e);}
	public void onPaint(PaintEvent e) 						{_data.onPaint(e);}
	public void onRobotDeath(RobotDeathEvent e) 			{_data.onRobotDeath(e);}
	public void onScannedRobot(ScannedRobotEvent e) 		{_data.onScannedRobot(e);}
	public void onSkippedTurn(SkippedTurnEvent e) 			{_data.onSkippedTurn(e);}
	public void onStatus(StatusEvent e) 					{_data.onStatus(e);}
	public void onWin(WinEvent e) 							{_data.onWin(e);}
	
}
