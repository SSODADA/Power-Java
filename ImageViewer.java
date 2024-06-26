package test;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Myframe extends JFrame implements ActionListener{
	private JLabel label;
	private JMenuItem open, exit;
	
	public Myframe() {
		setTitle("타이틀");
		setSize(400, 400);
		
		JMenuBar mbar = new JMenuBar();
		JMenu m = new JMenu("File");
		open = new JMenuItem("Open");
		open.addActionListener(this);
		m.add(open);
		exit = new JMenuItem("Exit");
		exit.addActionListener(this);
		m.add(exit);
		mbar.add(m);
		setJMenuBar(mbar);
		
		label = new JLabel();
		JPanel panel = new JPanel();
		panel.add(label, "Center");
		add(panel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == open) {
			JFileChooser chooser = new JFileChooser();
			int r = chooser.showOpenDialog(this);
			if(r == JFileChooser.APPROVE_OPTION) {
				String name = chooser.getSelectedFile().getAbsolutePath();	
				label.setIcon(new ImageIcon(name));
			}
		}
		else if (source == exit)
			System.exit(0);
	}
	
	public static void main(String[] args) {
		Myframe f = new Myframe();
	}
}
