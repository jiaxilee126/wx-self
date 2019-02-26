<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html">
    <meta charset="UTF-8">
    <title>SpringBoot学习|登录</title>
    <link rel="stylesheet" href="/login-resource/animate.min.css">

    <link rel="stylesheet" href="/login-resource/font-awesome.min.css">
    <link rel="stylesheet" href="/login-resource/style.min.css">
    <link rel="stylesheet" href="/login-resource/iconfont.css">

    <link rel="stylesheet" href="/login-resource/sweetalert/sweetalert.css">

    <!-- jQuery 2.2.3 -->
    <script src="/adminlte/plugins/jQuery/jquery-2.2.3.min.js"  type="text/javascript"></script>
    <!-- Bootstrap 3.3.6 -->
    <script src="/adminlte/bootstrap/js/bootstrap.min.js"  type="text/javascript"></script>
    <link rel="stylesheet" href="/adminlte/bootstrap/css/bootstrap.css">
<#--<script type="text/javascript" src="/js/validator-0.7.3/jquery.validator.js"></script>
<script type="text/javascript" src="/js/validator-0.7.3/local/zh_CN.js"></script>-->
    <script type="text/javascript" src="/login-resource/host.js"></script>
    <script type="text/javascript" src="/login-resource/sweetalert/sweetalert.min.js"></script>
<#--<#assign contextPath=request.contextPath />-->
</head>
<body bgcolor="#FFFFFF">
<div class="middle-box text-center loginscreen  ">
    <div >
        <div onclick="boke();" class="animated animated lightSpeedIn ">
            <i class="icon iconfont">&#xf0028;</i>
        </div>
        <form id="userForm" class=" animated rollIn"  action="/login" method="post">
            <div class="form-group">
                <input type="text" class="form-control"  placeholder="用户名" name="username" required id = "username" value="admin">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="密码" required id = "password" name="password" value="admin">
            </div>
        <#--用户名 : <input type="text" name="username"/>
        密码 : <input type="password" name="password"/>-->
            <input type="submit"  class="btn btn-primary block full-width " value="登录">
        </form>
        <br/>
        <br/>
        <div class = "animated bounceInLeft" >
            © 2019 All Rights Reserved. 李先生|随便玩一玩的
        </div>
    </div>
</div>
<div class="part" style="z-index:-1;position:fixed;height:100%;width:100%;top:0;left:0"></div>
</body>

<#--validator-->
<script src="/validator/bootstrapValidator.js" ></script>
<link rel="stylesheet" rel="/validator/bootstrapValidator.css">
<script type="text/javascript">

    //跳转到个人博客
    function boke(){
    };

    $('#userForm').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            username: {
                message: '用户名验证失败',
                validators: {
                    notEmpty: {
                        message: '用户名不能为空'
                    },
                    stringLength: {
                        min: 4,
                        max: 20,
                        message: "长度为4~20"
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    }
                }
            }
        }
    });

</script>
</html>