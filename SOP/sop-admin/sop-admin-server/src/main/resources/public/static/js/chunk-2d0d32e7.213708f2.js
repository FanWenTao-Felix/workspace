(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0d32e7"],{"5c58":function(t,e,l){"use strict";l.r(e);var a=function(){var t=this,e=t.$createElement,l=t._self._c||e;return l("div",{staticClass:"app-container"},[l("el-form",{staticClass:"demo-form-inline",attrs:{inline:!0,model:t.searchFormData,size:"mini"}},[l("el-form-item",{attrs:{label:"接口名"}},[l("el-input",{staticStyle:{width:"250px"},attrs:{clearable:!0,placeholder:"输入接口名或版本号"},model:{value:t.searchFormData.routeId,callback:function(e){t.$set(t.searchFormData,"routeId",e)},expression:"searchFormData.routeId"}})],1),t._v(" "),l("el-form-item",[l("el-button",{attrs:{type:"primary",icon:"el-icon-search"},on:{click:t.loadTable}},[t._v("搜索")])],1)],1),t._v(" "),l("el-alert",{staticStyle:{"margin-bottom":"10px"},attrs:{title:"监控数据保存在网关服务器，重启网关数据会清空。",type:"info",closable:!1}}),t._v(" "),l("el-table",{attrs:{data:t.tableData,border:"","default-expand-all":!1,"row-key":"id",height:"500","empty-text":"无数据"}},[l("el-table-column",{attrs:{fixed:"",prop:"instanceId",label:"网关实例",width:"200"},scopedSlots:t._u([{key:"default",fn:function(e){return[e.row.children?t._e():l("span",[t._v(t._s(e.row.instanceId))])]}}])}),t._v(" "),l("el-table-column",{attrs:{fixed:"",prop:"name",label:"接口名 (版本号)",width:"280"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v("\n        "+t._s(e.row.name+(e.row.version?" ("+e.row.version+")":""))+"\n      ")]}}])}),t._v(" "),l("el-table-column",{attrs:{prop:"serviceId",label:"serviceId",width:"170"}}),t._v(" "),l("el-table-column",{attrs:{prop:"maxTime",label:"最大耗时(ms)",width:"125"}},[l("template",{slot:"header"},[t._v("\n        最大耗时(ms)\n        "),l("i",{staticClass:"el-icon-question",staticStyle:{cursor:"pointer"},on:{click:function(e){return t.$alert("耗时计算：签名验证成功后开始，微服务返回结果后结束")}}})])],2),t._v(" "),l("el-table-column",{attrs:{prop:"minTime",label:"最小耗时(ms)",width:"120"}}),t._v(" "),l("el-table-column",{attrs:{prop:"avgTime",label:"平均耗时(ms)",width:"120"}}),t._v(" "),l("el-table-column",{attrs:{prop:"totalCount",label:"总调用次数",width:"100"}}),t._v(" "),l("el-table-column",{attrs:{prop:"successCount",label:"成功次数",width:"100"}}),t._v(" "),l("el-table-column",{attrs:{prop:"errorCount",label:"失败次数",width:"100"},scopedSlots:t._u([{key:"default",fn:function(e){return[e.row.errorCount>0?l("el-link",{staticStyle:{"text-decoration":"underline"},attrs:{underline:!1,type:"danger"},on:{click:function(l){return t.onShowErrorDetail(e.row)}}},[t._v("\n          "+t._s(e.row.errorCount)+"\n        ")]):t._e(),t._v(" "),0===e.row.errorCount?l("span",[t._v("0")]):t._e()]}}])},[l("template",{slot:"header"},[t._v("\n        失败次数\n        "),l("i",{staticClass:"el-icon-question",staticStyle:{cursor:"pointer"},on:{click:function(e){return t.$alert("只统计微服务返回的未知错误，JSR-303验证错误算作成功")}}})])],2)],1),t._v(" "),l("el-dialog",{attrs:{title:"错误详情",visible:t.logDetailVisible,width:"60%"},on:{"update:visible":function(e){t.logDetailVisible=e}}},[l("div",{staticStyle:{"overflow-x":"auto"},domProps:{innerHTML:t._s(t.errorMsgDetail)}}),t._v(" "),l("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[l("el-button",{attrs:{type:"primary"},on:{click:function(e){t.logDetailVisible=!1}}},[t._v("关 闭")])],1)])],1)},o=[],r={data:function(){return{searchFormData:{routeId:""},tableData:[],logDetailVisible:!1,errorMsgDetail:""}},created:function(){this.loadTable()},methods:{loadTable:function(){this.post("monitor.data.list",this.searchFormData,function(t){var e=t.data;this.tableData=e.monitorInfoData})},onShowErrorDetail:function(t){var e=t.errorMsgList;this.errorMsgDetail=e.length>0?e.join("<br>"):"无内容",this.logDetailVisible=!0}}},i=r,n=l("2877"),s=Object(n["a"])(i,a,o,!1,null,null,null);e["default"]=s.exports}}]);