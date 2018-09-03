import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AskPrCat extends JFrame
{
	public AskPrCat()
	{
		Container cp=getContentPane();
		setLayout(new BorderLayout());
		cp.add(new AskCategoryLabel(),BorderLayout.NORTH);
		cp.add(new AskCategoryOnly(),BorderLayout.WEST);
		cp.add(new SpecUsab(),BorderLayout.EAST);
		cp.add(new ProceedButtonClOnly(),BorderLayout.SOUTH);
	}
}

class SpecUsab extends JPanel
{
	JSlider jsld;
	public SpecUsab()
	{
		jsld = new JSlider(JSlider.VERTICAL,0,10,5);
		add(jsld);
		jsld.setMinorTickSpacing(1);
        jsld.setMajorTickSpacing(5);
        jsld.setPaintTicks(true);
        jsld.setPaintLabels(true);
		jsld.setLabelTable(jsld.createStandardLabels(5));
	}
}


class AskCategoryLabel extends JPanel
{
	JLabel jl;
	Font f=new Font("Times new roman",Font.PLAIN,20);
	public AskCategoryLabel()
	{
		jl=new JLabel("::CATEGORY::\t\t::UTILITY::");
		jl.setForeground(Color.RED);
		jl.setFont(f);
		add(jl);
	}
}

class AskCategoryOnly extends JPanel implements ActionListener
{
	static JRadioButton jr1,jr2,jr3,jr4,jr5,jr6,jr7;
	
	public AskCategoryOnly()
	{
		setLayout(new GridLayout(7,1,4,4));		
		jr1=new JRadioButton("C GRAPHICS");
		jr2=new JRadioButton("C TERMINAL");
		jr3=new JRadioButton("JAVA CONSOLE");
		jr4=new JRadioButton("JAVA SWING");
		jr5=new JRadioButton("JAVA APPLET");
		jr6=new JRadioButton("WEB FORM");
		jr7=new JRadioButton("OTHERS");
		
		jr1.addActionListener(this);
		jr2.addActionListener(this);
		jr3.addActionListener(this);
		jr4.addActionListener(this);
		jr5.addActionListener(this);
		jr6.addActionListener(this);
		jr7.addActionListener(this);
				
		add(jr1);
		add(jr2);
		add(jr3);
		add(jr4);
		add(jr5);
		add(jr6);
		add(jr7);
	}

	public void actionPerformed(ActionEvent ae)
	{
		ProgramCounterDataReadWrite obj= new ProgramCounterDataReadWrite();
		String tor=ae.getActionCommand();
		if(tor.equals("C GRAPHICS"))
		{
			obj.category="C GRAPHICS";
		}
		else if(tor.equals("C TERMINAL"))
		{
			obj.category="C TERMINAL";
		}
		else if(tor.equals("JAVA CONSOLE"))
		{
			obj.category="JAVA CONSOLE";
		}
		else if(tor.equals("JAVA SWING"))
		{
			obj.category="JAVA SWING";
		}
		else if(tor.equals("JAVA APPLET"))
		{
			obj.category="JAVA APPLET";
		}
		else if(tor.equals("WEB FORM"))
		{
			obj.category="WEB FORM";
		}
		else if(tor.equals("OTHERS"))
		{
			obj.category="OTHERS";
		}		
	}
}

class ProceedButtonClOnly extends JPanel implements ActionListener
{
	JButton jb;
	public ProceedButtonClOnly()
	{
		jb=new JButton("PROCEED");
		add(jb);
		jb.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae)
	{
		ProgramCounterDataReadWrite obj=new ProgramCounterDataReadWrite();
		String tob=ae.getActionCommand();
		if(tob.equals("PROCEED"))
		{
			JFrame jrf=new ShowSpecClass();
			jrf.setVisible(true);
			jrf.pack();
		}
	}
}