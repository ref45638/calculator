import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Formatter;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.math.BigDecimal;
import java.math.RoundingMode;

@SuppressWarnings("serial")
public class F74021048_hw9 extends JFrame implements ActionListener {
	static F74021048_hw9 frame = new F74021048_hw9();
	static JButton mc,mr,ms,madd,msub,back,ce,c,negative,sqrt,divide,percent,multiply,nstate,sub,log,nod,equal,add,exp;
	static JButton n0,n1,n2,n3,n4,n5,n6,n7,n8,n9;
	static JButton showpic,showhis,clearhis;
	static JTextField label;
	static JLabel memory,pic;
	static JTextArea history;
	static JScrollPane picturePane,historyPane;
	static String word="0",print="",c_str="",b_str="",his="",result="",m="0";
	static String preWord="",curWord="";
	static int op=0,preOp=0;;
	static boolean eq=false,NaN=false;
	
	public static void main(String[] args)
	{
		Image logo = null;
		try
		{
			logo = ImageIO.read(F74021048_hw9.class.getResource( "/logo.png" ));
		}
		catch(Exception e)
		{
			;
		}
		
		frame.setSize(790, 450);
		frame.setTitle("奈米屌計算機");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);  //不能調整視窗大小
		frame.getContentPane().setBackground(Color.PINK);
		frame.setIconImage(logo);
		
		label = new JTextField("0");
		label.setBounds(7,5,375,100);
		label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		label.setBackground(Color.PINK);
		label.setFont(new Font("", Font.BOLD|Font.ITALIC , 35));
		label.setForeground(Color.red);
		label.setEditable(false);
		label.setHorizontalAlignment(JTextField.RIGHT);
		frame.add(label);
		
		memory = new JLabel("",JLabel.LEFT);
		memory.setBounds(10,75,375,30);
		memory.setForeground(Color.red);
		memory.setFont(new Font("", Font.BOLD|Font.ITALIC , 25));
		memory.setHorizontalAlignment(JLabel.LEFT);
		frame.add(memory);
		
		pic = new JLabel(new ImageIcon(F74021048_hw9.class.getResource("/picture.png")));
		picturePane = new JScrollPane(pic);
		picturePane.setBounds(400,35,377,380);
		frame.add(picturePane);
		picturePane.setVisible(false);
		
		history = new JTextArea();
		history.setForeground(Color.BLACK);
		history.setBackground(Color.PINK);
		history.setFont(new Font("", Font.BOLD|Font.ITALIC , 20));
		history.setEditable(false);
		historyPane = new JScrollPane(history);
		historyPane.setBounds(400,35,377,380);
		historyPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		frame.add(historyPane);
		
		mc = new JButton("MC");
		mc.setSize(75,50);
		mc.addActionListener(frame);
		mc.setActionCommand("mc");
		mc.setLocation(5, 110);
		mc.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		mc.setFont(new Font("",Font.ITALIC ,30)); 
		mc.setBackground(Color.PINK);
		mc.setFocusable(false);
		frame.add(mc);
		
		mr = new JButton("MR");
		mr.setSize(75,50);
		mr.addActionListener(frame);
		mr.setActionCommand("mr");
		mr.setLocation(81, 110);
		mr.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		mr.setFont(new Font("",Font.ITALIC ,30)); 
		mr.setBackground(Color.PINK);
		mr.setFocusable(false);
		frame.add(mr);
		
		ms = new JButton("MS");
		ms.setSize(75,50);
		ms.addActionListener(frame);
		ms.setActionCommand("ms");
		ms.setLocation(157, 110);
		ms.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		ms.setFont(new Font("",Font.ITALIC ,30)); 
		ms.setBackground(Color.PINK);
		ms.setFocusable(false);
		frame.add(ms);
		
		madd = new JButton("M+");
		madd.setSize(75,50);
		madd.addActionListener(frame);
		madd.setActionCommand("madd");
		madd.setLocation(233, 110);
		madd.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		madd.setFont(new Font("",Font.ITALIC ,30)); 
		madd.setBackground(Color.PINK);
		madd.setFocusable(false);
		frame.add(madd);
		
		msub = new JButton("M-");
		msub.setSize(75,50);
		msub.addActionListener(frame);
		msub.setActionCommand("msub");
		msub.setLocation(309, 110);
		msub.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		msub.setFont(new Font("",Font.ITALIC ,30)); 
		msub.setBackground(Color.PINK);
		msub.setFocusable(false);
		frame.add(msub);
		
