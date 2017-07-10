package Main;

import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import dao.Dao;

public class Stats extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table ;
	private Vector<String> c_name ;
	private Vector<Vector<Object>> data ;
	private model model ;
	private JScrollPane scrollPane ;
	private Dao dao ;
	private ResultSet rs ;
	private JComboBox<String> list ; 
	private Vector<String> list_ele =new Vector<String>() ;
	private Vector<String> tmp = new Vector<String>() ;
	/**	
	 * Create the panel.
	 */
	public Stats(Dao dao) {
		this.dao =  dao ;
		initial() ;
	}
	public void getData(){
		c_name.add("编  号") ;
		c_name.add("名  称") ;
		c_name.add("数  量") ;
		c_name.add("价  格") ;
		c_name.add("日  期") ;
		
		rs = dao.executeQuery("select *from Tb_Sale") ;
		try{
			while(rs.next()){
				Vector<Object> temp = new Vector<Object>() ;
				temp.add(rs.getInt("id")) ;
				temp.add(rs.getString("tb_title").trim()) ;
				temp.add(rs.getInt("tb_nums")) ;
				temp.add(rs.getFloat("tb_value")) ;
				temp.add(rs.getString("tb_date")) ;
				data.add(temp);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void list_update(){
		rs = dao.executeQuery("select tb_title from Tb_Sale") ;
		tmp.clear(); 
		try{
			while(rs.next()){
				if(!list_ele.contains(rs.getString("tb_title").trim())){
					tmp.addElement(rs.getString("tb_title"));
					list_ele.addElement(rs.getString("tb_title"));
				}
			}
			for(String i:tmp){
				list.addItem(i);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public void update(String str){
		data.clear();
		if(str.equals("全部")){
		rs = dao.executeQuery("select *from Tb_Sale") ;
		try{
			while(rs.next()){
				Vector<Object> temp = new Vector<Object>() ;
				temp.add(rs.getInt("id")) ;
				temp.add(rs.getString("tb_title").trim()) ;
				temp.add(rs.getInt("tb_nums")) ;
				temp.add(rs.getFloat("tb_value")) ;
				temp.add(rs.getString("tb_date")) ;
				data.add(temp);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		model = new model() ;
		table.setModel(model);
		}
		else{
			rs = dao.executeQuery("select *from Tb_Sale where tb_title='"+str+"'") ;
			try{
				while(rs.next()){
					Vector<Object> temp = new Vector<Object>() ;
					temp.add(rs.getInt("id")) ;
					temp.add(rs.getString("tb_title").trim()) ;
					temp.add(rs.getInt("tb_nums")) ;
					temp.add(rs.getFloat("tb_value")) ;
					temp.add(rs.getString("tb_date")) ;
					data.add(temp);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			model = new model() ;
			table.setModel(model);
		}
	}
	
	
	public void initial(){
		list = new JComboBox<String>() ;
		list.addItem("全部");
		list.setBounds(100, 40, 150, 30);
		list_update() ;
		this.setBounds(200, 0, 900, 600);
		this.setLayout(null);
		data = new Vector<Vector<Object>>() ;
		c_name = new Vector<String>() ;
		getData() ;
		model = new model() ;
		table = new JTable() ;
		table.setModel(model);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(100, 100, 700, 350);
		table.setBorder(getBorder());
		table.setBounds(0, 0, 700, 350);
		this.add(scrollPane);
		add(list) ;
	}

	
	public JComboBox<String> getList() {
		return list;
	}
	public void setList(JComboBox<String> list) {
		this.list = list;
	}	
	
	class model extends AbstractTableModel{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return data.size();
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return c_name.size();
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return data.get(rowIndex).get(columnIndex);
		}
		public String getColumnName(int column) {
			  return c_name.get(column);
		}
		
	}
}
