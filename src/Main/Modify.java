package Main;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Modify extends JPanel {
	private JLabel name_text;
	private JPasswordField old_password ;
	private JPasswordField new_password ;
	private JLabel old_text ;
	private JLabel new_text ;
	private JLabel sure_text ;
	private JPasswordField sure_password;
	private JButton sure ;
	private String name ;
	private JLabel tip ;
	/**
	 * Create the panel.
	 */
	public JButton getSure(){
		return this.sure ;
	}
	public JPasswordField getOld(){
		return this.old_password ;
	}
	public JPasswordField getNew(){
		return this.new_password ;
	}
	public JPasswordField getSure_password(){
		return this.sure_password ;
	}
	public JLabel getTip(){
		return this.tip ;
	}
	public Modify(String name) {
		this.name = name ;
		this.setBounds(200, 0,900,600);
		this.setLayout(null);
		
		initial() ;
	}
	public String getName(){
		return this.name ;
	}
	public void initial(){
		
		tip = new JLabel("") ;
		tip.setBounds(200, 20, 500, 80);
		tip.setForeground(Color.RED);
		add(tip) ;
		
		JLabel label = new JLabel("用 户 名： ");
		label.setBounds(183, 120, 153, 50);
		add(label);
		
		name_text = new JLabel(name);
		name_text.setBounds(362, 120, 243, 50);
		add(name_text);
		
		
		old_text = new JLabel("旧 密 码： ");
		old_text.setBounds(183, 220, 153, 50);
		add(old_text);
		
		old_password = new JPasswordField("") ;
		old_password.setBounds(362, 220, 243, 50);
		add(old_password) ;
		
		new_text = new JLabel("新 密 码： ");
		new_text.setBounds(183, 320, 153, 50);
		add(new_text);
		
		new_password = new JPasswordField("") ;
		new_password.setBounds(362, 320, 243, 50);
		add(new_password) ;
		
		sure_text = new JLabel("再次确认新密码：") ;
		sure_text.setBounds(183, 420, 153, 50);
		add(sure_text) ;
		
		sure_password = new JPasswordField("") ;
		sure_password.setBounds(362, 420, 243, 50);
		add(sure_password) ;
		
		sure = new JButton("确 认 修 改");
		sure.setBounds(326, 520, 119, 50);
		add(sure);
	}
}
