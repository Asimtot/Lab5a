import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class BombButton extends JButton
{
    JComponent component;
    public BombButton()
    {
        //addActionListener(new ButtonClicked1());
        component = new JComponent()
        {
            public void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                g.drawOval(10, 10, 100, 100);
            } 
        };


    }
    /*
    private class ButtonClicked1 implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            setColorButton();
        }
    }
    */

    public void setColorButton()
    {
        setBackground(Color.red);
    }

    public String toString()
    {
        return "This is bomb";
    }

        
    
}
