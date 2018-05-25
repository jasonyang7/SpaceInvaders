import greenfoot.*;

/**
 * Keeps track of the user's score.
 * 
 * @author Jason Yang, Sai Enduri, Krish G
 * @version 5/24/2018
 */
public class GameOverScore extends Actor {
	public static final float FONT_SIZE = 48.0f;
	public static final int WIDTH = 400;
	public static final int HEIGHT = 300;

	/**
	 * Creates a score board with dummy result for testing.
	 */
	public GameOverScore() {
		this(100);
	}

	/**
	 * Creates a score board for the final result.
	 */
	public GameOverScore(int score) {
		makeImage("Game Over", "Score: ", score);
	}

	/**
	 * Makes the score board image.
	 */
	private void makeImage(String title, String prefix, int score) {
		GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);
		image.setColor(new Color(20, 20, 20, 160));
		image.fillRect(0, 0, WIDTH, HEIGHT);
		Font font = image.getFont();
		font = font.deriveFont(FONT_SIZE);
		image.setFont(font);
		image.setColor(Color.WHITE);
		image.drawString(title, 60, 100);
		image.drawString(prefix + score, 60, 200);
		setImage(image);
	}
}
