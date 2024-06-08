
package AMS;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4;
    JTextField t1;
    JPasswordField p1;
    JButton b1,b2;
    JFrame f;
    Login()
    {
        f=new JFrame("Login Account");
        f.setBackground(Color.WHITE);
        f.setLayout(null);
        
        l1=new JLabel();
        l1.setBounds(0,0,580,350);
        l1.setLayout(null);
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource(""));
        Image i1=img.getImage().getScaledInstance(580,350,Image.SCALE_SMOOTH);
        ImageIcon img2=new ImageIcon(i1);
        l1.setIcon(img2);
      
        l2=new JLabel("UserName");
        l2.setBounds(120,120,150,30);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Arial",Font.BOLD,20));
        l1.add(l2);
        f.add(l1);
        
        l3=new JLabel("LOGIN ACCOUNT");
        l3.setBounds(190,120,150,30);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Arial",Font.BOLD,30));
        l1.add(l3);
        
        
        
        l4=new JLabel("Password");
        l4.setBounds(120,170,150,30);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Arial",Font.BOLD,20));
        l1.add(l4);
        
        
        t1=new JTextField();
        t1.setBounds(320,120,150,30);
        l1.add(t1);
        
        p1=new JPasswordField();
        p1.setBounds(320,170,150,30);
        l1.add(p1);
        
       
        
        b1=new JButton("Login");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(120,220,150,40);
        l1.add(b1);
        
        b2=new JButton("SignUp");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(320,220,150,40);
        l1.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        
        
        
        f.setVisible(true);
        f.setSize(580,350);
        f.setLocation(300,100);
        
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            String username=t1.getText();
            String pass=p1.getText();
            try
            {
                ConnectionClass obj=new ConnectionClass();
                String q="select *from signup where username='"+username+"' and password='"+pass+"'";
                ResultSet rs=obj.stm.executeQuery(q);
                if(rs.next())
                {
                    new HomePage().setVisible(true);
                    f.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null, "you have entered wrong username and password");
                    f.setVisible(false);
                    f.setVisible(true);
                    
                    
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
                    
            
        }
        if(e.getSource()==b2)
        {
             this.f.setVisible(false);
             new SignupMessage();
            
        }
        
    }
    public static void main(String[] args)
    {
        new Login();
    }
    
}
