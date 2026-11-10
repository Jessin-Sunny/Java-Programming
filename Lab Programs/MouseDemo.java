/*Handling Mouse Events*/
import javax.swing.*;
import java.awt.event.*;


class Mouse
{
    JFrame jfrm=new JFrame();
    public Mouse()
    {
        jfrm.addMouseListener(new MouseAdapter() 
        {
            public void mousePressed(MouseEvent e)
            {
                System.out.println(e.getX()+"  "+e.getY());
            }   
        });
        jfrm.setLayout(null);
        jfrm.setSize(400,400);
        jfrm.setVisible(true);
        jfrm.setDefaultCloseOperation(jfrm.EXIT_ON_CLOSE);
    }

    
}

public class MouseDemo
{
    public static void main(String args[])
    {
        Mouse m=new Mouse();
    }
}