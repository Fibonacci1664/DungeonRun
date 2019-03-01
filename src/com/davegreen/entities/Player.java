/**
 * Player - represents the player in the game
 */
package com.davegreen.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.HashMap;
import com.davegreen.entities.GameObject;

/**
 *  
 * 
 */
public class Player extends GameObject
{
    private int health;
        
    private double xSpeed = 1.9;
    private double gravity = 0;

    // Displacement from current X and Y
    private double dx;
    private double dy;
        
    private int countDown = 0;
    //Sprites and Animations
    //0 up, 1 down, 2 left, 3 right
    
    private HashMap<String, Sprite> animations = new HashMap();
    

    
    // Player States
    // Simple implementation of a state machine
    private boolean STANDING;
    private boolean MOVE_LEFT;
    private boolean MOVE_RIGHT;
    private boolean JUMP;
    private boolean ATTACK;
    private boolean BLOCKED_X;
    private boolean BLOCKED_Y;
    private boolean FALLING;
    
    private final double GRAVITY = 1.2;
    
    public Player()
    {        
        x = 100; // This should be changed so that the start coordinates are passed into the object
        y = 200;
        dx = 0;
        dy = 0;
        
        FALLING = true;
    }
    
    public void setAnimations(String direction, Sprite s)
    {
        // Add code to set the animations
        
        animations.put(direction, s);
        
        if(direction.equals("STATIC"))
        {
            sprite = s;
            cHeight = s.getSpriteHeight();
            cWidth = s.getSpriteWidth();
        }
    }
    
    @Override
    public void update()
    {
        double checkX;
        double checkY;
        double tempX;
        double tempY;
        int currentRow;
        int currentCol;
                
        checkX = x + dx;
        checkY = y + dy;
       
        tempX = x;
        tempY = y;
        
        if(dx < 0)
        {
            if(cTopLeft || cBottomLeft)
            {
                System.out.println("Collision Left");
                tempX = x; // Reset X position
            }else
            {
                tempX += dx;
            }
        }
           
        if(dx > 0)
        {
            if(cTopRight || cBottomRight)
            {
                System.out.println("Collision Right");
                tempX = x; // Reset X position                
            } else
            {
                tempX += dx;
            }
        }
        
        if(dy < 0)
        {
            if(cTopRight || cTopLeft)
            {
                System.out.println("Collision Top");
                tempY = y;  // Reset Y position
            }else
            {
                tempY += dy;
            }
        }
                  
        if(cBottomLeft || cBottomRight)
        {
            System.out.println("Collision Bottom");
            tempY = y;
            FALLING = false;
        }else
            FALLING = true;
        
        if(JUMP)
        {
            tempY-=25;
            JUMP = false;            
        }else if(countDown > 0)
        {
            tempY -=25;
            countDown--;
        }
        
        if(FALLING)
        {
            gravity = GRAVITY;
        }else
        {
            gravity = 0;
        }        
                  
        x=tempX;        
        y=tempY;
        
        //Apply gravity
        y+= gravity;
    }

    @Override
    public void draw(Graphics2D g)
    {
        g.setColor(Color.yellow);

        if(MOVE_RIGHT)
        {
            sprite = animations.get("RIGHT");
        }
        else if(MOVE_LEFT)
        {
            sprite = animations.get("LEFT");
        }
        else if(STANDING)
        {
            sprite = animations.get("STATIC");
        }
        
        super.draw(g);
    }
    
    public void moveLeft(boolean move)
    {
        if(move == true)
        {        
            MOVE_LEFT = true;
            dx = -xSpeed;
        }else
        {
            STANDING = true;
            MOVE_LEFT = false;
            dx = 0;
        }
    }
    
    public void moveRight(boolean move)
    {
        if(move == true)
        {
            MOVE_RIGHT = true;
            dx = xSpeed;
        }else
        {
            STANDING = true;
            MOVE_RIGHT = false;
            dx = 0;
        }   
    }
    
    public void jump()
    {
      if(FALLING == false)
      {
          JUMP = true;        
          countDown = 5;
      }
    }
    
    public void checkEnemyCollisions(Enemy[] enemies)
    {
        for(Enemy current: enemies)
        {
            
            
            // We have a collision
            // What do we do next?
          
            if(intersects(current))
            {
                
            }
        }
    }
    
    public void checkCollectableCollisions(Collectable[] collectables)
    {
        for(Collectable current: collectables)
        {
            if(intersects(current))
            {
                
            }
        }
    }
    
    public void setHealth(int health)
    {
        this.health = health;
    }
    
    public int getHealth()
    {
        return this.health;
    }
}