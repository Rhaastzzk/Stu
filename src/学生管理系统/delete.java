package 学生管理系统;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class delete extends J10 implements ActionListener{ //删除
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton b0,b1,b2,b3;
	JTextField t1,t2;
	delete(int i){
		if(i==0) {
			setSize(300,200);
			setTitle("删除学生信息");
			t1 = new JTextField(10);
			
			JLabel l1 = new JLabel("学号："); 
			
			setLayout(new GridLayout(2,1));
			JPanel p1 = new JPanel();
			
			p1.add(l1);
			p1.add(t1);
			this.add(p1);
			
			JPanel p10 = new JPanel();
			b0 = new JButton("删除"); 
			b0.addActionListener(this);
			p10.add(b0); add(p10);
			setLocationRelativeTo(null);
			setResizable(false); 
			setVisible(true);
		}else if(i==1) {
			setSize(300,200);
			setTitle("删除课程信息");
			t1 = new JTextField(10);
			
			JLabel l1 = new JLabel("课程号："); 
			
			setLayout(new GridLayout(2,1));
			JPanel p1 = new JPanel();
			
			p1.add(l1);
			p1.add(t1);
			this.add(p1);
			
			JPanel p10 = new JPanel();
			b1 = new JButton("删除"); 
			b1.addActionListener(this);
			p10.add(b1); add(p10);
			setLocationRelativeTo(null);
			setResizable(false); 
			setVisible(true);
		}else if(i==2) {
			setSize(300,200);
			setTitle("删除选课信息");
			t1 = new JTextField(10);
			t2 = new JTextField(10);
			
			JLabel l1 = new JLabel("学号："); 
			JLabel l2 = new JLabel("课程号："); 
			
			setLayout(new GridLayout(3,1));
			JPanel p1 = new JPanel();
			JPanel p2 = new JPanel();
			
			p1.add(l1);p1.add(t1);
			p2.add(l2);p2.add(t2);
			this.add(p1);this.add(p2);
			
			JPanel p10 = new JPanel();
			b2 = new JButton("删除"); 
			b2.addActionListener(this);
			p10.add(b2); add(p10);
			setLocationRelativeTo(null);
			setResizable(false); 
			setVisible(true);
		}else if(i==3) {
			setSize(300,200);
			setTitle("删除成绩信息");
			t1 = new JTextField(10);
			t2 = new JTextField(10);
			
			JLabel l1 = new JLabel("学号："); 
			JLabel l2 = new JLabel("课程号："); 
			
			setLayout(new GridLayout(3,1));
			JPanel p1 = new JPanel();
			JPanel p2 = new JPanel();
			
			p1.add(l1);p1.add(t1);
			p2.add(l2);p2.add(t2);
			this.add(p1);this.add(p2);
			
			JPanel p10 = new JPanel();
			b3 = new JButton("删除"); 
			b3.addActionListener(this);
			p10.add(b3); add(p10);
			setLocationRelativeTo(null);
			setResizable(false); 
			setVisible(true);
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == b0) {
			String num = this.t1.getText();
			
			JDB1 x = new JDB1();
			try {
				JDB1.OpenConn();
				String sql = "select * from student where snum="+num;
				JDB1.rs = x.executeQuery(sql);
	            if(!JDB1.rs.next()) setTitle("删除失败！！！");
	            else setTitle("删除成功！！！");
	            
				sql = "delete from student where snum="+num;
				System.out.println(sql);
				x.executeUpdate(sql);
			}catch(Exception e1) {
				System.err.println(e1.getMessage());
			}
			x.closeStmt();
			x.closeConn();
		}else if(obj==b1) {
			String con = this.t1.getText();
			
			JDB1 x = new JDB1();
			try {
				JDB1.OpenConn();
				String sql = "select * from class where con="+con;
				JDB1.rs = x.executeQuery(sql);
	            if(!JDB1.rs.next()) setTitle("删除失败！！！");
	            else setTitle("删除成功！！！");
	            
				sql = "delete from class where con="+con;
				System.out.println(sql);
				x.executeUpdate(sql);
			}catch(Exception e1) {
				System.err.println(e1.getMessage());
			}
			x.closeStmt();
			x.closeConn();
		}else if(obj==b2) {
			String sno = this.t1.getText();
			String con = this.t2.getText();
			
			JDB1 x = new JDB1();
			try {
				JDB1.OpenConn();
				String sql = "select * from sc where sno='"+sno+"' and con='"+con+"'";
				JDB1.rs = x.executeQuery(sql);
	            if(!JDB1.rs.next()) setTitle("删除失败！！！");
	            else setTitle("删除成功！！！");
	            
				sql = "delete from sc where sno='"+sno+"' and con='"+con+"'";
				System.out.println(sql);
				x.executeUpdate(sql);
			}catch(Exception e1) {
				System.err.println(e1.getMessage());
			}
			x.closeStmt();
			x.closeConn();
		}else if(obj==b3) {
			String sno = this.t1.getText();
			String con = this.t2.getText();
			
			JDB1 x = new JDB1();
			try {
				JDB1.OpenConn();
				String sql = "select * from grade where sno='"+sno+"' and con='"+con+"'";
				JDB1.rs = x.executeQuery(sql);
	            if(!JDB1.rs.next()) setTitle("删除失败！！！");
	            else setTitle("删除成功！！！");
	            
				sql = "delete from grade where sno='"+sno+"' and con='"+con+"'";
				System.out.println(sql);
				x.executeUpdate(sql);
			}catch(Exception e1) {
				System.err.println(e1.getMessage());
			}
			x.closeStmt();
			x.closeConn();
		}
}
	
}	
