package bingo.design.creative.builder.b;

import java.util.ArrayList;

public abstract class CarModel {
	private ArrayList<String> sequence = new ArrayList<String>();
	
	protected abstract void start();
	
	protected abstract void stop();
	
	protected abstract void alarm();
	
	protected abstract void engineBoom();
	
	/**
	 * 
	 */
	public final void run(){
		for(int i=0;i<sequence.size();i++){
			String actionName = sequence.get(i);
			if(actionName.equalsIgnoreCase( "start" )){
				this.start();
			}else if(actionName.equalsIgnoreCase( "stop" )){
				this.stop();
			}else if(actionName.equalsIgnoreCase( "alarm" )){
				this.alarm();
			}else if(actionName.equalsIgnoreCase( "engineBoom" )){
				this.engineBoom();
			} 
		}
	}
}
