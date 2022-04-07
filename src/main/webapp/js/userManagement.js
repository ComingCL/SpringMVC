$(function(){
	//根据窗口调整表格高度
    $(window).resize(function() {
        $('#mytab').bootstrapTable('resetView', {
            height: tableHeight()
        })
    })
    //生成用户数据
    $('#mytab').bootstrapTable({
	method : 'get',
	url : "user/getUserListPage",//请求路径
	striped : true, //是否显示行间隔色
	pageNumber : 1, //初始化加载第一页
	pagination : true,//是否分页
	sidePagination : 'client',//server:服务器端分页|client：前端分页
	pageSize : 4,//单页记录数
	pageList : [ 5, 10, 20, 30 ],//可选择单页记录数
	showRefresh : true,//刷新按钮
	queryParams : function(params) {//上传服务器的参数
		var temp = {//如果是在服务器端实现分页，limit、offset这两个参数是必须的
			limit : params.limit, // 每页显示数量
			offset : params.offset, // SQL语句起始索引
			//page : (params.offset / params.limit) + 1, //当前页码

			Name : $('#search_name').val(),
			Tel : $('#search_tel').val()
		};
		return temp;
	},
        columns : [ {
            title : '商品名',
            field : 'GoodsName',
            sortable : true
        }, {
            title : '数量',
            field : 'Amount',
            sortable : true
        }, {
            title : '操作',
            field : 'id',
            formatter : operation,//对资源进行操作
        } ]
    })

    //删除、编辑操作
    function operation(value, row, index) {
        var htm = "<button>删除</button><button>修改</button>"
        return htm;
    }

    //查询按钮事件
    $('#search_btn').click(function() {
        $('#mytab').bootstrapTable('refresh', {
            url : 'user/getUserListPage'
        });
    })

})
function tableHeight() {
    return $(window).height() - 140;
}
