<%-- 
    Document   : test
    Created on : 4 mai 2023, 13:54:35
    Author     : Kanto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajout contenu</title>
    </head>
    <body>
        <form action="insertContenu" method="post">
            <p><h1>Insertion contenu</h1></p>
        <p>Nom:<input type="text" name="nom"></p>
        <p>Numero: <input type="number" name="numero"></p>
        <p><input type="submit" value="Ajouter"></p>
        </form>
        <% int s = 2;%>
        <p><a href="Intelligence_Artificielle/article-<%=s%>.html">Lien</a></p>
</html>
