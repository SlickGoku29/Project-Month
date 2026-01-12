package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//JAVA SWING
import javax.swing.*;
import java.awt.*;

// PLAYER SPRITE
import PlayerMovement.PlayerSprite;

public class GameScreen extends JPanel implements ActionListener, KeyListener {

    private JFrame gameFrame; // when the game launches

    private JPanel gameMenuPanel; // menu where game resides 
    private JPanel gameScreenPanel; //Lesson 6
    private JPanel buttonWrapper; //Lesson 6

    private JButton backToMainButton;

    private int panelWidth = 1280; // MAX Width
    private int panelHeight = 720; // MAX Height


    Timer t = new Timer(10,this);
    PlayerSprite p = new PlayerSprite(50, 50, 50, 50, 0, 0);

    public GameScreen() {

        t.start();
        
        initialize();

        // Example placeholder panel
        JLabel label = new JLabel("This is the New Game Screen", SwingConstants.CENTER);
        label.setFont(new Font("Times New Roman", Font.BOLD, 28));
        add(label, BorderLayout.CENTER);
    }//END GAMESCREEN

    public void initialize(){
        gameFrame = new JFrame(); //ADDED
        gameFrame.setTitle("Game Example");
        gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gameFrame.setSize(panelWidth, panelHeight);
        gameFrame.setLocationRelativeTo(null);

        // gameFrame.setLayout(new BorderLayout());

        gameMenuPanel = new JPanel();
        gameMenuPanel.setLayout(new BoxLayout(gameMenuPanel, BoxLayout.Y_AXIS));
        gameMenuPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        // gameMenuPanel.setOpaque(false);
        gameMenuPanel.setBackground(Color.BLUE);

        backToMainButton = createBackToMainButton();
        buttonWrapper = new JPanel();
        buttonWrapper.add(backToMainButton);


        backToMainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToMainScreen(backToMainButton);
            }
        });

        gameScreenPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                p.draw(g);// DRAWS UPDATED PLAYER ONTO GAMESCREEN
            }
        };

        gameScreenPanel.setBackground(Color.DARK_GRAY);
        gameScreenPanel.setFocusable(true);
        gameScreenPanel.addKeyListener(this);


        gameFrame.setLayout(new BorderLayout());

        gameFrame.add(gameScreenPanel, BorderLayout.CENTER);

        gameFrame.add(buttonWrapper, BorderLayout.WEST); 

        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(this);
        this.setBackground(Color.RED);
        
    }

    private void switchToMainScreen(JButton sourceButton){

        MainScreen runMainScreen = new MainScreen();
        runMainScreen.setVisible(true);

        JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(sourceButton);
        if (currentFrame !=null) {
            currentFrame.dispose();
        }
    }

    public JButton createBackToMainButton(){
        JButton button = new JButton("Back to Main");
        button.setFocusable(false);
        return button;
    }

    public void setVisible(boolean b) {
        gameFrame.setVisible(b);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        p.tick(gameScreenPanel.getWidth(), gameScreenPanel.getHeight());
        gameScreenPanel.repaint();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        p.draw(g);
    }

    @Override
    public void keyPressed(KeyEvent e){
        switch(e.getKeyCode()){
            //WASD MOVEMENT
            case KeyEvent.VK_W: //UP
                p.setDy(-1);
                break;
            case KeyEvent.VK_A: //LEFT
                p.setDx(-1);
                break;
            case KeyEvent.VK_S: //DOWN
                p.setDy(1);
                break;
            case KeyEvent.VK_D: //RIGHT
                p.setDx(1);
                break;

            //ARROW
            case KeyEvent.VK_UP: //UP
                p.setDy(-1);
                break;
            case KeyEvent.VK_LEFT: //LEFT
                p.setDx(-1);
                break;
            case KeyEvent.VK_DOWN: //DOWN
                p.setDy(1);
                break;
            case KeyEvent.VK_RIGHT: //RIGHT
                p.setDx(1);
                break;
        }

    }


    @Override
    public void keyReleased(KeyEvent e){
        switch(e.getKeyCode()){
            //WASD MOVEMENT
            case KeyEvent.VK_W: //UP
                p.setDy(0);
                break;
            case KeyEvent.VK_A: //LEFT
                p.setDx(0);
                break;
            case KeyEvent.VK_S: //DOWN
                p.setDy(0);
                break;
            case KeyEvent.VK_D: //RIGHT
                p.setDx(0);
                break;

            //ARROW
            case KeyEvent.VK_UP: //UP
                p.setDy(0);
                break;
            case KeyEvent.VK_LEFT: //LEFT
                p.setDx(0);
                break;
            case KeyEvent.VK_DOWN: //DOWN
                p.setDy(0);
                break;
            case KeyEvent.VK_RIGHT: //RIGHT
                p.setDx(0);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e){
        
    }

}
