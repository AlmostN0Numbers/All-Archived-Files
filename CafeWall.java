//Name: Reid Moirn
//Class:	CS141
//Assignment: Lab	3
//Purpose: Creates Cafe Wall Art
import java.awt.*;

public class CafeWall {
	//Sets the amount of space between each square
	public static final int MORTAR = 4;
	
	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel(650,400);
		panel.setBackground(Color.GRAY);
		Graphics g = panel.getGraphics();
		//configures the size of the image 
		drawRow(4, 20, 0, 0, g);
		drawRow(5, 30, 50, 70, g);
		drawGrid(0, 4, 25, 10, 150, g);
		drawGrid(10, 3, 25, 250, 200, g);
		drawGrid(10, 5, 20, 425, 180, g);
		drawGrid(35, 2, 35, 400, 20, g);
	}
	//sets values to each grid and row of the illustration
	public static void drawRow(int number, int size, int x, int y, Graphics g) {
		for (int boxes = 0; boxes < number; boxes ++) {
			g.setColor(Color.BLACK);
			g.fillRect(x + 2 * boxes * size, y, size, size);
			g.setColor(Color.WHITE);
			g.fillRect(x + 2 * boxes * size + size, y, size, size);
			g.setColor(Color.BLUE);
			g.drawLine(x + 2 * boxes * size, y, x + 2 * boxes * size + size, y + size);
			g.drawLine(x + 2 * boxes * size, y + size, x + 2 * boxes * size + size, y);
		}  //defines color, filling, and how to create the illustration
	}
	
	public static void drawGrid(int offset, int number, int size, int x, int y, Graphics g) {
		for (int i = 0; i < number * 2; i++) {
			drawRow(number, size, x + offset / 2 - (offset * (int) Math.pow(-1.0, i)) / 2, y + i * (size + MORTAR), g);
		}  //combines the above functions to create the illustration in full
	}
	
}
