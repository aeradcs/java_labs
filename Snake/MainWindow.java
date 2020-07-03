import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainWindow extends JFrame {

    GameField gameField = new GameField();
    public MainWindow() throws IOException {

        setTitle("Змейка");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(700,700);
        setLocation(400,100);
        add(gameField);
        setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        MainWindow mw = new MainWindow();
    }
}