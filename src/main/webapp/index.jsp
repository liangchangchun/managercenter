<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="us">
<head>
<meta charset="utf-8">
<title>Insert</title>
<link href="js/jquery12/jquery-ui.css" rel="stylesheet"></link>
<link href="js/ztree3.5/zTreeStyle/zTreeStyle.css" rel="stylesheet"></link>
<script src="js/jquery12/external/jquery/jquery.js" ></script>
<script src="js/jquery12/jquery-ui.min.js" ></script>
<script src="js/ztree3.5/jquery.ztree.core.js" ></script>

  <style>
	body {
	background-color: white;
	margin:0; padding:0;
	text-align: center;
	font-family: "Trebuchet MS", sans-serif;
	margin: 50px;
	}

	#testIframe {margin-left: 10px;}
	
	.demoHeaders {
		margin-top: 2em;
	}
	#dialog-link {
		padding: .4em 1em .4em 20px;
		text-decoration: none;
		position: relative;
	}
	#dialog-link span.ui-icon {
		margin: 0 5px 0 0;
		position: absolute;
		left: .2em;
		top: 50%;
		margin-top: -8px;
	}
	#icons {
		margin: 0;
		padding: 0;
	}
	#icons li {
		margin: 2px;
		position: relative;
		padding: 4px 0;
		cursor: pointer;
		float: left;
		list-style: none;
	}
	#icons span.ui-icon {
		float: left;
		margin: 0 4px;
	}
	.fakewindowcontain .ui-widget-overlay {
		position: absolute;
	}
	select {
		width: 200px;
	}
  </style>
  
  <SCRIPT type="text/javascript" >

	var zTree;
	var demoIframe;

	var setting = {
		view: {
			dblClickExpand: false,
			showLine: true,
			selectedMulti: false
		},
		data: {
			simpleData: {
				enable:true,
				idKey: "id",
				pIdKey: "pId",
				rootPId: ""
			}
		},
		callback: {
			beforeClick: function(treeId, treeNode) {
				var zTree = $.fn.zTree.getZTreeObj("tree");
				if (treeNode.isParent) {
					zTree.expandNode(treeNode);
					return false;
				} else {
					demoIframe.attr("src",treeNode.file + ".html");
					return true;
				}
			}
		}
	};

	var zNodes =[
{id:1, pId:0, name:"首页1", open:true},
{id:101, pId:1, name:"登录", file:"core/simpleData"},
	{id:10101, pId:101, name:"玩家注册", file:"core/simpleData"},
	{id:10102, pId:101, name:"商家注册", file:"core/simpleData"},
	{id:10103, pId:101, name:"忘记密码", file:"core/simpleData"},
{id:102, pId:1, name:"24小时", file:"core/simpleData"},
	{id:10201, pId:102, name:"page01", file:"core/simpleData"},
		{id:1020101, pId:10201, name:"所在城市", file:"core/simpleData"},
			{id:102010101, pId:1020101, name:"所有城市", file:"core/simpleData"},
		{id:1020102, pId:10201, name:"武汉", file:"core/simpleData"},
	{id:10202, pId:102, name:"个人中心", file:"core/simpleData"},
		{id:1020201, pId:10202, name:"我的收藏", file:"core/simpleData"},
		{id:1020202, pId:10202, name:"我的订阅", file:"core/simpleData"},
			{id:102020201, pId:1020202, name:"精选订阅", file:"core/simpleData"},
				{id:10202020101, pId:102020201, name:"搜索", file:"core/simpleData"},
		{id:1020203, pId:10202, name:"我的频道", file:"core/simpleData"},
	{id:10203, pId:102, name:"搜索", file:"core/simpleData"},
	{id:10204, pId:102, name:"新闻正文", file:"core/simpleData"},
		{id:1020401, pId:10204, name:"所有评论", file:"core/simpleData"},
			{id:102040101, pId:1020401, name:"单个评论", file:"core/simpleData"},
	{id:10205, pId:102, name:"添加频道", file:"core/simpleData"},
		{id:1020501, pId:10205, name:"编辑", file:"core/simpleData"},
		{id:1020502, pId:10205, name:"完成", file:"core/simpleData"},
	{id:10206, pId:102, name:"发布新闻", file:"core/simpleData"},
{id:103, pId:1, name:"我要服务", file:"core/simpleData"},
	{id:10301, pId:103, name:"商业服务", file:"core/simpleData"},
		{id:1030101, pId:10301, name:"需求分类", file:"core/simpleData"},
		{id:1030102, pId:10301, name:"专家团", file:"core/simpleData"},
			{id:103010201, pId:1030102, name:"专家分类", file:"core/simpleData"},
		{id:1030103, pId:10301, name:"发布需求时的分类", file:"core/simpleData"},
		{id:1030104, pId:10301, name:"单个推荐需求", file:"core/simpleData"},
		{id:1030105, pId:10301, name:"我发布的所有需求", file:"core/simpleData"},
		{id:1030106, pId:10301, name:"发布需求", file:"core/simpleData"},
		{id:1030107, pId:10301, name:"编辑完成已发布", file:"core/simpleData"},
		{id:1030108, pId:10301, name:"需求列表", file:"core/simpleData"},
	{id:10302, pId:103, name:"服务注册(提供方)", file:"core/simpleData"},
		{id:1030201, pId:10302, name:"服务分类", file:"core/simpleData"},
			{id:103020101, pId:1030201, name:"健康", file:"core/simpleData"},
			{id:103020102, pId:1030201, name:"二手", file:"core/simpleData"},
			{id:103020103, pId:1030201, name:"时尚", file:"core/simpleData"},
			{id:103020104, pId:1030201, name:"娱乐", file:"core/simpleData"},
			{id:103020105, pId:1030201, name:"教育", file:"core/simpleData"},
			{id:103020106, pId:1030201, name:"公益", file:"core/simpleData"},
			{id:103020107, pId:1030201, name:"租房", file:"core/simpleData"},
			{id:103020108, pId:1030201, name:"兼职", file:"core/simpleData"},
			{id:103020109, pId:1030201, name:"维修", file:"core/simpleData"},
			{id:103020110, pId:1030201, name:"商务", file:"core/simpleData"},
		{id:1030202, pId:10302, name:"专家团", file:"core/simpleData"},
			{id:103020201, pId:1030202, name:"专家分类", file:"core/simpleData"},
			{id:103020202, pId:1030202, name:"专家注册", file:"core/simpleData"},
		{id:1030203, pId:10302, name:"编辑服务时的分类", file:"core/simpleData"},
		{id:1030204, pId:10302, name:"单个推荐服务", file:"core/simpleData"},
		{id:1030205, pId:10302, name:"我提供的所有服务", file:"core/simpleData"},
		{id:1030206, pId:10302, name:"服务列表", file:"core/simpleData"},
		{id:1030207, pId:10302, name:"发布服务", file:"core/simpleData"},
		{id:1030208, pId:10302, name:"编辑完成已发布服务", file:"core/simpleData"},
{id:104, pId:1, name:"玩家挣钱", file:"core/simpleData"},
	{id:10401, pId:104, name:"美丽行", file:"core/simpleData"},
		{id:1040101, pId:10401, name:"美容美体", file:"core/simpleData"},
			{id:104010101, pId:1040101, name:"热门秒杀", file:"core/simpleData"},
				{id:10401010101, pId:104010101, name:"boss买单", file:"core/simpleData"},
				{id:10401010102, pId:104010101, name:"秒杀", file:"core/simpleData"},
					{id:1040101010201, pId:10401010102, name:"我要修改", file:"core/simpleData"},
			{id:104010102, pId:1040101, name:"最新揭晓", file:"core/simpleData"},
			{id:104010103, pId:1040101, name:"晒单分享", file:"core/simpleData"},
				{id:10401010301, pId:104010103, name:"晒单详情", file:"core/simpleData"},
			{id:104010104, pId:1040101, name:"玩家挣钱", file:"core/simpleData"},
		{id:1040102, pId:10401, name:"美发造型", file:"core/simpleData"},
		{id:1040103, pId:10401, name:"化妆美甲", file:"core/simpleData"},
		{id:1040104, pId:10401, name:"时尚衣装", file:"core/simpleData"},
		{id:1040105, pId:10401, name:"潮流鞋包", file:"core/simpleData"},
		{id:1040106, pId:10401, name:"搜索", file:"core/simpleData"},
		{id:1040107, pId:10401, name:"发起", file:"core/simpleData"},
	{id:10402, pId:104, name:"快乐行", file:"core/simpleData"},
	{id:10403, pId:104, name:"健康行", file:"core/simpleData"},
	{id:10404, pId:104, name:"财富行", file:"core/simpleData"},
	{id:10405, pId:104, name:"时尚行", file:"core/simpleData"},
	{id:10406, pId:104, name:"公益行", file:"core/simpleData"},
	{id:10407, pId:104, name:"排行榜", file:"core/simpleData"},
{id:105, pId:1, name:"白送白玩", file:"core/simpleData"},
{id:106, pId:1, name:"泡圈聊天", file:"core/simpleData"},
{id:107, pId:1, name:"粉旗帜", file:"core/simpleData"},
{id:108, pId:1, name:"账户查询", file:"core/simpleData"},
{id:109, pId:1, name:"美好人生", file:"core/simpleData"},
{id:1010, pId:1, name:"我要炫", file:"core/simpleData"},
	{id:101001, pId:1010, name:"我要炫的", file:"core/simpleData"},
	{id:101002, pId:1010, name:"视频详情页", file:"core/simpleData"},
	{id:101003, pId:1010, name:"视频上传", file:"core/simpleData"},
{id:2, pId:0, name:"我的圈子", open:false},
{id:201, pId:2, name:"全部圈子", file:"core/simpleData"},
{id:202, pId:2, name:"聊天", file:"core/simpleData"},
	{id:20201, pId:202, name:"群聊", file:"core/simpleData"},
	{id:20202, pId:202, name:"私聊", file:"core/simpleData"},
	{id:20203, pId:202, name:"通讯录", file:"core/simpleData"},
{id:203, pId:2, name:"朋友圈", file:"core/simpleData"},
	{id:20301, pId:203, name:"个人详情", file:"core/simpleData"},
	{id:20302, pId:203, name:"发布", file:"core/simpleData"},
{id:204, pId:2, name:"全部圈子详情", file:"core/simpleData"},
	{id:20401, pId:204, name:"圈子成员", file:"core/simpleData"},
{id:205, pId:2, name:"圈子组列表", file:"core/simpleData"},
{id:206, pId:2, name:"创建圈子", file:"core/simpleData"},
{id:207, pId:2, name:"我的圈子详情", file:"core/simpleData"},
	{id:20701, pId:207, name:"设置", file:"core/simpleData"},
	{id:20702, pId:207, name:"我的圈子小组", file:"core/simpleData"},
{id:208, pId:2, name:"圈子二维码", file:"core/simpleData"},
{id:209, pId:2, name:"活动", file:"core/simpleData"},
{id:2010, pId:2, name:"相册", file:"core/simpleData"},
	{id:201001, pId:2010, name:"创建相册", file:"core/simpleData"},
	{id:201002, pId:2010, name:"添加相片", file:"core/simpleData"},
	{id:201003, pId:2010, name:"相册上传", file:"core/simpleData"},
{id:2011, pId:2, name:"视频", file:"core/simpleData"},
	{id:201101, pId:2011, name:"上传视频", file:"core/simpleData"},
{id:2012, pId:2, name:"通知", file:"core/simpleData"},
	{id:201201, pId:2012, name:"发布", file:"core/simpleData"},
{id:2013, pId:2, name:"搜索", file:"core/simpleData"},
{id:2014, pId:2, name:"活动详情", file:"core/simpleData"},
{id:3, pId:0, name:"生活",open:false},
{id:301, pId:3, name:"商品", file:"core/simpleData"},
	{id:30101, pId:301, name:"商品详情", file:"core/simpleData"},
{id:302, pId:3, name:"全部分类", file:"core/simpleData"},
{id:303, pId:3, name:"购物车", file:"core/simpleData"},
	{id:30301, pId:303, name:"购物车2", file:"core/simpleData"},
{id:304, pId:3, name:"店铺内页", file:"core/simpleData"},
	{id:30401, pId:304, name:"全部商品", file:"core/simpleData"},
{id:305, pId:3, name:"确认订单", file:"core/simpleData"},
{id:306, pId:3, name:"选择收货地址", file:"core/simpleData"},
	{id:30601, pId:306, name:"新增收货地址", file:"core/simpleData"},
{id:307, pId:3, name:"搜索页面", file:"core/simpleData"},
{id:4, pId:0, name:"粉商家版", open:false},
{id:401, pId:4, name:"管理圈子", file:"core/simpleData"},
	{id:40101, pId:401, name:"尊享圈修改", file:"core/simpleData"},
	{id:40102, pId:401, name:"玩家圈修改", file:"core/simpleData"},
	{id:40103, pId:401, name:"加入的圈子", file:"core/simpleData"},
	{id:40104, pId:401, name:"设置", file:"core/simpleData"},
{id:402, pId:4, name:"发布的活动", file:"core/simpleData"},
	{id:40201, pId:402, name:"上传凭证", file:"core/simpleData"},
	{id:40202, pId:402, name:"Cope of 详情", file:"core/simpleData"},
	{id:40203, pId:402, name:"fabu", file:"core/simpleData"},
	{id:40204, pId:402, name:"jinxingzhogn", file:"core/simpleData"},
	{id:40205, pId:402, name:"yiwancheng", file:"core/simpleData"},
	{id:40206, pId:402, name:"weiwanc", file:"core/simpleData"},
{id:403, pId:4, name:"会员卡", file:"core/simpleData"},
	{id:40301, pId:403, name:"Copy of圈子详情", file:"core/simpleData"},
	{id:40302, pId:403, name:"账单", file:"core/simpleData"},
		{id:40303, pId:403, name:"账单详情", file:"core/simpleData"},
	{id:40303, pId:403, name:"卡详情", file:"core/simpleData"},
{id:404, pId:4, name:"城市账户", file:"core/simpleData"},
	{id:40401, pId:404, name:"提现", file:"core/simpleData"},
	{id:40402, pId:404, name:"尊享圈账单", file:"core/simpleData"},
{id:405, pId:4, name:"买单的活动", file:"core/simpleData"},
	{id:40501, pId:405, name:"查看凭证", file:"core/simpleData"},
	{id:40502, pId:405, name:"详情", file:"core/simpleData"},
{id:406, pId:4, name:"活动订单", file:"core/simpleData"},
	{id:40601, pId:406, name:"待付款详情", file:"core/simpleData"},
	{id:40602, pId:406, name:"已付款详情", file:"core/simpleData"},
	{id:40603, pId:406, name:"已完成详情", file:"core/simpleData"},
	{id:40604, pId:406, name:"商品订单", file:"core/simpleData"},
{id:407, pId:4, name:"购物车", file:"core/simpleData"},
	{id:40701, pId:407, name:"名片收藏", file:"core/simpleData"},
	{id:40702, pId:407, name:"店铺", file:"core/simpleData"},
	{id:40703, pId:407, name:"商品", file:"core/simpleData"},
	{id:40704, pId:407, name:"会员卡", file:"core/simpleData"},
	{id:40705, pId:407, name:"内容", file:"core/simpleData"},
	{id:40706, pId:407, name:"活动", file:"core/simpleData"},
{id:408, pId:4, name:"收藏", file:"core/simpleData"},
{id:409, pId:4, name:"设置", file:"core/simpleData"},
	{id:40901, pId:409, name:"新消息提醒", file:"core/simpleData"},
	{id:40902, pId:409, name:"勿扰模式", file:"core/simpleData"},
	{id:40903, pId:409, name:"账号与安全", file:"core/simpleData"},
		{id:4090301, pId:40903, name:"密码设置", file:"core/simpleData"},
	{id:40904, pId:409, name:"关于我们", file:"core/simpleData"},
		{id:4090401, pId:40904, name:"功能介绍", file:"core/simpleData"},
		{id:4090402, pId:40904, name:"系统通知", file:"core/simpleData"},
		{id:4090403, pId:40904, name:"意见反馈", file:"core/simpleData"},
		{id:4090404, pId:40904, name:"版本更新", file:"core/simpleData"},
	{id:40905, pId:409, name:"用户协议", file:"core/simpleData"},
	{id:40906, pId:409, name:"消息设置", file:"core/simpleData"},
{id:4010, pId:4, name:"设置头像", file:"core/simpleData"},
{id:4011, pId:4, name:"通知", file:"core/simpleData"},
{id:5, pId:0, name:"粉玩家版", file:"core/simpleData"}
	];

	$(document).ready(function(){
		
		var t = $("#tree");
		t = $.fn.zTree.init(t, setting, zNodes);
		demoIframe = $("#testIframe");
		demoIframe.bind("load", loadReady);
		var zTree = $.fn.zTree.getZTreeObj("tree");
		zTree.selectNode(zTree.getNodeByParam("id", 101));
		
		$( "#left-accordion" ).accordion();
		$( "#right-tabs" ).tabs();
		$( "#button" ).button();
		
		$( "#button" ).click(function(){
			 $.ajax( {  
			    url:'init.do',// 跳转到 action  
			    data:{  id : $("#usercode").val(),  userName : $("#username").val() },  
			    type:'post',  
			    cache:false,  
			    dataType:'json',  
			    success:function(data) {  
			    	//alert(data.code);
			        if(data.code =="1" ){  
			            dialogOpen("添加成功！");  
			           // window.location.reload();  
			        }else{  
			        	dialogOpen(data.text);  
			        }  
			     },  
			     error : function() {  
			          dialogOpen("异常！");  
			     }  
			});
			
			event.preventDefault();
		});
		
		$( "#button-icon" ).button({
			icon: "ui-icon-gear",
			showLabel: false
		});
		
		
		$( "#dialog-link" ).click(function( event ) {
			$( "#dialog" ).dialog( "open" );
			event.preventDefault();
		});
		
		
		$( "#dialog" ).dialog({
			autoOpen: false,
			width: 400,
			buttons: [
				{
					text: "Ok",
					click: function() {
						$( this ).dialog( "close" );
					}
				},
				{
					text: "Cancel",
					click: function() {
						$( this ).dialog( "close" );
					}
				}
			]
		});

		// Link to open the dialog
		$( "#dialog-link" ).click(function( event ) {
			$( "#dialog" ).html("<p>123</p>");
			$( "#dialog" ).dialog( "open" );
			event.preventDefault();
		});

	});
	
	function dialogOpen(mes){
		$( "#dialog" ).html("<p>"+mes+"</p>");
		$( "#dialog" ).dialog( "open" );
		event.preventDefault();
	}
	function loadReady() {
		var bodyH = demoIframe.contents().find("body").get(0).scrollHeight,
		htmlH = demoIframe.contents().find("html").get(0).scrollHeight,
		maxH = Math.max(bodyH, htmlH), minH = Math.min(bodyH, htmlH),
		h = demoIframe.height() >= maxH ? minH:maxH ;
		if (h < 530) h = 530;
		demoIframe.height(h);
	}


  </SCRIPT>
