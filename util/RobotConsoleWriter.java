package util;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Formatter;

public class RobotConsoleWriter {
	private PrintStream _oStream;
	private String _format;
	private long _currentTime = -1;
	
	public RobotConsoleWriter(PrintStream printStream)
	{
		_oStream = printStream;
		_format = new String("[%d] %s");
	}
	
	public void print(String s)
	{
		_oStream.printf(_format, _currentTime, s);
	}
	public void println(String s)
	{
		_oStream.printf(_format, _currentTime, s);
		_oStream.println();
	}
	public void println()
	{
		_oStream.println();
	}
	public void updateTime(long nTime)
	{
		_currentTime = nTime;
	}
	public void close()
	{
		_oStream.close();
	}
}
