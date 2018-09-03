import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.SQLException.*;
import java.io.*;

public class GetDetailsBox extends JFrame
{
	public GetDetailsBox()
	{
		Container cp=getContentPane();
		cp.setLayout(new GridLayout(7,1));
		cp.add(new LabelOfBox());
		cp.add(new LocateFile());
		cp.add(new AskPrOpInTeDetails());
		cp.add(new SourceCode());
		cp.add(new ExecuteCode());
		cp.add(new Usefulness());
		cp.add(new ProceedButton());
	}
}

class LabelOfBox extends JPanel
{
	JLabel jl1;
	public LabelOfBox()
	{
		Font f=new Font("Times new roman",Font.PLAIN,20);
		jl1=new JLabel("::PLEASE PROVIDE THE FOLLOWING::");
		add(jl1);
		jl1.setForeground(Color.RED);
		jl1.setFont(f);
	}
}

class LocateFile extends JPanel implements ActionListener
{
	JButton jb;
	JLabel jl;
	static JTextField jt1,jt2;
	static String temp1="",temp2="",saved="null";
	public LocateFile()
	{
		//System.out.println("Constructor LocateFile()");
		setLayout(new GridLayout(2,2,5,5));
		jb=new JButton("Browse File");
		add(jb);
		jb.addActionListener(this);
		jl=new JLabel("Absolute Path:");				
		jt1=new JTextField(10);
		add(jt1);
		jt1.setEditable(false);
		add(jl);
		jt2=new JTextField(30);
		add(jt2);
		jt2.setEditable(false);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String tob=ae.getActionCommand();
		temp1="";temp2="";
		final JFileChooser jfc=new JFileChooser();
		jfc.setMultiSelectionEnabled(true);
		jfc.setCurrentDirectory(new File("C:\\TurboC4\\TC\\BIN"));
		int retval=jfc.showOpenDialog(LocateFile.this);
		if(tob.equals("Browse File"))
		{
			if (retval == JFileChooser.APPROVE_OPTION)
			{
             	File[] selectedfiles = jfc.getSelectedFiles();
             	StringBuilder sb1 = new StringBuilder();
				StringBuilder sb2 = new StringBuilder();
				for (int i = 0; i < selectedfiles.length; i++)
				{
                    sb1.append(selectedfiles[i].getName()+"\n");
					sb2.append(selectedfiles[i].getAbsolutePath()+"\n");
					temp1=sb1.toString();
					temp2=sb2.toString();
					jt1.setText(temp1);
					jt2.setText(temp2);
				}
			}
        }
	}
}

class SourceCode extends JPanel implements ActionListener
{
	JLabel jl;
	JButton jb;
	static String dem="";
	public SourceCode()
	{
		//System.out.println("Constructor SourceCode()");
		jl=new JLabel("VIEW SOURCE CODE >>");
		jb=new JButton("SOURCE CODE");	
		jb.addActionListener(this);
		add(jl);
		add(jb);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String tob=ae.getActionCommand();
		
		if(tob.equals("SOURCE CODE"))
		{
			FileContent fc=new FileContent();
			if(LocateFile.saved.equals(fc.filee))
			{
				JOptionPane.showMessageDialog(this,"The contents of this file are already being displayed!\nor maybe NO file have been selected");
			}
			else
			{
				LocateFile.saved=LocateFile.jt2.getText().trim();
				dem="";
				ShowFile jrf=new ShowFile();
				jrf.setVisible(true);
				jrf.pack();
				jrf.setLocation(150,100);
				jrf.setDefaultCloseOperation(jrf.DISPOSE_ON_CLOSE);
				jrf.setResizable(false);
			}
		}
	}
}

class AskPrOpInTeDetails extends JPanel 
{
	static JTextField jt1,jt2;
	JLabel jl1,jl2;
	public AskPrOpInTeDetails()
	{
		setLayout(new GridLayout(2,2,3,3));
		jl1=new JLabel("Program Operation: ");
		jl2=new JLabel("Intendations: ");
				
		jt1=new JTextField(10);
		jt2=new JTextField(10);
		
		add(jl1);
		add(jt1);
		add(jl2);
		add(jt2);
	}
}

class ExecuteCode extends JPanel implements ActionListener
{
	JLabel jl;
	JButton jb;
	public ExecuteCode()
	{
		jl=new JLabel("RESET THIS APPLICATION >>");
		jb=new JButton("RESET ALL");	
		jb.addActionListener(this);
		add(jl);
		add(jb);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String tob=ae.getActionCommand();
		if(tob.equals("RESET ALL"))
		{
			LocateFile.temp1="";
			LocateFile.temp2="";
			LocateFile.saved="null";
			LocateFile.jt1.setText("");
			LocateFile.jt2.setText("");
		}
	}
}

