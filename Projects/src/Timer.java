import javax.swing.JFrame;
import javax.swing.JPanel;

public class Timer {

	public static void main(String[] args) {
		TimerView view = new TimerView();
		TimerModel model = new TimerModel();
		TimerController controller = new TimerController(view, model);
		
		
		JFrame mainFrame = new JFrame();
		mainFrame.setTitle("Pomodoro Timer");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainFrame.setContentPane(view);
		
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	
	
}
