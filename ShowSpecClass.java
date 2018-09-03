import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

public class ShowSpecClass extends JFrame
{
	public ShowSpecClass()
	{
		super("PROGRAM DATABASE");
		Container cp=getContentPane();
		cp.setLayout(new GridLayout(1,1));
		Object head[]={"PROGRAM CAT","SOURCE CODE","PROGRAM OPERATION","INTENDATIONS","LOCATION","ERROR STATUS","LANGUAGE"};
		Object rec[][]={{null,null,null,null,null,null,null}};
		JTable tbl=new JTable();
		DefaultTableModel model=new DefaultTableModel();
		tbl.setModel(model);
		model.setColumnIdentifiers(head);
		
		try
		{
			ProgramCounterDataReadWrite obj=new ProgramCounterDataReadWrite();
			ResultSet rs=obj.showSpecific();
			
			if(rs!=null)
			{
				String PrCat="";
				String SrCd="";
				String PrOp="";
				String InTe="";
				String LoCa="";
				String ErSt="";
				String PrLa="";
					
				while(rs.next())
				{
					PrCat=rs.getString(1);
					SrCd=rs.getString(2);
					PrOp=rs.getString(3);
					InTe=rs.getString(4);
					LoCa=rs.getString(5);
					ErSt=rs.getString(6);
					PrLa=rs.getString(7);					
					model.addRow(new Object[]{PrCat,SrCd,PrOp,InTe,LoCa,ErSt,PrLa});
				}
			}
		}

		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,e.toString());
		}
		
		JScrollPane jsp=new JScrollPane(tbl);
		cp.add(jsp);
	}
}				