import java.awt.Rectangle;

public class Food {
	private int x;
	private int y;
	
	public Food(Snake player) {
		this.random(player);
	}
	
	public void random(Snake player) {
		
		boolean onSnake = true;
		//generate random x & y and checks if the tile on the body if its not on the body this while loop ends
		while (onSnake) {
			onSnake = false;
			
			x = (int) (Math.random() * FunGame.width);
			y = (int) (Math.random() * FunGame.height);
			for(Rectangle r : player.getBody()) {
				if(r.x== x && r.y==y) {
					onSnake = true;
				}
			}
		}
		
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
