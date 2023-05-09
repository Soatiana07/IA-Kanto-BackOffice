<%-- 
    Document   : ajouter_Contenu
    Created on : 5 mai 2023, 09:25:08
    Author     : Kanto
--%>
<%@page import="java.util.*"%>
<%@ page import="model.*" %>
<% ArrayList<Cible> listCible = (ArrayList<Cible>) request.getAttribute("listCible");
    ArrayList<Type> listType = (ArrayList<Type>) request.getAttribute("listType");
    ArrayList<Contenu> listContenu = (ArrayList<Contenu>) request.getAttribute("listContenu");
    int idContenu = (Integer) request.getAttribute("id");
%>
<!doctype html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <meta name="description" content="">
        <meta name="author" content="">

        <title>Modification</title>

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
                                <a class="nav-link active" href="formulaireContenu">Insert</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" href="listeContenu?limit=3&offset=0">Liste</a>
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

            <section class="contact-section section-padding pt-0">
                <div class="container">
                    <div class="row">

                        <div class="col-lg-8 col-12 mx-auto">
                            <div class="section-title-wrap mb-5">
                                <h4 class="section-title">Insertion Contenu</h4>
                            </div>

                            <form action="modifier" method="post" class="custom-form contact-form" role="form">
                                <div class="row">
                                    <div class="col-lg-6 col-md-6 col-12">
                                        <div class="form-floating">
                                            Type:<select name="type" id="full-name" class="form-select" required="">
                                                <%for (int i = 0; i < listType.size(); i++) {%>
                                                <option value="<%= listType.get(i).getId()%>"><%= listType.get(i).getType()%></option>
                                                <%}%>
                                            </select>
                                        </div>
                                    </div>
                                    <br/>
                                    <div class="col-lg-6 col-md-6 col-12">
                                        <div class="form-floating">
                                            Cible:<select name="cible" id="full-name" class="form-control" required="">
                                                <%for (int j = 0; j < listCible.size(); j++) {%>
                                                <option value="<%= listCible.get(j).getId()%>"><%= listCible.get(j).getCible()%></option>
                                                <%}%>
                                            </select>

                                        </div>
                                    </div>
                                    <div class="col-lg-12 col-12">
                                        <div class="form-floating">
                                            <input type="text" name="titre" id="name" class="form-control" 
                                                placeholder="<%= listContenu.get(0).getTitre()%>"   value="<%= listContenu.get(0).getTitre()%>" required="">

                                            <label for="floatingInput">Titre</label>
                                        </div>

                                        <div class="form-floating">
                                            <input type="date" name="date" id="name" class="form-control"
                                                   value="<%= listContenu.get(0).getDate()%>" required="">

                                            <label for="floatingInput">Date</label>
                                        </div>

                                        <div class="form-floating">
                                            <textarea class="form-control" id="editor" name="descri"  placeholder="<%= listContenu.get(0).getDescription()%>" value="<%= listContenu.get(0).getDescription()%>">
                                            </textarea>
                                        </div>
                                    </div>
                                    <input type="hidden" name="id" value="<%=idContenu%>">
                                    <input type="hidden" name="idAdmin" value="<%=listContenu.get(0).getIdadmin()%>">
                                    <div class="col-lg-4 col-12 ms-auto">
                                        <button type="submit" class="form-control">Modifier</button>
                                    </div>

                                </div>
                            </form>
                        </div>

                    </div>
                </div>
            </section>

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
        <script src="${pageContext.request.contextPath}/assets/js/ckeditor.js"></script>

        <script>
            ClassicEditor
                    .create(document.querySelector('#editor'), {
                        // toolbar: [ 'heading', '|', 'bold', 'italic', 'link' ]
                    })
                    .then(editor => {
                        window.editor = editor;
                    })
                    .catch(err => {
                        console.error(err.stack);
                    });
        </script>
    </body>
</html>
