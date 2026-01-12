package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MainScreen {
    private JFrame mainFrame; // when the game launches 
    private JPanel mainMenuPanel; // menu where game resides 
    private JPanel additionalPanel; 

    private int panelWidth = 1280; // MAX Width
    private int panelHeight = 720; // MAX Height

    // To run the Main Screen
    public MainScreen( ){ 
        initialize();
        mainMenuPanel = new JPanel(new BorderLayout()) {
            private final Image bg =
                    new ImageIcon("IMAGE PATH HERE").getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
            }
        };
        
    }
    
    // Where the MainScreen feature live
    public void initialize() { 
    	
/*    	// --------> JAVA SWING - LESSON 2 - Set up the MainScreen
 *         Create JFrame
 *         Create aspects of the main screen 
 *         Connect MS features 
 *         Add BKG to MainScreen
*/
    	
        // --------> STEP 1: Create JFrame, a window that launches the application ( LESSON 2 )
        mainFrame = new JFrame();
        mainFrame.setTitle("GameExample Launcher");
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // ➡️ ---> REPLACE <--- ⬅️ 
        mainFrame.setMinimumSize(new Dimension(panelWidth, panelHeight)); // Prevents the user from making the frame too small
        // mainFrame.setSize(panelWidth, panelHeight); // 16:9 Ratio OR 1920 x 1080   
        mainFrame.setLocationRelativeTo(null);

        // --------> STEP 2: Create JPanel, houses objects for the screen ( LESSON 2 )
        mainMenuPanel = new JPanel();
        mainMenuPanel.setBackground(Color.BLUE); 
        
        // ⭐ --------> EXTRA FLAIR: Set preferred width / height ( LESSON 2 )
        mainMenuPanel.setPreferredSize(new Dimension(500, 250)); // Sets preferred width to 200, height to 150

        // ⭐ --------> EXTRA FLAIR: Adding an extra panel ( LESSON 2 )
        additionalPanel = new JPanel(); 
        additionalPanel.setBackground(Color.RED);

        // ⭐ --------> EXTRA FLAIR: Adding words to the panels ( LESSON 2 )
        JLabel myLabel = new JLabel("Hello~ Human (づ ◕‿◕ )づ"); 
        myLabel.setFont(new Font("San Serif", Font.BOLD, 20)); 
        myLabel.setForeground(Color.WHITE);
        additionalPanel.add(myLabel); 

    // ------------------- LESSON 3 - MENU BUTTONS UPDATED ( VERSION 2 ) { instructor provides } ------------------- //

	// --------> STEP 1: Create the buttons

        JButton gameScreenButton = createButton(
        		" N E W  G A M E ",
        		KeyEvent.VK_S,
        		"New Game Button", 
        		"New Game Button clicked!"
        		);

        // --------> STEP 3: Give the GAME BUTTON some action 
	    // --------> 🔥Specific location where the button goes
        // --------> 🖥️ This action takes you to a new screen
        gameScreenButton.addActionListener(e -> {
            System.out.println("New Game button clicked!");
            new GameScreen().setVisible(true); // Opens the new screen
            mainFrame.dispose(); // Closes the main menu
        });

        JButton settingsScreenButton = createButton(
        		" S E T T I N G S ",
        		KeyEvent.VK_S,
        		"Settings Button", 
        		"Settings button clicked!"
        		);

        // --------> STEP 3: Give the SETTING BUTTON some action 

        JButton creditScreenButton = createButton(
        		" C R E D I T S ",
        		KeyEvent.VK_R,
        		"Credits Button", 
        		"Credits button clicked!"
        		);

        // --------> STEP 3: Give the CREDIT BUTTON some action 

        // --------> STEP 2: Add the buttons to the menu panel    
        mainMenuPanel.add(gameScreenButton);
        mainMenuPanel.add(settingsScreenButton);
        mainMenuPanel.add(creditScreenButton);

        // ------------------- SET CONTENT PANEL TO FRAME ------------------- //
        // --------> LESSON 1: Position the menu where you need it  
        mainFrame.add(mainMenuPanel, BorderLayout.CENTER); // adds the panel to the frame but Center
        mainFrame.add(additionalPanel, BorderLayout.WEST); // adds the panel to the frame but West
        mainFrame.add(mainMenuPanel);
        show(); 
    }// END INITIALIZE
    
    // SHOW GAME
    public void show() {
		this.mainFrame.setVisible(true);
	}// END SHOW  
    
    // ------------------- LESSON 3 - MENU BUTTONS UPDATED ( VERSION 2 ) { instructor provides } ------------------- //
    private JButton createButton(String buttonText, int mnemonicKey, String toolTipMEssgae, String clickMessage) {
	    // LOAD and SCALE Button Image
	    // ImageIcon buttonImage = new ImageIcon(imagePath);
	    int newWidth = 300;
	    int newHeight = 75;
	   
	    // Image scaledImage = buttonImage.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
	    // ImageIcon buttonIcon = new ImageIcon(scaledImage);
	    
	    // Create the button
            // JButton button = new JButton(buttonImage);
	    JButton button = new JButton();
	    button.setText(buttonText);
	    button.setForeground(Color.WHITE);
	    button.setPreferredSize(new Dimension(newWidth + 5, newHeight + 5));
	    
	    // Button Text Position
	    button.setVerticalTextPosition(SwingConstants.CENTER);
	    button.setHorizontalTextPosition(SwingConstants.CENTER);
	    
	    // Button appearance (image-skin)
	    button.setBorderPainted(false);
	    button.setContentAreaFilled(false);
	    button.setFocusPainted(false);
	    button.setOpaque(false);
	    
	    // Mnemonic (keyboard shortcut)
	    button.setMnemonic(mnemonicKey);
	    
	    // Tooltip (auto-generated from message)
	    button.setToolTipText(toolTipMEssgae);
	    
	    // --------> 👔 BUTTON STYLE
	    button.setFont(new Font("Times New Roman", Font.PLAIN, 24)); // Button Font
	    button.setMargin(new Insets(10, 10, 10, 10)); // Button spacing from other buttons
	    
	    // --------> 😈 BUTTON ACTION🔥// Univeral Action Behavior - Styling / Effects
	    button.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            System.out.println(clickMessage);
	        }
	        
	    });
	    
	    // Hover effect (italic + cursor change)
	    button.addMouseListener(new java.awt.event.MouseAdapter() {
	        @Override
	        public void mouseEntered(java.awt.event.MouseEvent evt) {
	            button.setCursor(new Cursor(Cursor.HAND_CURSOR));
	            button.setFont(button.getFont().deriveFont(Font.ITALIC | Font.BOLD));
	        }
	        @Override
	        public void mouseExited(java.awt.event.MouseEvent evt) {
	            button.setForeground(Color.WHITE);
	            button.setFont(button.getFont().deriveFont(Font.BOLD));
	        }
	    });
	    return button;
	}// END CREATE BUTTON
    
    public void setVisible(boolean b) {
        mainFrame.setVisible(b);
    }
}// END CLASS