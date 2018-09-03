import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class ReturnDefaultValues
{
	//static String LoCa="",PrOp="",InTe="";
	public ReturnDefaultValues()
	{
		
		try
		{
			ProgramCounterDataReadWrite obj=new ProgramCounterDataReadWrite();
			ResultSet rs=obj.SelectByName();
			String LoCa="",PrOp="",InTe="";
			if(rs!=null)
			{				
				while(rs.next())
				{
					LoCa=rs.getString(2);
					PrOp=rs.getString(3);
					InTe=rs.getString(4);
				}
			}
		}
		catch(Exception e)
		{
			//JOptionPane.showMessageDialog(this,e.toString());
		}
	}
}				