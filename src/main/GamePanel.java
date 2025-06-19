package main;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

// Basically JPanel with a bit more extra functions
public class GamePanel extends JPanel {
    //SCREEN SETTINGS
    final int originalTileSize = 16; //16x16 tile

    // Scaling the game to match screen size (16x16 tile size will be 48x48 tile size
    final int scale = 3;
    final int tileSize = originalTileSize * scale; // 48x48 tile

    // Screen size (horizontal and vertical)
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 16x48=768px
    final int screenHeight = tileSize * maxScreenRow; // 12x48=576px

    //GamePanel constructor
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        // Activate offscreen painting buffer for all drawing for this component before displaying on screen for the players
        // enabling this can improve game's rendering performance
        this.setDoubleBuffered(true);

    }
}
