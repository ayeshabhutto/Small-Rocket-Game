import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Rocket - creates rocket actor to move with keybaord keys. 
 * 
 * @AyeshaBhutto 
 * @March/25/2017
 */
public class Rocket extends Mover
{
    int moving = 1;    
    
    
    public void act() 
    {
        
        moveSteadily();     // calls moveSteadily void 
        currentWorld = (MyWorld) getWorld(); // defines and calls MyWorld
        
         
        move( (int)moving);     // rocket starts off moving 
            

        if (Greenfoot.isKeyDown("right")) {    
          System.out.println("The right key was pressed"); 
          moving = 0;       // stops moving 
          
          if (speed < maxspeed) {
              speed = speed + speed*acceleration;
            } 
           // acceleration of the rocket is stopped until speed reaches 0
           // this way the rocket will not move too fast
        move ( (int) speed );  
        }
        // rocket will move with defined speed 

        if (Greenfoot.isKeyDown("left")) {
            System.out.println("The left key was pressed");
            moving = 0;
            move ( -(int)speed );
        }
        // when the left arrow key is pressed, the bear will move backwards with the same speed 

        if (Greenfoot.isKeyDown("down")) {  
            System.out.println("The down key was pressed");
            turn (5);
        }
        // when the down arrow key is pressed, the bear will rotate by 5 degrees down 
        
        if (Greenfoot.isKeyDown("up")) {
            System.out.println("The down key was pressed");
            turn (-5);
        }
        
        // when the up arrow key is pressed, the bear will rotoate by 5 degrees up (defined with a negative value)  
        
        if (Greenfoot.isKeyDown("space")) {
            if (currentWorld.getObjects( Bullet.class ).isEmpty() ) {
            currentWorld.addObject( new Bullet ( getRotation() ), getX(), getY());
            }
            // when space key is pressed, rocket will "shoot out" new bullet in the same x and y directions
         }    
    }
}
