package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MyWindow extends JFrame implements KeyListener{
	int width = 900;
	int height = 900;
	Hero egg;
	Hero pug;
	boolean itemPickedUp;
	BufferedImage landscape;

	public static void main(String[] args) {
		new MyWindow();

	}

	public MyWindow(){
		//the following are JFrame methods
		pug = new Hero("Pug","/images/heros/pug.png",400,200);
		egg = new Hero("Egg","/images/heros/egg.png",90,200);
		itemPickedUp = false;
		landscape=new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D)landscape.getGraphics();
		paintLandscape(g2);
		
		setVisible(true);
		setSize(500,500);//units in px
		setLocation(200,250);//200px right,150 px down
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//static constant reference for special close operation
		addKeyListener(this);
	}

	public void paint(Graphics g){
		//Graphics is a crayon box
		//Graphics2d is like an art kit
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		//g2.setColor(new Color(50,100,200));
		Graphics2D g2=(Graphics2D)g;
//		g2.setColor(Color.white);
//		g2.fillRect(0,0,width,height);
		//		g2.setColor(new Color(255, 229, 180 ));
		//		g2.fillOval(20,100,width,height);
		//		g2.setColor(new Color(255, 229, 180 ));
		//		g2.drawOval(20, 100, width, height);
		//		g2.setColor(Color.black);
		//		g2.drawOval(70, 180, 50, 50);
		//		g2.setColor(Color.black);
		//		g2.fillOval(70, 180, 50, 50);
		//		
		//		g2.setColor(Color.black);
		//		g2.drawOval(210, 180, 50, 50);
		//		g2.setColor(Color.black);
		//		g2.fillOval(210, 180, 50, 50);
		//		
		//		//x,y,width,height,startDEG,lengthDEG
		//		g2.setColor(Color.red);
		//		g2.drawArc(100, 250, 150, 150, 0 , 180 );


		//		//string,x,y
		//		g2.drawString("Strings", 300, 100);
		//
		//		//lines: startx,starty, end x, end y
		//		g2.drawLine(0,0,width,height);
		
		g2.setColor(new Color(254, 254, 160));
		g2.fillRect(0,0,width,height);

		g2.drawImage(landscape,0,0,null);
		
		
		
		if(Math.abs(pug.getX()-egg.getX())
				+ Math.abs(pug.getY()-egg.getY()) < 10) 
			itemPickedUp=true;
		
		if(!itemPickedUp)g2.drawImage(egg.getImage(),egg.getX(),egg.getY(),null);
		
		g2.drawImage(pug.getImage(),pug.getX(),pug.getY(),null);

		//		int squareD = 20;
		//		int margin = 2;
		//		int c = 225;
		//		for(int x = 0; x<width; x+=squareD+margin){
		//			for( int y = 0; y<height; y+=squareD+margin){
		//				if(c>225){
		//					c=0;
		//				}
		//				g2.fillRect(x, y, squareD, squareD);
		//				g2.setColor(new Color(0,0,c));
		//
		//				c++;
		//			}
		//draw the bufferedImage on the canvas
		g.drawImage(image, 0, 0, null);
	}

	private void paintLandscape(Graphics2D g2) {
		// TODO Auto-generated method stub

	}

	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int key = arg0.getKeyCode();
		if(key == KeyEvent.VK_UP){
			pug.moveUp();
		}
		else if(key == KeyEvent.VK_DOWN){
			pug.moveDown();
		}else if(key == KeyEvent.VK_RIGHT){
			pug.moveRight();
		}else if(key == KeyEvent.VK_LEFT){
			pug.moveLeft();
		}
		repaint();
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}	
}
	
