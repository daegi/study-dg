package com.flriker;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FlickeringLabelTest extends JFrame {

	public FlickeringLabelTest() {
		this.setTitle("¤¢¤³ ¤¢¤³");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());

		FlickeringLabel fLabel = new FlickeringLabel("±ôºý");
		JLabel label = new JLabel("¾È±ôºý");
		FlickeringLabel fLabel2 = new FlickeringLabel("¿©±âµµ ±ôºý");

		c.add(fLabel);
		c.add(label);
		c.add(fLabel2);

		this.setSize(300, 150);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new FlickeringLabelTest();
	}

}
