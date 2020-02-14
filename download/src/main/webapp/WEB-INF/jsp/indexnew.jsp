<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basepath %>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <title>欧文电玩淘宝店下载工具</title>
    <link rel="icon" type="image/x-ico"
          href="https://img.alicdn.com/imgextra/i3/2632299970/O1CN01rf6OSC2NWJMNsKi4l_!!2632299970.png"/>
    <script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://www.layuicdn.com/layui/css/layui.css"/>
</head>

<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">欧文电玩下载工具</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="<%=basepath %>">首页</a></li>
            <li class="layui-nav-item"><a href="https://shop449801053.taobao.com">欧文电玩淘宝店</a></li>
            <li class="layui-nav-item"><a href="https://item.taobao.com/item.htm?id=611683888974">淘宝产品地址</a></li>
        </ul>
<%--        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    贤心
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">退了</a></li>
        </ul>--%>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
        <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
    </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <blockquote class="layui-elem-quote layui-text">
                本网站为内部网站，轻忽外传
            </blockquote>
            <form class="layui-form" action="">
                <div class="layui-form-item">
                    <label class="layui-form-label">资源链接</label>
                    <div class="layui-input-block">
                        <input type="text" name="bookUrl" required lay-verify="required" placeholder="请输入资源链接" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">资源页数</label>
                    <div class="layui-input-block">
                        <input type="text" name="pageTotal" required lay-verify="required" placeholder="请输入页数" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
            <div class="layui-row">
                <div class="layui-col-xs0 layui-col-sm0 layui-col-md3">
                </div>
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md3">
                    <img width=500px height=500px
                         src="https://img.alicdn.com/imgextra/i4/2632299970/O1CN01vSqJqC2NWJMPXwXZ5_!!2632299970.png"
                         alt="转换介绍.png"/>
                </div>
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md3">
                    <img width=500px height=500px
                         src="https://img.alicdn.com/imgextra/i4/2632299970/O1CN01Mfwu3f2NWJMPLsznO_!!2632299970.png"
                         alt="价格800white.png"/>
                </div>
                <div class="layui-col-xs0 layui-col-sm0 layui-col-md3">
                </div>
            </div>
        </div>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<script src="https://www.layuicdn.com/layui/layui.js"></script>
<script>
    layui.use('element', function () {
        var element = layui.element();
    });
    //Demo
    layui.use('form', function () {
        var form = layui.form;

        //监听提交
        form.on('submit(formDemo)', function (data) {
            var basepath = "<%=basepath %>"
            var url = basepath + "download"
            var data = JSON.stringify(data.field);
            //alert(data);
            layer.confirm('链接和页数是否正确？', {icon: 3, title: '检查输入信息'}, function (index) {
                var loading = layer.load();
                //post请求
                $.ajax({
                    type: "post",
                    url: url,
                    dataType: "json",
                    contentType: "application/json",
                    data: data,
                    success: function (result, state) {
                        layer.close(loading);
                        if (result.error == true) {
                            layer.open({
                                type: 2,
                                area: ['500px', '600px'],
                                content: result.url //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
                            });
                        } else {
                            layer.msg("下错错误，请检查输入链接是否正确");
                        }
                    }
                });
                layer.close(index);
            });
            return false;
        });
    });
</script>
</body>
</html>