package ie.tudublin;

import processing.core.PApplet;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Gantt extends PApplet
{

	public void settings()
	{
		size(800, 600);
	}

	public void loadTasks()
	{
		String csvFile = "java/data/tasks.csv";
		String line = "";
		String splitBy = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			int count = 0;
			while ((line = br.readLine()) != null) {
				if (count > 0) {
					String[] taskString = line.split(splitBy);
				}
				count++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void printTasks()
	{
		
	}
	
	public void mousePressed()
	{
		println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}

	
	
	public void setup() 
	{
	}
	
	public void draw()
	{			
		background(0);
	}
}
