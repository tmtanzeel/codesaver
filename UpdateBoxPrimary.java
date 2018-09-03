import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.SQLException.*;
import java.io.*;

public class UpdateBoxPrimary extends JFrame
{
	public UpdateBoxPrimary()
	{
		Container cp=getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(new GetSourceCodeAndLocation(),BorderLayout.NORTH);
		//cp.add(new GetPrOpInTeDetails(),BorderLayout.CENTER);
		//cp.add(new OkButton(),BorderLayout.SOUTH);
	}
}

class GetSourceCodeAndLocation extends JPanel implements ActionListener
{
	JButton jb;
	JLabel jl1,jl2,jl3,jl4;
	static JTextField jt1,jt2,jt3,jt4;
	static String temp1="",temp2="";
	public GetSourceCodeAndLocation()
	{
		setLayout(new GridLayout(3,3,5,5));
		jb=new JButton("Name and Location");
			
		jb.addActionListener(this);
		
		jl1=new JLabel("FILE NAME:");				
		jl2=new JLabel("LOCATION:");				
		jl3=new JLabel("OPERATION:");				
		jl4=new JLabel("INTENDATION:");				
		jt1=new JTextField(10);
		jt1.setEditable(false);
		jt2=new JTextField(10);
		jt3=new JTextField(10);
		jt4=new JTextField(10);
		
		add(jb);
		add(jl1);
		add(jt1);		
		add(jl2);
		add(jt2);
		add(jl3);
		add(jt3);
		add(jl4);
		add(jt4);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String tob=ae.getActionCommand();
		final JFileChooser jfc=new JFileChooser();
		jfc.setMultiSelectionEnabled(true);
		jfc.setCurrentDirectory(new File("C:\\TurboC++\\Disk\\TurboC3\\BIN"));
		int retval=jfc.showOpenDialog(GetSourceCodeAndLocation.this);
		if(tob.equals("Name and Location"))
		{
			if (retval == JFileChooser.APPROVE_OPTION)
			{
             	File[] selectedfiles = jfc.getSelectedFiles();
             	StringBuilder sb1 = new StringBuilder();
				//StringBuilder sb2 = new StringBuilder();
				for (int i = 0; i < selectedfiles.length; i++)
				{
                    sb1.append(selectedfiles[i].getName()+"\n");
					//sb2.append(selectedfiles[i].getAbsolutePath()+"\n");
					temp1=sb1.toString();
					//temp2=sb2.toString();
					jt1.setText(temp1);
					//jt2.setText(temp2);
				}
				ReturnDefaultValues rdv=new ReturnDefaultValues();
				/*System.out.println(rdv.LoCa);
				System.out.println(rdv.PrOp);
				System.out.println(rdv.InTe);*/
				//jt2.setText(rdv.LoCa);
				//jt3.setText(rdv.PrOp);
				//jt4.setText(rdv.InTe);				
			}
        }
	}
}