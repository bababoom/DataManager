package Main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Vector;

import dao.Dao;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

public class Kc_manager extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table ;
	private JLabel title ;
	private JLabel style ;
	private JLabel num ;
	private JLabel value ;
	private JLabel mark ;
	private JLabel id ;
	private JButton add_button ;
	private JButton delete_button ;
	private JButton modify_button ;
	private JButton save_button ;
	private Vector<Object[]> data ;
	private Vector<String> columnNames ;
	private JScrollPane scrollPane ;
	private ResultSet rs ;
	private Dao dao ;
	private model model ;
	private String temp ;
	private JLabel tip ;
	/**
	 * Create the panel.
	 */
	public Kc_manager(Dao dao) {
		this.dao = dao ;
		setLayout(null);
		initial() ;
		
	}
	public void update(){
		String title,style,mark ;
		int num,id;
		float value ;
		rs = dao.executeQuery("select *from Tb_kc") ;
		try{
			while(rs.next()){
				id = rs.getInt("id") ;
				title = rs.getString("tb_title")==null?"--":rs.getString("tb_title").trim() ;
				mark = rs.getString("tb_mark")==null ?"暂无介绍":rs.getString("tb_mark").trim() ;
				value = rs.getFloat("tb_value") ;
				style = rs.getString("tb_style")==null?"--":rs.getString("tb_style").trim() ;
				num = rs.getInt("tb_nums") ;
				data.addElement(new Object[]{id,title,value,num,style,mark});
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public void reupdate(){
		String title,style,mark ;
		int num,id;
		float value ;
		rs = dao.executeQuery("select *from Tb_kc") ;
		data.clear();
		try{
			while(rs.next()){
				id = rs.getInt("id") ;
				title = rs.getString("tb_title")==null?"--":rs.getString("tb_title").trim() ;
				mark = rs.getString("tb_mark")==null ?"暂无介绍":rs.getString("tb_mark").trim() ;
				value = rs.getFloat("tb_value") ;
				style = rs.getString("tb_style")==null?"--":rs.getString("tb_style").trim() ;
				num = rs.getInt("tb_nums") ;
				data.addElement(new Object[]{id,title,value,num,style,mark});
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		model = new model() ;
		table.setModel(model);
		this.repaint();
	}
	public void initial(){
		tip = new JLabel("");
		tip.setForeground(Color.RED);
		tip.setBounds(95, 420, 200, 50);
		add(tip) ;
		columnNames = new  Vector<String>() ;
		data = new Vector<Object[]>() ;
		columnNames.add("编  号") ;
		columnNames.add("名  称") ;
		columnNames.add("单  价") ;
		columnNames.add("数  量") ;
		columnNames.add("类  别") ;
		columnNames.add("备  注") ;
		this.update();
		this.setBounds(200, 0, 900, 600);
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(124, 110, 169, 44);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(124, 160, 169, 44);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(124, 212, 169, 44);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(124, 264, 169, 44);
		add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(124, 316, 169, 44);
		add(textField_5);
		textField_5.setColumns(10);
		
		
		title = new JLabel("名称 ：");
		title.setBounds(14, 110, 96, 44);
		add(title);
		
		style = new JLabel("类别 ：");
		style.setBounds(14, 160, 96, 44);
		add(style);
		
		num = new JLabel("数量 ：");
		num.setBounds(14, 212, 96, 44);
		add(num);
		
		value = new JLabel("单价 ：");
		value.setBounds(14, 264, 96, 44);
		add(value);
		
		mark = new JLabel("备注 ：");
		mark.setBounds(14, 316, 96, 44);
		add(mark);
		model = new model() ;
		table = new JTable() ;
		table.setModel(model);
	
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				// TODO Auto-generated method stub
				if(!e.getValueIsAdjusting()){
					if(table.getSelectedRow()!=-1){
						Object[] a;
						
				         a = data.elementAt(table.getSelectedRow()) ;
				         temp = a[0].toString() ;
				        // System.out.println(id);
				         textField_1.setText(a[1].toString());
				         textField_2.setText(a[4].toString());
				         textField_3.setText(a[3].toString());
				         textField_4.setText(a[2].toString());
				         textField_5.setText(a[5].toString());
				        
				         
					}else{
						textField_1.setText("");
				         textField_2.setText("");
				         textField_3.setText("");
				         textField_4.setText("");
				         textField_5.setText("");
					}
			}
			}
			
		});
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(350, 60, 450, 300);
		table.setBorder(getBorder());
		table.setBounds(0, 0, 450, 300);
		add(scrollPane);
		
		
		add_button = new JButton("添  加") ;
		add_button.setBounds(95, 500, 80, 44);
		add(add_button) ;
		
		delete_button = new JButton("删  除") ;
		delete_button.setBounds(205, 500, 80, 44);
		add(delete_button) ;
		
		modify_button = new JButton("修  改") ;
		modify_button.setBounds(315, 500, 80, 44);
		add(modify_button) ;
		

		modify_button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(temp!=null){
					String title = textField_1.getText().trim() ;
			         String style = textField_2.getText().trim() ;
			         String num = textField_3.getText().trim() ;
			         String value = textField_4.getText().trim() ;
			         String mark = textField_5.getText().trim() ;
			         
				         String sql = "update Tb_kc set tb_title = '"+title+"',tb_style='"+style+"',tb_nums="+num+
				        		 ",tb_value="+value+",tb_mark='"+mark+"' where id="+temp ;
				         temp = null ;
				        // System.out.println(sql);
				        dao.execute(sql);
				        reupdate() ;
				        
			}
		         
		        
			}
        	 
         });
       
         delete_button.addActionListener(new ActionListener(){
        	 
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(temp!=null){
				String sql = "delete from Tb_kc where id="+temp ;
				
				//System.out.println(sql);
				//System.out.println(temp);
				dao.execute(sql);
				reupdate() ;
				}
				
			}
        	 
         });
         add_button.addActionListener(new ActionListener(){

 			@Override
 			public void actionPerformed(ActionEvent e) {
 				// TODO Auto-generated method stub
 				String title = textField_1.getText().trim() ;
		         String style = textField_2.getText().trim() ;
		         String num = textField_3.getText().trim() ;
		         String value = textField_4.getText().trim() ;
		         String mark = textField_5.getText().trim() ;
		         if(isNumber(num)){
		        	 String sql = "insert into Tb_kc(id,tb_title,tb_mark,tb_nums,tb_value,tb_style) values(NULL,'"+title+"','"
		        			 +mark+"',"+num+","+value+",'"+style+"')" ;
		        	 dao.execute(sql);
		        	 tip.setText("");
		        	 reupdate() ;
		         }
		         else{
		        	 tip.setText("数据不合法，请重试！");
		         }
		         
 			}
 			
 		});

	}
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	class model extends AbstractTableModel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return data.size() ;
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return columnNames.size();
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return data.get(rowIndex)[columnIndex];
		}
		 public String getColumnName(int column) {
			  return columnNames.get(column);
		}
		
	}
	public static boolean isNumber(String str)
	{
		return str.matches("[0-9]+") ;
	} 
	
}
