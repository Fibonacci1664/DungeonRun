/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davegreen.state;

import com.davegreen.state.LevelState;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

/**
 *
 * @author Dave
 */
public class LevelManager
{
    private LevelState[] gameStateList; // Polymorphism, can represent any level.
    private int currentState;
    
    // Declare static variable to represent our levels
    // We can call these from elsewhere in the program (not all will be used);
    public static final int MENU_SCREEN = 0;
    public static final int LEVEL_1 = 1;
    public static final int LEVEL_2 = 0;
    public static final int VICTORY_SCREEN = 0;
    public static final int DEATH_SCREEN = 0;
    
    public LevelManager()
    {
        currentState = 0; // This will noramlly be set outside
        gameStateList = new LevelState[5];
        
        // Add levels to the level manager array (wont work until levels are done.
        //gameStateList[0] = new Menu(this);
        gameStateList[0] = new Level_1(this);
        // Continue adding levels as appropriate.
    }
    
    public void update()
    {
        gameStateList[currentState].update();
    }
    
    public void goToState(int state)
    {
        this.currentState = state;
    }
    
    public void nextState()
    {
        this.currentState ++;
    }
    
    public void previousState()
    {
        this.currentState --;
    }
    
    public void updateScreenBuffer(Graphics2D g2d)
    {
        gameStateList[currentState].draw(g2d);
    }
    
    public void keyPressed(int keyCode)
    {
        gameStateList[currentState].keyPressed(keyCode);
    }
    
    public void keyReleased(int keyCode)
    {
        gameStateList[currentState].keyReleased(keyCode);
    }
    
    public void mouseClicked(MouseEvent mouseEvent)
    {
        gameStateList[currentState].mouseClicked(mouseEvent);
    }
    
    public void setCurrentState(int state)
    {
        this.currentState = state;
    }
    
    public int getCurrentState()
    {
        return this.currentState;
    } 
}
