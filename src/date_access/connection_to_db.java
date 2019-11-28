package date_access;

import java.sql.*;

public class connection_to_db {


    Connection connection = null;

   public Connection getCo(){

           if(connection == null){

               String jdbcURL = "jdbc:mysql://localhost:3306/gestio_produit?useSSL=false";
               String jdbcUsername = "root";
               String jdbcPassword = "";
               try {

                   Class.forName("com.mysql.jdbc.Driver");
                   connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

                   System.out.println("connected" );

               }catch (Exception event){

                   System.out.println("not connected" );


               }



               return connection;

           }else{



               return connection;


           }




   }


}
