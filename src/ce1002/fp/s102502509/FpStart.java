package ce1002.fp.s102502509;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FpStart extends JPanel implements ActionListener// 切panel
{
	private JButton bt = new JButton("Start");
	private JButton bt1 = new JButton("Load");
	private JButton bt2 = new JButton("Exit");
	private JButton bt3 = new JButton("Direction");
	//準備放入音樂
	private Clip clip; 
	
	//CardLayout card;
	FpStart()
	{
		//card = new CardLayout();
		setLayout(null);
		setLocation(0, 0);
		setSize(500, 500);
		//加入背景
		ImageIcon image = new ImageIcon("images.jpg");
		JLabel label = new JLabel(image);
		
		bt.setBounds(350, 200, 100, 30);
		bt1.setBounds(350, 250, 100, 30);
		bt2.setBounds(350, 400, 100, 30);
		bt3.setBounds(350, 300, 100, 30);
		label.setBounds(0, 0, 500, 500);
		
		try 
		{
			//音樂加入程式
			AudioInputStream music = AudioSystem.getAudioInputStream
					(new File("Need to be next to you.wav").getAbsoluteFile());
			//給入clip
			clip = AudioSystem.getClip();
			clip.open(music);
			clip.start();
			//重複三遍
			clip.loop(3);
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			System.out.println("File can't be found");
			e.printStackTrace();
		}
		add(bt);
		add(bt1);
		add(bt2);
		add(bt3);
		add(label);
				
		bt.addActionListener(this);
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
	
}//Fpstart
	@Override
	 public void actionPerformed(ActionEvent event) 
	{
		//增加動作指令
		String buttonName = event.getActionCommand();
		if(buttonName.equals("Start"))
		{
			// 遮此panel進行下一個panel。
		setVisible(false);
		FpMyframe.Showone();
		
		}
		
		else if(buttonName.equals("Exit"))
		{
			int result = JOptionPane.showConfirmDialog(this, "是否離開?");
			if(result == 0)
			{
				//close the frame
				System.exit(0);
			}
		}
		
		else if(buttonName.equals("Direction"))
		{
			setVisible(false);
			FpMyframe.Showdirection();
		}
		
		else 
		{
			setVisible(false);
			FpMyframe.Showend();
		}
	}
	
}// class
