<%--
  Created by IntelliJ IDEA.
  User: 刘涛
  Date: 2021/5/23
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<!-- 头部导航栏文件 !-->

<%@include file="../common/apply_head.jsp"%>


<html>
<head>
    <title>条目申请页面</title>

    <style type="text/css">

        .neirong{
            width: auto;
            height: 92%;
            margin: 0;
            background: url("static/img/bg2.jpg") ;
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
            color: aqua;
            font-family: Arial;
            font-size: 13px;
        }

        a:link{
            text-decoration-line: none;
            text-decoration: #0078B7;
        }

        .errorMsg{
            color: coral;
            font-family: Arial;
            font-size: 13px;
        }

    </style>

    <script type="text/javascript">
        //页面加载完成之后
        $(function () {
            $("#sub_btn").click(function () {

                if($("#tmname").val().length == 0  ){
                    alert("条目名称不能为空，请输入条目名称！");
                    return ;
                }
                if($("#errMsg1").css("visibility")=="visible"){
                    alert("条目名称已存在！")
                    return ;
                }

                if($("#tmIntro").val() == "政治言论"){
                    $("#errMsg2").css("visibility","visible");
                    return ;
                }
                if($("#tmIntro").val().length == 0 ){
                    alert("条目简介不能为空，请输入条目简介！");
                    return ;
                }
                applyFrm.submit();
            });
            //判断内容标题是编辑还是申请

            $("#tmname").blur(function () {
                //1.用户名
                var tmname = this.value;
                //2.Jquery调用getjson对象
                $.getJSON("${basepath}/applyServlet","action=ajaxExistName&tmname="+tmname,function (data) {
                    if(data.existsTmname){
                        $("#errMsg1").css("visibility","visible");
                    }else{
                    }
                })
            });

            $("#tmname").change(function (){
                $("#errMsg1").css("visibility","hidden");
                $("#errMsg2").css("visibility","hidden");
            });
        });
    </script>

</head>
<body>


    <div class="neirong">
        <div style="background:white; width:800px; height:500px; position: absolute ;left: 550px; top:250px"  >
            <div style="position: relative; left:60px; top:30px">
                <form action="applyServlet" method="get" name="applyFrm" >
                    <input type="hidden" name="action" value="Apply">
                    <input type="hidden" name="username" value="${sessionScope.login_user.username}">
                    <input type="hidden" name="user_id" value="${sessionScope.login_user.u_id}">
                    <input type="hidden" name="statements" value="待审核">
                    <div>
                        <h1>条目申请</h1>
                    </div>
                    <div >
                        <label>条目名称:</label> <input type="text" id="tmname" name="title">
                        <br />
                        <br />
                        <label>条目简介:</label> <textarea  rows="5" cols="22" id="tmIntro" name="introduction"></textarea>
                    </div>
                    <br />
                    <br />
                    <div>
                        &emsp;&emsp;&emsp;&emsp;&emsp;<button type="button" id="sub_btn">立即创建</button>
                    </div>
                    <br />
                    <br />
                    <br />
                    <div class="form-a">
                        <a  class="linkatest" href="pages/dianquan/tip.jsp" >条目创建协议</a>
                        <br />
                        <br />
                        <a  class="linkatest" href="pages/dianquan/tip.jsp">全国人大常委会关于加强网络信息保护的决定</a>
                    </div>
                </form>
            </div>

            <div>
                <div id="errMsg1" style="position:absolute; top:94px;left:293px; visibility: hidden ">
                    <!-- 当输入的信息不符合要求时，产生提示 !-->
                    <img id="errImg1" src="static/img/Redtip.png" style="position: relative; top:18px;">
                    <span id="errorMsg1" class="errorMsg">条目名称已存在，请更换条目名称。</span>
                </div>
                <div id="errMsg2" style="position:absolute; top:180px;left:293px; visibility: hidden ">
                    <img  src="static/img/Redtip.png" style="position: relative; top:15px;">
                    <span id="errorMsg2"  class="errorMsg">请查看条目创建协议，并严格遵守协议。</span>
                </div>
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
