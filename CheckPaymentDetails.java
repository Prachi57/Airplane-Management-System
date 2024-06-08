/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AMS;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class CheckPaymentDetails extends JFrame
{
    JTable table;
    JLabel Sector,FlightCode,Capacity,Classcode,Classname,label;
    JTextField textField;
    
    public static void main(String[] args)
    {
        new CheckPaymentDetails();
        
    }
    CheckPaymentDetails()
    {
        initialize();
        
    }
    private void initialize()
    {
        setTitle("Payment Details");
        getContentPane().setBackground(Color.WHITE);
        setSize(860,486);
        setLayout(null);
        
        JLabel Fcode =new JLabel("Username");
        Fcode.setFont(new Font("Arial",Font.BOLD,16));
        Fcode.setBounds(190,160,150,26);
        add(Fcode);
        
        textField=new JTextField();
        textField.setBounds(300,160,150,26);
        textField.setFont(new Font("Arial",Font.BOLD,14));
        add(textField);
        
        table=new JTable();
        table.setBounds(93,297,766,87);
        add(table);
        
        JButton Show=new JButton("Show");
        Show.setFont(new Font("Arial",Font.BOLD,14));
        Show.setBounds(500,160,150,26);
        Show.setBackground(Color.BLACK);
        Show.setForeground(Color.WHITE);
        add(Show);
        
        Sector=new JLabel("Check Payment Details");
        Sector.setForeground(Color.BLUE);
        Sector.setFont(new Font("Arial",Font.BOLD,33));
        Sector.setBounds(291,17,800,39);
        add(Sector);
        
        FlightCode=new JLabel("Ticket Id");
        FlightCode.setFont(new Font("Arial",Font.BOLD,14));
        FlightCode.setBounds(117,262,108,26);
        add(FlightCode);
        
        
        Capacity=new JLabel("Price");
        Capacity.setFont(new Font("Arial",Font.BOLD,14));
        Capacity.setBounds(237,268,38,14);
        add(Capacity);
                
                
        Classcode=new JLabel("Journey Date");
        Classcode.setFont(new Font("Arial",Font.BOLD,14));
        Classcode.setBounds(362,264,101,24);
        add(Classcode);
        
        
        Classname=new JLabel("Journey Time");
        Classname.setFont(new Font("Arial",Font.BOLD,14));
        Classname.setBounds(485,268,114,14);
        add(Classname);
        
        
        
        JLabel Cardno=new JLabel("Username");
        Cardno.setFont(new Font("Arial",Font.BOLD,14));
        Cardno.setBounds(620,269,101,19);
        add(Cardno);
        
        JLabel Phoneno=new JLabel("Status");
        Phoneno.setFont(new Font("Arial",Font.BOLD,14));
        Phoneno.setBounds(752,264,86,24);
        add(Phoneno);
        
        
        label=new JLabel("");//null value
        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("AMS\\icon\\plane.jpg"));
        Image img=ic.getImage().getScaledInstance(700,370,Image.SCALE_SMOOTH);
        ImageIcon ic1=new ImageIcon(img);
        label.setIcon(ic1);
        label.setBounds(0,0,960,590);
        add(label);
        setVisible(true);
        
        Show.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                try
                {
                    String usn=textField.getText();
                    ConnectionClass obj=new ConnectionClass();
                    String str="select tid,price,journey_date,journey_time,username,status from bookedflight where username='"+usn+"' and status='Success'";
                    ResultSet rs=obj.stm.executeQuery(str);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                    table.setFont(new Font("Arial",Font.BOLD,14));
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                }
            }
        });
        setSize(960,590);
        setLocation(40,20);
        setVisible(true);
        
    }
    
    
    
}
