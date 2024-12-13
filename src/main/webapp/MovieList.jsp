<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<table border="1" cellpadding="5" cellspacing="0" style="border-collapse: collapse;">
    <p>Liste de Films</p>
    <tr>
        <th style="border: 1px solid black;">Titre</th>
        <th style="border: 1px solid black;">Année</th>
        <th style="border: 1px solid black;">Acteurs</th>
        <th style="border: 1px solid black;">Affiche</th>
        <th style="border: 1px solid black;">baisser</th>
        <th style="border: 1px solid black;">Note</th>
        <th style="border: 1px solid black;">Augmenter</th>
    </tr>
    <c:forEach items="${requestScope.RESULTS_LIST}" var="results">
        <tr>
            <td style="border: 1px solid black;">${results.MovieBean.titre}</td>
            <td style="border: 1px solid black;">${results.MovieBean.annee}</td>
            <td style="border: 1px solid black;">${results.MovieBean.acteurs}</td>
            <td style="border: 1px solid black;"><img src="${results.MovieBean.affiche}" alt="Affiche" width="50" height="75"></td>
            <td style="border: 1px solid black;"><a href="MovieServlet?action=decrease&id=${results.MovieBean.id}">➖</a></td>
            <td style="border: 1px solid black;">${results.MovieBean.note}</td>
            <td style="border: 1px solid black;"><a href="MovieServlet?action=increase&id=${results.MovieBean.id}">➕</a></td>
        </tr>
    </c:forEach>
</table>