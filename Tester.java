import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class Tester
{

    public static void main ( String [] args)
    {
        
    }

    public static void addButton(JFrame frame)
    {
        for(int a = 0; a < 25; a++)
        {
            JButton b = new JButton("Button" + (a + 1));
            b.setSize(new Dimension(10,10));
            frame.add(b);
        }
    }
}