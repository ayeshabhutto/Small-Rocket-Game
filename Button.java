import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button - creates a button for game to start. 
 * 
 * @AyeshaBhutto 
 * @March/25/2017
 */
public class Button extends Actor
{
    boolean buttonState = false;    // main state of button is false 
    String buttonText = "Start";    // button is called Reset 
    
    public Button() {
        buttonOff();
    }
    // sets void for when button is not clicked 
    
    public void buttonOff() {
        // when button is false, it has the following colored characteristics
        GreenfootImage buttonImage = new GreenfootImage(buttonText, 20, Color.CYAN, Color.BLACK);
        setImage (buttonImage);
        buttonState = false; // button is false when off 
        
        
    }
    
}
