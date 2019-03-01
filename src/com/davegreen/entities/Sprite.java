/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davegreen.entities;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Dave
 */
public class Sprite
{
    private int stepCount;
    private int currentFrame;
    private int numOfFrames;
    private int spriteWidth;
    private int spriteHeight;
    private int animationSpeed;
    private boolean isAnimated;
    private ArrayList<BufferedImage> animation;

    public Sprite(int animationSpeed)
    {
        this.stepCount = 0;
        this.currentFrame = 0;
        this.numOfFrames = 0;
        this.spriteWidth = spriteWidth;
        this.spriteHeight = spriteHeight;
        this.animationSpeed = animationSpeed;
        this.isAnimated = false;
        this.animation = new ArrayList<>();
    }
    
    public void addFrame(BufferedImage frame)
    {
        animation.add(frame);
        
        if(animation.size() > 1)
        {
            this.isAnimated = true;
        }
    }
    
    private void update()
    {
        this.spriteWidth = animation.get(currentFrame).getWidth();      // This is set to current frame rather than 0, all sprite should techinically be the same size so its hould matter
                                                                        // unless the sprite size changes due to the animations, attacks etc.
        this.spriteHeight = animation.get(currentFrame).getHeight();
    }
    
    private BufferedImage getNextFrame()
    {
        BufferedImage frame = animation.get(currentFrame);
        
        stepCount ++;
        
        if(stepCount % animationSpeed == 0)
        {
            currentFrame ++;
        }
        
        if(currentFrame == numOfFrames)
        {
            currentFrame = 0;
        }
        
        return frame;
    }
    
    public BufferedImage getSprite()
    {
        return isAnimated ? getNextFrame() : animation.get(0);      // turnery syntax '?' queries the initial term, runs the term before the double colon if returns true, runs the term
                                                                    // after the double colon if the query returns false.
    }

    public int getSpriteWidth()
    {
        return spriteWidth;
    }

    public int getSpriteHeight()
    {
        return spriteHeight;
    }
}
