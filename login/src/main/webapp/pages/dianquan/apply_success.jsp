<%--
  Created by IntelliJ IDEA.
  User: 刘涛
  Date: 2021/5/23
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>

    <title>条目申请页面</title>
    <style type="text/css">
        .daohang{
            color: #e51585;
            width: auto;
            height: 160px;
            margin: 0;
            background: #d7d7d7;
        }

        .neirong{
            width: auto;
            height: 92%;
            margin: 0;
            background: url("../../static/img/bg2.jpg") ;
        }

        .head-a{
            font-family: 黑体;
            font-size: 40px;
            color: black;
        }

        label{
            font-family: Arial;
            font-size: 13px;
            color: black;
        }

        button{
            background-color: #f7b052;
            color: white;
            height: 30px;
            width: 100px;
        }

        h1{
            font-family: 黑体;
            font-size: 35px;
            font-weight:bold;
        }

        h2{
            font-family: 黑体;
            font-size: 20px;
        }

        .form-a{
            color: #0078B7;
            font-family: Arial;
            font-size: 13px;
        }

    </style>



</head>
<body>

    <!-- 头部导航栏文件 !-->
    <%@include file="../common/apply_head.jsp"%>

    <div class="neirong">
        <div style="background:white; width:800px; height:500px; position: absolute ;left: 550px; top:250px"  >

            <img style="height: 60px;width: 65px; position: relative;left:50px;top:45px" src="static/img/rigImg.png">

            <div style="color: yellowgreen; position: absolute;left: 115px;top: 30px;">
                <h1>提交成功</h1>
                <label style="color: #f7b052">您的条目创建申请已提交，请耐心等待工作人员审核，您可以在个人中心<br/>查看审核进度及结果。</label>
            </div>

            <div class="form-a" style="position: absolute;left:350px;top:400px">
                <a class="linkatest" href="#">回到首页</a>&emsp;&emsp;
                <a class="linkatest" href="pages/dianquan/tip.jsp">联系客服</a>
            </div>

            <div style="position: absolute; left:585px; top:90px">
                <h2>条目创建帮助</h2>
                <div style="position: relative; left: 10px; top: 25px" class="form-a">
                    <a class="linkatest" href="pages/dianquan/tip.jsp">条目创建指南</a>
                    <br/>
                    <br/>
                    <a class="linkatest" href="pages/dianquan/tip.jsp">条目创建时显示名称已存在如何处理？</a>
                    <br/>
                    <br/>
                    <a class="linkatest" href="pages/dianquan/tip.jsp">创建异常如何处理？</a>
                    <br/>
                    <br/>
                    <a class="linkatest" href="pages/dianquan/tip.jsp">更多帮助>></a>
                    <br/>
                    <br/>
                </div>
            </div>

            <div style="position: absolute;top:60px;left: 560px; width: 1px;height: 400px; background: darkgray;"></div>

        </div>
    </div>
</body>
</html>
