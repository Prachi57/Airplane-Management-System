/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AMS;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class FlightJourneyDetails extends JFrame
{
    JTable t;
    String x[]={"Ticket ID","Source","Destination" ,"Class","Price" ,"Flight Code","Flight Name","Journey Date","Journey Time","Username","Name","Status"};
    String y[][]= new String[20][11];
    int i=0,j=0;
    Font f;
    
    FlightJourneyDetails(String src,String dst)
    {
       super("Flight Journer Details");
        setSize(1300,400);
        setLocation(0,10);
        f=new Font("MS UI Gothic",Font.BOLD,17);
        
        try
        {
            ConnectionClass obj=new ConnectionClass();
            String q="Select *from bookedflight where source='"+src+"' and destination='"+dst+"'";
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next())
            {
                y[i][j++]=rest.getString("tid");
                y[i][j++]=rest.getString("source");
                y[i][j++]=rest.getString("destiation");
                y[i][j++]=rest.getString("class_name");
                y[i][j++]=rest.getString("price");
                y[i][j++]=rest.getString("fcode");
                y[i][j++]=rest.getString("fname");
                y[i][j++]=rest.getString("journey_date");
                y[i][j++]=rest.getString("journey_time");
                y[i][j++]=rest.getString("Username");
                y[i][j++]=rest.getString("name");
                y[i][j++]=rest.getString("status");
                i++;
                j=0;
                
            }
            t=new JTable(y,x);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        t.setFont(f);
        t.setBackground(Color.BLACK);
        t.setForeground(Color.WHITE);
        JScrollPane js=new JScrollPane(t);
        add(js);
          
    }
    
}
