package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class BookHotel extends JFrame implements ActionListener {
    Choice chotel,cac,cfood;
    JTextField tfperson,tfdays;
    String username;
    JLabel lb1username, labelid, labelnumber, labelphone, labelprice,labelusername;
    JButton checkprice,bookpackage,back;
    
    BookHotel(String username){
        this.username=username;
        setBounds(350,200,1100,600);
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
         
          JLabel lb1package=new JLabel("Select Hotel");
         lb1package.setBounds(40,110,150,20);
         lb1package .setFont(new Font("Tahoma",Font.PLAIN,16));
         add(lb1package);
         
         
        chotel=new Choice();
        chotel.setBounds(250,110,200,20);
        add(chotel);
        try{
            Conn c =new Conn();
            ResultSet rs=c.s.executeQuery("select*from hotel");
            while(rs.next()){
               chotel.add(rs.getString("name")); 
            }
        }catch(Exception e){
            e.printStackTrace();
        }
         
          JLabel lb1person=new JLabel("Total Person");
         lb1person.setBounds(40,150,150,25);
         lb1person.setFont(new Font("Tahoma",Font.PLAIN,16));
         add(lb1person);
         
         
         tfperson=new JTextField("1");
         tfperson.setBounds(250,150,200,25);
         add(tfperson);
         
         JLabel lb1days=new JLabel("No Of Days");
         lb1days.setBounds(40,190,150,25);
         lb1days.setFont(new Font("Tahoma",Font.PLAIN,16));
         add(lb1days);
         
         
         tfdays=new JTextField("1");
         tfdays.setBounds(250,190,200,25);
         add(tfdays);
         
          JLabel lb1ac=new JLabel("AC/Non-AC");
         lb1ac.setBounds(40,230,150,25);
         lb1ac.setFont(new Font("Tahoma",Font.PLAIN,16));
         add(lb1ac);
         
         cac=new Choice();
         cac.add("AC");
         cac.add("Non-AC");
         
        cac.setBounds(250,230,200,20);
        add(cac);
        
         JLabel lb1food=new JLabel("Food Included");
         lb1food.setBounds(40,270,150,25);
         lb1food.setFont(new Font("Tahoma",Font.PLAIN,16));
         add(lb1food);
         
         cfood=new Choice();
         cfood.add("Yes");
         cfood.add("No");
         
        cfood.setBounds(250,270,200,20);
        add(cfood);
                   JLabel lb1id=new JLabel("Id");
         lb1id.setBounds(40,310,150,20);
         lb1id.setFont(new Font("Tahoma",Font.PLAIN,16));
         add(lb1id);
         
          labelid=new JLabel();
        labelid.setBounds(250,310,200,25);
         add(labelid);
         
          JLabel lb1number=new JLabel("Number");
         lb1number.setBounds(40,350,150,25);
        lb1number .setFont(new Font("Tahoma",Font.PLAIN,16));
         add(lb1number);
         
          labelnumber=new JLabel();
        labelnumber.setBounds(250,350,150,25);
         add(labelnumber);
         
         JLabel lb1phone=new JLabel("Phone");
         lb1phone.setBounds(40,390,150,20);
         lb1phone.setFont(new Font("Tahoma",Font.PLAIN,16));
         add(lb1phone);
         
          labelphone=new JLabel();
        labelphone.setBounds(250,390,200,25);
         add(labelphone);
         
          JLabel lb1total=new JLabel("Total Price");
         lb1total.setBounds(40,430,150,25);
        lb1total .setFont(new Font("Tahoma",Font.PLAIN,16));
         add(lb1total);
         
          labelprice=new JLabel();
        labelprice.setBounds(250,430,150,25);
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
          checkprice.setBounds(60,490,120,25);
          checkprice.addActionListener(this);
          add(checkprice);
           bookpackage=new JButton("Book Hotel");
          bookpackage.setBackground(Color.BLACK);
          bookpackage.setForeground(Color.WHITE);
          bookpackage.setBounds(200,490,120,25);
          bookpackage.addActionListener(this);
          add(bookpackage);
          
          back=new JButton("Back");
          back.setBackground(Color.BLACK);
          back.setForeground(Color.WHITE);
          back.setBounds(340,490,120,25);
          back.addActionListener(this);
          add(back);
          
          ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(500,50,600,400);
        add(l1);

          
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkprice){
            try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select*from hotel where name='"+chotel.getSelectedItem()+"'");
            while(rs.next()){
                int cost=Integer.parseInt(rs.getString("costperperson"));
                 int food=Integer.parseInt(rs.getString("foodincluded"));
                  int ac=Integer.parseInt(rs.getString("acroom"));
                  int persons=Integer.parseInt(tfperson.getText());
                  int days=Integer.parseInt(tfdays.getText());
                  String acselected=cac.getSelectedItem();
                  String foodselected=cfood.getSelectedItem();
                  if(persons*days>0){
                      int total=0;
                      total +=acselected.equals("AC")?ac:0;
                      total +=foodselected.equals("Yes")?food:0;
                      total +=cost;
                      total=total*persons*days;
                      labelprice.setText("Rs"+total);
                  }else{
                      JOptionPane.showMessageDialog(null, "Please enter a Valid number");
                  }
            }
          
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==bookpackage){
            try{
                Conn c=new Conn();
                c.s.executeUpdate("insert into bookhotel values('"+labelusername.getText()+"','"+chotel.getSelectedItem()+"','"+tfperson.getText()+"','"+tfdays.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')");
                
                
                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
                
            }
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {
       new BookHotel("khushi");
    }
}
