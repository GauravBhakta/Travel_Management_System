
package travel.management.system;
import java.awt.*;
import javax.swing.*;

public class Loading extends JFrame implements Runnable{
    Thread t;
    JProgressBar bar;
    String user;
    
    Loading(String user){
        this.user = user;
        t = new Thread(this);
        setBounds(500,200,650,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Travel and Tourism Application");
        text.setBounds(50,20,600,40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Railway",Font.BOLD,35));
        add(text);
        
        bar = new JProgressBar();
        bar.setBounds(150,100,300,35);
        add(bar);
        bar.setStringPainted(true);
        
        JLabel loading = new JLabel("Loading, please wait....");
        loading.setBounds(225,130,200,30);
        loading.setForeground(Color.RED);
        loading.setFont(new Font("Railway",Font.BOLD,16));
        add(loading);
        
        JLabel username = new JLabel("Welcome "+user);
        username.setBounds(20,310,400,40);
        username.setForeground(Color.RED);
        username.setFont(new Font("Railway",Font.BOLD,16));
        add(username);
        
        t.start();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    @Override
    public void run(){
        try{
            for(int i= 1;i < 101;i++){
                int max = bar.getMaximum(); // 100
                int value = bar.getValue();
                
                if(value < max){
                    bar.setValue(bar.getValue() + 1);
                }else{
                    setVisible(false);
                   
                }
                t.sleep(50);
                
            }
            
           new Dashboard(user);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Loading("");
    }
}
