
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>beyzablog</title>
<style>
    
{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Poppins',sans-serif;
}
body{
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    background: #dfdfdf;
}
.login-box{
    display: flex;
    justify-content: center;
    flex-direction: column;
    width: 440px;
    height: 480px;
    padding: 30px;
}
.baslik{
    text-align: center;
    margin: 20px 0 40px 0;
}
.baslik header{
    color: #333;
    font-size: 30px;
    font-weight: 600;
}

::placeholder{
    font-weight: 500;
    color: #333;
}


.input-submit{
    position: relative;
}
.submit-btn{
    width: 100%;
    height: 60px;
    background: #fff;
    border: none;
    border-radius: 30px;
    cursor: pointer;
    transition: .3s;
}
.input-submit label{
    position: absolute;
    top: 45%;
    left: 50%;
    color: #fff;
    -webkit-transform: translate(-50%, -50%);
    -ms-transform: translate(-50%, -50%);
    transform: translate(-50%, -50%);
    cursor: pointer;
}
.submit-btn:hover{
    background: #111;
    transform: scale(1.05,1);
}

</style>
</head>
<body>
    <div class="login-box">
    <div class="baslik">
        <header>Hoşgeldin <%= request.getParameter("username") %></header>
    </div>
    <div class="input-submit">
        <form action="login.jsp" method="get"> 
            <button type="submit" class="submit-btn">Çıkış Yap</button>
        </form>
    </div>
</div>

    
</body>
</html>