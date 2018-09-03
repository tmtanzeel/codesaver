import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class IndexFrame extends JFrame
{
	public IndexFrame()
	{
		Container cp=getContentPane();
		cp.setLayout(new BorderLayout());		
		cp.add(new MainLabel(),BorderLayout.NORTH);
		cp.add(new JSeparator());
		cp.add(new ButtonPanel(),BorderLayout.SOUTH);
	}
}

class MainLabel extends JPanel
{
	JLabel jl;
	ImageIcon ic;
	public MainLabel()
	{
		ic=new ImageIcon("Untitled.png");
		jl=new JLabel(ic);
		add(jl);
	}
}

class ButtonPanel extends JPanel implements ActionListener
{
	JButton addB,showallB,showspecB,updateB,dropB;
	ImageIcon i1,i2,i3,i4,i5;
	public ButtonPanel()
	{
		i1=new ImageIcon("4.png");
		addB=new JButton(i1);
		addB.setActionCommand("ADD");
		i2=new ImageIcon("3.png");
		showallB=new JButton(i2);
		showallB.setActionCommand("SHOW ALL");
		i3=new ImageIcon("1.png");
		showspecB=new JButton(i3);
		showspecB.setActionCommand("SHOW SPECEFIC");
		i4=new ImageIcon("2.png");
		updateB=new JButton(i4);
		updateB.setActionCommand("UPDATE");
		i5=new ImageIcon("5.png");
		dropB=new JButton(i5);
		dropB.setActionCommand("DROP");

		add(addB);
		add(showallB);
		add(showspecB);
		add(updateB);
		add(dropB);

		addB.addActionListener(this);
		showallB.addActionListener(this);
		showspecB.addActionListener(this);
		updateB.addActionListener(this);
		dropB.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String tob=ae.getActionCommand();
		if(tob.equals("ADD"))
		{
			JFrame jrf=new GetDetailsBox();
			jrf.setVisible(true);
			jrf.pack();
			jrf.setSize(700,380);
			jrf.setResizable(false);
			jrf.setLocation(100,150);			
			jrf.setDefaultCloseOperation(2);
		}
		else if(tob.equals("SHOW ALL"))
		{
			JFrame jrf=new ShowAllBox();
			jrf.setVisible(true);
			jrf.setLocation(400,100);
			jrf.pack();
			jrf.setDefaultCloseOperation(2);
		}		
		else if(tob.equals("SHOW SPECEFIC"))
		{
			JFrame jrf=new AskPrCat();
			jrf.setVisible(true);
			jrf.setLocation(400,250);
			jrf.pack();
			jrf.setDefaultCloseOperation(2);
		}
		else if(tob.equals("DROP"))
		{
			JFrame jrf=new DropBox();
			jrf.setVisible(true);
			jrf.setLocation(400,250);
			jrf.pack();
			jrf.setDefaultCloseOperation(2);
		}
		else if(tob.equals("UPDATE"))
		{
			JFrame jrf=new UpdateBoxPrimary();
			jrf.setVisible(true);
			jrf.setLocation(400,250);
			jrf.pack();
			jrf.setResizable(false);
			jrf.setDefaultCloseOperation(2);
		}
	}
}	