package Main;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class person extends JPanel {
	private JLabel name_label ;
	private String name ;
	/**
	 * Create the panel.
	 */
	
	public person(String name) {
		this.name = name ;
		initial() ;
	}
	public void initial(){
		this.setBounds(550, 620, 300, 40);
		this.setLayout(null);
		name_label = new JLabel("当前管理员： "+name) ;
		name_label.setBounds(0, 0,250 , 40);
		this.add(name_label);
	}
}
