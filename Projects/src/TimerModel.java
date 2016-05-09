import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Timer;

public class TimerModel extends Observable implements ActionListener{

	private Boolean isWorkCycle;
	private Boolean isBreakCycle;
	private Boolean isLongBreakCycle;
	private Boolean isStarted;
	private Timer timerClock;
	private int remainingSeconds;
	
	public TimerModel() {
		isWorkCycle = true;
		isBreakCycle = false;
		isLongBreakCycle = false;
		isStarted = false;
		remainingSeconds = 1500;
		
		
		timerClock = new Timer(1000, this);
	}
	
	//getter methods
	public Boolean getIsStarted() {
		return isStarted;
	}
	
	public Boolean getIsWorkCycle() {
		return isWorkCycle;
	}
	
	public Boolean getIsBreakCycle() {
		return isBreakCycle;
	} 
	
	public Boolean getIsLongBreakCycle() {
		return isLongBreakCycle;
	}
	
	public int getRemainingSeconds() {
		return remainingSeconds;
	}
	
	//setter methods
	public void setIsWorkCycle(Boolean t) {
		isWorkCycle = t;
	}
	
	public void setIsBreakCycle(Boolean t) {
		isBreakCycle = t;
	} 
	
	public void setIsLongBreakCycle(Boolean t) {
		isLongBreakCycle = t;
	}
	
	public void setIsStarted(Boolean t) {
		isStarted = t;
	}
	
	public void setRemainingSeconds(int s) {
		remainingSeconds = s;
	}
	
	
	public void startTimer() {
		timerClock.start();
	}
	
	public void stopTimer() {
		timerClock.stop();
	}
	
	public void resetTimer() {
		timerClock.restart();
		timerClock.stop();
	}

	public void actionPerformed(ActionEvent e) {
		remainingSeconds--;
		setChanged();
		notifyObservers();
	}
}