		back = new JButton("back");
		back.setSize(75,50);
		back.addActionListener(frame);
		back.setActionCommand("back");
		back.setLocation(5, 161);
		back.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		back.setFont(new Font("",Font.ITALIC ,30)); 
		back.setBackground(Color.PINK);
		back.setFocusable(false);
		frame.add(back);
		
		ce = new JButton("CE");
		ce.setSize(75,50);
		ce.addActionListener(frame);
		ce.setActionCommand("ce");
		ce.setLocation(81, 161);
		ce.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		ce.setFont(new Font("",Font.ITALIC ,30)); 
		ce.setBackground(Color.PINK);
		ce.setFocusable(false);
		frame.add(ce);
		
		c = new JButton("C");
		c.setSize(75,50);
		c.addActionListener(frame);
		c.setActionCommand("c");
		c.setLocation(157, 161);
		c.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		c.setFont(new Font("",Font.ITALIC ,30)); 
		c.setBackground(Color.PINK);
		c.setFocusable(false);
		frame.add(c);
		
		negative = new JButton("+/-");
		negative.setSize(75,50);
		negative.addActionListener(frame);
		negative.setActionCommand("negative");
		negative.setLocation(233, 161);
		negative.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		negative.setFont(new Font("",Font.ITALIC ,30)); 
		negative.setBackground(Color.PINK);
		negative.setFocusable(false);
		frame.add(negative);
		
		sqrt = new JButton("√");
		sqrt.setSize(75,50);
		sqrt.addActionListener(frame);
		sqrt.setActionCommand("sqrt");
		sqrt.setLocation(309, 161);
		sqrt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		sqrt.setFont(new Font("",Font.ITALIC ,30)); 
		sqrt.setBackground(Color.PINK);
		sqrt.setFocusable(false);
		frame.add(sqrt);
		
		divide = new JButton("/");
		divide.setSize(75,50);
		divide.addActionListener(frame);
		divide.setActionCommand("divide");
		divide.setLocation(233, 212);
		divide.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		divide.setFont(new Font("",Font.ITALIC ,30)); 
		divide.setBackground(Color.PINK);
		divide.setFocusable(false);
		frame.add(divide);
		
		percent = new JButton("%");
		percent.setSize(75,50);
		percent.addActionListener(frame);
		percent.setActionCommand("percent");
		percent.setLocation(309, 212);
		percent.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		percent.setFont(new Font("",Font.ITALIC ,30)); 
		percent.setBackground(Color.PINK);
		percent.setFocusable(false);
		frame.add(percent);
		
		multiply = new JButton("*");
		multiply.setSize(75,50);
		multiply.addActionListener(frame);
		multiply.setActionCommand("multiply");
		multiply.setLocation(233, 263);
		multiply.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		multiply.setFont(new Font("",Font.ITALIC ,30)); 
		multiply.setBackground(Color.PINK);
		multiply.setFocusable(false);
		frame.add(multiply);
		
		nstate = new JButton("n!");
		nstate.setSize(75,50);
		nstate.addActionListener(frame);
		nstate.setActionCommand("nstate");
		nstate.setLocation(309, 263);
		nstate.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		nstate.setFont(new Font("",Font.ITALIC ,30)); 
		nstate.setBackground(Color.PINK);
		nstate.setFocusable(false);
		frame.add(nstate);
		
		sub = new JButton("-");
		sub.setSize(75,50);
		sub.addActionListener(frame);
		sub.setActionCommand("sub");
		sub.setLocation(233, 314);
		sub.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		sub.setFont(new Font("",Font.ITALIC ,30)); 
		sub.setBackground(Color.PINK);
		sub.setFocusable(false);
		frame.add(sub);
		
		log = new JButton("log");
		log.setSize(75,50);
		log.addActionListener(frame);
		log.setActionCommand("log");
		log.setLocation(309, 314);
		log.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		log.setFont(new Font("",Font.ITALIC ,30)); 
		log.setBackground(Color.PINK);
		log.setFocusable(false);
		frame.add(log);
		
