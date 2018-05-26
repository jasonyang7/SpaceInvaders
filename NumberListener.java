import greenfoot.*;

/**
 * The number display on the bottom left and right corners of the screen.
 * 
 * @author Jason Yang, Sai Enduri, Krish G
 * @version 5/24/2018
 */
public class NumberListener extends Actor {
	private int value = 0;
	private String text = "";
	private int stringLength;

	/**
	 * Initializes and creates the number listener image.
	 * 
	 * @param prefix
	 *            the changed string that is passed in.
	 */
	public NumberListener(String prefix) {
		text = prefix;
		stringLength = (text.length() + 2) * 16;
		setImage(new GreenfootImage(stringLength, 24));
		GreenfootImage image = getImage();
		Font font = image.getFont();
		image.setFont(font.deriveFont(24.0F));
		image.setColor(Color.WHITE);

		updateImage();
	}

	/**
	 * Updates the image.
	 */
	public void act() {
		updateImage();
	}

	/**
	 * Adds the changed number to the existing score.
	 * 
	 * @param score
	 *            the increased score
	 */
	public void add(int score) {
		value += score;
		updateImage();
	}

	/**
	 * Subtracts the changed number from the existing score.
	 * 
	 * @param score
	 *            the increased score
	 */
	public void subtract(int score) {
		value -= score;
		updateImage();
	}

	/**
	 * Returns the value.
	 * 
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Makes the pixel representation of the number.
	 */
	private void updateImage() {
		GreenfootImage image = getImage();
		image.clear();
		image.drawString(text + value, 2, 20);
	}
}
