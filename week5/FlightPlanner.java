package week5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import acm.program.ConsoleProgram;

public class FlightPlanner extends ConsoleProgram {
	private HashMap<String, String[]> dict;
	private String[] route;
	
	public void run() {
		readData("week5//flights.txt");
		PlanFlight();
	}
	
	private void PlanFlight() {
		println("Welcome to Flight Planner!");
		printIntroduction();
		String city = readLine("Enter the Starting City: ");
		while (!verifyConnection(null, city)) {
			println("Not a valid Starting City.");
			printIntroduction();
			city = readLine("Enter the Starting City: ");
		}
		addToRoute(city);

		while (!verifyConnection(route[route.length-1], city)) {
			printConnections(route[route.length-1]);
			String askString = String.format("Where do you want to go from %s?: ", route[route.length-1]);
			city = readLine(askString);
			if (!verifyConnection(route[route.length-1], city)) {
				if (dict.containsKey(city)) println("You can't get to that city by direct flight");
				else println("Invalid destination.");
			}
			else {
				addToRoute(city);
				if (route[0].equals(city)) break;
			}
		}
		println("The route you've chosen is:");
		String finalRoute = String.join(" -> ", route);
		println(finalRoute);
		
	}
	
	private void printIntroduction() {
		println("Here's a list of all the cities in our database:");
		for (String x: dict.keySet()) {
			println(" "+x);
		}
		println("Let's plan a round-trip route!");
	}
	
	private void addToRoute(String city) {
		String[] tmp = new String[route.length+1];
		for (int i = 0; i<route.length; i++) {
			tmp[i] = route[i];
		}
		tmp[route.length] = city;
		route = tmp;
	}
	
	private void printConnections(String city) {
		String intro = String.format("From %s you can fly directly to:", city);
		println(intro);
		for (String x: dict.get(city)) {
			println(" "+x);
		}
	}

	private boolean verifyConnection(String origin, String destination) {
		if (origin == null) return dict.containsKey(destination);
		for (String x: dict.get(origin)) {
			if (x.equals(destination)) return true;
		}
		return false;
	}
	
	private void readData(String file) {
		dict = new HashMap<String, String[]>();
		route = new String[0];
		
		BufferedReader in = openFile(file);
		String currentLine = getNextLine(in);
		
		while (currentLine != null) {
			currentLine = currentLine.trim();
			if (currentLine.length()>0) {
				String[] dataLine = currentLine.split(" -> ");
				addToDict(dataLine[0], dataLine[1]);
			}
			currentLine = getNextLine(in);
		}
	}

	
	private void addToDict(String origin, String destination) {
		if (!dict.containsKey(origin)) dict.put(origin, new String[0]);
		
		String[] reference = dict.get(origin);
		String[] tmp = new String[reference.length+1];
		for (int i = 0; i<reference.length; i++) {
			tmp[i] = reference[i];
		}
		tmp[reference.length] = destination;
		dict.replace(origin, tmp);
	}
	
	public BufferedReader openFile(String file) {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return in;
	}
	
	public String getNextLine(BufferedReader in) {
		String nextLine = null;
		try {
			nextLine = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return nextLine;
	}
}
