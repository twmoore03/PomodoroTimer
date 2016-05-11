import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TimerView extends JPanel {

	private JLabel display;
	private JLabel workCount;
	private JLabel longBreakCountdown;
	private JPanel buttonPanel;
	private JPanel cyclesPanel;
	private JPanel historyPanel;
	
	private int workCountNumber;
	
	public TimerView() {
		setLayout(new BorderLayout());
		
		cyclesPanel = new JPanel();
		cyclesPanel.setLayout(new GridLayout(0,3));
		
		JButton work = new JButton("Work");
		JButton rest = new JButton("Rest");
		JButton longRest = new JButton("Long Rest");
		
		cyclesPanel.add(work);
		cyclesPanel.add(rest);
		cyclesPanel.add(longRest);
		add(cyclesPanel, BorderLayout.NORTH);
		
		historyPanel = new JPanel();
		historyPanel.setLayout(new BoxLayout(historyPanel, BoxLayout.PAGE_AXIS));
		workCount = new JLabel();
		setWorkCountLabel(0);
		longBreakCountdown = new JLabel();
		setLongBreakCountdownLabel(4);
		
		historyPanel.add(workCount);
		historyPanel.add(longBreakCountdown);
		add(historyPanel, BorderLayout.WEST);
		
		display = new JLabel();
		display.setHorizontalAlignment(SwingConstants.CENTER);
		display.setFont(new Font("Serif", Font.BOLD, 40));
		add(display, BorderLayout.CENTER);
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(0,3));
		
		JButton start = new JButton("Start");
		JButton stop = new JButton("Stop");
		JButton reset = new JButton("Reset");
		
		buttonPanel.add(start);
		buttonPanel.add(stop);
		buttonPanel.add(reset);
		add(buttonPanel, BorderLayout.SOUTH);
		
	}
	
	public void setDisplayTimeLabel(String s) {
		display.setText(s);
	}
	
	public void setWorkCountLabel(int s) {
		workCount.setText("Work cyles completed: " + s);
	}
	
	public void setLongBreakCountdownLabel(int s) {
		longBreakCountdown.setText("Long break coundown: " + s);
	}
	
	public void addActionListener(ActionListener l) {
		for (Component c: cyclesPanel.getComponents()) {
			JButton b = (JButton) c;
			b.addActionListener(l);
		}
		
		for (Component c: buttonPanel.getComponents()) {
			JButton b = (JButton) c;
			b.addActionListener(l);
		}
	}
}
