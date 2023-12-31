package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener {
    JButton signup, password, login;
    JTextField tfusername,tfpassword;
    Login(){
        setSize(900,400);
        setLocation(350,200);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JPanel pl = new JPanel();
        pl.setBackground(new Color(131, 193, 233));
        pl.setBounds(0,0,400,400);
        pl.setLayout(null);
        add(pl);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image2 = new JLabel(i3);
        image2.setBounds(100, 120, 200, 200);
        pl.add(image2);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400,30,450,300);
        add(p2);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60,20,100,25);
        lblusername.setFont(new Font("TIME_ROMAN", Font.PLAIN, 20));
        p2.add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(60,60,300,30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(60,110,100,25);
        lblpassword.setFont(new Font("TIME_ROMAN", Font.PLAIN, 20));
        p2.add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(60,150,300,30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);
        
        login = new JButton("Login");
        login.setBounds(60,200,130,30);
        login.setBackground(new Color(133, 193, 233));
        login.setForeground(Color.WHITE);
        login.setBorder(BorderFactory.createEmptyBorder());
        login.addActionListener(this);
        p2.add(login);
        
        signup = new JButton("Sign Up");
        signup.setBounds(230,200,130,30);
        signup.setBackground(new Color(133, 193, 233));
        signup.setForeground(Color.WHITE);
        signup.setBorder(BorderFactory.createEmptyBorder());
        p2.add(signup);
        signup.addActionListener(this);
        
        password = new JButton("Forgot Password ?");
        password.setBounds(130,250,130,30);
        password.setBackground(new Color(133, 193, 233));
        password.setForeground(Color.WHITE);
        password.setBorder(BorderFactory.createEmptyBorder());
        password.addActionListener(this);
        p2.add(password);
        
        JLabel text = new JLabel("Trouble in login...");
        text.setBounds(300,255,150,20);
        text.setForeground(Color.RED);
        p2.add(text);
        
        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == signup)
        {
            setVisible(false);
            new Signup();
        }
        else if(ae.getSource() == password){
            setVisible(false);
            new ForgetPassword();
        }
        else{
            try{
            String username = tfusername.getText();
            String pass = tfpassword.getText();
            
            String query = "select * from account where username = '"+username+"' AND password = '"+pass+"'";
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Loading(username);
            }else{
                JOptionPane.showMessageDialog(null, "Incorrect username or password");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}
