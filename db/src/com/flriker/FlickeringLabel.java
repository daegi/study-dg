package com.flriker;

import java.awt.Color;

import javax.swing.JLabel;

public class FlickeringLabel extends JLabel implements Runnable {

	public FlickeringLabel(String text) {
		super(text);
		this.setOpaque(true);

		Thread th = new Thread(this);
		th.start();
	}

	public void run() {
		int n = 0;
		while (true) {
			if (n == 0)
				setBackground(Color.yellow);
			else
				setBackground(Color.green);

			if (n == 0)
				n = 1;
			else
				n = 0;

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
		}

	}

}
