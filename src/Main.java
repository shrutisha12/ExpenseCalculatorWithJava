import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        JFrame frame= new JFrame("Expense Calculator");
        Connection conn;

        JLabel   todayExpenselable= new JLabel("Expenses :");
        todayExpenselable.setBounds(190,10 ,200, 50);
        todayExpenselable.setForeground(Color.RED);
        todayExpenselable.setFont(new Font("ARIAL", Font.BOLD,  20));


        JLabel   expensetype_label =new JLabel( "Expense Type");
        expensetype_label.setBounds(20,50,120,50);

        JTextField expense_type_field = new JTextField();
        expense_type_field.setBounds(110,60,120,30);

        JLabel   expense_amt_label=new JLabel( "Expense amt");
        expense_amt_label.setBounds(20,80,120,50);
        frame.add(expense_amt_label);

        JTextField expense_amt_field = new JTextField();
        expense_amt_field.setBounds(110,95,120,30);

        JLabel   income_lable= new JLabel("Income :");
        income_lable.setBounds(190,150 ,200, 50);
        income_lable.setForeground(Color.GREEN);
        income_lable.setFont(new Font("ARIAL", Font.BOLD,  20));

        JLabel   add_income_label =new JLabel( "ADD Income");
        add_income_label.setBounds(20,175,120,50);

        JTextField income_amt_field = new JTextField();
        income_amt_field.setBounds(100,190,120,30);


        JButton add_button= new JButton("ADD");
        add_button.setBounds(130,250,80,50);
        add_button.setForeground(Color.WHITE);

        add_button.setBackground(Color.blue);
        JButton view_button= new JButton("VIEW");
        view_button.setBounds(220,250,80,50);
        view_button.setForeground(Color.WHITE);

        view_button.setBackground(Color.blue);

        frame.add(todayExpenselable);
        frame.add(expense_type_field);
        frame.add(expensetype_label);
        frame.add(expense_amt_field);
        frame.add(income_lable);
        frame.add(add_income_label);
        frame.add(income_amt_field);
        frame.add(add_button);
        frame.add(view_button);
// databaseConnectivity
        String url = "jdbc:mysql://localhost:3306/ExpenseCalculator";
        String username= "root";
        String password="";
        try {
            conn= DriverManager.getConnection(url,username,password);
            System.out.println("DB connected");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        add_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String expense_type=expense_type_field.getText();
                int expense_amt= (expense_amt_field.getText().isEmpty()? 0 : Integer.valueOf(expense_amt_field.getText()));//Integer this is a wrapper class
                if(expense_amt !=0 && ! expense_type.isEmpty()){
                    //insert  the record to mysql
                    String  insert_expense="INSERT INTO expensetb(expense_type,expense_amount, income_amount)VALUES(?,?,?)";
                    try {
                        PreparedStatement  statement = conn.prepareStatement(insert_expense);
                        statement.setString(1,expense_type);
                        statement.setInt(2,expense_amt);
                        statement.setInt(3,Integer.parseInt(income_amt_field.getText()));
                        statement.execute();
                    }
                    catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                }
                else {
                    JOptionPane.showMessageDialog(null,  " The Value can't be 0 oe empty");
                }
            }
        });

        frame.setSize(500,400);
        frame.setLayout(null);
        frame.setVisible(true);

    }
}