/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davegreen.state;

import com.davegreen.entities.Collectable;
import com.davegreen.entities.Enemy;
import com.davegreen.entities.Player;
import com.davegreen.entities.Sprite;
import com.davegreen.entities.SpriteLoader;
import com.davegreen.main.LevelPanel;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;



/**
 *
 * @author Dave
 */
public class Level_1 extends LevelState
{
    // Declare characetrs and objects.
    private Player player;
    private boolean win;
    
    // Enemies
    private Enemy[] enemies;
    
    // Collectables
    private Collectable[] collectables;
    
    public Level_1(LevelManager lm)
    {
        super(lm);
        player = new Player();  // This line will change when we define a character class.
        
        win = false;
        init();
//        initEnemies();
//        initCollectables();

        loadPlayerResources();
    }
    
    private void init()
    {
        
    }
    
    private void loadPlayerResources()
    {
        Sprite s;
        SpriteLoader sm = new SpriteLoader("/Images/Animation_frames/Level_1/character");
        s = sm.loadFileSequence("walk_right", 6, "png");
        player.setAnimations("RIGHT", s);
        s = sm.loadFileSequence("walk_left", 6, "png");
        player.setAnimations("LEFT", s);
        s = sm.loadFileSequence("static", 1, "png");
        player.setAnimations("STATIC", s);
        
    }
    
//    private void initEnemies()
//    {
//        enemies = new Enemy[5];
//        
//        for (int i = 0; i < enemies.length; i++)
//        {
//            enemies[i] = new Enemy("/Images/enemy.png");
//        }
//    }
    
//    private void initCollectables()
//    {
//        collectables = new Collectable[5];
//        
//        for (int i = 0; i < collectables.length; i++)
//        {
//            collectables[i] = new Collectable("/Images/collectable.png");
//        }
//    }

    @Override
    public void keyPressed(int keyCode)
    {
        if(keyCode == KeyEvent.VK_A)
        {
            player.moveLeft(true);
        }
        if(keyCode == KeyEvent.VK_D)
        {
            player.moveRight(true);
        }
    }

    @Override
    public void keyReleased(int keyCode)
    {
        if(keyCode == KeyEvent.VK_A)
        {
            player.moveLeft(false);
        }
        if(keyCode == KeyEvent.VK_D)
        {
            player.moveRight(false);
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent mouseEvent)
    {
        System.out.println("########################################### MouseX pos is " + mouseEvent.getPoint().toString());
        if(mouseEvent.getButton() == MouseEvent.BUTTON1);
    }

    @Override
    public void update()
    {
        player.update();
//        player.checkEnemyCollisions(enemies);
//        player.checkCollectableCollisions(collectables);
        // Update computer moves.
        // Check collisions.
        // Other updates.
    }

    @Override
    public void draw(Graphics2D g2d)
    {
        g2d.setColor(Color.BLUE);
        g2d.fillRect(0, 0, LevelPanel.PANEL_WIDTH, LevelPanel.PANEL_HEIGHT);
        
        // Draw player.
        
        player.draw(g2d);
        
        // Draw enemies.
        
//        for (int i = 0; i < enemies.length; i++)
//        {
//            enemies[i].draw(g2d);
//        }
//        
//        // Draw collectbles
//        
//        for (int i = 0; i < collectables.length; i++)
//        {
//            collectables[i].draw(g2d);
//        }
    }

//    private SpriteLoader SpriteLoader(String imagesAnimation_framesLevel_1character)
//    {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
