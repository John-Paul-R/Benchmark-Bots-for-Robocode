package robot_components.data_management;

import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.LinkedList;

import robocode.AdvancedRobot;
import robocode.BattleEndedEvent;
import robocode.BulletHitBulletEvent;
import robocode.BulletHitEvent;
import robocode.BulletMissedEvent;
import robocode.DeathEvent;
import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.KeyEvent;
import robocode.MessageEvent;
import robocode.MouseEvent;
import robocode.PaintEvent;
import robocode.RobotDeathEvent;
import robocode.ScannedRobotEvent;
import robocode.SkippedTurnEvent;
import robocode.StatusEvent;
import robocode.WinEvent;
import robot_components.Manager;

public class DataManager implements Manager
{
	private AdvancedRobot _self;
	private HashMap<String, Bot> _enemies;
	private LinkedList<BotState> _selfData;
	private BotState cSelf;
	private Bot cTarget;
	public DataManager() {}
	
	public void init(AdvancedRobot self) 
	{
		_self = self;
		_enemies = new HashMap<String, Bot>();
		_selfData = new LinkedList<BotState>();
	}
	
	//Do
	@Override
	public void execute() // Note:  It is almost always optimal to run the 'execute()' method for DataManager before doing anything else in your main while loop
	{
		cSelf = new BotState(_self.getX(), _self.getY(), _self.getEnergy(), _self.getHeadingRadians(), _self.getVelocity(), _self.getTime());
		_selfData.add(cSelf);
	}
	public void update()
	{

	}
	public void onScannedRobot(ScannedRobotEvent e)
	{
		if (!_enemies.containsKey(e.getName()))
		{
			addEnemy(e);
		}
		addEnemyState(e);
	}
	public void addEnemy(ScannedRobotEvent e)
	{
		Bot enemy = new Bot();
		_enemies.put(e.getName(), enemy);
	}
	public void addEnemyState(ScannedRobotEvent e)
	{
		Bot enemy = _enemies.get(e.getName());
        double eX = (cSelf.getX() + Math.sin((cSelf.getHeading() + e.getBearingRadians()) % (2*Math.PI)) * e.getDistance());
        double eY = (cSelf.getY() + Math.cos((cSelf.getHeading() + e.getBearingRadians()) % (2*Math.PI)) * e.getDistance());
		BotState scanData = new BotState(eX, eY, e.getEnergy(), e.getHeadingRadians(), e.getVelocity(), e.getTime());
		enemy.addState(scanData);
	}
	
	
	//Get
	public BotState getSelf() 
	{
		return cSelf;
	}
	public Bot getEnemy(String name)
	{
		return _enemies.get(name);
	}
	public BotState getEnemyState(String name)
	{
		return _enemies.get(name).getState();
	}
	public BotState getEnemyState(String name, int index)
	{
		return _enemies.get(name).getState(index);
	}
	
	//EVENTS (Note that some events (onStatus) will trigger before the DataManager is initialized)
	public void onBattleEnded(BattleEndedEvent e) {}
	public void onBulletHitBullet(BulletHitBulletEvent e) {}
	public void onBulletHit(BulletHitEvent e) {}
	public void onBulletMissed(BulletMissedEvent e) {}
	public void onDeath(DeathEvent e) {}
	public void onHitByBullet(HitByBulletEvent e) {}
	public void onHitRobot(HitRobotEvent e) {}
	public void onHitWall(HitWallEvent e) {}
	public void onKey(KeyEvent e) {}
	public void onMessage(MessageEvent e) {}
	public void onMouse(MouseEvent e) {}
	public void onPaint(PaintEvent e) {}
	public void onRobotDeath(RobotDeathEvent e) {}
	//public void onScannedRobot(ScannedRobotEvent e) {}
	public void onSkippedTurn(SkippedTurnEvent e) {}
	//public void onStatus(StatusEvent e) {}
	public void onWin(WinEvent e) {}

	public Bot getEnemyDEBUG() {
		// TODO Auto-generated method stub
		if (_enemies.size() > 0)
			return _enemies.get((String) (_enemies.keySet().toArray()[0]));
		else
			return null;
	}

	public Bot getTarget() {
		return cTarget;
	}

	public void setTarget(Bot cTarget) {
		this.cTarget = cTarget;
	}
}
