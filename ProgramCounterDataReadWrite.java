import java.sql.*;

public class ProgramCounterDataReadWrite
{
	Connection con;
	Statement st;
	String query="";
	static String PrCat="",SrCd="",PrOp="",InTe="",LoCa="",ErSt="",ImPl="",category="",name="";
	static int UsFu;
	public ProgramCounterDataReadWrite()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:data","admin","rootaccess");
			st=con.createStatement();
		}
		catch(Exception x)
		{
			System.out.println("" +x);
		}
	}
	
	public int add()
	{
		int x=0;
		try
		{
			if(st!=null)
			{
				query="insert into ProgramCounter values('"+SrCd+"','"+LoCa+"','"+PrOp+"','"+InTe+"','"+PrCat+"','"+ImPl+"','"+ErSt+"',"+UsFu+")";
				x=st.executeUpdate(query);
			}
		}
		catch(Exception e)
		{
			System.out.println("OOPS! SOMETHING WENT WRONG: " +e);
		}
		return(x);
	}

	public ResultSet showAll()
	{
		ResultSet rs=null;
		try
		{
			if(st!=null)
			{
				query="select * from ProgramCounter";
				rs=st.executeQuery(query);
			}
		}
		catch(Exception e)
		{
			System.out.println("OOPS! SOMETHING WENT WRONG: " +e);
		}
		return(rs);
	}
	
	public ResultSet showSpecific()
	{
		ResultSet rs=null;
		try
		{
			if(st!=null)
			{
				query="select * from ProgramCounter where PrCat='"+category+"'";
				rs=st.executeQuery(query);
			}
		}
		catch(Exception e)
		{
			System.out.println("OOPS! SOMETHING WENT WRONG: " +e);
		}
		return(rs);
	}
	
	public ResultSet SelectByName()
	{
		ResultSet rs=null;
		String sn=GetSourceCodeAndLocation.jt1.getText();//.trim();		
		try
		{
			if(st!=null)
			{
				query="select * from ProgramCounter where SrCd='"+sn+"'";
				rs=st.executeQuery(query);
			}
		}
		catch(Exception e)
		{
			System.out.println("OOPS! SOMETHING WENT WRONG: " +e);
		}
		return(rs);
	}
	
	public int drop()
	{
		int x=0;
		ResultSet rs=null;
		System.out.println(name);
	
		try
		{
			if(st!=null)
			{	
				query="delete from ProgramCounter where SrCd='"+name+"'";
				x=st.executeUpdate(query);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return(x);
	}

	public ResultSet update()
	{
		//int x=0;
		ResultSet rs=null;
		String sn=GetSourceCodeAndLocation.jt1.getText();
		String sl=GetSourceCodeAndLocation.jt2.getText();
		try
		{
			if(st!=null)
			{
			System.out.println(sl);
			query="select * from ProgramCounter where SrCd='"+sn+"'";
			rs=st.executeQuery(query);
			//str="update ProgramCounter set LoCa='"++"', where studRoll="+ern+" and studClass="+ecls;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return(rs);
	}
}
			/*if(column.equals("rn"))
			{
				str="update StudentClass3 set studRoll="+uprn+" where studRoll="+ern+" and studClass="+ecls;
			}
			else if(column.equals("name"))
			{
				str="update StudentClass3 set studName='"+upname+"' where studRoll="+ern+" and studClass="+ecls;
			}
			else if(column.equals("cls"))
			{
				str="update StudentClass3 set studClass='"+upcls+"' where studRoll="+ern+" and studClass="+ecls;
			}
			else if(column.equals("dob"))
			{
				str="update StudentClass3 set studDb="+updob+" where studRoll="+ern+" and studClass="+ecls;
			}
			else if(column.equals("mob"))
			{
				str="update StudentClass3 set studMb="+upmob+" where studRoll="+ern+" and studClass="+ecls;
			}
			else if(column.equals("yob"))
			{
				str="update StudentClass3 set studYb="+upyob+" where studRoll="+ern+" and studClass="+ecls;
			}
			else if(column.equals("ped"))
			{
				str="update StudentClass3 set studPerAdd='"+upped+"' where studRoll="+ern+" and studClass="+ecls;
			}
			else if(column.equals("fan"))
			{
				str="update StudentClass3 set studFName='"+upfan+"' where studRoll="+ern+" and studClass="+ecls;
			}
			else if(column.equals("man"))
			{
				str="update StudentClass3 set studMName='"+upman+"' where studRoll="+ern+" and studClass="+ecls;
			}
			else if(column.equals("cnt1"))
			{
				str="update StudentClass3 set studCn1='"+upcnt1+"' where studRoll="+ern+" and studClass="+ecls;
			}
			else if(column.equals("cnt2"))
			{
				str="update StudentClass3 set studCn2='"+upcnt2+"' where studRoll="+ern+" and studClass="+ecls;
			}
			else if(column.equals("da"))
			{
				str="update StudentClass3 set studDa="+upda+" where studRoll="+ern+" and studClass="+ecls;
			}
			else if(column.equals("ma"))
			{
				str="update StudentClass3 set studMa="+upma+" where studRoll="+ern+" and studClass="+ecls;
			}
			else if(column.equals("ya"))
			{
				str="update StudentClass3 set studYa="+upya+" where studRoll="+ern+" and studClass="+ecls;
			}
			x=st.executeUpdate(str);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return(x);
	}*/			