		nod = new JButton(".");
		nod.setSize(75,50);
		nod.addActionListener(frame);
		nod.setActionCommand("nod");
		nod.setLocation(81, 365);
		nod.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		nod.setFont(new Font("",Font.ITALIC ,30)); 
		nod.setBackground(Color.PINK);
		nod.setFocusable(false);
		frame.add(nod);
		
		equal = new JButton("=");
		equal.setSize(75,50);
		equal.addActionListener(frame);
		equal.setActionCommand("equal");
		equal.setLocation(157, 365);
		equal.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		equal.setFont(new Font("",Font.ITALIC ,30)); 
		equal.setBackground(Color.PINK);
		equal.setFocusable(false);
		frame.add(equal);
		
		add = new JButton("+");
		add.setSize(75,50);
		add.addActionListener(frame);
		add.setActionCommand("add");
		add.setLocation(233, 365);
		add.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add.setFont(new Font("",Font.ITALIC ,30)); 
		add.setBackground(Color.PINK);
		add.setFocusable(false);
		frame.add(add);
		
		exp = new JButton("exp");
		exp.setSize(75,50);
		exp.addActionListener(frame);
		exp.setActionCommand("exp");
		exp.setLocation(309, 365);
		exp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		exp.setFont(new Font("",Font.ITALIC ,30)); 
		exp.setBackground(Color.PINK);
		exp.setFocusable(false);
		frame.add(exp);
		
		n0 = new JButton("0");
		n0.setSize(75,50);
		n0.addActionListener(frame);
		n0.setActionCommand("n0");
		n0.setLocation(5, 365);
		n0.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		n0.setFont(new Font("",Font.ITALIC ,30)); 
		n0.setBackground(Color.PINK);
		n0.setFocusable(false);
		frame.add(n0);
		
		n1 = new JButton("1");
		n1.setSize(75,50);
		n1.addActionListener(frame);
		n1.setActionCommand("n1");
		n1.setLocation(5, 314);
		n1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		n1.setFont(new Font("",Font.ITALIC ,30)); 
		n1.setBackground(Color.PINK);
		n1.setFocusable(false);
		frame.add(n1);
		
		n2 = new JButton("2");
		n2.setSize(75,50);
		n2.addActionListener(frame);
		n2.setActionCommand("n2");
		n2.setLocation(81, 314);
		n2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		n2.setFont(new Font("",Font.ITALIC ,30)); 
		n2.setBackground(Color.PINK);
		n2.setFocusable(false);
		frame.add(n2);
		
		n3 = new JButton("3");
		n3.setSize(75,50);
		n3.addActionListener(frame);
		n3.setActionCommand("n3");
		n3.setLocation(157, 314);
		n3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		n3.setFont(new Font("",Font.ITALIC ,30)); 
		n3.setBackground(Color.PINK);
		n3.setFocusable(false);
		frame.add(n3);
		
		n4 = new JButton("4");
		n4.setSize(75,50);
		n4.addActionListener(frame);
		n4.setActionCommand("n4");
		n4.setLocation(5, 263);
		n4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		n4.setFont(new Font("",Font.ITALIC ,30)); 
		n4.setBackground(Color.PINK);
		n4.setFocusable(false);
		frame.add(n4);
		
		n5 = new JButton("5");
		n5.setSize(75,50);
		n5.addActionListener(frame);
		n5.setActionCommand("n5");
		n5.setLocation(81, 263);
		n5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		n5.setFont(new Font("",Font.ITALIC ,30)); 
		n5.setBackground(Color.PINK);
		n5.setFocusable(false);
		frame.add(n5);

		n6 = new JButton("6");
		n6.setSize(75,50);
		n6.addActionListener(frame);
		n6.setActionCommand("n6");
		n6.setLocation(157, 263);
		n6.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		n6.setFont(new Font("",Font.ITALIC ,30)); 
		n6.setBackground(Color.PINK);
		n6.setFocusable(false);
		frame.add(n6);
		
		n7 = new JButton("7");
		n7.setSize(75,50);
		n7.addActionListener(frame);
		n7.setActionCommand("n7");
		n7.setLocation(5, 212);
		n7.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		n7.setFont(new Font("",Font.ITALIC ,30)); 
		n7.setBackground(Color.PINK);
		n7.setFocusable(false);
		frame.add(n7);
		
