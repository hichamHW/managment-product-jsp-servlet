package date_access;

import java.sql.*;
import java.util.ArrayList;
import  java.sql.SQLDataException;
import java.util.List;

import java.util.ResourceBundle;

import  models.products;


public class services_product {


    public void insert(products p ) throws SQLDataException {




        String query = " INSERT INTO  produit (NOM_PRODUIT,QUA_PRODUIT,PRIX_PRODUIT,REF_CAT,DATE_DELEV) VALUE (?,?,?,?,?)   ";
        System.out.println(p.getNom_p() +"  " + p.getQuantite() );




        try {

            connection_to_db cc = new connection_to_db();
           Connection connection = cc.getCo();

            if(connection == null){
                System.out.println("  services insert connection");
                return ;

            }

           PreparedStatement ps = connection.prepareStatement(query);

           ps.setString(1,p.getNom_p());
        ps.setInt(2,p.getQuantite());
        ps.setFloat(3,p.getPrix_p());
        ps.setInt(4,p.getId_c());

        ps.setString(5,p.getDate_delev_p());

        ps.executeUpdate();

            ps.close();
            connection.close();


    }catch (Exception e){



            System.out.println(e   +"  services insert");

        }






    }
    public  void  DeleteP( Integer id){

        String query = " DELETE FROM PRODUIT WHERE REF_PRODUIT =?   ";

        try {
            connection_to_db cc = new connection_to_db();
            Connection connection = cc.getCo();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1,id);
            ps.executeUpdate();
            ps.close();
            connection.close();


        }catch (Exception e){

            System.out.println(e);

        }


    }
    public void edit_produit(Integer id,products p ){

        String query = " UPDATE  PRODUIT   SET NOM_PRODUIT=? ,QUA_PRODUIT=?,PRIX_PRODUIT=?,REF_CAT=?,DATE_DELEV=? WHERE REF_PRODUIT =?   ";

        try {
            connection_to_db cc = new connection_to_db();
            Connection connection = cc.getCo();
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1,p.getNom_p());
            ps.setInt(2,p.getQuantite());
            ps.setFloat(3,p.getPrix_p());
            ps.setInt(4,p.getId_c());

            ps.setString(5,p.getDate_delev_p());
            ps.setInt(6,id);


            ps.executeUpdate();
            ps.close();
            connection.close();


        }catch (Exception e){

            System.out.println(e);

        }



    }


    public List<products> select_by_key(String key) throws SQLDataException{


        List <products>  Products_key= new ArrayList<products>() ;


        String query = " SELECT *FROM produit WHERE NOM_PRODUIT LIKE \"%?%\"   ";


        try {

            connection_to_db cc = new connection_to_db();
            Connection connection = cc.getCo();

            if(connection == null){
                System.out.println("  services List connection");
                return Products_key;

            }
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,key);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){

                products p_key =new products();
                p_key.setId_p(rs.getInt("REF_PRODUIT"));
                p_key.setNom_p(rs.getString("NOM_PRODUIT"));
                p_key.setQuantite(rs.getInt("QUA_PRODUIT"));
                p_key.setPrix_p(rs.getFloat("PRIX_PRODUIT"));
                p_key.setId_c(rs.getInt("REF_CAT"));
                p_key.setDate_delev_p(rs.getString("DATE_DELEV"));

                Products_key.add(p_key);



            }








        }catch (Exception e){



            System.out.println(e   +"  services List");

        }
        return Products_key;




    }
    public List<products> select( ) throws SQLDataException {



        List <products>  Products = new ArrayList<products>() ;


        String query = " SELECT *FROM produit    ";


        try {

            connection_to_db cc = new connection_to_db();
            Connection connection = cc.getCo();

            if(connection == null){
                System.out.println("  services List connection");
                return Products;

            }
            PreparedStatement ps = connection.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){

                products p =new products();
                p.setId_p(rs.getInt("REF_PRODUIT"));
                p.setNom_p(rs.getString("NOM_PRODUIT"));
                p.setQuantite(rs.getInt("QUA_PRODUIT"));
                p.setPrix_p(rs.getFloat("PRIX_PRODUIT"));
                p.setId_c(rs.getInt("REF_CAT"));
                p.setDate_delev_p(rs.getString("DATE_DELEV"));

                Products.add(p);



            }








        }catch (Exception e){



            System.out.println(e   +"  services List");

        }
        return Products;






    }





}
