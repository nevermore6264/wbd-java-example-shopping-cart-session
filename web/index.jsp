<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/4/2018
  Time: 9:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>

<body>

<p>
    <strong>Home Shopping</strong>
</p>
<a href="${pageContext.request.contextPath }/ShoppingCart.jsp">View Cart</a>
<br/><br/>
<table width="75%" border="1">
    <tr>
        <td>
            <form name="modelDetail1" method="POST" action="servlet/CartController">
                <strong>Model:</strong>Iphone 8
                <input type="hidden" name="modelNo" value="Iphone8">
                <p>
                    <strong>Description:</strong> Apple

                    <input type="hidden" name="description" value="Apple">
                </p>
                <p>
                    <strong>Quantity:<input type="text" size="2" value="1" name="quantity"></strong>

                </p>
                <p>
                    <strong>Price:</strong>$10.00
                    <input type="hidden" name="price" value="10">
                </p>
                <input type="hidden" name="action" value="add">
                <input type="submit" name="addToCart" value="Add To Cart">
            </form>
        </td>
        <td>
            <form name="modelDetail2" method="POST" action="servlet/CartController">
                <strong>Model</strong>: Samsung S8
                <input type="hidden" name="modelNo" value="SamsungS8">
                <p>
                    <strong>Description</strong>: Samsung
                    <input type="hidden" name="description" value="Samsung">
                </p>
                <p>
                    <strong>Quantity</strong>:
                    <input type="text" size="2" value="1" name="quantity">
                </p>
                <p>
                    <strong>Price</strong>: $20.00
                    <input type="hidden" name="price" value="20">
                </p>
                <input type="hidden" name="action" value="add">
                <input type="submit" name="addToCart" value="Add To Cart">
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <form name="modelDetail3" method="POST" action="servlet/CartController">
                <p>
                    <strong>Model:</strong> Nokia 6
                    <input type="hidden" name="modelNo" value="Nokia6">
                </p>
                <p>
                    <strong>Description:</strong> Nokia
                    <input type="hidden" name="description" value="Nokia">
                </p>
                <p>
                    <strong>Quantity:</strong>
                    <input type="text" size="2" value="1" name="quantity">
                </p>
                <p>
                    <strong>Price: $30.00</strong>
                    <input type="hidden" name="price" value="30">
                </p>
                <input type="hidden" name="action" value="add">
                <input type="submit" name="addToCart" value="Add To Cart">
            </form>
        </td>
        <td>
            <form name="modelDetail4" method="POST" action="servlet/CartController">
                <p>
                    <strong>Model</strong>: Xiami 5
                    <input type="hidden" name="modelNo" value="Xiaomi5">
                </p>
                <p>
                    <strong>Description</strong>: Xiaomi
                    <input type="hidden" name="description" value="Xiaomi">
                </p>
                <p>
                    <strong>Quantity</strong>:
                    <input type="text" size="2" value="1" name="quantity">
                </p>
                <p>
                    <strong>Price</strong>: $40.00
                    <input type="hidden" name="price" value="40">
                </p>
                <input type="hidden" name="action" value="add">
                <input type="submit" name="addToCart" value="Add To Cart">
            </form>
        </td>
    </tr>
</table>
</body>
</html>