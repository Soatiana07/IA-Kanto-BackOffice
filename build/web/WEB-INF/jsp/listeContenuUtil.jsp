<%-- 
    Document   : listeContenuUtil
    Created on : 8 mai 2023, 08:26:46
    Author     : Kanto
--%>

<%@page import="java.util.*"%>
<%@ page import="model.*" %>
<% ArrayList<Contenu> listContenu = (ArrayList<Contenu>) request.getAttribute("listContenu");
%>
<!doctype html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <meta name="description" content="">
        <meta name="author" content="">

        <title>Liste_Intelligence_Artificielle_Util</title>

        <!-- CSS FILES -->
        <link rel="preconnect" href="https://fonts.googleapis.com">

        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

        <link
            href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400&family=Sono:wght@200;300;400;500;700&display=swap"
            rel="stylesheet">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap-icons.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/owl.carousel.min.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/owl.theme.default.min.css">

        <link href="${pageContext.request.contextPath}/assets/css/templatemo-pod-talk.css" rel="stylesheet">

        <!--
    
    TemplateMo 584 Pod Talk
    
    https://templatemo.com/tm-584-pod-talk
    
        -->
    </head>

    <body>

        <main>

            <nav class="navbar navbar-expand-lg">
                <div class="container">
                    <a class="navbar-brand me-lg-5 me-0" href="index.html">
                        IA-Kan
                    </a>



                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav ms-lg-auto">


                            <li class="nav-item">
                                <a class="nav-link active" href="contact.html">Insert</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>


            <header class="site-header d-flex flex-column justify-content-center align-items-center">
                <div class="container">
                    <div class="row">

                        <div class="col-lg-12 col-12 text-center">

                            <h2 class="mb-0">Intelligence Artificielle</h2>
                        </div>

                    </div>
                </div>
            </header>

            <section class="topics-section section-padding pb-0" id="section_3">
                <div class="container">
                    <div class="row">

                        <div class="col-lg-12 col-12">
                            <div class="section-title-wrap mb-5">
                                <h4 class="section-title">Liste des contenus</h4>
                            </div>
                        </div>

                        <%for (int i = 0; i < listContenu.size(); i++) {%>
                        <div class="col-lg-4  col-12 mb-4 mb-lg-0">
                            <div class="custom-block custom-block-overlay">
                                <a href="detail-page.html" class="custom-block-image-wrap">
                                    <img src="images/topics/physician-consulting-his-patient-clinic.jpg"
                                         class="custom-block-image img-fluid" alt="">
                                </a>
                                <div class="custom-block-info custom-block-overlay-info">
                                    <h5 class="mb-1">
                                        <a href="#">
                                            <%= listContenu.get(i).getTitre()%>
                                        </a>
                                    </h5>
                                    <p>
                                        <a href="#" class="btn btn-link">
                                            Voir detail
                                        </a>
                                    </p>
                                    <p>
                                        <a href="#" class="btn btn-info">
                                            Modifier
                                        </a>
                                        <a href="#" class="btn btn-danger">
                                            Supprimer
                                        </a>
                                    </p>
                                </div>
                            </div>
                        </div>
                        <%}%>


                    </div>
                </div>
            </section>
            <% int limite = (Integer) request.getAttribute("limite");
                int offset = (Integer) request.getAttribute("offset");
            %>

            <div class="col-lg-4 col-12 mx-auto">
                <nav aria-label="Page navigation example">
                    <ul class="pagination pagination-lg justify-content-center mt-5">
                         <%if (offset > 0) {%>
                        <li class="page-item">
                            <a class="page-link" href="listeContenu?offset=<%= offset - limite%>&limite=<%= limite%>" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <%} %>
                        <%if (listContenu.size() == limite) {%>
                        <li class="page-item">
                            <a class="page-link" href="listeContenu?offset=<%= offset + limite%>&limite=<%= limite%>" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                        <%} %>
                    </ul>
                </nav>
            </div>
        </main>

        <footer class="site-footer">
            <div class="container">
                <div class="row">
                </div>
            </div>

            <div class="container pt-5">
                <div class="row align-items-center">
                    <div class="col-lg-3 col-12">
                        <p class="copyright-text mb-0"><center>ANDRIANIONY Miharizo Kanto  ETU001541</center>
                    </div>
                </div>
            </div>
        </footer>
    </body>
</html>