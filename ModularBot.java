import robot_components.gun.*;
import robot_components.move.*;
import robot_components.radar.*;

import util.RobotConsoleWriter;

import java.util.Formatter;

import robocode.AdvancedRobot;

public class ModularBot extends AdvancedRobot 
{
	private RobotConsoleWriter console = new RobotConsoleWriter(System.out);
	private Gun _gun;
	private Mover _mover;
	private Radar _radar;
	
	public void run() 
	{
		console.println(/*Modular Robot Configuration*/);
		
		while(true)
		{
			long currentTime = getTime();
			console.updateTime(currentTime);
			
			
			execute();
		}
	}
	
}
