package com.sun.atilim.compe501;

import java.awt.Color;

import javax.swing.JFrame;

public class BallWorld extends JFrame {

	public static final int FrameHeight = 400;

	public static final int FrameWidth = 600;
	public static void main(String[] args) {
		BallWorld world = new BallWorld(Color.red);
		world.setVisible(true);
		world.run();
		// System.exit(0);
	}
	private BallWorldPanel panel;

	private BallWorld(Color ballColor) {
		setSize(FrameWidth, FrameHeight);
		setTitle(Messages.getString("BallWorld.0")); //$NON-NLS-1$

		panel = new BallWorldPanel(ballColor);
		getContentPane().add(panel);
	}

	private void run() {
		for (int i = 0; i < 2000; i++) {
			panel.moveBall(FrameWidth - 8, FrameHeight - 35);
			repaint();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				System.exit(0);
			}
		}
	}
}
