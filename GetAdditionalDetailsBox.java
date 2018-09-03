import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GetAdditionalDetailsBox extends JFrame
{
	public GetAdditionalDetailsBox()
	{
		Container cp=getContentPane();
		setLayout(new GridLayout(1,3,20,20));
		cp.add(new AskCategory());
		cp.add(new AskTechnique());
		cp.add(new AskErrorStatus());		
		cp.add(new DoneButton());
	}
}

class AskCategory extends JPanel implements ActionListener
{
	JLabel jl;
	static JRadioButton jr1,jr2,jr3,jr4,jr5,jr6,jr7;
	Font f=new Font("Times new roman",Font.PLAIN,20);
	public AskCategory()
	{
		setLayout(new GridLayout(8,1,4,4));
		jl=new JLabel("::PROGRAM CATEGORY::");
		jl.setForeground(Color.RED);
		jl.setFont(f);
		
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
				
		add(jl);
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
			obj.PrCat="C GRAPHICS";
		}
		else if(tor.equals("C TERMINAL"))
		{
			obj.PrCat="C TERMINAL";
		}
		else if(tor.equals("JAVA CONSOLE"))
		{
			obj.PrCat="JAVA CONSOLE";
		}
		else if(tor.equals("JAVA SWING"))
		{
			obj.PrCat="JAVA SWING";
		}
		else if(tor.equals("JAVA APPLET"))
		{
			obj.PrCat="JAVA APPLET";
		}
		else if(tor.equals("WEB FORM"))
		{
			obj.PrCat="WEB FORM";
		}		
		else if(tor.equals("OTHERS"))
		{
			obj.PrCat="OTHERS";
		}
	}
}


class AskErrorStatus extends JPanel implements ActionListener
{
	static JRadioButton jr1,jr2,jr3,jr4,jr5,jr6;
	Font f=new Font("Times new roman",Font.PLAIN,20);
	JLabel jl;
	public AskErrorStatus()
	{
		setLayout(new GridLayout(7,1,4,4));
		jl=new JLabel("::ERROR [IF ANY]::");
		jl.setForeground(Color.RED);
		jl.setFont(f);
		jr1=new JRadioButton("LOGICAL");
		jr2=new JRadioButton("COMPLIED & EXECUTING");
		jr3=new JRadioButton("COMPILE TIME");		
		jr4=new JRadioButton("RUN TIME");
		jr5=new JRadioButton("COMPILER PROBLEM");
		jr6=new JRadioButton("UNKNOWN");
		
		jr1.addActionListener(this);
		jr2.addActionListener(this);
		jr3.addActionListener(this);		
		jr4.addActionListener(this);
		jr5.addActionListener(this);
		jr6.addActionListener(this);		
		
		add(jl);
		add(jr1);
		add(jr2);
		add(jr3);		
		add(jr4);
		add(jr5);
		add(jr6);
	}

	public void actionPerformed(ActionEvent ae)
	{
		ProgramCounterDataReadWrite obj=new ProgramCounterDataReadWrite();
		String tor=ae.getActionCommand();
		if(tor.equals("LOGICAL"))
		{
			obj.ErSt="LOGICAL";
		}
		else if(tor.equals("COMPLIED & EXECUTING"))
		{
			obj.ErSt="COMPLIED & EXECUTING";
		}
		else if(tor.equals("COMPLIE TIME"))
		{
			obj.ErSt="COMPLIE TIME";
		}		
		else if(tor.equals("RUN TIME"))
		{
			obj.ErSt="RUN TIME";
		}
		else if(tor.equals("COMPLIER PROBLEM"))
		{
			obj.ErSt="COMPILER PROBLEM";
		}
		else if(tor.equals("UNKNOWN"))
		{
			obj.ErSt="UNKNOWN";
		}
	}
}

class AskTechnique extends JPanel implements ActionListener
{
	static JRadioButton jr1,jr2,jr3,jr4,jr5,jr6,jr7,jr8;
	Font f=new Font("Times new roman",Font.PLAIN,20);
	JLabel jl;
	public AskTechnique()
	{
		setLayout(new GridLayout(9,1,4,4));
		jl=new JLabel("::IMPLEMENTATION::");
		jl.setForeground(Color.RED);
		jl.setFont(f);
		jr1=new JRadioButton("STRUCTURE");
		jr2=new JRadioButton("UNION");
		jr3=new JRadioButton("CLASSES & OBJECTS");
		jr4=new JRadioButton("C HEADER FILE");
		jr5=new JRadioButton("DATA FILE HANDLING");
		jr6=new JRadioButton("(N)IO JAVA");
		jr7=new JRadioButton("JAVA DATABASES");
		jr8=new JRadioButton("OTHERS");
		
		
		jr1.addActionListener(this);
		jr2.addActionListener(this);
		jr3.addActionListener(this);
		jr4.addActionListener(this);
		jr6.addActionListener(this);
		jr7.addActionListener(this);
		jr8.addActionListener(this);
				
		add(jl);
		add(jr1);
		add(jr2);
		add(jr3);
		add(jr4);
		add(jr5);
		add(jr6);		
		add(jr7);		
		add(jr8);		
	}

	public void actionPerformed(ActionEvent ae)
	{
		ProgramCounterDataReadWrite obj= new ProgramCounterDataReadWrite();
		String tor=ae.getActionCommand();
		if(tor.equals("STRUCTURE"))
		{
			obj.ImPl="STRUCTURE";
		}
		else if(tor.equals("UNION"))
		{
			obj.ImPl="UNION";
		}
		else if(tor.equals("CLASSES & OBJECTS"))
		{
			obj.ImPl="CLASSES & OBJECTS";
		}
		else if(tor.equals("C HEADER FILE"))
		{
			obj.ImPl="C HEADER FILE";
		}
		else if(tor.equals("(N)IO JAVA"))
		{
			obj.ImPl="(N)IO JAVA";
		}
		else if(tor.equals("DATA FILE HANDLING"))
		{
			obj.ImPl="DATA FILE HANDLING";
		}		
		else if(tor.equals("JAVA DATABASES"))
		{
			obj.ImPl="JAVA DATABASES";
		}
	}
}

		
class DoneButton extends JPanel implements ActionListener
{
	JButton jb;
	public DoneButton()
	{
		jb=new JButton("DONE");
		add(jb);
		jb.addActionListener(this);	
	}

	public void actionPerformed(ActionEvent ae)
	{
		String tob=ae.getActionCommand();
		ProgramCounterDataReadWrite obj=new ProgramCounterDataReadWrite();
		if(tob.equals("DONE"))
		{
			int x=obj.add();
			if(x>0)
			{
				JOptionPane.showMessageDialog(this,"Record Successfully Added");	
			}
			else
			{					
				JOptionPane.showMessageDialog(this,"A field or two might've left blank!\nOr maybe the File has already been added");
			}
		}
	}
}