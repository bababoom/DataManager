package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class success_modify extends JPanel {

	/**
	 * Create the panel.
	 */
	public success_modify() {
		this.setBounds(0, 0, 450, 300);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u4FEE\u6539\u6210\u529F\uFF01\u8BF7\u70B9\u51FB\u786E\u5B9A\u9000\u51FA\u7A0B\u5E8F\u91CD\u542F\u767B\u5F55");
		lblNewLabel.setBounds(87, 97, 303, 58);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u786E    \u5B9A");
		btnNewButton.setBounds(154, 208, 120, 50);
		add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				System.exit(0) ;
			}
			
		});
	}
}
