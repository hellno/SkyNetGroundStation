package skyNet;

import java.util.LinkedList;

public class Time {
	float maxSize;
	LinkedList<Float> timeList;
	
	public Time(){
		this.timeList = new LinkedList<>();
	}
	
	public boolean offer(Float element){
		if(timeList.size() < 9){
			timeList.addFirst(element);
			timeList.poll();
		}
		
		else if(timeList.size() > 9){
			timeList.removeLast();
		}
		return true;
	}
}
