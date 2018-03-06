package maze;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import maze.states.*;

/**
 *
 * @author Alex
 */
public class Main extends Loop{
   
    private Display display;
    private BufferStrategy bs;
    private Graphics g;
    public static int width, height;
    
    public static final String VERSION = "V. Alpha 1.0";
    
    private double score=0;
    private double maxScore=0;
    
    private State startMenuState;
    private State gameState;
    private State endMenuState;
    private State diffMenuState;
    private State pauseMenuState;
    private State howToMenuState;
    private State creditsState;
    private State settingsMenuState;
    private State saveLoaderState;
    
    private Player player;
    private Character pc = new Character();
    
    @Override
    public void startup() {
        width = 1080;
        height = 720; 
        display = new Display("Chasey Atom", width, height);
        
        player = new Player();
        
        startMenuState = new StartMenuState(this);
        gameState = new GameState(this);
        endMenuState = new EndMenuState(this);
        diffMenuState = new DiffMenuState(this);
        pauseMenuState = new PauseMenuState(this);
        howToMenuState = new HowToMenuState(this);
        creditsState = new CreditsState(this);
        settingsMenuState = new SettingsMenuState(this);
        saveLoaderState = new SaveLoaderState(this);
        
        State.setState(startMenuState);
        
        display.getFrame().addMouseMotionListener(player);
        display.getCanvas().addMouseMotionListener(player);
        display.getFrame().addMouseListener(player);
        display.getCanvas().addMouseListener(player);
        
    }

    @Override
    public void shutdown() {
        
    }

    @Override
    public void update() {
        State.getState().update();
    }
    
    @Override
    public void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0, 0, width, height);
        
        g.setColor(new Color(135, 165, 255));
        g.fillRect(0, 0, width, height);
        
        State.getState().render(g);
        
        bs.show();
        g.dispose();
    }
    
    public double getScore(){return score;}
    public void setScore(double score){this.score = score;}
    public double getMaxScore(){return maxScore;}
    public void setMaxScore(double score){this.maxScore = score;}
    
    public Player getPlayer(){return player;}
    public Character getCharacter() {return pc;}
    
    public State getStartMenuState(){return startMenuState;}
    public State getGameState(){return gameState;}
    public State getEndMenuState(){return endMenuState;}
    public State getDiffMenuState() {return diffMenuState;}
    public State getPauseMenuState() {return pauseMenuState;}
    public State getHowToMenuState() {return howToMenuState;}
    public State getCreditsState() {return creditsState;}
    public State getSettingsMenuState() {return settingsMenuState;}
    public State getSaveLoaderState() {return saveLoaderState;}
}
