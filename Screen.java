import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/** 
 *  @author Efe Can Tepe
 *  @version 03.30.2021
 */
public class Screen extends JFrame 
{
    private ButtonPanel buttons;

    public Screen()
    {
        buttons = new ButtonPanel();
        setSize(new Dimension(600,600));
        setDefaultCloseOperation(3);
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));

        add(buttons);
        add(buttons.infoMessage1);

        setVisible(true);
    }

}
