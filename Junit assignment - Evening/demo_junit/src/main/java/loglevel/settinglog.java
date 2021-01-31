package loglevel;

import java.util.Scanner;

import org.apache.log4j.*;
import org.apache.log4j.Logger;

public class settinglog {
	static Logger logger = Logger.getLogger("settinglog");
	static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicConfigurator.configure();
		sc = new Scanner(System.in);

		int levelSet = getUserInputForLogLevel();
		switch (levelSet) {
		case 1:
			logger.setLevel(Level.ALL);
			break;
		case 2:
			logger.setLevel(Level.DEBUG);
			break;
		case 3:
			logger.setLevel(Level.INFO);
			break;
		case 4:
			logger.setLevel(Level.WARN);
			break;
		case 5:
			logger.setLevel(Level.ERROR);
			break;
		case 6:
			logger.setLevel(Level.FATAL);
			break;
		case 7:
			logger.setLevel(Level.OFF);
			break;

		}

		System.out.println("--------------Log Details----------");
		logDetails();
	}

	static public int getUserInputForLogLevel() {
		int levelSet = 0;

		showOptions();

		levelSet = sc.nextInt();
		return levelSet;
	}

	static void showOptions() {

		System.out.println("Enter 1  for log level to ALL");
		System.out.println("Enter 2  for log level to DEBUG");
		System.out.println("Enter 3  for log level to INFO");
		System.out.println("Enter 4  for log level to WARN");
		System.out.println("Enter 5  for log level to ERROR");
		System.out.println("Enter 6  for log level to FATAL");
		System.out.println("Enter 7  for log level to OFF");

	}

	static void logDetails() {
		logger.trace("Trace Message!");
		logger.debug("Debug Message!");
		logger.info("Info Message!");
		logger.warn("Warn Message!");
		logger.error("Error Message!");
		logger.fatal("Fatal Message!");

	}
}
