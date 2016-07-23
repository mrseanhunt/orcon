package ORCONOUTSIDEGAME;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window extends JPanel  {
private static final long serialVersionUID = 4005930978865087898L;

private ArrayList<Planet> planetList;
private ImageIcon icon;
private JLabel jlabel;
private Font font;
private JLabel button;
private BufferedImage bi= null;
private Point centerOfScreen= new Point(mainFunction.getHeight()/2, mainFunction.getWidth()/2);

public Window(){
	
	//used to load the images	
	try {
	    bi = ImageIO.read(new File("PlanetTest.png"));
	} catch (IOException e) {
	}	
	planetList= new ArrayList();
	Planet sol = new Planet();
	Planet earth = new Planet();
    sol.setCoordinates(300, 100);
    sol.setStarMapImage(bi);
    sol.setPlanetColor(255, 0, 0);
    earth.setCoordinates(400,-20);
    earth.setStarMapImage(bi);
	
	
	planetList.add(sol);
	planetList.add(earth);
	
	GenericMouseHandler genericMouseHandler = new GenericMouseHandler();
	this.addMouseListener(genericMouseHandler);
	this.addMouseMotionListener(genericMouseHandler);
	
	
	
}//end of contrstuctor

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    
    //This will draw out all planet add to the planetList
    for(int i =0;i<planetList.size();i++){
    g.setColor(planetList.get(i).getPlanetColor());
    g.drawImage(planetList.get(i).getStarMapImage(),planetList.get(i).getXCoordinates(),planetList.get(i).getYCoordinates(), null);
    g.drawString(planetList.get(i).getPlanetName(), planetList.get(i).getXCoordinates()+6, planetList.get(i).getYCoordinates()+45);
    }
    
    
   
}
public class GenericMouseHandler implements MouseListener,MouseMotionListener{

	@Override
	public void mouseClicked(MouseEvent e) {
//		int xDifference = e.getX()-centerOfScreen.x;
//		int yDifference = e.getY()-centerOfScreen.y;
//		System.out.println(xDifference);
//		for(int indexOfPlanets =0; indexOfPlanets <planetList.size();indexOfPlanets++){
//			planetList.get(indexOfPlanets).setCoordinates(e.getX()-xDifference, e.getY());	
//		}
		planetList.get(0).setCoordinates(e.getX(), e.getY());
		repaint();
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e ){
		MouseWatcher.setJTextField(e.getX()+ " , " +e.getY());
//		planetList.get(0).setCoordinates(e.getX(), e.getY());
//		repaint();
		
	}
	
}

}//end of class




