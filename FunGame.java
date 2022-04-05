import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class FunGame 
implements KeyListener{
	
	private Snake player;
	private Food food;
	private Graphics graphics;
	private JFrame window;
	public static final int width = 30;
	public static final int height = 30;
	public static final int dimension = 20; 
	
	public FunGame() {
		window = new JFrame();
		player = new Snake();
		food = new Food(player);
		graphics = new Graphics(this);
		
		window.setResizable(false);
		window.add(graphics);
		window.setTitle(" Bring back the old ");
		window.setSize(width * dimension + 2, height * dimension +4);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	//creat the X on the window
		
		
		
	}
	
	public void start() {
		graphics.state = "RUNNING";
	}
	
	public void updateTheGame() {
		if(graphics.state == "RUNNING") {
			 if(checkFoodCollsion()) {
				 player.grow();
				 food.random(player);
			 }
			 else if(checkWallCollsion() || selfCheckCollsion()) {
				 graphics.state = "END";
			 }
			 else {
				 player.move();
			 }
		}
	}
	
	//checking if you die
	private boolean checkWallCollsion() {
		if(player.getX() < 0 || player.getX()>= width * dimension 
				|| player.getY() < 0 || player.getY() >= height * dimension ) {
			return true;
		}
		return false;
	}
	
	
	private boolean checkFoodCollsion() {
		if(player.getX() == food.getX() * dimension && player.getY() == food.getY() * dimension ) {
			return true;
		}
		return false;
	}
	
	
	
	private boolean selfCheckCollsion() {
		for(int i = 1; i < player.getBody().size(); i++) {
			if(player.getX() == player.getBody().get(i).x && player.getY() == player.getBody().get(i).y) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void keyTyped(KeyEvent e) {	
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		//moving the snake
		int KeyCode = e.getKeyCode();
				
		if(graphics.state == "RUNNING") {
			if(KeyCode == KeyEvent.VK_UP && player.getMove() != "DOWN") {
				player.up();
			}
		
			if(KeyCode == KeyEvent.VK_DOWN && player.getMove() != "UP") {
				player.down();
			}
		
			if(KeyCode == KeyEvent.VK_LEFT && player.getMove() != "RIGHT") {
				player.left();
			}
		
			if(KeyCode == KeyEvent.VK_RIGHT && player.getMove() != "LEFT") {
				player.right();
			}

		}
		else {
			this.start();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	public Snake getPlayer() {
		return player;
	}

	public void setPlayer(Snake player) {
		this.player = player;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public JFrame getWindow() {
		return window;
	}

	public void setWindow(JFrame window) {
		this.window = window;
	}

	
}
