import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class CoordinateSystem extends JPanel {
	Point[] redPoints;
	Point[] bluePoints;

	public CoordinateSystem(Point[] redPoints, Point[] bluePoints) {
		this.redPoints = redPoints;
		this.bluePoints = bluePoints;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.WHITE);

		// Draw x-axis
		g.drawLine(40, getHeight() - 40, getWidth() - 40, getHeight() - 40);
		// Draw y-axis
		g.drawLine(40, 40, 40, getHeight() - 40);

		// Draw x-axis arrow
		g.drawLine(getWidth() - 40, getHeight() - 40, getWidth() - 30, getHeight() - 50);
		g.drawLine(getWidth() - 40, getHeight() - 40, getWidth() - 30, getHeight() - 30);

		// Draw y-axis arrow
		g.drawLine(40, 40, 30, 50);
		g.drawLine(40, 40, 50, 50);

		// Draw x-axis label
		g.drawString("X", getWidth() - 20, getHeight() - 20);

		// Draw y-axis label
		g.drawString("Y", 20, 50);

		// Draw red points
		g.setColor(Color.RED);
		for (int i = 0; i < redPoints.length; i++) {
			int x = redPoints[i].x;
			int y = redPoints[i].y;
			if (x > 40 && y > 40)
				g.fillOval(x, y, 10, 10);
		}
		// Draw blue points
		g.setColor(Color.BLUE);
		for (int i = 0; i < bluePoints.length; i++) {
			int x = bluePoints[i].x;
			int y = bluePoints[i].y;
			if (x > 40 && y > 40)
				g.fillOval(x, y, 10, 10);
		}
		// Draw a line between red and blue points
		g.setColor(Color.BLACK);
		int redX = redPoints[redPoints.length - 1].x;
		int redY = redPoints[redPoints.length - 1].y;
		int blueX = bluePoints[0].x;
		int blueY = bluePoints[0].y;
		g.drawLine(redX, redY, blueX, blueY);
	}

}
