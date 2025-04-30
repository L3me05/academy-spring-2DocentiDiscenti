<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/home.css">

</head>
<body>
    <div class="card">
        <div class="header">
            <h2>Scegli in quale menu vuoi andare</h2>
        </div>

        <div class="body">
            <div class="menu1">
                <a href="<c:url value='/docenti/lista'/>">Form Docente</a>
            </div>
            <div class="menu2">
                <a href="<c:url value='/discenti/list'/>">Form Studente</a>
            </div>
            <div class="menu3">
                <a href="form-corso.html">Form Corso</a>
            </div>
        </div>

    </div>

</body>
</html>