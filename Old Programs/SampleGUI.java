import javax.swing.JFrame;

public class SampleGUI 
{
    public static void main(String args[])
    {
        JFrame gui=new JFrame();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("Close Window Example");
        gui.setBounds(100,100,600,600);
        gui.setVisible(true);
    }
}
