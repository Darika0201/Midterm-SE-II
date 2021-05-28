<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%--<%@ page import="java.lang.Class.forName" %>--%>
<%@page import="java.sql.*"%>
<%@ page import="java.util.Objects" %>
<%
    String id = "";
    String user_id = request.getParameter("user_id");
    String feedback = request.getParameter("feedback");
    String password = request.getParameter("password");
    String email = request.getParameter("email");

    String driverName = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://127.0.0.1:3308/";
    String database = "user";
    String userId = "root";
    String pass = "";

    try {
        Class.forName(driverName);
    }catch (ClassNotFoundException e){
        e.printStackTrace();
    }
    Connection connect;
    Statement state;
    try {
        connect = DriverManager.getConnection(url + database,userId,pass);
        state = connect.createStatement();
        String create = "CREATE DATABASE IF NOT EXISTS user";
        state.executeUpdate(create);
        String variable = "CREATE TABLE IF NOT EXIST userInfo(user_id int(10), feedback varchar(100), password varchar(10), email varchar(10))";
        state.executeUpdate(variable);

        String sql = "INSERT INTO userInfo (user_id, feedback, password, email) " +
                "VALUES('\"+ user_id + \"','\" + pwd + \"','\" + name + \"','\" + email + \"')";
        state.executeUpdate(sql);
    }catch (Exception e){
        e.printStackTrace();
    }
%>
<html>
<<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body {
            font-family: 'Open Sans', sans-serif;
            background: #3396d8;
            margin: 0 auto 0 auto;
            width: 100%;
            text-align: center;
            margin: 20px 0px 20px 0px;
        }

        p {
            font-size: 12px;
            text-decoration: none;
            color: #ffffff;
        }

        h1 {
            font-size: 1.5em;
            color: #525252;
        }

        .box {
            background: white;
            width: 300px;
            border-radius: 6px;
            margin: 0 auto 0 auto;
            padding: 0px 0px 70px 0px;
            border: #2288cc 4px solid;
        }

        .email {
            background: #ecf0f1;
            border: #ccc 1px solid;
            border-bottom: #ccc 2px solid;
            padding: 8px;
            width: 250px;
            color: #AAAAAA;
            margin-top: 10px;
            font-size: 1em;
            border-radius: 4px;
        }

        .password {
            border-radius: 4px;
            background: #ecf0f1;
            border: #ccc 1px solid;
            padding: 8px;
            width: 250px;
            font-size: 1em;
        }

        .btn {
            background: blue;
            width: 125px;
            padding-top: 5px;
            padding-bottom: 5px;
            color: white;
            border-radius: 4px;
            border: blue 1px solid;

            margin-top: 20px;
            margin-bottom: 20px;
            float: left;
            margin-left: 16px;
            font-weight: 800;
            font-size: 0.8em;
        }

        .btn:hover {
            background: blue;
        }

    </style>
</head>

<body>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:700,600' rel='stylesheet' type='text/css'>

<form method="post" action="index.html">
    <div class="box">
        <h1>Feedback</h1>

        <input type="text" name="user_id"
               onblur="field_blur(this, 'email');" class="email" />

        <input type="text" name="feedback" onFocus="field_focus(this, 'feedback');"
               onblur="field_blur(this, 'email');" class="email" />

        <input type="email" name="email" value="email" onFocus="field_focus(this, 'email');"
               onblur="field_blur(this, 'email');" class="email" />

        <input type="password" name="password" value="email" onFocus="field_focus(this, 'email');"
               onblur="field_blur(this, 'email');" class="email" />

        <a href="#">
            <div class="btn">Submit</div>
        </a>

    </div>

</form>

<p>Forgot your password? <u style="color:blue;">Click Here!</u></p>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js" type="text/javascript"></script>
</body>
</html>