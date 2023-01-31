package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class BookPackage extends JFrame implements ActionListener {
    Choice cpackage;
    JTextField tfperson;
    String username;
    JLabel lb1username, labelid, labelnumber, labelphone, labelprice,labelusername;
    JButton checkprice,bookpackage,back;
    
    BookPackage(String username){
        this.username=username;
        setBounds(350,200,1100,500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        JLabel text=new JLabel("BOOK PACKAGE");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);
        
         lb1username=new JLabel("Username");
         lb1username.setBounds(40,70,100,20);
        lb1username .setFont(new Font("Tahoma",Font.PLAIN,16));
         
         add(lb1username);
         
          labelusername=new JLabel();
        labelusername.setBounds(250,70,200,25);
          labelusername .setFont(new Font("Tahoma",Font.PLAIN,16));
         add(labelusername);
         
          JLabel lb1package=new JLabel("Select Package");
         lb1package.setBounds(40,110,150,20);
         lb1package .setFont(new Font("Tahoma",Font.PLAIN,16));
         add(lb1package);
         
         
        cpackage=new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(250,110,200,20);
        add(cpackage);
         
          JLabel lb1person=new JLabel("Total Person");
         lb1person.setBounds(40,150,150,25);
         lb1person.setFont(new Font("Tahoma",Font.PLAIN,16));
         add(lb1person);
         
         
         tfperson=new JTextField("1");
         tfperson.setBounds(250,150,200,25);
         add(tfperson);
                   JLabel lb1id=new JLabel("Id");
         lb1id.setBounds(40,190,150,20);
         lb1id.setFont(new Font("Tahoma",Font.PLAIN,16));
         add(lb1id);
         
          labelid=new JLabel();
        labelid.setBounds(250,190,200,25);
         add(labelid);
         
          JLabel lb1number=new JLabel("Number");
         lb1number.setBounds(40,230,150,25);
        lb1number .setFont(new Font("Tahoma",Font.PLAIN,16));
         add(lb1number);
         
          labelnumber=new JLabel();
        labelnumber.setBounds(250,230,150,25);
         add(labelnumber);
         
         JLabel lb1phone=new JLabel("Phone");
         lb1phone.setBounds(40,270,150,20);
         lb1phone.setFont(new Font("Tahoma",Font.PLAIN,16));
         add(lb1phone);
         
          labelphone=new JLabel();
        labelphone.setBounds(250,270,200,25);
         add(labelphone);
         
          JLabel lb1total=new JLabel("Total Price");
         lb1total.setBounds(40,310,150,25);
        lb1total .setFont(new Font("Tahoma",Font.PLAIN,16));
         add(lb1total);
         
          labelprice=new JLabel();
        labelprice.setBounds(250,310,150,25);
         add(labelprice);
          try{
                    Conn conn=new Conn();
                    String query="select*from customer where username='"+username+"'";
                ResultSet re=    conn.s.executeQuery(query);
                while (re.next()){
                    labelusername.setText(re.getString("username"));
                    labelid.setText(re.getString("id"));
                    labelnumber.setText(re.getString("number"));
                    labelphone.setText(re.getString("phone"));
                    
                }
                }catch(Exception e){
                    e.printStackTrace();
                }
          checkprice=new JButton("Check Price");
          checkprice.setBackground(Color.BLACK);
          checkprice.setForeground(Color.WHITE);
          checkprice.setBounds(60,380,120,25);
          checkprice.addActionListener(this);
          add(checkprice);
           bookpackage=new JButton("Book Package");
          bookpackage.setBackground(Color.BLACK);
          bookpackage.setForeground(Color.WHITE);
          bookpackage.setBounds(200,380,120,25);
          bookpackage.addActionListener(this);
          add(bookpackage);
          
          back=new JButton("Back");
          back.setBackground(Color.BLACK);
          back.setForeground(Color.WHITE);
          back.setBounds(340,380,120,25);
          back.addActionListener(this);
          add(back);
          
          ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(550, 300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(550,50,450,420);
        add(l1);

          
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkprice){
           String pack = cpackage.getSelectedItem();
           int cost=0;
           if(pack.equals("Gold Package")){
            cost+=12000;
        }else if (pack.equals("Silver Package")){
                cost+=25000;
                }else{
            cost+=32000;
        }
           int persons=Integer.parseInt(tfperson.getText());
           cost*=persons;
           labelprice.setText("Rs"+ cost);
           
            
        }else if(ae.getSource()==bookpackage){
            try{
                Conn c=new Conn();
                c.s.executeUpdate("insert into bookpackage values('"+labelusername.getText()+"','"+cpackage.getSelectedItem()+"','"+tfperson.getText()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')");
                JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
                
            }
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {
       new BookPackage("khushi");
    }
}