<body>
<div id="dialog" title="Dialog Title">
	<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
</div>
<div id="content">
<div id="top"></div>
<div id="" >
<div id="left-accordion" style="width:30%; margin-left: auto; margin-right: auto;float:left;height:780px;">
	<h3>UI结构图</h3>
	<div><ul id="tree" class="ztree" style="overflow:auto;height:575px;"></ul></div>
	<h3>接口管理</h3>
	<div>123</div>
	<h3>IOS任务管理</h3>
	<div>Nam dui erat, auctor a, dignissim quis.</div>
	<h3>Android任务管理</h3>
	<div>Nam dui erat, auctor a, dignissim quis.</div>
</div>
</div>
<div id="right-tabs" style="width:69%; margin-left:4px; margin-right: auto;float:left;height:790px;">
	<ul>
		<li><a href="#tabs-1">玩家注册</a></li>
		<li><a href="#tabs-2">商业注册</a></li>
		<li><a href="#tabs-3">忘记密码</a></li>
	</ul>
	<div id="tabs-1">
	usercode:<input id="usercode" type="text" />
	username:<input id="username" type="text" />
<button id="button">A button element</button>
<button id="button-icon">An icon-only button</button>

<button id="dialog-link" class="ui-button ui-corner-all ui-widget">
		<span class="ui-icon ui-icon-newwin"></span>Open Dialog
	</button>
	</div>
	<div id="tabs-2">
	</div>
	<div id="tabs-3">
	</div>
</div>
</div>
</body>
</html>