import java.awt.*;
import java.awt.event.*;

class MyFrame extends Frame implements ActionListener
{
	Panel pnl1,pnl2;
	Button btn1[],btn2[],btn3;
	TextField tf;
	String op[]={"+","-","*","/"};
	String num[]={"1","2","3","4","5","6","7","8","9","0",".","C"};
	String s0,s1,s2;
	public MyFrame()
	{
		s0=s1=s2=" ";
		tf=new TextField();
		tf.setFont(new Font("Arial",Font.BOLD,30));
		add(tf,"North");
		tf.setForeground(Color.white);
		tf.setBackground(Color.black);

		pnl1=new Panel(new GridLayout(4,3,5,5));
		btn1=new Button[num.length];
		for(int i=0;i<num.length;i++)
		{
			btn1[i]=new Button(num[i]);
			pnl1.add(btn1[i]);
			btn1[i].setFont(new Font("Arial",Font.BOLD,25));
			btn1[i].addActionListener(this);
			btn1[i].setForeground(Color.white);
			btn1[i].setBackground(Color.black);
		
		}
		add(pnl1,"Center");
		btn2=new Button[op.length];
		pnl2=new Panel(new GridLayout(4,1,5,5));
		for(int i=0;i<op.length;i++)
		{
			btn2[i]=new Button(op[i]);
			pnl2.add(btn2[i]);
			btn2[i].setFont(new Font("Arial",Font.BOLD,50));
			btn2[i].addActionListener(this);
			btn2[i].setForeground(Color.white);
			btn2[i].setBackground(Color.black);
		}
		add(pnl2,"East");
		btn3=new Button("=");
		add(btn3,"South");
		btn3.setFont(new Font("Arial",Font.BOLD,40));
		btn3.addActionListener(this);
		setBackground(Color.white);
		pnl1.setBackground(Color.white);
		pnl2.setBackground(Color.white);
		btn3.setForeground(Color.white);
		btn3.setBackground(Color.black);
		
		
	}
	public void actionPerformed(ActionEvent e)
	{
	String s=e.getActionCommand();
	if((s.charAt(0)>='0')&&(s.charAt(0)<='9')||(s.charAt(0)=='.'))
		{
			if(!s1.equals(" "))
				s2=s2+s;
			else
				s0=s0+s;
				tf.setText(s0+s1+s2);
		
		}
	else if(s.charAt(0)=='C')
		{
		s0=s1=s2=" ";
		tf.setText(s0+s1+s2);
		}
	else if(s.charAt(0)== '=')
		{
		double te;
		
		if(s1.equals("+"))
			te=(Double.parseDouble(s0)+Double.parseDouble(s2));
		else if(s1.equals("-"))
			te=(Double.parseDouble(s0)-Double.parseDouble(s2));
		else if(s1.equals("*"))
			te=(Double.parseDouble(s0)*Double.parseDouble(s2));
		else
			te=(Double.parseDouble(s0)/Double.parseDouble(s2));
		
		tf.setText(s0+s1+s2+ "=" + te);
		s0=Double.toString(te);
		s1=s2=" ";
		}
	else{
		if(s1.equals(" ")||s2.equals(" "))
			s1=s;
		else{
			double te;
			
			if(s1.equals("+"))
				te=(Double.parseDouble(s0)+Double.parseDouble(s2));
			else if(s1.equals("-"))
				te=(Double.parseDouble(s0)-Double.parseDouble(s2));
			else if(s1.equals("*"))
				te=(Double.parseDouble(s0)*Double.parseDouble(s2));	
			else
				te=(Double.parseDouble(s0)/Double.parseDouble(s2));
			s0=Double.toString(te);
			s1=s;
			s2=" ";
		}
		tf.setText(s0+s1+s2);
	}
	}
	
}
class Calculator
{
	public static void main(String args[])
	{
	MyFrame f=new MyFrame();
	f.setSize(500,500);
	f.setVisible(true);
	}
}














