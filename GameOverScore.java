import greenfoot.*;

public class GameOverScore extends Actor
{
    public float fontSize = 48.0f;
    public int width = 400;
    public int height = 300;
    

    /**
     * get the score for image
     */
    public GameOverScore(int score)
    {
        makeImage("Game Over", "Score: ", score);
    }

    /**
     * create the image
     */
    private void makeImage(String title, String text, int score)
    {
        GreenfootImage image = new GreenfootImage(width, height);

        image.setColor(new Color(20, 20, 20, 160));
        image.fillRect(0, 0, width, height);
        Font font = image.getFont();
        font = font.deriveFont(fontSize);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(title, 60, 100);
        image.drawString(text + score, 60, 200);
        setImage(image);
    }
}