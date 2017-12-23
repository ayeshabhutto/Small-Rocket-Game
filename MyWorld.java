import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * MyWorld - creates the overall background and space. 
 * 
 * @AyeshaBhutto 
 * @March/25/2017
 */
public class MyWorld extends World
{
    MyWorld currentWorld;   // defines current world 
    Button currentButton;   // defines button actor  
    int gameState;  // defines game state as an integer 
    
    
    public MyWorld()
    {    
        super(600, 400, 1, false);  // creates screen size 
        
    }
    
    public void act() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        
        switch (gameState) {
            case 0: currentButton = new Button ();
                    addObject (currentButton, 40, 370);
                    gameState = 1;
                    
                    // start screen with start button  
            
            case 1: 
                    // initialization of start screen 
                    if (mouse != null) {
                        Actor currentActor = mouse.getActor();
                        if (currentActor != null) {
                            if (currentActor.getClass() == Button.class) {
                            int mouseClickCount = mouse.getClickCount(); //sets integar variable for number of mouse clicks
                            System.out.println(mouseClickCount); // displays the values 
                                 if (mouseClickCount == 1) {
                                     gameState = 2;
                                     removeObject(currentButton);
                                  }
                            }
                        }
                    }
        
                    break;
                    
                    
            case 2:
                    // actual game screen 
                   addObject( new Rocket (), 50, 200);
                   addObject( new Asteroid (), 300, 200);
                   break;
                   
                   
            default: //gameState = 0;
            // default game state is set to 0 
        }
        
    }
}    
