/* Havi Nguyen 
 * HTN2115 
 * This class is used to model a talk and provide the 
 * speaker for a talk along with the start 
 * and stop times of the talk. */

public class Talk implements Comparable<Talk>{
	
	private String name;
	private int startTime;
	private int endTime;
	
	public Talk(String name, int startTime, int endTime) {
		this.name = name; 
		this.startTime = startTime;
		this.endTime = endTime;
		
	}
	
	public int getStartTime(){
		return startTime;
	}
	
	public int getEndTime(){
		return endTime;
	}
	
	public int compareTo(Talk other){
		if(this.getEndTime() > other.getEndTime()){
			return 1; 
		}
		if(this.getEndTime() < other.getEndTime()){
			return -1; 
		}
		else {
			return 0; 
		}
	}
	
	public String toString(){
		return "\n" + name + "\n Start:" + startTime + " Finish:" + endTime;
	}
	
}