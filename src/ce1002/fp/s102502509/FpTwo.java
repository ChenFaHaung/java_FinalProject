package ce1002.fp.s102502509;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class FpTwo extends JPanel implements ActionListener// 計時器
{
	private Timer timer = new Timer(1000, this); 
	private Label lab = new Label("Ready");
	private Label lab1 = new Label("Timer");
	private JLabel lab2 = new JLabel();
	private JButton btn1 = new JButton("Start");
	private JButton btn2 = new JButton("Stop");
	private JButton btn7 = new JButton("ReStart");
	private long startTime;
	private long passTime;
	private boolean start,pause;
	private int hour, minute, second;
	private int Calorie;
	private JButton btn3 = new JButton("Back");
	private JButton btn4 = new JButton("Next");
	private JButton btn5 = new JButton("Home");
	private JButton btn6 = new JButton("Consume");
	private JLabel label = new JLabel();

	//add a button for the direction of the timer
	
	FpTwo()
	{
		// usually setting
		setLayout(null);
		setBounds(0, 0, 500, 500);
		setVisible(false);
		
		lab.setBounds(100, 30, 200, 50);//Ready
		lab.setFont(new Font("標楷體", Font.BOLD, 17));
		
		lab1.setBounds(120, 0, 100, 40);//Timer
		lab1.setFont(new Font("標楷體", Font.BOLD, 17));
		
		lab2.setBounds(5, 130, 400, 100);
		//label中顯示try again 所以先看不到
		lab2.setVisible(false);
		btn1.setBounds(320, 30, 90, 30);//start
		btn2.setBounds(320, 80, 90, 30);//stop
		btn3.setBounds(40, 430, 100, 30);//back
		btn4.setBounds(200, 430, 100, 30);//next
		btn5.setBounds(350, 430, 100, 30);//home
		btn7.setBounds(200, 230, 100, 30);
		btn7.setVisible(false);
		//按下後，文字覆蓋
		btn6.setBounds(200, 200, 100, 30);
		//讀入圖檔當背景
		ImageIcon picIcon = new ImageIcon("wd.jpg");
		picIcon.setImage(picIcon.getImage().getScaledInstance(picIcon.getIconWidth(), 
				                            picIcon.getIconHeight(), Image.SCALE_DEFAULT));
		label.setBounds(0, 0, 500, 500);
		label.setHorizontalAlignment(0);
		label.setIcon(picIcon);
		
		add(lab);
		add(lab1);
		add(lab2);
		add(btn1);
		add(btn2);//stop
		add(btn3);//back
		add(btn4);//next
		add(btn5);//home
		add(btn6);
		add(btn7);
		add(label);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		
	}// one
	public void actionPerformed(ActionEvent actionEvent)
	{
		if(actionEvent.getSource() == btn1)
		{
			//timer work
			if(!start)
			{
				timer.start();
				passTime = 0;
				//回傳現在的時間
				startTime = System.currentTimeMillis();
				btn1.setText("Pause");
				start = true;
			}
			else if(!pause)// timer stop
			{
				timer.stop();
				btn1.setText("Start");
				pause = true;
			}
			else// timer start
			{
				//抓時間繼續計時
				startTime = System.currentTimeMillis();
				timer.restart();
				btn1.setText("Pause");
				pause = false;
			}
		}
		else if (actionEvent.getSource() == btn2)
		{
			timer.stop();
			lab.setText("Try again");
			btn1.setText("Start");
			//reset the button
			start = false;
			pause = false;
		}
		
		else if(actionEvent.getSource() == btn3)// back
		{
			setVisible(false);
			FpMyframe.Showone();
		}
		
		else if(actionEvent.getSource() == btn4)// next
		{
			setVisible(false);
			FpMyframe.Showend();
		}
		
		else if(actionEvent.getSource() == btn5)//home
		{
			setVisible(false);
			FpMyframe.Showstart();
		}
		//按鍵消失，顯示"恭喜消耗__大卡/每公斤/每小時" recalculate
		else if(actionEvent.getSource() == btn6)
		{
			cal();//數值讀取
			btn6.setVisible(false);
			System.out.println(cal());
			//顯示label 中字串換行使用html語法
			lab2.setText("<html>Well done!" 
						+ "<br>You have already burned " + cal() + " kcal/kilo*hr!</html>" );
			lab2.setFont(new Font("標楷體", Font.BOLD, 17));
			lab2.setVisible(true);
			btn7.setVisible(true);
		}
		
		else if(actionEvent.getSource() == btn7)
		{
			//重新計算一次
			lab2.setVisible(false);
			btn7.setVisible(false);
			btn6.setVisible(true);
			timer.stop();
			lab.setText("Try again");
			btn1.setText("Start");
			start = false;
			pause = false;
		}
		else 
		{
			//time counter
			passTime += System.currentTimeMillis() - startTime;
			startTime = System.currentTimeMillis();

			hour = (int)((passTime/1000) / (60 * 60)) ;
			minute = (int)(((passTime/1000) / 60) % 60);
			second = (int)(passTime/1000) % 60;
			//System.out.println((0.5*4.4));
			//顯示時間
			lab.setText(String.valueOf(hour) + " hr : " 
					  + String.valueOf(minute) + " min : "
					  + String.valueOf(second) + " sec");
		}
	}
	public String cal()//顯示計算
	{
		double cal = 0;
		DecimalFormat df = new DecimalFormat("0.0000");
		//轉型回來
		cal = (hour + ((double)minute/60) + ((double)second/3600))* 4.4;
		String num = df.format(cal);
		return num;
	}

}// class
