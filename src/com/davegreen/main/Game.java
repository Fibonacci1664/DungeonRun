/*
 * This class manages the game window and level panel.
 */

package com.davegreen.main;

import javax.swing.JFrame;

/**
 *
 * @author Dave
 */
public class Game
{
    public static final int WINDOW_WIDTH = 800; // This is public so other parts of the game can access it.
    public static final int WINDOW_HEIGHT = 600; // This is public so other parts of the game can access it.
    private static final String TITLE = "Bit Coin Boy!"; // This is public so other parts of the game can access it.
    
    private JFrame mainWindow;
    private LevelPanel lp;
    
    public Game()
    {
        initGame();
        initComponents();
        initWindow();
        
        lp.startGame();
    }
    
    /*
     * This initializes the game realated objects
     */
    private void initGame()
    {
        lp = new LevelPanel();
        mainWindow = new JFrame();       
    }
    
    /*
     * This initilizes the other GUI components such as buttons or menus
     */
    private void initComponents()
    {
        mainWindow.add(lp);
    }
    
    private void initWindow()
    {
        mainWindow.setTitle(Game.TITLE);
        mainWindow.setSize(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);
        mainWindow.setResizable(false);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setVisible(true);
    }
}
