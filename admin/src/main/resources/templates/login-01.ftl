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
            <form id="userForm" class=" animated rollIn">
                <div class="form-group">
                    <input type="text" class="form-control"  placeholder="用户名" name="username" required id = "username">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="密码" required id = "password" name="password">
                </div>
                <!--<div class="form-group col-xs-6" style="padding-left: 0px;">
                	<img src="/getGifCode">
                </div>
                <div class="form-group col-xs-6">
                    <span><input type="text" class="form-control" placeholder="验证码" data-rule="验证码:required" id = "vcode"></span>
                </div> -->
                <#--<div class="form-group" style="text-align : left">
					<label><input type="checkbox" id="rememberMe" style="width: 12px; height: 12px;margin-right: 5px;">记住我</label>
				</div>-->
                <button type="submit" id="submit" class="btn btn-primary block full-width " onclick="login();">登 录</button>
            </form>
            <br/>
            <br/>
            <div class = "animated bounceInLeft" >
                © 2017 All Rights Reserved. 李先生|随便玩一玩的
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
                        min: 6,
                        max: 20,
                        message: "长度为6~20"
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


	function login() {
		var username = $("#username").val();
		var password = $("#password").val();
		var vcode = $("#vcode").val();
		var rememberMe =$('#rememberMe').is(':checked');
        if (!$("#userForm").data('bootstrapValidator').isValid()) {//获取验证结果，如果成功，执行下面代码
            //alert("yes");//验证成功后的操作，如ajax
            return ;
        }
		$.ajax({
			type : "POST",
			data : {
				"username" : username,
				"password" : password,
				"vcode" : vcode,
				"rememberMe" : rememberMe
			},
			//url : "/login/passport",
            url : "/login",
			success : function(result) {
				console.log("===============");
			    console.log(result);
				if (result.status != 0) {
					swal("哦豁",result.msg,"error");
				} else {
					console.log(result)
				    swal({title:"太帅了",text:"登录成功，进入系统！",type:"success"},
						function () {
						location.href = "/home";
				    });
				}
			}
		});
	}
</script>
</html>