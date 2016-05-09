import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TimerView extends JPanel {

	private JLabel display;
	private JPanel buttonPanel;
	private JPanel cyclesPanel;
	
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
		
		
		display = new JLabel();
		display.setHorizontalAlignment(SwingConstants.CENTER);
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
	
	public void modifyTimeLabel(String s) {
		display.setText(s);
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
