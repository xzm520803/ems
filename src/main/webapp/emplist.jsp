<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="now" class="java.util.Date"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>emplist</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
    <script type="text/javascript">
        function isDelete(id) {
            if (confirm("确认删除嘛")) {
                location.href = "${pageContext.request.contextPath}/perpao/perpao	_delete?id=" + id;
            }
        }
    </script>
</head>
</head>
<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p>
                    <fmt:formatDate value="${now}"></fmt:formatDate>
                    <br/>
                    <a href="${pageContext.request.contextPath}/user/user_loginout">安全退出</a>
                </p>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="#">main</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                欢迎,小可爱: ${sessionScope.user.username}
            </h1>
            <table class="table">
                <tr class="table_header">
                    <td>
                        ID
                    </td>
                    <td>
                        Name
                    </td>
                    <td>
                        Salary
                    </td>
                    <td>
                        Age
                    </td>
                    <td>
                        Operation
                    </td>
                </tr>
                <c:forEach items="${requestScope.perpaos}" var="perpao">
                    <tr class="row1">
                        <td>
                                ${perpao.id}
                        </td>
                        <td>
                                ${perpao.name}
                        </td>
                        <td>
                                ${perpao.salary}
                        </td>
                        <td>
                                ${perpao.age}
                        </td>
                        <td>
                            <a href="javascript:;" onclick="isDelete('${perpao.id}')">删除信息</a>&nbsp;<a
                                href="${pageContext.request.contextPath}/perpao/perpao_queryOne?id=${perpao.id}">修改信息</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <p>
                <input type="button" class="button" value="添加信息"
                       onclick="location='${pageContext.request.contextPath}/addEmp.jsp'"/>
            </p>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            ABC@126.com
        </div>
    </div>
</div>
</body>
</html>
