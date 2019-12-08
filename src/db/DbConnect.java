package db;


import java.sql.*;
public class DbConnect {

    public static Statement st;
    public static Connection c;
    public static PreparedStatement checkUser,insertUser,getUserLike,getUserLike1,
            updateUser,deleteUser;
    static{
        try{
           
            Class.forName("com.mysql.jdbc.Driver");
            c= DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/spring","root","java123");
            st=c.createStatement();
            //checkUser=c.prepareStatement("select * from new_table where id=? and pass=?");
            getUserLike=c.prepareStatement("select * from todo where title like ?");
            getUserLike1=c.prepareStatement("select * from todo");
            insertUser=c.prepareStatement(
                    "insert into todo  (title,date,time,task) values(?,?,?,?)");
            updateUser=c.prepareStatement(
                    "update todo set title=?,date=?,time=?,task=? where id=?");
            deleteUser=c.prepareStatement(
                    "delete from todo where id=?");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
