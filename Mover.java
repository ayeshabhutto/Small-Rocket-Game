import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Mover - main actor that allows all subclasses to function efficiently. 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mover extends Actor
{
    double speed = 1.0;      // defines speed variable  
    double maxspeed = 10;   // defines maximum speed       
    double acceleration = 0.15; //defines accerlation  
    
    MyWorld currentWorld; // defines world 
    
    public void moveSteadily() {
          // following commands allow actors to move across walls 
        if(getX() > 650) {
            setLocation(-70, getY());  // rocket passes through right side of walls of world
                                       // and wraps around to other side 
        }
        
        else if (getX() < -70) {
            setLocation(650, getY()); // rocket passes through left side of walls 
                                      // and wraps to other side 
        }
        
        else if (getY() > 450) {
            setLocation(getX(), -70);   // rocket passes through lower walls
                                        // and wraps to other side 
        }
        
        else if (getY() < -70){
            setLocation(getX(), 450);   // rocket passes through upper walls and wraps around
        }
    }

    
    public void act() 
    {
    }    
}
