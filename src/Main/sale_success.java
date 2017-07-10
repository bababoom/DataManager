package Main;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class sale_success extends JPanel {

	/**
	 * Create the panel.
	 */
	private JButton btnNewButton ;
	public sale_success() {
		this.setBounds(0, 0, 450, 300);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8D2D\u4E70\u6210\u529F\uFF01");
		lblNewLabel.setBounds(191, 92, 118, 51);
		add(lblNewLabel);
		
		btnNewButton = new JButton("\u786E  \u5B9A");
		btnNewButton.setBounds(172, 205, 100, 38);
		add(btnNewButton);
		
	}
	public JButton getBtnNewButton() {
		return btnNewButton;
	}
	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}
}
