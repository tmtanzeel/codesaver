import java.sql.*;

public class ReadDataBase
{
	Connection con;
	Statement st;
	String str="", name="",ped="",fan="",man="",cnt1="",cnt2="";
	int rn,cls,dob,mob,yob,da,ma,ya,rtbdAtt1,rtbdAtt2;
	static int scl,srn,entClass,ecls,ern,uprn,upcls,updob,upmob,upyob,upda,upma,upya;
	static String upname="",upped="",upfan="",upman="",upcnt1="",upcnt2="",column="";

	public ReadDataBase()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:Data","Tanzeel","mirza");
			st=con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public int insert()
	{
		int x=0;
		try
		{
			if(st!=null)
			{
				str="insert into StudentClass3 values("+rn+",'"+name+"',"+cls+","+dob+","+mob+","+yob+",'"+ped+"','"+fan+"','"+man+"',"+cnt1+","+cnt2+","+da+","+ma+","+ya+")";
				x=st.executeUpdate(str);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return(x);
	}

	public ResultSet show()
	{
		ResultSet rs=null;
		try
		{
			if(st!=null)
			{	
				str="select * from StudentClass3 where studClass="+entClass;
				rs=st.executeQuery(str);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
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
				str="select * from StudentClass3 where studClass="+scl +"and studRoll="+srn;
				rs=st.executeQuery(str);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
		return(rs);			
	}
	
	public int drop()
	{
		int x=0;
		ResultSet rs=null;
	
		try
		{
			if(st!=null)
			{	
				str="delete StudentClass3 where studClass="+rtbdAtt1 +"and studRoll="+rtbdAtt2;
				x=st.executeUpdate(str);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return(x);
	}

	public int update()
	{
		int x=0;
		try
		{
			if(column.equals("rn"))
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
	}	
}