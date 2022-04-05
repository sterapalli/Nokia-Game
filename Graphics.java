import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Graphics
extends JPanel
implements ActionListener{
	private Timer t = new Timer(100, this);
	public String state;
	private Snake s;
	private Food f;
	private FunGame game; 
	
	public Graphics(FunGame g) {
		t.start();	//Starts the timer 
		state = "START";
		
		game = g;
		s = g.getPlayer();
		f = g.getFood();
		
		//adding keyListener to the game
		this.addKeyListener(g);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
	}
	
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.DARK_GRAY);
		g2d.fillRect(0, 0, FunGame.width *FunGame.dimension , FunGame.height * FunGame.dimension + 5);
		
		
		if(state == "START") {
			g2d.setColor(Color.black);
			g2d.drawString("PRESS ANY KEY", FunGame.width / 2 * FunGame.dimension - 40, 
					FunGame.height / 2 * FunGame.dimension - 20);
		}
		else if (state == "RUNNING") {
		
			//tile color
			g2d.setColor(Color.white);
			g2d.fillRect(f.getX() * FunGame.dimension, f.getY() * FunGame.dimension, FunGame.dimension, FunGame.dimension);
			//Snake color
			g2d.setColor(Color.black);
			for(Rectangle r: s.getBody()) {
				g2d.fill(r);
			}
		}
		else {
			g2d.setColor(Color.magenta);
			g2d.drawString("YOUR FINAL SCORE IS: " + (s.getBody().size() - 3), FunGame.width / 2 * FunGame.dimension - 40, 
					FunGame.height / 2 * FunGame.dimension - 20);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		game.updateTheGame();
	}

}
