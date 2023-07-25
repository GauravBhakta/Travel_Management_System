package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class About extends JFrame implements ActionListener {
    About(){
        setBounds(600,200,500,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBackground(Color.WHITE);
        
        JLabel l1 = new JLabel("ABOUT");
        l1.setBounds(200,10,100,40);
        l1.setForeground(Color.red);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l1);
        
        String s = "Welcome to our Travel Management System software, the ultimate solution for managing all your travel needs. We understand that traveling can be a daunting and time-consuming task, which is why our software is designed to simplify the process and ensure that your travel arrangements are smooth and hassle-free.\n" +
"\n" +
"Our Travel Management System software is a comprehensive solution that covers everything from flight bookings to hotel reservations and rental car bookings. With our software, you can manage all aspects of your travel from a single platform, saving you time and effort.\n" +
"\n" +
"Our software is user-friendly and intuitive, making it easy for even novice users to navigate and use. It has a simple and streamlined interface that enables you to book your travel arrangements quickly and easily. You can customize your search options to find the best deals on flights, hotels, and rental cars, and make your reservations with just a few clicks.\n" +
"\n" +
"One of the unique features of our Travel Management System software is that it allows you to manage multiple travel itineraries simultaneously. Whether you're planning a business trip or a family vacation, you can easily organize and manage all your travel plans in one place.\n" +
"\n" +
"Our software is also highly secure, with robust encryption protocols that ensure the safety and privacy of your personal and financial information. You can rest assured that your data is safe and secure with us.\n" +
"\n" +
"In addition, our software provides you with real-time updates on your travel itinerary, including flight delays, gate changes, and other important information. You can receive alerts and notifications via email or SMS, ensuring that you are always up-to-date with your travel plans.\n" +
"\n" +
"Overall, our Travel Management System software is the perfect solution for anyone who wants to simplify their travel arrangements and save time and effort. With its user-friendly interface, robust security, and real-time updates, our software is the ultimate travel companion for all your travel needs.";
        
        TextArea area = new TextArea(s, 10, 40, Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20,100,450,300);
        add(area);
        
         JButton back = new JButton("Back");
        back.setBounds(200,420,100,25);
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        
    }
    public static void main(String[] args) {
        new About();
    }
}
