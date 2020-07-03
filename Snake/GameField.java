import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class GameField extends JPanel implements ActionListener{
    private final int SIZE = 600;
    private final int DOT_SIZE = 20;
    private final int ALL_DOTS = 900;
    private Integer score;
    private Image dot;
    private Image apple;
    private int appleX;
    private int appleY;
    private int[] x = new int[ALL_DOTS];
    private int[] y = new int[ALL_DOTS];
    private int dots;
    private Timer timer;
    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;
    private boolean inGame = false;
    private boolean gameStarted = false;

    ArrayList<Integer> recordsValue = new ArrayList<>();
    File recordFile = new File("C:\\Users\\User\\IdeaProjects\\lab3_snake\\src\\records.txt");
    FileWriter outWriter = new FileWriter(recordFile, true);
    Scanner readFile = new Scanner(recordFile);
    Integer record = 0;
    Integer rec1, rec2, rec3;

    public GameField() throws IOException {
        setBackground(new Color(255,255,149));
        loadImages();
        initGame();
        addKeyListener(new FieldKeyListener());
        setFocusable(true);

        readFromFile();
        getLastRecords();

    }

    void readFromFile()
    {
        while(readFile.hasNextInt())
        {
            record = readFile.nextInt();
            recordsValue.add(record);
        }

    }
    void getLastRecords()
    {
        rec1 = recordsValue.get(recordsValue.size()-1);
        rec2 = recordsValue.get(recordsValue.size()-2);
        rec3 = recordsValue.get(recordsValue.size()-3);

    }
    public void initGame(){
        score = 0;
        gameStarted = false;
        inGame = false;
        dots = 3;
        for (int i = 0; i < dots; i++) {
            x[i] = 200 - i*DOT_SIZE;
            y[i] = 200;
        }
        timer = new Timer(75,this);
        timer.start();
        createApple();

    }

    public void createApple(){
        appleX = new Random().nextInt(29)*DOT_SIZE + 40;
        appleY = new Random().nextInt(28)*DOT_SIZE + 20;
    }

    public void loadImages(){
        ImageIcon iia = new ImageIcon("apple.png");
        apple = iia.getImage();
        ImageIcon iid = new ImageIcon("dot.png");
        dot = iid.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        String str;

        if(inGame && gameStarted){
            g.drawRect(40, 20, 600, 600);
            g.drawImage(apple,appleX,appleY,this);
            for (int i = 0; i < dots; i++) {
                g.drawImage(dot,x[i],y[i],this);
            }
            str = "Score: " + score;
            Font f = new Font("Agency FB", Font.PLAIN, 20)   ;
            g.setFont(f);
            g.setColor(Color.black);
            g.drawString(str,300,50);

        }
        if(!inGame && gameStarted){
            str = "Your score: " + score;
            Font f = new Font("Agency FB", Font.BOLD, 40)   ;
            g.setFont(f);
            g.setColor(Color.black);
            g.drawString(str,240,180);

            Font ff = new Font("Agency FB", Font.PLAIN, 30)   ;
            g.setFont(ff);

            str = "Previous records";
            g.setColor(Color.black);
            g.drawString(str,260,250);
            str = "" + rec1;
            g.drawString(str,330,290);
            str = "" + rec2;
            g.drawString(str,330,320);
            str = "" + rec3;
            g.drawString(str,330,350);

            str  = "Press enter to restart";
            Font fff = new Font("Agency FB", Font.PLAIN, 30)   ;
            g.setFont(fff);
            g.setColor(Color.black);
            g.drawString(str,240,450);

        }
        if(!gameStarted){
            String restartStr = "Press space to start the game";
            Font ff = new Font("Agency FB", Font.PLAIN, 36)   ;
            g.setFont(ff);
            g.setColor(Color.black);
            g.drawString(restartStr,170,320);
        }
    }

    public void move(){
        for (int i = dots; i > 0; i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        if(left){
            x[0] -= DOT_SIZE;
        }
        if(right){
            x[0] += DOT_SIZE;
        }
        if(up){
            y[0] -= DOT_SIZE;
        }
        if(down){
            y[0] += DOT_SIZE;
        }
    }

    public void checkApple(){
        if(x[0] == appleX && y[0] == appleY){
            score++;
            dots++;
            createApple();
        }
    }

    public void saveRecord() throws IOException {
        String s = score.toString();
        outWriter.write(" " + s);
        outWriter.close();
        readFile.close();
        outWriter = new FileWriter(recordFile, true);
        readFile = new Scanner(recordFile);
    }
    public void checkCollisions(){
        for (int i = dots; i > 0 ; i--) {
            if(dots > 4 && x[0] == x[i] && y[0] == y[i]){
                inGame = false;

                if(score > record) {

                    try {
                        saveRecord();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                createApple();
            }
        }

        if(x[0] > SIZE + 20){
            inGame = false;

            if(score > record) {
                try {
                    saveRecord();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            createApple();
        }
        if(x[0] < 40){
            inGame = false;

            if(score > record) {
                try {
                    saveRecord();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            createApple();
        }
        if(y[0] > SIZE ){
            inGame = false;

            if(score > record) {
                try {
                    saveRecord();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            createApple();
        }
        if(y[0] < 20){
            inGame = false;

            if(score > record) {
                try {
                    saveRecord();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            createApple();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(inGame){
            checkApple();
            checkCollisions();
            move();
        }
        repaint();
    }

    class FieldKeyListener extends KeyAdapter{
        void repaintGame()
        {
            score = 0;
            left = false;
            right = true;
            up = false;
            down = false;
            dots = 3;
            for (int i = 0; i < dots; i++) {
                x[i] = 60 - i*DOT_SIZE;
                y[i] = 60;
            }
            readFromFile();
            getLastRecords();
        }


        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            if(inGame && gameStarted) {
                if (key == KeyEvent.VK_LEFT && !right) {
                    left = true;
                    up = false;
                    down = false;
                }
                if (key == KeyEvent.VK_RIGHT && !left) {
                    right = true;
                    up = false;
                    down = false;
                }

                if (key == KeyEvent.VK_UP && !down) {
                    right = false;
                    up = true;
                    left = false;
                }
                if (key == KeyEvent.VK_DOWN && !up) {
                    right = false;
                    down = true;
                    left = false;
                }
            }
            else if(!inGame && gameStarted)
            {
                if (key == KeyEvent.VK_ENTER) {
                    inGame = true;
                    repaintGame();
                }
                if (key == KeyEvent.VK_S)
                {
                    try {
                        outWriter.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    readFile.close();
                }
            }
            if(!inGame && !gameStarted)
            {
                if (key == KeyEvent.VK_SPACE) {
                    inGame = true;
                    gameStarted = true;
                    repaintGame();
                }
            }
        }
    }


}