class Usefulness extends JPanel
{
	static JSlider jsld;
	JLabel jl;
	public Usefulness()
	{
		jsld = new JSlider(JSlider.HORIZONTAL,0,10,5);
		jl=new JLabel("HOW MUCH USEFUL IS THIS PROGRAM FOR YOU?");
		add(jl);
        add(jsld);
		jsld.setMinorTickSpacing(1);
        jsld.setMajorTickSpacing(5);
        jsld.setPaintTicks(true);
        jsld.setPaintLabels(true);
		jsld.setLabelTable(jsld.createStandardLabels(5));
	}
}

class ProceedButton extends JPanel implements ActionListener
{
	String tob="";
	public ProceedButton()
	{
		JButton jb=new JButton("PROCEED");
		jb.addActionListener(this);
		add(jb);		
	}

	public void actionPerformed(ActionEvent ae)
	{
		ProgramCounterDataReadWrite obj=new ProgramCounterDataReadWrite();
		tob=ae.getActionCommand();
		try
		{
			if(tob.equals("PROCEED"))
			{
				obj.SrCd=LocateFile.jt1.getText();
				obj.LoCa=LocateFile.jt2.getText();
				obj.PrOp=AskPrOpInTeDetails.jt1.getText();
				obj.InTe=AskPrOpInTeDetails.jt2.getText();
				obj.UsFu=Usefulness.jsld.getValue();
				
				JFrame ef=new GetAdditionalDetailsBox();
				ef.setVisible(true);
				ef.setTitle("Student Update");
				ef.setLocation(100,200);
				ef.pack();
				ef.setDefaultCloseOperation(2);
			}
		}
		catch(Exception e)	
		{
			JOptionPane.showMessageDialog(this,"ERROR! Please fill in the fields correctly");	
		}			
	}
}

class ShowFile extends JFrame
{
	/*static ShowFile _instance;
	public static ShowFile getInstance()
	{
		if(_instance == null) 
		{
			_instance = new ShowFile();
		}
		return _instance;
	}*/
	public ShowFile()
	{
		Container cp=getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(new FileNameLabel(),BorderLayout.NORTH);
		cp.add(new FileContent(),BorderLayout.CENTER);
		cp.add(new SaveButton(),BorderLayout.SOUTH);
	}
}

class FileNameLabel extends JPanel
{
	JLabel jl1;
	//LocateFile obj=new LocateFile();
	public FileNameLabel()
	{
		Font f=new Font("Times new roman",Font.PLAIN,20);
		jl1=new JLabel("File Name: " +LocateFile.jt1.getText());
		add(jl1);
		jl1.setForeground(Color.RED);
		jl1.setFont(f);
	}
}
class FileContent extends JPanel
{
	static JTextArea ja;
	JScrollBar jsb;
	//LocateFile obj=new LocateFile();
	SourceCode objSc=new SourceCode();
	String filee=LocateFile.jt2.getText().trim();
	public FileContent()
	{
		int i;
		FileInputStream fin;
		//System.out.println(LocateFile.jt2.getText().trim());
		try
		{
			//System.out.print(filee); CONSOLE CHECKING
			fin=new FileInputStream(filee);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("CANNOT OPEN THE FILE.");//CONSIDER CONSOLE 
			return;
		}

		try
		{
			do
			{
				i=fin.read();
				if(i!=-1)
				{
					objSc.dem+=((char)i);
				}
			}
			while(i!=-1);			
		}
		catch(IOException e)
		{
			System.out.println("ERROR READING THE FILE.");
		}

		try
		{
			fin.close();
		}
		catch(IOException e)
		{
			System.out.println("ERROR CLOSING FILE.");
		}
		ja=new JTextArea(objSc.dem,30,100);
		JScrollPane jsp=new JScrollPane(ja);
		add(jsp);
	}
}	

class SaveButton extends JPanel implements ActionListener
{
	JButton jb;
	public SaveButton()
	{
		jb=new JButton("DONE EDITTING");
		add(jb);
		jb.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String tob=ae.getActionCommand();
		if(tob.equals("DONE EDITTING"))
		{
			try
			{
				String source=FileContent.ja.getText();
				byte buf[] = source.getBytes();
				OutputStream f1 = new FileOutputStream("D:\\BUTTONS\\NewFile.txt");
				f1.write(buf);
				f1.close();
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		}
	}
}