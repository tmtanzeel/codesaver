import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DropBox extends JFrame
{
	public DropBox()
	{
		Container cp=getContentPane();
		setLayout(new BorderLayout());
		cp.add(new DropLabelAndTextField(),BorderLayout.NORTH);
		cp.add(new DropButton(),BorderLayout.SOUTH);
	}
}

class DropLabelAndTextField extends JPanel
{
	JLabel jl;
	static JTextField jt;
	public DropLabelAndTextField()
	{
		setLayout(new GridLayout(1,2));
		jl=new JLabel("SOURCE CODE:");
		jt=new JTextField(15);
		add(jl);
		add(jt);
	}
}

class DropButton extends JPanel implements ActionListener
{
	JButton jb;
	public DropButton()
	{
		jb=new JButton("OK");
		add(jb);
		jb.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae)
	{
		ProgramCounterDataReadWrite obj=new ProgramCounterDataReadWrite();
		String tob=ae.getActionCommand();
		if(tob.equals("OK"))
		{
			obj.name=DropLabelAndTextField.jt.getText();
			int x=obj.drop();
			if(x>0)
			{
				JOptionPane.showMessageDialog(this,"Record Successfully Deleted.");	
			}
			else
			{
				JOptionPane.showMessageDialog(this,"No Such Record Exists!");
			}
		}
	}
}