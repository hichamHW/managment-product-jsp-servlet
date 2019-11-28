package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;


import  models.products;
import date_access.services_product;



@WebServlet(name = "/produit_servlet" , urlPatterns = {"/produit_servlet"})
public class produit_servlet extends HttpServlet {



    protected  void  doGet(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException{
        Delete_product(request,response);

        Edit_products(request,response);


        System.out.println(request.getParameter("delete") );
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {





            insert_product(request,response);



    }













   private  void insert_product( HttpServletRequest request , HttpServletResponse response ) throws ServletException, IOException {


       services_product sp = new services_product();
       String name = request.getParameter("nom_p");
       String quant = request.getParameter("Qu");
       String prix = request.getParameter("Pri");
       String id_cat = request.getParameter("id_cat");
       String datdelev = request.getParameter("date");

       ///System.out.println(name+"     "+ quant +"  "+ prix + "  "+ id_cat +"  "+datdelev);


       products p1 = new products();
       p1.setNom_p(name);
       p1.setQuantite(Integer.parseInt(quant));
       p1.setPrix_p(Float.parseFloat(prix));
       p1.setId_c(Integer.parseInt(id_cat));
       p1.setDate_delev_p(datdelev);

       Alllist(request,response,"insert success ",null);



       try {





           sp.insert(p1);


       }catch (Exception e){

           System.out.println(e   +"  insert");
       }







}


private void  Alllist( HttpServletRequest request, HttpServletResponse response, String msginsert, String msgdelete) throws  ServletException,IOException{


        services_product sp = new services_product();
   List<products> Ps =  new ArrayList<products>();

    try{
        Ps =  sp.select();

    }catch (Exception e){

        System.out.println(e   +"  Lister");
    }



    request.getSession().setAttribute("list_products",Ps);
    request.getSession().setAttribute("msgi",msginsert);
    request.getSession().setAttribute("msgd",msgdelete);
   /// request.getRequestDispatcher("").include(request,response);
    response.sendRedirect( "/index.jsp");



}


    private void Edit_products( HttpServletRequest  request , HttpServletResponse response  ) throws  ServletException,IOException{


        if (request.getParameter("edit") != null) {


            String ed_id = request.getParameter("edit");

            Integer id_ED= Integer.parseInt(ed_id);

            String name = request.getParameter("Enom_p");
            String quant = request.getParameter("EQu");
            String prix = request.getParameter("EPri");
            String id_cat = request.getParameter("Eid_cat");
            String datdelev = request.getParameter("Edate");


            products p1 = new products();
            p1.setNom_p(name);
            p1.setQuantite(Integer.parseInt(quant));
            p1.setPrix_p(Float.parseFloat(prix));
            p1.setId_c(Integer.parseInt(id_cat));
            p1.setDate_delev_p(datdelev);

            try {

                services_product pse = new services_product();

                pse.edit_produit(id_ED, p1);
                Alllist(request,response,"update success",null);

            } catch (Exception e) {

                System.out.println(e);

            }


        }
    }


    private void search_by_key(HttpServletRequest request, HttpServletResponse response){

        if (request.getParameter("search_key") !=null) {


            String search_key = request.getParameter("search_key");
            services_product ps = new services_product();
            List<products> Ps =  new ArrayList<products>();
            try{

               Ps= ps.select_by_key(search_key);

                request.getSession().setAttribute("list_products_key",Ps);


            }catch ( Exception e){


                System.out.println(e);
            }



        }



    }
private  void Delete_product(HttpServletRequest request,HttpServletResponse response){


        if (request.getParameter("delete") !=null){


            String del_id = request.getParameter("delete");

            Integer id = Integer.parseInt(del_id);
            services_product ps = new services_product();
            try{

                ps.DeleteP(id);
                Alllist(request,response,null,"Delete success ");

            }catch (Exception e){

                System.out.println(e);
            }


        }



    }

}

