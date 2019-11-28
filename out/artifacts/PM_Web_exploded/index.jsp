<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="models.products" %>
<%@ page import="date_access.services_product" %>
<html>
  <head>

    <title>$Title$</title>
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
      <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </head>
  <body>





  <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <a class="navbar-brand" href="#">PMS</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav mr-auto">
              <li class="nav-item active">
                  <a class="nav-link" href="#">Products <span class="sr-only">(current)</span></a>
              </li>



          </ul>

      </div>
  </nav>

  <%

      if(session.getAttribute("msgi") != null){

          String msg = (String) session.getAttribute("msgi");

  %>
  <div class="alert alert-success alert-success fade show" role="alert">

      <%
          out.print(msg);
      %>
      <button type="button" class="close" data-dismiss="alert" aria-label="Close">
          <span aria-hidden="true">&times;</span>
      </button>

  </div>

  <%

      }
  %>


  <%

      if(session.getAttribute("msgd") != null){

          String msg = (String) session.getAttribute("msgd");

  %>
  <div class="alert alert-warning alert-success fade show" role="alert">

      <%
          out.print(msg);
      %>
      <button type="button" class="close" data-dismiss="alert" aria-label="Close">
          <span aria-hidden="true">&times;</span>
      </button>

  </div>

  <%
      }
  %>
  <!-- Button trigger modal -->


  <div class="container">
      <div class="row" style="  position: relative; top: 100px;">

          <div class="col-md-12 min-vh-100 d-flex flex-column justify-content-center">

                  <div class="col-lg-12 col-md-8 mx-auto">

                      <!-- form card login -->
                      <div class="card rounded shadow shadow-sm">
                          <div class="card-header">
                              <h3 class="mb-0 text-center">Products</h3>
                          </div>
                          <div class="card-body">





                              <div class="row ">
                                  <div class="col text-center">
                                      <button type="button" class="btn btn-success" data-toggle="modal" data-target="#exampleModalCenter">
                                          Add new product
                                      </button>



                                  </div>


                              </div >

                              <br>
                              <div class="row ">
                                  <div class="col-md-12">

                                      <form action="produit_servlet" method="get" >

                                          <div class="form-group ">

                                              <input type="text" name="search_key" class="form-control text-center" id="" placeholder="Search">

                                          </div>

                                      </form>


                                  </div >
                              </div >


                              <br>
                              <div class="row">



                                  <div class="col">



                                      <table class="table">
                                          <thead>
                                          <tr>
                                              <th scope="col">N°</th>
                                              <th scope="col">Nom_p</th>
                                              <th scope="col">Quantite</th>
                                              <th scope="col">Prix</th>
                                              <th scope="col">Categorie</th>
                                              <th scope="col">Date</th>
                                              <th scope="col">Action</th>
                                          </tr>
                                          </thead>
                                          <tbody>

                                          <%
                                              services_product sp = new services_product();
                                              List<products> Ps =  new ArrayList<products>();

                                              try{
                                                  Ps =  sp.select();

                                              }catch (Exception e){

                                                  System.out.println(e   +"  Lister");
                                              }


                                              for(products p:Ps){%>


                                          <tr>


                                              <th><%out.print(p.getId_p());%></th>

                                              <th><%out.print(p.getNom_p());%></th>
                                              <th><%out.print(p.getQuantite());%></th>
                                              <th><%out.print(p.getPrix_p());%></th>
                                              <th><%out.print(p.getId_c());%></th>
                                              <th><%out.print(p.getDate_delev_p());%></th>
                                              <th>
                                                  <a href="produit_servlet?edit=<%=p.getId_p()%> " class="btn btn-primary"   data-toggle="modal" data-target="#model_update<%=p.getId_p()%>" role="button">edit</a>
                                                  <a href="produit_servlet?delete=<%=p.getId_p()%>" class="btn btn-danger" role="button">Delete</a>


                                                  <!-- Modal update-->
                                                  <div class="modal fade" id="model_update<%=p.getId_p()%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                                                      <div class="modal-dialog modal-dialog-centered" role="document">
                                                          <div class="modal-content">
                                                              <div class="modal-header">
                                                                  <h5 class="modal-title" id="update_title">Update product</h5>


                                                              </div>

                                                              <form action="produit_servlet" method="get" >

                                                                  <input   type="text"name="edit" class="form-control" id="EDIT" value="<%=p.getId_p()%>"   >
                                                                  <div class="modal-body">
                                                                      <div class="row">
                                                                          <div class="col">
                                                                              <label for="n">Name</label>
                                                                              <input type="text" name="Enom_p" class="form-control" id="n" value="<%=p.getNom_p()%>"   placeholder="First name">
                                                                          </div>
                                                                          <div class="col">
                                                                              <label for="q">Quanitie</label>
                                                                              <input type="text" class="form-control" name="EQu" value="<%=p.getQuantite()%>"  id="q" placeholder="Last name">
                                                                          </div>
                                                                      </div>
                                                                      <div class="row">

                                                                          <div class="col">
                                                                              <label for="p">Price</label>
                                                                              <input type="text" class="form-control"  name="EPri" value="<%=p.getPrix_p()%>"  id="p" placeholder="First name">
                                                                          </div>

                                                                          <div class="col">
                                                                              <label for="c">Categorie</label>
                                                                              <select id="c" name="Eid_cat" value="<%=p.getId_c()%>" class="form-control ">
                                                                                  <option value="1">Info</option>
                                                                                  <option value="2">electronic</option>

                                                                              </select>



                                                                          </div>

                                                                      </div>
                                                                      <div class="row">

                                                                          <div class="col">
                                                                              <label for="d">Date</label>
                                                                              <input type="Date" class="form-control" name="Edate" value="<%=p.getDate_delev_p()%>"  id="d" placeholder="First name">

                                                                          </div>




                                                                      </div>

                                                                  </div>
                                                                  <div class="modal-footer">
                                                                      <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                                      <input class="btn btn-primary " type="submit" value="Save ">

                                                                  </div>
                                                              </form>
                                                          </div>
                                                      </div>
                                                  </div>

                                              </th>



                                          </tr>





                                          <% }%>






                                          </tbody>
                                      </table>




                                      </div >

                          </div>
                          <!--/card-block-->
                      </div>
                      <!-- /form card login -->

                  </div>



              <!--/row-->

          </div>
          <!--/col-->
      </div>
      <!--/row-->
  </div>
  <!--/container-->

  <!-- Modal insert-->
  <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
      <div class="modal-dialog modal-dialog-centered" role="document">
          <div class="modal-content">
              <div class="modal-header">
                  <h5 class="modal-title" id="exampleModalCenterTitle">Insertt product</h5>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                  </button>
              </div>

              <form action="produit_servlet" method="post" >
              <div class="modal-body">
                      <div class="row">
                          <div class="col">
                              <label for="n">Name</label>
                              <input type="text" name="nom_p" class="form-control" id="n" >
                          </div>
                          <div class="col">
                              <label for="q">Quanitie</label>
                              <input type="text" class="form-control" name="Qu" id="q" >
                          </div>
                      </div>
                      <div class="row">

                          <div class="col">
                              <label for="p">Price</label>
                              <input type="text" class="form-control"  name="Pri"  id="p" >
                          </div>

                          <div class="col">
                              <label for="c">Categorie</label>
                              <select id="c" name="id_cat" class="form-control ">
                                  <option value="1">Info</option>
                                  <option value="2">electronic</option>

                              </select>



                          </div>

                      </div>
                      <div class="row">

                          <div class="col">
                              <label for="d">Date</label>
                              <input type="Date" class="form-control" name="date"  id="d" >

                          </div>




                      </div>

              </div>
              <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                  <input class="btn btn-primary " type="submit" value="Save ">

              </div>
              </form>
          </div>
      </div>
  </div>






  </body>
</html>

