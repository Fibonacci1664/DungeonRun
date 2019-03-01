/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davegreen.state;

import java.awt.Graphics2D;
 import java.awt.event.MouseEvent;
 
 /**
  *
  * @author Dave
  */
 public abstract class LevelState
 {
     protected LevelManager lm;
     
     public LevelState(LevelManager lm)
     {
         this.lm = lm;
     }
     
     // These abstract methods will be implemented in subclass
     public abstract void keyPressed(int keyCode);
     public abstract void keyReleased(int keyCode);
     public abstract void mouseClicked(MouseEvent mouseEvent);
    public abstract void update();
    public abstract void draw(Graphics2D g2d);
}
