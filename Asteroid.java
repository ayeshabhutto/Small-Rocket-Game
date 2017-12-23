import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Asteroid - creates an asteroid for Rocket to hit .
 * 
 * @AyeshaBhutto 
 * @March/25/2017
 */
public class Asteroid extends Mover
{
    int currentSize = 100;      // defines initial size of asteroid
    int smallestSize = 10;      // defines smallest size of asteroid 
    MyWorld currentWorld;       // defines variable for World 
    
    // creates an initial size of the asteroid    
    public Asteroid() {
        this(100);
    }
    
    public Asteroid( int sizeIn) {
        speed = Math.random()*maxspeed;
        turn ( (int) (Math.random()*360) );     // creates random turns for each asteroid
        currentSize = sizeIn;       // sizes the asteroid 
        sizeImage();
    
    }
    
    private void sizeImage() {
        if (currentSize <= smallestSize) {
            currentWorld.removeObject(this);
            // removes asteroid if the size gets smaller than the initial size 
        }
        GreenfootImage image = getImage();
        image.scale(currentSize, currentSize);
        setImage(image);        // scales and sets image according to "new" size 
    }
    
    public void scaleSize (double scaleFactor) {
        currentSize = Math.round ( (int) (currentSize*scaleFactor));    // sizes the new aseroid according to after it has been hit
    }

    public void act() 
    {
        currentWorld = (MyWorld)getWorld();     // calls the world
        moveSteadily();                         // calls moveSteadily function from mover
        
        Actor bullet;                           // defines bullet actor 
        bullet = getOneIntersectingObject(Bullet.class);
        int x = getX();         // calls x and y positions of initial asteroids 
        int y = getY();
        
        if (bullet != null) {
            if (currentSize >= 100) {
                
                // following lines create the "shatter" effect by adding smaller asteroids if the 
                // bullet hits the asteroid that is equal or greater to 100 in size 
                currentWorld.addObject( new Asteroid (50),(x-20) , (y+20));
                currentWorld.addObject( new Asteroid (50),(x+20) , (y+20));
                currentWorld.addObject( new Asteroid (50),(x-20) , (y-20));
                currentWorld.addObject( new Asteroid (50),(x+20) , (y-20));
                
                currentWorld.removeObject(this); // removes the initial asteroid 
                currentWorld.addObject( new Asteroid (), Greenfoot.getRandomNumber(550), Greenfoot.getRandomNumber(350));
                // places a new asteroid in the world when the first one is hit 
            }
            
            else if (currentSize == 50) {
                scaleSize(0.5);
                sizeImage();    // smaller peices get sized down 
            }
            
            
            else {
                currentWorld.removeObject(this); // removes any asteroids left if smaller
            }

        }
         
        currentWorld.removeObject(bullet);  // when bullet hits asteroid, removes itself from the world 
    }

        
    }    

