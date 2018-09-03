import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MainClass
{
	public static void main(String CommandLineArgument[])
	{
		JFrame jrf=new IndexFrame();		
		jrf.setVisible(true);
		jrf.pack();
		jrf.setLocation(350,200);
		jrf.setDefaultCloseOperation(jrf.EXIT_ON_CLOSE);
		jrf.setTitle("PROGRAM COUNTER");
		jrf.setResizable(false);
		
	}
}