package util;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.Properties;

import robocode.AdvancedRobot;
import robot_components.TargetSelector;
import robot_components.data_management.DataManager;
import robot_components.gun.*;
import robot_components.move.*;
import robot_components.radar.*;

public final class Settings 
{
	private static final int NUM_SETTINGS = 3; //0 = gun, 1 = movement, 2 = radar (have enabled/disabled options for all)
	private static Properties settings;
	public static Properties loadFromFile(String settingsFilePath)
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
	public static Gun getGun(AdvancedRobot self, DataManager data) {
		String val = settings.getProperty("gun");
		Gun output = null;
		
		switch (val.toUpperCase())
		{
		case "LINEAER" : output = new Linear(self, data);
		break;
		case "CONSTANT_TURN" : output = new ConstantTurnRate(self, data);
		break;
		case "HEAD_ON" : output = new HeadOn(self, data);
		}
		return null;
	}
	public static Mover getMover(AdvancedRobot self, DataManager data) {
		String val = settings.getProperty("gun");
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
		return null;
	}
	public static Radar getRadar(AdvancedRobot self, DataManager data) {
		String val = settings.getProperty("gun");
		Radar output = null;
		switch (val.toUpperCase())
		{
		case "" :
			break;
		}
		return null;
	}
	public static TargetSelector getTargeter(AdvancedRobot self, DataManager data) {
		String val = settings.getProperty("gun");
		TargetSelector output = null;
		switch (val.toUpperCase())
		{
		case "" :
			break;
		}
		return null;
	}
}
