package ie.tudublin;

import processing.core.PApplet;
import processing.core.PFont;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Gantt extends PApplet
{
	ArrayList<Task> tasks = new ArrayList<>();
	PFont f;

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
					Task task = new Task();
					task.setTaskName(taskString[0]);
					task.setStart(Integer.parseInt(taskString[1]));
					task.setEnd(Integer.parseInt(taskString[2]));
					tasks.add(task);
				}
				count++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void printTasks()
	{
		for(Task task: tasks)
		{
			println("Task name - " + task.getTaskName() + ", task start - " + task.getStart() + ", task end - " + task.getEnd());
		}
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
		loadTasks();
		printTasks();
		f = createFont("Arial",16,true);
	}
	
	public void draw() {
		background(0);
		textFont(f,12);
		fill(255);
		drawTimeSlots();
		drawTasks();
	}

	public void drawTimeSlots() {
		for (int i = 0; i <= 30; i++) {
			text(i,22 * (i + 5),50);
			stroke(255);
			line(22 * (i + 5), 75, 22 * (i + 5), 550);
		}
	}

	public void drawTasks() {
		for (int i = 0; i < tasks.size(); i++) {
			Task task = tasks.get(i);
			text(task.getTaskName(),10,50 * (i + 2));
		}
	}

}
