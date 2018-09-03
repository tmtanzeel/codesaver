import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

public class ShowAllBox extends JFrame
{
	public ShowAllBox()
	{
		super("PROGRAM DATABASE");
		Container cp=getContentPane();
		cp.setLayout(new GridLayout(1,1));
		Object head[]={"SOURCE CODE","LOCATION","PROGRAM OPERATION","INTENDATIONS","PROGRAM CAT","IMPLEMENTS","ERROR STATUS"};
		Object rec[][]={{null,null,null,null,null,null,null}};
		JTable tbl=new JTable();
		DefaultTableModel model=new DefaultTableModel();
		tbl.setModel(model);
		model.setColumnIdentifiers(head);
		
		try
		{
			ProgramCounterDataReadWrite obj=new ProgramCounterDataReadWrite();
			ResultSet rs=obj.showAll();
			
			if(rs!=null)
			{				
				String SrCd="";
				String LoCa="";
				String PrOp="";
				String InTe="";
				String PrCat="";
				String ImPl="";			
				String ErSt="";				
				
				while(rs.next())
				{
					SrCd=rs.getString(1);
					LoCa=rs.getString(2);
					PrOp=rs.getString(3);
					InTe=rs.getString(4);
					PrCat=rs.getString(5);
					ImPl=rs.getString(6);
					ErSt=rs.getString(7);
										
					model.addRow(new Object[]{SrCd,LoCa,PrOp,InTe,PrCat,ImPl,ErSt});
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