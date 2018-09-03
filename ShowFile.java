import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShowFile extends JFrame
{
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
	LocateFile obj=new LocateFile();
	public FileNameLabel()
	{
		Font f=new Font("Times new roman",Font.PLAIN,20);
		jl1=new JLabel("File Name: " +obj.temp1);
		add(jl1);
		jl1.setForeground(Color.RED);
		jl1.setFont(f);
	}
}
class FileContent extends JPanel implements AdjustmentListener
{
	JTextArea ja;
	JScrollBar jsb;
	String cont="";
	LocateFile obj=new LocateFile();
	public FileContent()
	{
		int i;
		FileInputStream fin;
		
		try
		{
			String filee=obj.temp2.trim();
			//System.out.print(filee); CONSOLE CHECKING
			fin=new FileInputStream(filee);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("CANNOT OPEN THE FILE.");
			return;
		}

		try
		{
			do
			{
				i=fin.read();
				if(i!=-1)
				{
					cont+=((char)i);
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
	
		Font f=new Font("Times new roman",Font.ITALIC,14);
		ja=new JTextArea(cont,30,100);
		JScrollPane jsp=new JScrollPane(ja);
		add(jsp);
	}
	
	public void adjustmentValueChanged(AdjustmentEvent e)
	{}
}

class SaveButton extends JPanel
{
	JButton jb;;
	public SaveButton()
	{
		jb=new JButton("DONE EDITTING");
		add(jb);
	}
}