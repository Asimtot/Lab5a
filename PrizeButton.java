import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PrizeButton extends JButton 
{
    public final String STAR_SYMBOL = "\u2605";
    public PrizeButton()
    {
        setPreferredSize(new Dimension(100,100));
        addActionListener(new ButtonClicked());
    }

    private class ButtonClicked implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            setForeground(Color.ORANGE);
            setText(STAR_SYMBOL);
            setOpaque(true);
            setEnabled(false);
        } 
    }

    public static void main ( String [] args)
    {
        JFrame frame = new JFrame();
        frame.add(new PrizeButton());
        frame.pack();
        frame.setVisible(true);
    }

}

   
