package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class MainScreen {

    private JFrame gameFrame;
    private JPanel mainMenuPanel;
    private JPanel additionalPanel;
    private JPanel mainScreenPanel;

    private final int panelWidth = 1280;
    private final int panelHeight = 720;

    public MainScreen() {
        initialize();
    }

    public void initialize() {

        // -------- FRAME --------
        gameFrame = new JFrame("GameExample Launcher");
        gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gameFrame.setMinimumSize(new Dimension(panelWidth, panelHeight));
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setLayout(new BorderLayout());

        // -------- BACKGROUND PANEL --------
        mainScreenPanel = new JPanel(new BorderLayout()) {
            private final Image bg = new ImageIcon("src/resources/bkg/Persona3roof.png").getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
            }
        };

        // -------- MENU PANEL --------
        mainMenuPanel = new JPanel();
        mainMenuPanel.setOpaque(false);
        mainMenuPanel.setPreferredSize(new Dimension(500, 250));

        // -------- SIDE PANEL --------
        additionalPanel = new JPanel();
        additionalPanel.setBackground(Color.LIGHT_GRAY);

        JLabel myLabel = new JLabel("Hello~ Human (づ ◕‿◕ )づ");
        myLabel.setFont(new Font("Sans Serif", Font.BOLD, 20));
        myLabel.setForeground(Color.WHITE);
        additionalPanel.add(myLabel);

        // -------- BUTTONS --------
        JButton gameButton = createButton(
                " N E W  G A M E ",
                KeyEvent.VK_N,
                "New Game",
                "New Game button clicked!"
        );

        gameButton.addActionListener(e -> {
            new GameScreen().setVisible(true);
            gameFrame.dispose();
        });

        JButton settingsButton = createButton(
                " S E T T I N G S ",
                KeyEvent.VK_S,
                "Settings",
                "Settings button clicked!"
        );

        JButton creditsButton = createButton(
                " C R E D I T S ",
                KeyEvent.VK_C,
                "Credits",
                "Credits button clicked!"
        );

        mainMenuPanel.add(gameButton);
        mainMenuPanel.add(settingsButton);
        mainMenuPanel.add(creditsButton);

        // -------- ASSEMBLE --------
        mainScreenPanel.add(mainMenuPanel, BorderLayout.CENTER);
        mainScreenPanel.add(additionalPanel, BorderLayout.WEST);

        gameFrame.setContentPane(mainScreenPanel);
        show();
    }

    public void show() {
        gameFrame.setVisible(true);
    }

    private JButton createButton(String text, int mnemonic, String tooltip, String clickMessage) {

        JButton button = new JButton(text);
        button.setForeground(Color.WHITE);
        button.setPreferredSize(new Dimension(305, 80));
        button.setFont(new Font("Times New Roman", Font.BOLD, 24));

        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(false);

        button.setMnemonic(mnemonic);
        button.setToolTipText(tooltip);

        button.addActionListener(e -> System.out.println(clickMessage));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e) {
                button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                button.setFont(button.getFont().deriveFont(Font.ITALIC | Font.BOLD));
            }

            public void mouseExited(java.awt.event.MouseEvent e) {
                button.setFont(button.getFont().deriveFont(Font.BOLD));
            }
        });

        return button;
    }
}