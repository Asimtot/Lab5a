import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class ButtonPanel extends JPanel
{
    private boolean isGameFinished;
    private String loseMessage = "You have lost";
    private String winMessage = "You have won";
    private final int WIN = 1;
    private final int LOSE = 2;
    private int attempt;
    JLabel infoMessage1;

    private JButton [] buttonGroup;
    private BombButton bomb;
    private PrizeButton prize1;
    private PrizeButton prize2;
    private JPanel infoPanel;

    public ButtonPanel()
    {
        isGameFinished = false; // Setting it the false

        // It is a info label
        infoMessage1 = new JLabel();
        attempt = 0;
        infoMessage1.setText("This is " + attempt + "th");

        // Buttons and button array
        buttonGroup = new JButton[25];
        bomb = new BombButton();
        prize1 = new PrizeButton();
        prize2 = new PrizeButton();

        prize1.addActionListener(new MouseClicked());
        prize2.addActionListener(new MouseClicked());
        bomb.addActionListener(new MouseClicked());

        buttonGroup[0] = bomb;
        buttonGroup[1] = prize1;
        buttonGroup[2] = prize2;

        addButtons();
        shuffle();

        setSize(new Dimension(500,500));
        setLayout(new GridLayout(5,5));
        addToFrame();
        setVisible(true);
    }

    public void addButtons()
    {
        for(int a = 3; a < 25; a++)
        {
            JButton holder = new JButton();
            holder.setOpaque(false);
            holder.addActionListener(new MouseClicked());
            buttonGroup[a] = holder;
        }
    }

    public void shuffle()
    {
        for(int a = 0; a < 25; a++)
        {
            int random = (int) (25 * Math.random());
            JButton holder = buttonGroup[a];
            buttonGroup[a] = buttonGroup[random];
            buttonGroup[random] = holder;
        }
    }

    public void addToFrame()
    {
        for(int a = 0; a < 25; a++)
        {
            buttonGroup[a].setText("" + (a + 1) );
            this.add(buttonGroup[a]);
        }
    }

    private class MouseClicked implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            JButton holder = (JButton) e.getSource();
            System.out.println(holder);

            if( (holder == prize1 || holder == prize2) && !isGameFinished)
            {
                System.out.println("win");
                isGameFinished = endGame(WIN);
            }

            else if(holder == bomb && !isGameFinished)
            {
                isGameFinished = endGame(LOSE);
            }
            
           
            if(!isGameFinished)
            {
                addAttempt(); // For altering the attempt
                holder.setEnabled(false);
            }

            else if(isGameFinished)
            {
                showEveryThing();
            }
           
           
        }

    }

    public static void main ( String [] args)
    {
        new Screen();
    }


    public void addAttempt()
    {
        attempt++;
        infoMessage1.setText("This is " + attempt + "th");
    }

    public boolean endGame(int a)
    {
        System.out.println("A is " + a);
        if(a == 1) 
        {
            System.out.println("It is happened");
            infoMessage1.setText(winMessage + " at " + attempt + "th");
            return true;
        }

        else if(a == 2)
        {
            infoMessage1.setText(loseMessage + " at " + attempt + "th");
            return true;
        }

        return false;
    }

    public void showEveryThing()
    {
        System.out.println("Show Everything is work");
        prize1.setText(prize1.STAR_SYMBOL);
        prize1.setEnabled(false);
        prize2.setText(prize1.STAR_SYMBOL);
        prize2.setEnabled(false);
        bomb.setColorButton(); 
    }


}
