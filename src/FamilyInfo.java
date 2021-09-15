import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FamilyInfo {

	private JFrame frame;
	private JTextField txtname;
	private JTextField txtid;
	private JTextField txtage;
	private JTextField txtFname;
	private JTextField txtMname;
	private JTextField txtContact;
	private JTable table_1;
	private JTextField txtid1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FamilyInfo window = new FamilyInfo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FamilyInfo() {
		initialize();
		Connect();
		table_load();
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	public void Connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/student_family_info", "root","");
        }
        catch (ClassNotFoundException ex) 
        {
          ex.printStackTrace();
        }
        catch (SQLException ex) 
        {
        	   ex.printStackTrace();
        }

    }
	
	 public void table_load()
	    {
	    	try 
	    	{
		    pst = con.prepareStatement("select * from familyinfo");
		    rs = pst.executeQuery();
		    table_1.setModel(DbUtils.resultSetToTableModel(rs));
		} 
	    	catch (SQLException e) 
	    	 {
	    		e.printStackTrace();
		  } 
	    }
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 646, 448);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" Student Family Information ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(125, 0, 370, 48);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "FamilyInfo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(48, 46, 259, 231);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Student Name :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 21, 98, 25);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Student ID :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 51, 98, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Father Name :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 97, 98, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mother Name :");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4.setBounds(10, 122, 98, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Age :");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_5.setBounds(10, 72, 46, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Phone Number :");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_6.setBounds(10, 145, 108, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Address :");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_7.setBounds(10, 170, 98, 14);
		panel.add(lblNewLabel_7);
		
		txtname = new JTextField();
		txtname.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtname.setBounds(112, 24, 118, 20);
		panel.add(txtname);
		txtname.setColumns(10);
		
		txtid = new JTextField();
		txtid.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtid.setColumns(10);
		txtid.setBounds(90, 49, 140, 20);
		panel.add(txtid);
		
		txtage = new JTextField();
		txtage.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtage.setColumns(10);
		txtage.setBounds(75, 72, 155, 20);
		panel.add(txtage);
		
		txtFname = new JTextField();
		txtFname.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtFname.setColumns(10);
		txtFname.setBounds(101, 95, 129, 20);
		panel.add(txtFname);
		
		txtMname = new JTextField();
		txtMname.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtMname.setColumns(10);
		txtMname.setBounds(112, 120, 118, 20);
		panel.add(txtMname);
		
		txtContact = new JTextField();
		txtContact.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtContact.setColumns(10);
		txtContact.setBounds(112, 143, 118, 20);
		panel.add(txtContact);
		
		JTextArea txtAddress = new JTextArea();
		txtAddress.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtAddress.setBounds(76, 171, 154, 49);
		panel.add(txtAddress);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name,ID,Age,Fname,Mname,PhoneNo,Address;
				
				Name = txtname.getText();
				ID = txtid.getText();
				Age = txtage.getText();
				Fname = txtFname.getText();
				Mname = txtMname.getText();
				PhoneNo = txtContact.getText();
				Address = txtAddress.getText();
				
				 try {
						pst = con.prepareStatement("insert into familyinfo(Name,ID,Age,Fname,Mname,PhoneNo,Address)values(?,?,?,?,?,?,?)");
						pst.setString(1, Name);
						pst.setString(2, ID);
						pst.setString(3, Age);
						pst.setString(4, Fname);
						pst.setString(5, Mname);
						pst.setString(6, PhoneNo);
						pst.setString(7, Address);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Record Addedddd!!!!!");
						table_load();
							          
						txtname.setText("");
						txtid.setText("");
						txtage.setText("");
						txtFname.setText("");
						txtMname.setText("");
						txtContact.setText("");
						txtAddress.setText("");
						txtname.requestFocus();
					   }
				 
					catch (SQLException e1) 
				        {
										
					e1.printStackTrace();
					}
				
				
			}
		});
		
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(48, 288, 77, 33);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnEdit = new JButton("Exit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnEdit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnEdit.setBounds(143, 288, 77, 33);
		frame.getContentPane().add(btnEdit);
		
		JButton btnExit = new JButton("Clear");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtname.setText("");
				txtid.setText("");
				txtage.setText("");
				txtFname.setText("");
				txtMname.setText("");
				txtContact.setText("");
				txtAddress.setText("");
				txtid1.setText("");
				txtname.requestFocus();
				
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnExit.setBounds(230, 288, 77, 33);
		frame.getContentPane().add(btnExit);
		
		JScrollPane table = new JScrollPane();
		table.setBounds(311, 50, 275, 271);
		frame.getContentPane().add(table);
		
		table_1 = new JTable();
		table.setViewportView(table_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(48, 332, 259, 66);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("Student ID :");
		lblNewLabel_2_1.setBounds(37, 21, 77, 17);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_1.add(lblNewLabel_2_1);
		
		txtid1 = new JTextField();
		txtid1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				 try {
			          
			            String id = txtid1.getText();

			                pst = con.prepareStatement("select Name,ID,Age,Fname,Mname,PhoneNo,Address from familyinfo where id = ?");
			                pst.setString(1, id);
			                ResultSet rs = pst.executeQuery();

			            if(rs.next()==true)
			            {
			              
			                String Name = rs.getString(1);
			                String ID = rs.getString(2);
			                String Age = rs.getString(3);
			                String Fname = rs.getString(4);
			                String Mname = rs.getString(5);
			                String PhoneNo = rs.getString(6);
			                String Address = rs.getString(7);
			                
			                txtname.setText(Name);
							txtid.setText(ID);
							txtage.setText(Age);
							txtFname.setText(Fname);
							txtMname.setText(Mname);
							txtContact.setText(PhoneNo);
							txtAddress.setText(Address);
			                
			            }   
			            else
			            {
			            	txtname.setText("");
							txtid.setText("");
							txtage.setText("");
							txtFname.setText("");
							txtMname.setText("");
							txtContact.setText("");
							txtAddress.setText("");
			                 
			            }
			        } 
				
				 catch (SQLException ex) {
			           
			        }
				
				
			}
		});
		txtid1.setBounds(122, 19, 96, 22);
		txtid1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtid1.setColumns(10);
		panel_1.add(txtid1);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String Name,ID,Age,Fname,Mname,PhoneNo,Address,sid;
				
				Name = txtname.getText();
				ID = txtid.getText();
				Age = txtage.getText();
				Fname = txtFname.getText();
				Mname = txtMname.getText();
				PhoneNo = txtContact.getText();
				Address = txtAddress.getText();
				sid = txtid1.getText();
				
				 try {
						pst = con.prepareStatement("update familyinfo set Name=?,ID=?,Age=?,Fname=?,Mname=?,PhoneNo=?,Address=? where Id=?");
						pst.setString(1, Name);
						pst.setString(2, ID);
						pst.setString(3, Age);
						pst.setString(4, Fname);
						pst.setString(5, Mname);
						pst.setString(6, PhoneNo);
						pst.setString(7, Address);
						pst.setString(8, sid);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Record Updated!!!!!");
						table_load();
							          
						txtname.setText("");
						txtid.setText("");
						txtage.setText("");
						txtFname.setText("");
						txtMname.setText("");
						txtContact.setText("");
						txtAddress.setText("");
						txtid1.setText("");
						txtname.requestFocus();
					   }
				 
					catch (SQLException e1) 
				    {					
					e1.printStackTrace();
					}
			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnUpdate.setBounds(410, 365, 85, 33);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sid;
				sid = txtid1.getText();
				
				 try {
						pst = con.prepareStatement("delete from familyinfo where Id=?");
						pst.setString(1, sid);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Record Deleted!!!!!");
						table_load();
						
						txtname.setText("");
						txtid.setText("");
						txtage.setText("");
						txtFname.setText("");
						txtMname.setText("");
						txtContact.setText("");
						txtAddress.setText("");
						txtid1.setText("");
						txtname.requestFocus();	          
					   }
				 
					catch (SQLException e1) 
				    {					
					e1.printStackTrace();
					}
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDelete.setBounds(505, 365, 90, 33);
		frame.getContentPane().add(btnDelete);
	}
}
