<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>

<head>

    <title>Title</title>

    <link href="/css/styles.css" rel="stylesheet" type="text/css">

</head>



<div class="form-style-2">

    <div class="form-style-2-heading">

        Please Sign Up!

    </div>

    <form method="post" action="/calculete">

        <label for="example">example

            <input class="input-field" type="text" id="example" name="example">

        </label>

        <input type="submit" value="result">

    </form>

</div>



<div class="form-style-2">

    <div class="form-style-2-heading">

        Already in System!

    </div>

    <table>

        <tr>

            <th>example</th>

            <th>result</th>

        </tr>

        <c:forEach items="${calculateFromServer}" var="calculate">

            <tr>

                <td>${calculate.example}</td>

                <td>${calculate.result}</td>

            </tr>

        </c:forEach>

    </table>

</div>

</body>

</html>