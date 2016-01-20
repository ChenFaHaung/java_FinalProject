package ce1002.fp.s102502509;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.security.auth.x500.X500Principal;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class FpOne extends JPanel implements ActionListener// 填資料 寫檔
{
	private JLabel 			lab = new JLabel();
	private JLabel 			lab2 = new JLabel();
	private JLabel 			lab3 = new JLabel();
	private JLabel 			lab4 = new JLabel();
	private JLabel 			lab5 = new JLabel();
	private JLabel 			lab6 = new JLabel();
	private JLabel 			lab7 = new JLabel();
	private JLabel 			lab9 = new JLabel();
	//background picture
	private JLabel label = new JLabel();
	private JTextField 		tb = new JTextField(20);
	private JTextField 		tb2 = new JTextField(3);	
	private JTextField 		tb3 = new JTextField(5);
	private JTextField 		tb4 = new JTextField(5);
	JLabel 		tb7 = new JLabel();
	JButton		tb5 = new JButton();
	JButton		jb = new JButton();
	JButton     bt1 = new JButton();
	double c = 0;
	// 新增按鈕進行下一頁
	JRadioButton chbox = new JRadioButton("男", false);
	JRadioButton chbox1 = new JRadioButton("女", false);
	ButtonGroup bg = new ButtonGroup();// 改單選
	String string = "";
	// 必須先填數字，才能執行
	FpOne()
	{
		//basic setting
		setLayout(null);
		setBounds(0, 0, 500, 500);
		setVisible(false);
		//設背景
		ImageIcon picIcon = new ImageIcon("images (1).jpg");
		//取得畫面大小，設置背景
		picIcon.setImage(picIcon.getImage().getScaledInstance(picIcon.getIconWidth(), 
				                            picIcon.getIconHeight(), Image.SCALE_DEFAULT));
		label.setBounds(0, 0, 500, 500);
		label.setHorizontalAlignment(0);
		label.setIcon(picIcon);
		
		lab.setBounds(10, 0, 90, 30);
		lab.setText("Name: ");
		//name
		tb.setBounds(90, 5, 150, 25);	
		
		lab2.setBounds(10, 30, 90, 30);
		lab2.setText("Age: ");
		//age
		tb2.setBounds(90, 35, 60, 25);
		
		lab3.setBounds(10, 60, 90, 30);
		lab3.setText("Weight: ");
		//weight
		tb3.setBounds(90, 65, 60, 25);
		
		lab4.setBounds(10, 90, 90, 30);
		lab4.setText("Height: ");
		//height
		tb4.setBounds(90, 95, 60, 25);
		lab5.setBounds(160, 60, 20, 30);
		lab5.setText("kg");
		
		lab6.setBounds(160, 90, 20, 30);
		lab6.setText("m");
		
		chbox.setBounds(10, 130, 60, 30);
		chbox1.setBounds(70, 130, 60, 30);
		
		lab7.setBounds(130, 225, 150, 30);
		lab7.setText(" ");// 評語
		
		lab9.setBounds(250, 225, 60, 30);
		
		tb5.setBounds(50, 225, 70, 25);
		tb5.setText("BMI");
		//add box for only-choose
		bg.add(chbox);
		bg.add(chbox1);
		
		jb.setBounds(200, 430, 100, 30);
		jb.setText("Exercise");
		
		bt1.setBounds(40, 430, 100, 30);
		bt1.setText("Back");
		//timer
		tb7.setBounds(10, 165, 300, 30);
		
		add(tb7);
		add(lab);
		add(lab2);
		add(lab3);
		add(lab4);
		add(lab5);
		add(lab6);
		add(lab7);
		add(tb);	
		add(tb2);		
		add(tb3);		
		add(tb4);
		add(tb5);
		add(chbox);
		add(chbox1);
		add(jb);
		add(bt1);
		add(lab9);
		add(label);
		
		tb5.addActionListener(this);
		jb.addActionListener(this);
		bt1.addActionListener(this);
	}//one
	
	@Override
	 public void actionPerformed(ActionEvent event) 
	{
		
		String buttonName = event.getActionCommand();
		//計算BMI
		if(buttonName.equals("BMI"))
		{
			
			double a;// weight
			double b;// height
			//小數格式化，四捨五入到小數點後第二位。
			DecimalFormat df = new DecimalFormat("0.00");
			try 
			{
				// 判斷輸入是否為數字
				isage(tb2.getText()); 
				isNumber(tb4.getText(), tb3.getText());
				//判斷是否勾選性別
				RB();
				//若身高、體重符合條件
				if(java.lang.Character.isDigit(tb4.getText().charAt(0)) && java.lang.Character.isDigit(tb3.getText().charAt(0))){
					a = Double.parseDouble(tb3.getText());
					b = Double.parseDouble(tb4.getText());
					//calculate the BMI
					c = a / (b * b);
				}
				//四捨五入欲改變數字
				String num = df.format(c);
				//增加條件，以排除非數字的計算
				if(c != 0)
				{
					lab9.setText(" " + num);
					//設置時間的格式
					String DATE_FORMAT_NOW = "yyyy-MM-dd E";
					//抓電腦的日期
					Calendar tmpCal = Calendar.getInstance();
					//顯示日期
					SimpleDateFormat tmpSDF = new SimpleDateFormat(DATE_FORMAT_NOW);
					// catch the time
					tb7.setText(tmpSDF.format(tmpCal.getTime()));
					//顯示狀態
					Ctext(c);
				}
				
				
			}
			catch(Exception e)
			{
				// 用setText 才能刷新label
				lab7.setText(string);
			}
			try
			{
				//判斷輸入範圍
				check(tb.getText());
				//建寫入檔
				FileWriter fw = new FileWriter("Your info.txt");
				//加入空格以方便切字
				fw.write(lab.getText());
				fw.write(tb.getText() + " ");
				fw.write(lab2.getText());
				fw.write(tb2.getText() + " ");
				fw.write(lab3.getText());
				fw.write(tb3.getText() + " ");
				fw.write(lab4.getText());
				fw.write(tb4.getText() + " ");
				fw.write("狀態: ");
				fw.write(lab7.getText() + " ");
				fw.write("BMI: ");
				fw.write(lab9.getText() + " ");
				fw.write("紀錄時間: ");
				fw.write(tb7.getText() + " ");
				//記得寫~~
				fw.flush();
				fw.close();
			}
			catch (Exception e) 
			{
				// TODO: handle exception
				JOptionPane.showMessageDialog(this , e.getMessage(), "警告",
						JOptionPane.INFORMATION_MESSAGE);
				// 跳出警告後，重新寫label
				lab7.setText(string);
			}
		}
		else if(buttonName.equals("Exercise"))
		{
			setVisible(false);
			FpMyframe.Showtwo();
		}

		else if(buttonName.equals("Back"))
		{
			setVisible(false);
			FpMyframe.Showstart();
		}
	}
	public boolean RB() throws Exception
	{
		//判斷是否填性別
		if(!chbox1.isSelected() && !chbox.isSelected())
		{
			string = ("填性別");
			throw new Exception();
		}		
		return true;
	}
	public boolean Ctext(double num) throws Exception
	{	
			if(chbox.isSelected())
			{
				if(c >= 18.5 && c <= 24.9)
				{
					string = ("正常喔請繼續保持");
					//記得丟回去
					throw new Exception();
				}
				else if(c >= 25 && c <= 29.9)
				{
					string = ("注意!有些過重");
					throw new Exception();
				}
				else if(c >= 30 && c <= 39.9)
				{
					string = ("太胖了，馬上來運動");
					throw new Exception();
				}
				else if(c >= 40)
				{
					string = ("太恐怖了");
					throw new Exception();
				}
				else if(c < 18.5)
				{
					string = ("太瘦了");
					if(c == 0)
					{
						string = ("");
					}
					throw new Exception();
				}
			}
			else if(chbox1.isSelected())
			{
				if(c >= 17 && c <= 22)
				{
					string = ("正常喔請繼續保持");
					throw new Exception();
				}
				else if(c >= 23 && c <= 28)
				{
					string = ("注意!有些過重");
					throw new Exception();
				}
				else if(c >= 29 && c <= 37)
				{
					string = ("太胖了，馬上來運動");
					throw new Exception();
				}
				else if(c >= 38)
				{
					string = ("太恐怖了");
					throw new Exception();
				}
				else if(c < 17)
				{
					string = ("太瘦了");
					throw new Exception();
				} 
			}
			//not necessary at all		
			else 
			{
				return true;
			}
			//記得回傳值
		return false;
		
	}
	
	public boolean check(String file) throws Exception
	{		// 判斷是否空
		
		if(tb.getText().isEmpty() || tb2.getText().isEmpty() 
				|| tb3.getText().isEmpty() || tb4.getText().equals(""))
		{
			//沒東西，所以做空白label
			string = "";
			lab9.setText("");
			throw new Exception("Full the information!");
		}
		else
		{
			// 判斷大小
			double a = Double.parseDouble(tb3.getText());// weight
			double b = Double.parseDouble(tb4.getText());// height
			
			 if (a < 5.9 || a > 635)
				{
					throw new Exception("Your weight out of range!!");
				}
				
				else if (b < 0.57 || b > 2.72)
				{
					throw new Exception("Your height out of range!!");
				}
				
				else if((a < 5.9 || a > 635) && (b < 0.57 || b > 2.72))
				{
					throw new Exception("Refill your wei. and hei!");// nothing happened
				}

				else 
				{
					return true;
				}
		}
	}
	public boolean isage(String sttr) 
	{
		//判斷字串是否為數字
		if(!java.lang.Character.isDigit(sttr.charAt(0)))
		{
			JOptionPane.showMessageDialog(this , "Age must be an integer!", "警告",
					JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		//字串轉成數字型態判斷範圍。
		else
		{
			int str = Integer.valueOf(sttr).intValue();
			if(str < 0 || str > 122 )
			{
				JOptionPane.showMessageDialog(this , "Your age is out of range!", "警告",
						JOptionPane.INFORMATION_MESSAGE);
				return false;
			}
		}
		return true;
	}
	
	public boolean isNumber(String str, String str1)
	{
		if(!java.lang.Character.isDigit(str.charAt(0)) || !java.lang.Character.isDigit(str1.charAt(0)))
		{
			if(!java.lang.Character.isDigit(str.charAt(0)))
			{
				JOptionPane.showMessageDialog(this, "Height must be a number!", "Error", 
						 JOptionPane.INFORMATION_MESSAGE);
			}
			if(!java.lang.Character.isDigit(str1.charAt(0)))
			{
				JOptionPane.showMessageDialog(this, "Weight must be a number!", "Error", 
						 JOptionPane.INFORMATION_MESSAGE);
			}
			return false;
		}
		return true;
	}
	
	/*private class click implements KeyListener {

		public void keyPressed(KeyEvent arg0) {
			if(arg0.getKeyCode() >= KeyEvent.VK_0 && arg0.getKeyCode() <= KeyEvent.VK_9)
				
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	
	}java textbox 限制輸入 數字
		*/
}// class
