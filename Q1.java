import java.awt.*;
import java.awt.event.*;


 class Q1 extends WindowCloser implements ActionListener
{
	int var=0,xy=0;
	char o='h',m='n',l='a';					
	double number = 0,answer=0;
	Frame f;
	Panel p1;
	Panel p[] = new Panel[4];
	Button b[] = new Button[16];
	TextField t;
	
	public Q1()
	{
		int i,j=0,n;
		
		f = new Frame();
		f.setSize(600,400);
		f.setLayout(new GridLayout(5,1));
		GridLayout g = new GridLayout(1,4);
		p1 = new Panel();
		p1.setLayout(new BorderLayout());
		for(i=0;i<4;i++)
		{
			p[i]=new Panel();
			p[i].setLayout(g);
		}

		b[0] = new Button("1");
		b[1] = new Button("2");
		b[2] = new Button("3");
		b[3] = new Button("+");
		b[4] = new Button("4");
		b[5] = new Button("5");
		b[6] = new Button("6");
		b[7] = new Button("-");
		b[8] = new Button("7");
		b[9] = new Button("8");
		b[10] = new Button("9");
		b[11] = new Button("*");
		b[12] = new Button("c");
		b[13] = new Button("0");
		b[14] = new Button("/");
		b[15] = new Button("=");
		
		for(i=0;i<16;i++)
		b[i].addActionListener(this);
	
		t = new TextField();
		t.setEditable(false);
		p1.add(t);
		
		for(i=0;i<4;i++)
		{
			n=j+4;
			for(;j<n;j++)
			{
				p[i].add(b[j]);
			}
		}
		
		f.add(p1);
		for(i=0;i<4;i++)
		{
			f.add(p[i]);
		}
		f.setVisible(true);
		
		WindowCloser wc = new WindowCloser();
		f.addWindowListener(wc);
	}
	
	public void actionPerformed(ActionEvent e)
	{

		String str = e.getActionCommand();
		char ch = str.charAt(0);
		if(Character.isDigit(ch))
		{
			
			number = number*10 + Character.getNumericValue(ch);
			t.setText(""+number);
			m='h';
			l='a';
			
		}
		
		if(ch=='c')
		{
			t.setText("0");
			number=0;
			answer=0;
			m='n';
			xy=0;
		}	
		if(ch=='=')
		{
			if(l=='+'||l=='-')
			number=0;
		
			if(l=='*'||l=='/')
			number=1;
			
			if(o!='h')
				solv();
			m='n';
			
			number=0;
			
			if(xy==1)
				t.setText(""+answer);
			
		}
		if(ch=='+'||ch=='-'||ch=='*'||ch=='/')
		{
			xy=1;
			if(o!='h'&& m=='h')
			{
				solv();
				o=ch;
				number=0;
				return;
			}
			answer=Double.parseDouble(t.getText());
			number=0;
			m='n';
			o=ch;
			l=ch;
		}
	}
	public void solv()
	{
		m='n';
		switch(o)
		{
			case '+' :		answer=answer+number;
							o='h';
							break;
			case '-' :		answer=answer-number;
							o='h';
							break;
			case '*' :		answer=answer*number;
							o='h';
							break;
			case '/' :		answer=answer/number;
							o='h';		
		}
		t.setText(""+answer);
	}
	
	
	
	public static void main (String arg[])
	{
		Q1 c = new Q1();
	}
	
}
