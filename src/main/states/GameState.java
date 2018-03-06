package maze.states;
/**
*
* @author Alex and Ryan
*/

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import maze.Character;
import maze.Main;
import maze.Player;

public class GameState extends State {
	
	private long lastSpawn, spawnTimer = lastSpawn, spawnCooldown = 2000;
	private int iter = 0;
	private Player player;
	private Character pc;
	private Main main;
	
	public GameState(Main main) {
        super(main);
        this.main = main;
        player = main.getPlayer();
        pc = main.getCharacter();
	}
	
	public void update() {
		while(pc.getdistToEnd() != (int)0) {
			
		}
	}
	/*
    public static double k = 8987552787.37;
    public static double e = -1.60217662 * Math.pow(10, -19);

    public static double masse = 9.10938356 * Math.pow(10, -31);
    public static double massp = 1.6726219 * Math.pow(10, -27);

    private ArrayList<Charge> charges = new ArrayList();
    private long lastSpawn, spawnTimer = lastSpawn, spawnCooldown = 2000;
    private int iter = 0;

    private Player player;
    
    private Main main;

    public GameState(Main main) {
        super(main);
        for (int i = 0; i < 2; i++) {
            charges.add(new Charge(Math.random() * 1070, Math.random() * 710, e, masse));
        }
        this.main = main;
        player = main.getPlayer();
    }

    @Override
    public void update() {
        double maxdm = 0;
        for (int i = 0; i < charges.size(); i++) {
            for (int j = 0; j < charges.size(); j++) {
                if (j != i) {
                    double d = Math.sqrt(Math.pow(charges.get(i).getX() - charges.get(j).getX(), 2)
                            + Math.pow(charges.get(i).getY() - charges.get(j).getY(), 2));
                    double theta = Math.atan2(charges.get(i).getX() - charges.get(j).getX(),
                            charges.get(i).getY() - charges.get(j).getY());
                    if (theta < 0) {
                        theta += 2 * Math.PI;
                    }
                    double magnitude = (k * Math.abs(charges.get(i).getCharge())
                            * Math.abs(charges.get(j).getCharge())) / (Math.pow(d, 2) * charges.get(j).getMass());
                    if (charges.get(i).getCharge() <= 0 && charges.get(j).getCharge() <= 0) {
                        magnitude *= -1;
                    }
                    if (charges.get(i).getCharge() >= 0 && charges.get(j).getCharge() >= 0) {
                        magnitude *= -1;
                    }
                    charges.get(j).setAx(magnitude * Math.sin(theta));
                    charges.get(j).setAy(magnitude * Math.cos(theta));
                    if (charges.get(j).collision(charges.get(i).getX(), charges.get(i).getY(), charges.get(i).getRadius())) {
                        if (charges.get(i).getCharge() != charges.get(j).getCharge()) {
                            if (charges.get(i).getCharge() > 0) {
                                double vx = (charges.get(i).getVX() * charges.get(i).getMass()
                                        + charges.get(j).getVX() * charges.get(j).getMass()) / (charges.get(i).getMass() + charges.get(j).getMass());
                                double vy = (charges.get(i).getVY() * charges.get(i).getMass()
                                        + charges.get(j).getVY() * charges.get(j).getMass()) / (charges.get(i).getMass() + charges.get(j).getMass());
                                charges.remove(i);
                                charges.add(new Charge(charges.get(j).getX(), charges.get(j).getY(), 0, masse));
                                charges.get(charges.size() - 1).setVX(vx);
                                charges.get(charges.size() - 1).setVY(vy);
                            }
                        }
                    }
                    double dx = Math.sqrt(Math.pow(charges.get(i).getX() - charges.get(j).getX(), 2));
                    double dy = Math.sqrt(Math.pow(charges.get(i).getY() - charges.get(j).getY(), 2));
                    double dm = Math.sqrt(Math.pow(charges.get(i).getX() - dx, 2)
                            + Math.pow(charges.get(i).getY() - dy, 2));
                    if (dm > maxdm) {

                    }
                }
            }
        }
        for (Charge c : charges) {
            c.update();
        }

        for (int i = 0; i < charges.size(); i++) {
            if (player.collision(charges.get(i).getX(), charges.get(i).getY(), charges.get(i).getRadius())) {
                if (charges.get(i).getCharge() < 0) {
                    if(main.getScore()>main.getMaxScore()){
                        main.setMaxScore(main.getScore());
                    }
                    State.setState(main.getEndMenuState());
                } else if (charges.get(i).getCharge() > 0) {
                    main.setScore(main.getScore() + 100);
                    charges.remove(i);
                    charges.remove(0);
                } else {
                    main.setScore(main.getScore() + 20);
                    charges.remove(i);
                }
            }
        }

        spawnTimer += System.currentTimeMillis() - lastSpawn;
        lastSpawn = System.currentTimeMillis();
        if (spawnTimer > spawnCooldown) {
            charges.add(new Charge(Math.random() * 1070, Math.random() * 710, e, masse));
            iter++;
            if (iter >= 3) {
                iter = 0;
                charges.add(new Charge(Math.random() * 1070, Math.random() * 710, -e, massp));
            }
            spawnTimer = 0;
        }

        main.setScore(main.getScore() + 0.01);
    }
    
    @Override
    public void render(Graphics g) {
        for (Charge c : charges) {
            c.render(g);
        }
        player.render(g);

        g.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        g.setColor(Color.white);
        g.drawString(("Score: " + Integer.toString((int) main.getScore())), 0, 18);
    }

    @Override
    public void reloadState() {
        charges.removeAll(charges);
        for (int i = 0; i < 2; i++) {
            charges.add(new Charge(Math.random() * 1070, Math.random() * 710, e, masse));
        }
        main.setScore(0);
    }
    */
}
