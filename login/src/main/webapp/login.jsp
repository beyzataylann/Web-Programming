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
.input-box .input-field{
    width: 100%;
    height: 60px;
    font-size: 17px;
    padding: 0 25px;
    margin-bottom: 15px;
    border-radius: 30px;
    border: none;
    box-shadow: 0px 5px 10px 1px rgba(0,0,0, 0.05);
    outline: none;
    transition: .3s;
}
::placeholder{
    font-weight: 500;
    color: #333;
}
.input-field:focus{
    width: 105%;
}
.forgot{
    display: flex;
    justify-content: space-between;
    margin-bottom: 40px;
}

#check{
    margin-right: 10px;
}
a{
    text-decoration: none;
}
a:hover{
    text-decoration: underline;
}
section a{
    color: #666;
}
.input-submit{
    position: relative;
}
.submit-btn{
    width: 100%;
    height: 60px;
    background: #333;
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
            <header>Giriş Yap</header>
        </div>
        <form action="./home.jsp" method="post">
            <div class="input-box">
                <input type="text" class="input-field" name="username" placeholder="Kullanıcı Adı" required>
                <input type="password" class="input-field" name="password" placeholder="Şifre" required>
            </div>
            <div class="forgot">
                <section>
                    <input type="checkbox" id="rememberMe" name="rememberMe">
                    <label for="rememberMe">Beni Hatırla</label>
                </section>
                <section><a href="#">Şifremi Unuttum</a></section>
            </div>
            <div class="input-submit">
                <button type="submit" class="submit-btn">Giriş Yap</button>
                <label for="submit" class="submit-label">Giriş Yap</label>
            </div>
        </form>
    </div>
</body>
</html>