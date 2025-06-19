package main;

import javax.swing.JFrame;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("2D adventure");

        // Calls our extended JPanel class -GamePanel- and add it to this window
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        GameConnectFour connectFour = new GameConnectFour();
        connectFour.Play();

        // Pack this GPanel (GamePanel) so we can see it
        window.pack();

        window.setLocationRelativeTo(null); //game window is centered to screen
        window.setVisible(true);
    }
}