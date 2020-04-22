package ie.tudublin;

import java.util.Random;

public class Task {
    private String taskName;
    private int start;
    private int end;
    public int r;
    public int g;
    public int b;


    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setColour() {
        Random rand = new Random();
        r = rand.nextInt(256);
        g = rand.nextInt(256);
        b = rand.nextInt(256);
    }

}
