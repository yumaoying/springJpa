<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jsencrypt.min.js"></script>
    <script type="text/javascript">
        // 使用jsencrypt类库加密js方法，
        $(function () {
            $('#sub').click(function () {
                var publicKey=$("#publicKey").val();
                if(publicKey==null||publicKey==""){
                    alert("公钥为空");
                    return
                }
                var key = $('#key').val();
                var value = $('#value').val();
                if(value==null||value==""){
                    alert("解密的值为空");
                    return
                }
                var encrypt = new JSEncrypt();
                encrypt.setPublicKey(publicKey);
                 value= encrypt.encrypt(value);
                $("#ecrydata").value=value;
                var params={};
                params.key=key;
                params.value=value;
                $.ajax({
                    url: "save",
                    type: 'POST',
                    data:params,
                    dataType: 'json',
                  //  contentType: 'application/json; charset=utf-8',
                    success: function (data) {
                        alert(data.value);
                    },
                    error: function (xhr) {
                        alert("错误")
                    }
                });
            });
        });
    </script>
</head>
<body>
     <label>请输入加密文本</label>
     <input type="hidden" name="publicKey" value="${publicKey}" id="publicKey">
     <input type="hidden" name="key" id="key" value="yada">
     <input type="text" name="value" id="value"><br>
    <textarea id="ecrydata">加密后：</textarea>
    <input type="submit" value="提交" id="sub"><br>
</body>
</html>