		n8 = new JButton("8");
		n8.setSize(75,50);
		n8.addActionListener(frame);
		n8.setActionCommand("n8");
		n8.setLocation(500,400);
		n8.setLocation(81, 212);
		n8.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		n8.setFont(new Font("",Font.ITALIC ,30)); 
		n8.setBackground(Color.PINK);
		n8.setFocusable(false);
		frame.add(n8);
		
		n9 = new JButton("9");
		n9.setSize(75,50);
		n9.addActionListener(frame);
		n9.setActionCommand("n9");
		n9.setLocation(157, 212);
		n9.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		n9.setFont(new Font("",Font.ITALIC ,30)); 
		n9.setBackground(Color.PINK);
		n9.setFocusable(false);
		frame.add(n9);
		
		showpic = new JButton("Show Picture");
		showpic.setSize(125, 25);
		showpic.addActionListener(frame);
		showpic.setActionCommand("showpic");
		showpic.setLocation(400, 5);
		showpic.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		showpic.setFont(new Font("",Font.ITALIC ,20)); 
		showpic.setBackground(Color.PINK);
		showpic.setFocusable(false);
		frame.add(showpic);
		
		showhis = new JButton("Show History");
		showhis.setSize(125, 25);
		showhis.addActionListener(frame);
		showhis.setActionCommand("showhis");
		showhis.setLocation(526, 5);
		showhis.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		showhis.setFont(new Font("",Font.ITALIC ,20)); 
		showhis.setBackground(Color.PINK);
		showhis.setFocusable(false);
		frame.add(showhis);
		
		clearhis = new JButton("Clear History");
		clearhis.setSize(125, 25);
		clearhis.addActionListener(frame);
		clearhis.setActionCommand("clearhis");
		clearhis.setLocation(652, 5);
		clearhis.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		clearhis.setFont(new Font("",Font.ITALIC ,20)); 
		clearhis.setBackground(Color.PINK);
		clearhis.setFocusable(false);
		frame.add(clearhis);
		
