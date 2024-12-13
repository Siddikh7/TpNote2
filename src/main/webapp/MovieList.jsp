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
        <th style="border: 1px solid black;">Baisser</th>
        <th style="border: 1px solid black;">Note</th>
        <th style="border: 1px solid black;">Augmenter</th>
    </tr>
    <c:forEach items="${RESULTS_LIST}" var="movie">
        <tr>
            <td style="border: 1px solid black;">${movie.title}</td>
            <td style="border: 1px solid black;">${movie.annee}</td>
            <td style="border: 1px solid black;">${movie.acteurs}</td>
            <td style="border: 1px solid black;"><img src="${movie.affiche}" alt="Affiche" width="50" height="75"></td>
            <td style="border: 1px solid black;">
                <form action="moviesList" method="post">
                    <input type="hidden" name="id" value="${movie.id}">
                    <input type="hidden" name="action" value="decrease">
                    <button type="submit">➖</button>
                </form>
</td>
            <td style="border: 1px solid black;">${movie.note}</td>
            <td style="border: 1px solid black;">
                <form action="moviesList" method="post">
                    <input type="hidden" name="id" value="${movie.id}">
                    <input type="hidden" name="action" value="increase">
                    <button type="submit">➕</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<!-- Future implementation attributes -->
<!--
<td style="border: 1px solid black;">${movie.picture}</td>
<td style="border: 1px solid black;">${movie.description}</td>
-->