package ce1002.fp.s102502509;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FpEnd extends JPanel implements ActionListener // 顯示紀錄  
{
	private JButton bt = new JButton("Check");
	private JButton btn3 = new JButton("Back");
	private JButton btn4 = new JButton("Exit");
	private JButton btn5 = new JButton("Home");
	private JLabel label = new JLabel();
	private JLabel label2 = new JLabel();
	private JLabel label3 = new JLabel(); 
	private JLabel label4 = new JLabel(); 
	private JLabel label5 = new JLabel(); 
	private JLabel label6 = new JLabel(); 
	private JLabel label7 = new JLabel(); 
	private JLabel label8 = new JLabel(); 
	
	FpEnd()
	{
		setLayout(null);
		setBounds(0, 0, 500, 500);
		setVisible(false);
		bt.setBounds(160, 30, 150, 30);
		btn3.setBounds(40, 430, 100, 30);//back
		btn4.setBounds(200, 430, 100, 30);//exit
		btn5.setBounds(350, 430, 100, 30);//home
		
		ImageIcon picIcon = new ImageIcon("images (2).jpg");
		picIcon.setImage(picIcon.getImage().getScaledInstance(picIcon.getIconWidth(), 
				                            picIcon.getIconHeight(), Image.SCALE_DEFAULT));
		label.setBounds(0, 0, 500, 500);
		label.setHorizontalAlignment(0);
		label.setIcon(picIcon);
		
		label2.setBounds(145, 75, 400, 17);
		label3.setBounds(145, 100, 400, 17);
		label4.setBounds(145, 125, 400, 17);
		label5.setBounds(145, 150, 400, 17);
		label6.setBounds(145, 175, 400, 17);
		label7.setBounds(145, 200, 400, 17);
		label8.setBounds(145, 225, 400, 17);
		
		add(bt);
		add(btn3);//back
		add(btn4);//next
		add(btn5);//home
		add(label2);
		add(label3);
		add(label4);
		add(label5);
		add(label6);
		add(label7);
		add(label8);
		add(label);
		
		bt.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		
	}// end
	
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			//宣告判斷的名字
			String buttonName = e.getActionCommand();
			if(buttonName.equals("Check"))// 讀檔，顯示紀錄
			{
				//讀取檔案
				FileReader fr = new FileReader("Your info.txt");
				//讀檔媒介
				BufferedReader br = new BufferedReader(fr);
				//切字串
				String str = br.readLine().toString();
				//利用讀取空格來切字
				String[] AfterSplit = str.split(" ");
				//利用陣列儲存字串。
				label2.setText(AfterSplit[0] + " " + AfterSplit[1]);
				label3.setText(AfterSplit[2] + " " + AfterSplit[3]);
				label4.setText(AfterSplit[4] + " " + AfterSplit[5]);
				label5.setText(AfterSplit[6] + " " + AfterSplit[7]);
				label6.setText(AfterSplit[8] + " " + AfterSplit[9]);
				label7.setText(AfterSplit[10] + " " + AfterSplit[11]+ " " + AfterSplit[12]);
				label8.setText(AfterSplit[13] + " " + AfterSplit[14]+ " " + AfterSplit[15]);
				br.close();
				
			}
			else if(buttonName.equals("Back"))// back
			{
				setVisible(false);
				FpMyframe.Showtwo();
			}
			// exit 出現對話視窗選擇是否離開
			else if(buttonName.equals("Exit"))
			{
				//創造選項對話窗
				int result = JOptionPane.showConfirmDialog(this, "是否離開?");
				if(result == 0)
				{
					//close the frame
					System.exit(0);
				}
			}
			
			else if(buttonName.equals("Home"))//home
			{
				setVisible(false);
				FpMyframe.Showstart();
			}
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(bt, exp.getMessage(), 
					                      "警告", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
}// class 
