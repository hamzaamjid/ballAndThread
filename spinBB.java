package spinningBall;

import javax.swing.*;



import java.awt.*;
import java.awt.event.*;

public class spinBB extends JFrame implements ActionListener {

	private Color[] color;	
	private int spin;
	
	
	private class spin extends Thread {
		
		public void run() {
			while(true) {
				try {
					sleep(150);
					repaint();
				} catch (InterruptedException e){
					System.exit(0);
				}
			}
		}
	}
	
	public spinBB () {
		setSize(600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		color = new Color[4];
		spin = 0;
		
		color[0] = Color.RED;
		color[1] = Color.BLUE;
		color[2] = Color.YELLOW;
		color[3] = Color.GREEN;

		JButton button = new JButton("Beach time!");
		button.addActionListener(this);
		add(button, BorderLayout.SOUTH);
	}
	
	
	public void paint(Graphics gr) {
		super.paint(gr);
		spin++;
		int degrees = 360, x = 200, y = 200, arc = -180;
		
		if (spin >= color.length) {
			spin = 0;
		}
		
		for (int z = 0; z < 4; z++) {
			gr.setColor(color[spin]);
			gr.fillArc(x, y, 100, 100, degrees, arc);
			degrees -= 90;
			spin++;
			if (spin >= color.length) {
				spin = 0;
			}
		}
		
		
	}
	

	public void actionPerformed(ActionEvent e) {
		spin thread = new spin();
		thread.start();
	}
	
	
}
