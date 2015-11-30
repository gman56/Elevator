package Control;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

public class Elevator implements Runnable {
	
	boolean isMoving;
	int curFloor;
	
	
	
	String id;
	int floor; 
	int maxWeight;
	int numFloors;
	int desiredFloor;
	boolean doorsOpen;
	boolean isEmergency;
	
	
	public Elevator (String id, int curFloor, int maxWeight, int numFloors, boolean doorsOpen,
					boolean isEmergency)
					{
		
						setID(id);
						setCurFloor(curFloor);
						setMaxWeight(maxWeight);
						setNumFloors(numFloors);
						//desiredFloor = getDesiredFloor();
						setDoorsOpen(doorsOpen);
						setIsEmergency(isEmergency);
						
						isMoving = false; 
						curFloor = 1;
						
						
						new Thread(this).start();

		
		
					}

	
	
	public void setID(String x)
	{
		id =x;
	}
	
	public void setDesiredFloor(int x)
	{
		desiredFloor = x;
	}
	
	public void setCurFloor(int x)
	{
		curFloor = x;
	}
	
	public void setMaxWeight(int x)
	{
		maxWeight = x;
	}
	
	public void setNumFloors(int x)
	{
		numFloors = x;
	}
	
	public void setDoorsOpen(boolean x)
	{
		doorsOpen = x;
	}
	
	public void setIsEmergency(boolean x)
	{
		isEmergency=x;
	}
	
	public String getID()
	{
		return id;
	}
	
	
	public void run()
	{
		
		if (this.isMoving == false)
		{
	        String x = JOptionPane.showInputDialog(null, "Imput Desired Floor", "Desired Floor", JOptionPane.QUESTION_MESSAGE);
            desiredFloor = Integer.parseInt(x);
            doorsOpen = false;
            System.out.println("Elevator " + getID()+ " Doors Closing");
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
	            System.out.println(e.getMessage());
				e.printStackTrace();
			}
			System.out.println("Elevator " + getID()+ " Moving to Floor " + desiredFloor);
            isMoving = true;
            

		}
		while (this.isMoving == true)
		{
			doorsOpen=false;
			
			int a  = floorCalc(curFloor+1, desiredFloor, 0);
			int wait = 0;
			try {
				wait = timeWait(a);
			} catch (Exception e) {
	            System.out.println(e.getMessage());
				e.printStackTrace();
			}
			if (curFloor < desiredFloor)
			{
				System.out.println("Elevator " + getID() +" Going up");
			}
			else
			{
				System.out.println("Elevator " + getID() +" Going down");
			}
			
			try {
				TimeUnit.SECONDS.sleep(wait);
			} catch (InterruptedException e) {
	            System.out.println(e.getMessage());
				e.printStackTrace();
			}
			System.out.println("Elevator "+ getID()+ " Arriving at Floor");
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			curFloor = desiredFloor;
			doorsOpen=true;
            System.out.println("Elevator " + getID()+ " Doors Opening");
            

			isMoving = false;
			
		}
	}
	
	public int timeWait(int floorNum) throws Exception
	{
		
		int time = 0;
		if (floorNum == 0)
		{
			throw new Exception("Aint going nowhere");
		}
		
		else if (floorNum > 0)
		{
			for (int i = 0; i < floorNum-1; i++)
			{
			 	int eachFloor = 5;
			 	time = i + eachFloor;
			 	
			}
		}
		return time;
	}
	
	
	
	public int floorCalc(int cur, int des, int floors)
	{
		if (cur == des)
		{
			return floors;
		}
		else
		{
			if (cur > des)
			{
				return floorCalc(cur-1, des, floors+1);
			}
			if (cur < des)
			{
				return floorCalc(cur+1, des, floors+1);
			}
		}
		return floors;
		
	}
	
	
	
}

