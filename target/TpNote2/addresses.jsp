<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<title>Rechercher une adresse</title>
</head>
<body>
    <form action="searchAddress" method="post">
        <input type="text" name="search"/>
        <input type="submit" value="Rechercher"/>
    </form>
    <table>
        <tr>
            <th>Adresse</th>
            <th>Ville</th>
            <th>Code postal</th>
        </tr>
        <c:forEach var="address" items="${requestScope.ADDRESSES}">
            <tr>
                <td>
                    ${address.properties.name}
                </td>
                <td>
                    ${address.properties.city}
                </td>
                <td>
                    ${address.properties.postcode}
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>