		frame.setLayout(null);
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		b_str = c_str;
		c_str = e.getActionCommand();
		switch(c_str)
		{
			case "mc":
				memory.setText("");
				m="0";
				break;
			case "mr":
				print = "";
				preWord = "";
				curWord = "";
				op = 0;
				preOp=0;
				eq=false;
				try
				{
					if(Long.valueOf(m.substring(m.indexOf(".")+1, m.length()))==0) m =  m.substring(0, m.indexOf("."));
					else
					{
						for(int i=1;i<10;i++)
						{
							if(Long.valueOf(m.substring(m.indexOf(".")+1+i, m.length()))==0) m = m.substring(0, m.indexOf(".")+i+1);
						}
					}		
				}
				catch(NumberFormatException eee)
				{
					;
				}
				word = m;
				memory.setText("M");
				break;
			case "ms":
				memory.setText("M");
				m = word;
				break;
			case "madd":
				memory.setText("M");				
				m=String.valueOf(Double.valueOf(m)+Double.valueOf(word));
				break;
			case "msub":
				memory.setText("M");
				m=String.valueOf(Double.valueOf(m)+Double.valueOf("-"+word));
				break;
			case "back":
				if(!word.equals(""))word = word.substring(0, word.length()-1);
				break;
			case "ce":
				if(!print.equals("")) word = "";
				else word = "0";
				eq=false;
				break;
			case "c":
				print = "";
				word = "0";
				preWord = "";
				curWord = "";
				op = 0;
				preOp=0;
				m="0";
				eq=false;
				if(NaN)
				{
					mc.setEnabled(true);mr.setEnabled(true);ms.setEnabled(true);madd.setEnabled(true);
					msub.setEnabled(true);back.setEnabled(true);ce.setEnabled(true);
					negative.setEnabled(true);sqrt.setEnabled(true);divide.setEnabled(true);percent.setEnabled(true);
					multiply.setEnabled(true);nstate.setEnabled(true);sub.setEnabled(true);log.setEnabled(true);
					nod.setEnabled(true);equal.setEnabled(true);add.setEnabled(true);exp.setEnabled(true);
					n0.setEnabled(true);n1.setEnabled(true);n2.setEnabled(true);n3.setEnabled(true);n4.setEnabled(true);
					n5.setEnabled(true);n6.setEnabled(true);n7.setEnabled(true);n8.setEnabled(true);n9.setEnabled(true);
					NaN=false;
				}
				break;
			case "negative":
				if(Double.valueOf(word)==0)  break;  //不能是零
				if(word.substring(0, 1).equals("-")) word = word.substring(1);
				else word = "-" + word;
				break;
			case "sqrt":
				if(word.substring(word.length()-1, word.length()).equals(".")) word = word + "0";
				word = "sqrt("+word+")";
				curWord = String.valueOf(Math.sqrt(Double.valueOf(word)));
				break;
			case "divide":
				if(!word.equals("") && word.substring(word.length()-1, word.length()).equals(".")) word = word + "0";
				if(word.equals(""))
				{
					print = print.substring(0, print.length()-3) + " / ";
					op = 1;
					break;
				}
				else  print = print.concat(word)+" / ";
				if(NaN)
				{
					word = "";
					break;  //NaN
				}
				if(word.indexOf("(")==-1 && op!=6)  curWord = word;
				word = "";
				if(preWord.equals(""))  preWord = curWord;
				else if(op==6)
				{
					curWord = operator(op);
					preWord = operator(preOp);
				}
				else if(curWord.equals("0") && op==1)
				{
					preWord = "NaN";
					NaN = true;
					break;
				}
				else  preWord = operator(op);
				op = 1;
				preOp=0;
				if(eq) eq=!eq;
				break;
			case "percent":
				if(!word.equals("") && word.substring(word.length()-1, word.length()).equals(".")) word = word + "0";
				if(word.equals(""))
				{
					print = print.substring(0, print.length()-3) + " % ";
					op = 2;
					break;
				}
				else print = print.concat(word)+" % ";
				if(NaN)
				{
					word = "";
					break;  //NaN
				}
				if(word.indexOf("(")==-1 && op!=6)  curWord = word;
				word = "";
				if(preWord.equals(""))  preWord = curWord;
				else if(op==6)
				{
					curWord = operator(op);
					preWord = operator(preOp);
				}
				else if(curWord.equals("0") && op==1)
				{
					preWord = "NaN";
					NaN = true;
					break;
				}
				else  preWord = operator(op);
				op = 2;
				preOp=0;
				if(eq) eq=!eq;
				break;
			case "multiply":
				if(!word.equals("") && word.substring(word.length()-1, word.length()).equals(".")) word = word + "0";
				if(word.equals(""))
				{
					print = print.substring(0, print.length()-3) + " * ";
					op = 3;
					break;
				}
				else print = print.concat(word)+" * ";
				if(NaN)
				{
					word = "";
					break;  //NaN
				}
				if(word.indexOf("(")==-1 && op!=6)  curWord = word;
				word = "";
				if(preWord.equals(""))  preWord = curWord;
				else if(op==6)
				{
					curWord = operator(op);
					preWord = operator(preOp);
				}
				else if(curWord.equals("0") && op==1)
				{
					preWord = "NaN";
					NaN = true;
					break;
				}
				else  preWord = operator(op);
				op = 3;
				preOp=0;
				if(eq) eq=!eq;
				break;
			case "nstate":
				if(word.substring(word.length()-1, word.length()).equals(".")) word = word + "0";
				try
				{
					curWord = String.valueOf(nstate(Integer.valueOf(word)));
				}
				catch(NumberFormatException ee)
				{
					curWord = String.valueOf(nstate(Integer.valueOf(curWord)));
				}
				word = "fact("+word+")";
				break;
			case "sub":
				if(!word.equals("") && word.substring(word.length()-1, word.length()).equals(".")) word = word + "0";
				if(word.equals(""))
				{
					print = print.substring(0, print.length()-3) + " - ";
					op = 4;
					break;
				}
				else print = print.concat(word)+" - ";
				if(NaN)
				{
					word = "";
					break;  //NaN
				}
				if(word.indexOf("(")==-1 && op!=6)  curWord = word;
				word = "";
				if(preWord.equals(""))  preWord = curWord;
				else if(op==6)
				{
					curWord = operator(op);
					preWord = operator(preOp);
				}
				else if(curWord.equals("0") && op==1)
				{
					preWord = "NaN";
					NaN = true;
					break;
				}
				else  preWord = operator(op);
				op = 4;
				preOp=0;
				if(eq) eq=!eq;
				break;
			case "log":
				if(word.substring(word.length()-1, word.length()).equals(".")) word = word + "0";
				try
				{
					curWord = String.valueOf(Math.log10(Double.valueOf(word)));
				}
				catch(NumberFormatException ee)
				{
					curWord = String.valueOf(Math.log10(Double.valueOf(curWord)));
				}
				if(curWord.equals("-Infinity"))
				{
					curWord = "";
					preWord = "-Infinity";
					NaN=true;
				}
				else if(Long.valueOf(curWord.substring(curWord.indexOf(".")+1, curWord.length()))==0) 
					curWord = curWord.substring(0, curWord.indexOf("."));
				word = "log("+word+")";
				break;
			case "nod":
				if(word.equals("")) word = "0.";
				else if(word.indexOf(".")==-1)  word = word + ".";
				break;
			case "equal":
				if(word.equals(""))  print = print.substring(0, print.length()-3);
				else print = print.concat(word);
				if(word.indexOf("(")==-1 && op!=6 && !NaN)  curWord = word;
				System.out.println(curWord+ " " + op);
				if(preWord.equals(""))  result = curWord;
				else if(op==6)
				{
					curWord = operator(op);
					result = operator(preOp);
				}
				else if( NaN || (curWord.equals("0") && op==1) )
				{
					NaN = true;
					if(!preWord.equals("-Infinity")) preWord = "NaN";
					result = preWord;
					his = his.concat(print)+" = ".concat(result)+"\r\n";
					print = "";
					word = result;					
					
					mc.setEnabled(false);mr.setEnabled(false);ms.setEnabled(false);madd.setEnabled(false);
					msub.setEnabled(false);back.setEnabled(false);ce.setEnabled(false);
					negative.setEnabled(false);sqrt.setEnabled(false);divide.setEnabled(false);percent.setEnabled(false);
					multiply.setEnabled(false);nstate.setEnabled(false);sub.setEnabled(false);log.setEnabled(false);
					nod.setEnabled(false);equal.setEnabled(false);add.setEnabled(false);exp.setEnabled(false);
					n0.setEnabled(false);n1.setEnabled(false);n2.setEnabled(false);n3.setEnabled(false);n4.setEnabled(false);
					n5.setEnabled(false);n6.setEnabled(false);n7.setEnabled(false);n8.setEnabled(false);n9.setEnabled(false);
					break;
				}
				else  result = operator(op);
				his = his.concat(print)+" = ".concat(result)+"\r\n";
				print = "";
				word = result;
				preWord = "";
				curWord = "";
				eq=true;
				op=0;
				preOp=0;
				break;
			case "add":
				if(!word.equals("") && word.substring(word.length()-1, word.length()).equals(".")) word = word + "0";
				if(word.equals(""))
				{
					print = print.substring(0, print.length()-3) + " + ";
					op = 5;
					break;
				}
				else print = print.concat(word)+" + ";
				if(NaN)
				{
					word = "";
					break;  //NaN
				}
				if(word.indexOf("(")==-1 && op!=6)  curWord = word;
				word = "";
				if(preWord.equals(""))  preWord = curWord;
				else if(op==6)
				{
					curWord = operator(op);
					preWord = operator(preOp);
				}
				else if(curWord.equals("0") && op==1)
				{
					preWord = "NaN";
					NaN = true;
					break;
				}
				else  preWord = operator(op);
				op = 5;
				preOp=0;
				if(eq) eq=!eq;
				break;
			case "exp":
				if(!word.equals("") && word.substring(word.length()-1, word.length()).equals(".")) word = word + "0";
				if(word.equals(""))
				{
					print = print.substring(0, print.length()-3) + " ^ ";
					op = 6;
					break;
				}
				else print = print.concat(word)+" ^ ";
				if(NaN)
				{
					word = "";
					break;  //NaN
				}
				if(word.indexOf("(")==-1)  curWord = word;
				word = "";
				if(preWord.equals(""))  preWord = curWord;
				if(curWord.equals("0") && op==1)
				{
					preWord = "NaN";
					NaN = true;
					break;
				}
				preOp=op;
				op = 6;
				if(eq) eq=!eq;
				break;
			case "n0":
				if(eq) print="";
				if(word.equals("0")) word = "0";
				else if(!word.equals("") && word.substring(word.length()-1, word.length()).equals(")")) word = "0";
				else word = word + "0";
				eq=false;
				break;
			case "n1":
				if(eq)
				{
					word="";
					print="";
				}
				if(word.equals("0")) word = "1";
				else if(!word.equals("") && word.substring(word.length()-1, word.length()).equals(")")) word = "1";
				else word = word + "1";
				eq=false;
				break;
			case "n2":
				if(eq)
				{
					word="";
					print="";
				}
				if(word.equals("0")) word = "2";
				else if(!word.equals("") && word.substring(word.length()-1, word.length()).equals(")")) word = "2";
				else word = word + "2";
				eq=false;
				break;
			case "n3":
				if(eq)
				{
					word="";
					print="";
				}
				if(word.equals("0")) word = "3";
				else if(!word.equals("") && word.substring(word.length()-1, word.length()).equals(")")) word = "3";
				else word = word + "3";
				eq=false;
				break;
			case "n4":
				if(eq)
				{
					word="";
					print="";
				}
				if(word.equals("0")) word = "4";
				else if(!word.equals("") && word.substring(word.length()-1, word.length()).equals(")")) word = "4";
				else word = word + "4";
				eq=false;
				break;
			case "n5":
				if(eq)
				{
					word="";
					print="";
				}
				if(word.equals("0")) word = "5";
				else if(!word.equals("") && word.substring(word.length()-1, word.length()).equals(")")) word = "5";
				else word = word + "5";
				eq=false;
				break;
			case "n6":
				if(eq)
				{
					word="";
					print="";
				}
				if(word.equals("0")) word = "6";
				else if(!word.equals("") && word.substring(word.length()-1, word.length()).equals(")")) word = "6";
				else word = word + "6";
				eq=false;
				break;
			case "n7":
				if(eq)
				{
					word="";
					print="";
				}
				if(word.equals("0")) word = "7";
				else if(!word.equals("") && word.substring(word.length()-1, word.length()).equals(")")) word = "7";
				else word = word + "7";
				eq=false;
				break;
			case "n8":
				if(eq)
				{
					word="";
					print="";
				}
				if(word.equals("0")) word = "8";
				else if(!word.equals("") && word.substring(word.length()-1, word.length()).equals(")")) word = "8";
				else word = word + "8";
				eq=false;
				break;
			case "n9":
				if(eq)
				{
					word="";
					print="";
				}
				if(word.equals("0")) word = "9";
				else if(!word.equals("") && word.substring(word.length()-1, word.length()).equals(")")) word = "9";
				else word = word + "9";
				eq=false;
				break;
			case "showpic":
				picturePane.setVisible(true);
				historyPane.setVisible(false);
				break;
			case "showhis":
				historyPane.setVisible(true);
				picturePane.setVisible(false);
				break;
			case "clearhis":
				his="";
				break;
		}
		label.setText(print+word);
		history.setText(his);
	}
	public String operator(int opCode)
	{
		String s = new String();
		if(opCode!=6)
		{
			BigDecimal b1 = new BigDecimal(preWord);
			BigDecimal b2 = new BigDecimal(curWord);
			switch(opCode)
			{
				case 1:
					s = b1.divide(b2, 10,RoundingMode.HALF_UP).toString();
					break;
				case 2:
					BigDecimal b3[] = b1.divideAndRemainder(b2);
					s = b3[1].toString();
					break;
				case 3:
					s = b1.multiply(b2).toString();
					break;
				case 4:
					s = b1.subtract(b2).toString();
					break;
				case 5:
					s = b1.add(b2).toString();
					break;
			}
		}
		else
		{
			s = String.valueOf(Math.pow(Double.valueOf(curWord),Double.valueOf(word)));
		}
		try
		{
			if(Long.valueOf(s.substring(s.indexOf(".")+1, s.length()))==0) return s.substring(0, s.indexOf("."));
			else
			{
				for(int i=1;i<10;i++)
				{
					if(Long.valueOf(s.substring(s.indexOf(".")+1+i, s.length()))==0) return s.substring(0, s.indexOf(".")+i+1);
				}
			}		
		}
		catch(NumberFormatException eee)
		{
			;
		}
		catch(StringIndexOutOfBoundsException eeee)
		{
			;
		}
		return s;
	}
	public int nstate(int n)
	{
	    if (n <= 1)
	    {
	    	return 1;
	    } 
	    else
	    {
	    	return n * nstate(n - 1);
	    }
	}
}
