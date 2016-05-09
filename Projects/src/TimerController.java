import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;



public class TimerController extends Thread implements ActionListener, Observer{

	private TimerView view;
	private TimerModel model;
	private Sound sound;

	public TimerController(TimerView view, TimerModel model) {
		this.view = view;
		this.model = model;
		this.setDisplay();

		view.addActionListener(this);
		model.addObserver(this);
	}

	public void setDisplay() {
		int seconds = 0;
		if (model.getIsWorkCycle()) {
			model.setRemainingSeconds(25 * 60);
			seconds = model.getRemainingSeconds();
			view.modifyTimeLabel(secondsToString(seconds));
		} else if (model.getIsBreakCycle()) {
			model.setRemainingSeconds(5 * 60);
			seconds = model.getRemainingSeconds();
			view.modifyTimeLabel(secondsToString(seconds));
		} else if (model.getIsLongBreakCycle()) {
			model.setRemainingSeconds(15 * 60);
			seconds = model.getRemainingSeconds();
			view.modifyTimeLabel(secondsToString(seconds));
		}	
	}

	public void updateDisplay() {
		int seconds = model.getRemainingSeconds();
		if (seconds == 0) {
			playSound();
			model.resetTimer();
			setDisplay();
		} else {
			view.modifyTimeLabel(secondsToString(seconds));
		}
	}

	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton)e.getSource();
		String buttonText = "";

		if (source != null) {
			buttonText = source.getText();
		}

		switch(buttonText)	{
		case "Start":
			model.startTimer();
			break;
		case "Stop":
			model.stopTimer();
			break;
		case "Reset":
			model.resetTimer();
			setDisplay();
			break;
		case "Work":
			model.setIsWorkCycle(true);
			model.setIsBreakCycle(false);
			model.setIsLongBreakCycle(false);
			setDisplay();
			model.resetTimer();
			break;
		case "Rest":
			model.setIsWorkCycle(false);
			model.setIsBreakCycle(true);
			model.setIsLongBreakCycle(false);
			setDisplay();
			model.resetTimer();
			break;
		case "Long Rest":
			model.setIsWorkCycle(false);
			model.setIsBreakCycle(false);
			model.setIsLongBreakCycle(true);
			setDisplay();
			model.resetTimer();
			break;
		}


	}

	public String secondsToString(int seconds) {
		int minutes = 0;
		if (seconds > 60) {
			minutes = seconds / 60;
			seconds = seconds % 60;
		} 
		String time = String.format("%d:%02d", minutes, seconds);
		return time;
	}

	public void update(Observable o, Object arg) {
		updateDisplay();
	}
	
	public void playSound() {
		Sound.ding.play();
		new Thread(this).start();
	}	
}
