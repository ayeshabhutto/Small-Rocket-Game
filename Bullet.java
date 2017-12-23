import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Bullet - allows and creates bullets for the rocket to shoot out. 
 * 
 * @AyeshaBhutto 
 * @March/25/2017
 */
public class Bullet extends Mover
{
    public void act() {
       
        move(5); // bullet moves faster than rocket with 5 spaces 
        
        if (isAtEdge()) {
            getWorld().removeObject(this);
            // when bullet touches the edge of screen, actor removes itself from world
        }     
        
        
    }
    
    public Bullet( int direction) {
        turn(direction); // turn specififc direction that is entered 
    }
}
