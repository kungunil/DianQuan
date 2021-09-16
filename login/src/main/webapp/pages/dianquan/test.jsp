<%--
  Created by IntelliJ IDEA.
  User: 刘涛
  Date: 2021/6/9
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
    <script type="text/javascript" src="../../static/js/jquery-1.7.2.js"></script>

<script type="text/javascript">
        function check(){
            //13位数字
            var Isbn = /^\d{13}$/;
            var Name= /^.{10,50}$/;
            var Author= /^.{2,30}$/;
            var Press= /^.{4,20}$/;
            var Price = /^\d+(\.\d+)?$/;


            if(!Isbn.test(frm.BIsbn.value)){
                alert("Isbn不符合");
                return false;
            }
            if(!Name.test(frm.BName.value)){
                alert("Name不符合");
                return false;
            }
            if(!Author.test(frm.BAuthor.value)){
                alert("Author不符合");
                return false;
            }
            if(!Press.test(frm.BPress.value)){
                alert("Press不符合");
                return false;
            }
            if(!Price.test(frm.BPrice.value)){
                alert("Price不符合");
                return false;
            }

        }

        function del(obj){
            alert(obj=="2"?"删除成功":"删除失败");
            $.ajax({
                url:"http://www.microsoft.com",    //请求的url地址
                dataType:"json",   //返回格式为json
                async:true,//请求是否异步，默认为异步，这也是ajax重要特性
                data:{"id":obj},    //参数值
                type:"POST",   //请求方式
                success:function (data){
                    alert(data=="0"?"":"")
                }
            });
        }
    </script>
<body>
    <form name="frm" onsubmit="check()">
        Isbn:<input type="text" name="BIsbn"> </br>
        书名:<input type="text" name="BName"> </br>
        作者:<input type="text" name="BAuthor"> </br>
        出版社:<input type="text" name="BPress"> </br>
        单价:<input type="text" name="BPrice"> </br>
        <input type="submit" name="suBtn" value="提交">
    </form>

      <a name="1" href="" onclick="del(this.name)"> 测试 </a>
</body>
</html>
