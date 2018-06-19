package util;

import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.Properties;

import robocode.AdvancedRobot;
import robot_components.selectors.Closest;
import robot_components.selectors.TargetSelector;
import robot_components.data_management.DataManager;
import robot_components.gun.*;
import robot_components.move.*;
import robot_components.radar.*;

public final class Settings 
{
	private static final int NUM_SETTINGS = 3; //0 = gun, 1 = movement, 2 = radar (have enabled/disabled options for all)
	private static Properties settings;
	private static final String propErrorFormat =
			("ERROR \t> The property '%s' in ./ModularBot.data/bot_options.properties is invalid or configured incorrectly."
				+ "\n\t\t> The acceptable format is:  %s = PROPERTY");
	public static Properties loadFromFile(File settingsFilePath)
	{
		FileReader reader = null;
		Properties prop = new Properties();
		try {
			reader = new FileReader(settingsFilePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		settings = prop;
		return prop;
	}
	public static Properties get()
	{
		return settings;
	}
	private static BulletPowerSelector getBulletPowerSelector(DataManager data) {
		String propertyName = "BulletPowerSelector";
		String val = settings.getProperty(propertyName);
		BulletPowerSelector output = null;
		
		switch (val.toUpperCase())
		{
		case "BY_DIST_SIMPLE" : output = new SimplePowerByDist(data);//TODO rework this mode. Its unnecessarily complicated for zero benefit
		break;
		case "MANUAL" : output = new PowerManual(data);
		break;
		}
		if (output == null)
			System.out.println(String.format(propErrorFormat, propertyName, propertyName));
		return output;
	}
	public static Gun getGun(AdvancedRobot self, DataManager data) {
		String propertyName = "Gun";
		String val = settings.getProperty(propertyName);
		Gun output = null;
		BulletPowerSelector bp = getBulletPowerSelector(data);
		switch (val.toUpperCase())
		{
		case "LINEAER" : output = new Linear(self, data, bp);
		break;
		case "CONSTANT_TURN" : output = new ConstantTurnRate(self, data, bp);
		break;
		case "HEAD_ON" : output = new HeadOn(self, data, bp);
		}
		if (output == null)
			System.out.println(String.format(propErrorFormat, propertyName, propertyName));
		return output;
	}
	public static Mover getMover(AdvancedRobot self, DataManager data) {
		String propertyName = "Mover";
		String val = settings.getProperty(propertyName);
		Mover output = null;
		switch (val.toUpperCase())
		{
		case "BOX" : output = new Box_Pattern(self, data);
		break;
		case "CIRCLE" : output = new Circle_Pattern(self, data);
		break;
		case "DIAMOND" : output = new Diamond_Pattern(self, data);
		break;
		case "LEFTRIGHT" : output = new LeftRight_Pattern(self, data);
		break;
		case "SINEWAVE" : output = new Sinewave_Pattern(self, data);
		break;
		case "WALLS" : output = new Walls_Pattern(self, data);
		break;
		}
		if (output == null)
			System.out.println(String.format(propErrorFormat, propertyName, propertyName));
		return output;
	}
	public static Radar getRadar(AdvancedRobot self, DataManager data) {
		String propertyName = "Radar";
		String val = settings.getProperty(propertyName);
		Radar output = null;
		switch (val.toUpperCase())
		{
		case "SPIN" : output = new Spin(self, data);
		break;
		case "LOCK" : output = new Lock(self, data);
		}
		if (output == null)
			System.out.println(String.format(propErrorFormat, propertyName, propertyName));
		return output;
	}
	public static TargetSelector getTargeter(DataManager data) {
		String propertyName = "Targeter";
		String val = settings.getProperty(propertyName);
		TargetSelector output = null;
		switch (val.toUpperCase())
		{
		case "" : output = new Closest(data);
		break;
		case "CLOSEST" : output = new Closest(data);	
		}
		if (output == null)
			System.out.println(String.format(propErrorFormat, propertyName, propertyName));
		return output;
	}
}
