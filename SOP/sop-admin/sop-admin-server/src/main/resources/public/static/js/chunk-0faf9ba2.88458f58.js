(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-0faf9ba2"],{"0a49":function(e,t,i){var a=i("9b43"),l=i("626a"),o=i("4bf8"),r=i("9def"),n=i("cd1c");e.exports=function(e,t){var i=1==e,s=2==e,c=3==e,m=4==e,p=6==e,u=5==e||p,d=t||n;return function(t,n,g){for(var f,D,h=o(t),v=l(h),y=a(n,g,3),b=r(v.length),k=0,x=i?d(t,b):s?d(t,0):void 0;b>k;k++)if((u||k in v)&&(f=v[k],D=y(f,k,h),e))if(i)x[k]=D;else if(D)switch(e){case 3:return!0;case 5:return f;case 6:return k;case 2:x.push(f)}else if(m)return!1;return p?-1:c||m?m:x}}},1169:function(e,t,i){var a=i("2d95");e.exports=Array.isArray||function(e){return"Array"==a(e)}},2735:function(e,t,i){"use strict";i.r(t);var a=function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"app-container"},[i("el-container",[i("el-aside",{staticStyle:{"min-height":"300px",width:"250px"}},[i("el-input",{staticStyle:{"margin-bottom":"20px"},attrs:{"prefix-icon":"el-icon-search",placeholder:"搜索服务...",size:"mini",clearable:""},model:{value:e.filterText,callback:function(t){e.filterText=t},expression:"filterText"}}),e._v(" "),i("el-tree",{ref:"tree2",staticClass:"filter-tree",attrs:{data:e.treeData,props:e.defaultProps,"filter-node-method":e.filterNode,"highlight-current":!0,"expand-on-click-node":!1,"empty-text":"无数据","node-key":"id","default-expand-all":""},on:{"node-click":e.onNodeClick},scopedSlots:e._u([{key:"default",fn:function(t){t.node;var a=t.data;return i("span",{staticClass:"custom-tree-node"},[i("div",[i("el-tooltip",{directives:[{name:"show",rawName:"v-show",value:a.custom,expression:"data.custom"}],staticClass:"item",attrs:{content:"自定义服务",effect:"light",placement:"left"}},[i("i",{staticClass:"el-icon-warning-outline"})]),e._v(" "),a.label.length<e.serviceTextLimitSize?i("span",[e._v(e._s(a.label))]):i("span",[i("el-tooltip",{staticClass:"item",attrs:{content:a.label,effect:"light",placement:"right"}},[i("span",[e._v(e._s(a.label.substring(0,e.serviceTextLimitSize)+"..."))])])],1)],1),e._v(" "),i("span",[1===a.custom?i("el-button",{attrs:{type:"text",size:"mini",icon:"el-icon-delete",title:"删除服务"},on:{click:function(t){return t.stopPropagation(),function(){return e.onDelService(a)}()}}}):e._e()],1)])}}])})],1),e._v(" "),i("el-main",{staticStyle:{"padding-top":"0"}},[i("el-form",{staticClass:"demo-form-inline",attrs:{inline:!0,model:e.searchFormData,size:"mini"}},[i("el-form-item",{attrs:{label:"路由ID"}},[i("el-input",{attrs:{placeholder:"接口名，支持模糊查询",clearable:""},model:{value:e.searchFormData.routeId,callback:function(t){e.$set(e.searchFormData,"routeId",t)},expression:"searchFormData.routeId"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"AppKey"}},[i("el-input",{attrs:{placeholder:"AppKey，支持模糊查询",clearable:""},model:{value:e.searchFormData.appKey,callback:function(t){e.$set(e.searchFormData,"appKey",t)},expression:"searchFormData.appKey"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"IP"}},[i("el-input",{attrs:{placeholder:"ip，支持模糊查询",clearable:""},model:{value:e.searchFormData.limitIp,callback:function(t){e.$set(e.searchFormData,"limitIp",t)},expression:"searchFormData.limitIp"}})],1),e._v(" "),i("el-form-item",[i("el-button",{attrs:{type:"primary",icon:"el-icon-search",size:"mini"},on:{click:e.onSearchTable}},[e._v("查询")])],1)],1),e._v(" "),i("el-button",{staticStyle:{"margin-bottom":"10px"},attrs:{type:"primary",size:"mini",icon:"el-icon-plus"},on:{click:e.onAdd}},[e._v("新增限流")]),e._v(" "),i("el-table",{attrs:{data:e.pageInfo.list,border:""}},[i("el-table-column",{attrs:{prop:"limitKey",label:"限流维度",width:"400"},scopedSlots:e._u([{key:"default",fn:function(t){return[i("div",{domProps:{innerHTML:e._s(e.limitRender(t.row))}})]}}])}),e._v(" "),i("el-table-column",{attrs:{prop:"limitType",label:"限流策略",width:"120"},scopedSlots:e._u([{key:"default",fn:function(t){return[1===t.row.limitType?i("span",[e._v("窗口策略")]):e._e(),e._v(" "),2===t.row.limitType?i("span",[e._v("令牌桶策略")]):e._e()]}}])},[i("template",{slot:"header"},[e._v("\n            限流策略 "),i("i",{staticClass:"el-icon-question",staticStyle:{cursor:"pointer"},on:{click:e.onLimitTypeTipClick}})])],2),e._v(" "),i("el-table-column",{attrs:{prop:"info",label:"限流信息",width:"250"},scopedSlots:e._u([{key:"default",fn:function(t){return[i("span",{domProps:{innerHTML:e._s(e.infoRender(t.row))}})]}}])}),e._v(" "),i("el-table-column",{attrs:{prop:"limitStatus",label:"状态",width:"80"},scopedSlots:e._u([{key:"default",fn:function(t){return[1===t.row.limitStatus?i("span",{staticStyle:{color:"#67C23A"}},[e._v("已开启")]):e._e(),e._v(" "),0===t.row.limitStatus?i("span",{staticStyle:{color:"#909399"}},[e._v("已关闭")]):e._e()]}}])}),e._v(" "),i("el-table-column",{attrs:{prop:"orderIndex",label:"排序",width:"80"}}),e._v(" "),i("el-table-column",{attrs:{prop:"remark",label:"备注",width:"150","show-overflow-tooltip":!0}}),e._v(" "),i("el-table-column",{attrs:{prop:"gmtCreate",label:"创建时间",width:"160"}}),e._v(" "),i("el-table-column",{attrs:{prop:"gmtModified",label:"修改时间",width:"160"}}),e._v(" "),i("el-table-column",{attrs:{label:"操作",fixed:"right",width:"80"},scopedSlots:e._u([{key:"default",fn:function(t){return[i("el-button",{attrs:{type:"text",size:"mini"},on:{click:function(i){return e.onTableUpdate(t.row)}}},[e._v("修改")])]}}])})],1),e._v(" "),i("el-pagination",{staticStyle:{"margin-top":"5px"},attrs:{background:"","current-page":e.searchFormData.pageIndex,"page-size":e.searchFormData.pageSize,"page-sizes":[5,10,20,40],total:e.pageInfo.total,layout:"total, sizes, prev, pager, next"},on:{"size-change":e.onSizeChange,"current-change":e.onPageIndexChange}}),e._v(" "),i("el-dialog",{attrs:{title:e.dlgTitle,visible:e.limitDialogVisible,"close-on-click-modal":!1},on:{"update:visible":function(t){e.limitDialogVisible=t},close:e.onLimitDialogClose}},[i("el-form",{ref:"limitDialogForm",attrs:{model:e.limitDialogFormData,rules:e.rulesLimit,"label-width":"150px",size:"mini"}},[i("el-form-item",{attrs:{label:"限流维度",prop:"typeKey"}},[i("el-checkbox-group",{model:{value:e.limitDialogFormData.typeKey,callback:function(t){e.$set(e.limitDialogFormData,"typeKey",t)},expression:"limitDialogFormData.typeKey"}},[i("el-checkbox",{attrs:{label:1,name:"typeKey"},model:{value:e.limitDialogFormData.typeKey[0],callback:function(t){e.$set(e.limitDialogFormData.typeKey,0,t)},expression:"limitDialogFormData.typeKey[0]"}},[e._v("路由ID")]),e._v(" "),i("el-checkbox",{attrs:{label:2,name:"typeKey"},model:{value:e.limitDialogFormData.typeKey[1],callback:function(t){e.$set(e.limitDialogFormData.typeKey,1,t)},expression:"limitDialogFormData.typeKey[1]"}},[e._v("AppKey")]),e._v(" "),i("el-checkbox",{attrs:{label:3,name:"typeKey"},model:{value:e.limitDialogFormData.typeKey[2],callback:function(t){e.$set(e.limitDialogFormData.typeKey,2,t)},expression:"limitDialogFormData.typeKey[2]"}},[e._v("IP")])],1)],1),e._v(" "),i("el-form-item",{directives:[{name:"show",rawName:"v-show",value:e.checkTypeKey(1),expression:"checkTypeKey(1)"}],attrs:{prop:"routeId",label:"路由ID",rules:e.checkTypeKey(1)?e.rulesLimit.routeId:[]}},[i("el-select",{staticStyle:{width:"300px"},attrs:{filterable:"",placeholder:"可筛选"},model:{value:e.limitDialogFormData.routeId,callback:function(t){e.$set(e.limitDialogFormData,"routeId",t)},expression:"limitDialogFormData.routeId"}},e._l(e.routeList,function(t){return i("el-option",{key:t.id,attrs:{label:t.id,value:t.id}},[i("span",{staticStyle:{float:"left"}},[e._v(e._s(t.name))]),e._v(" "),i("span",{staticStyle:{float:"right",color:"#8492a6","font-size":"13px"}},[e._v(e._s(t.version))])])}),1)],1),e._v(" "),i("el-form-item",{directives:[{name:"show",rawName:"v-show",value:e.checkTypeKey(2),expression:"checkTypeKey(2)"}],attrs:{prop:"appKey",label:"AppKey",rules:e.checkTypeKey(2)?e.rulesLimit.appKey:[]}},[i("el-input",{attrs:{placeholder:"需要限流的appKey"},model:{value:e.limitDialogFormData.appKey,callback:function(t){e.$set(e.limitDialogFormData,"appKey",t)},expression:"limitDialogFormData.appKey"}})],1),e._v(" "),i("el-form-item",{directives:[{name:"show",rawName:"v-show",value:e.checkTypeKey(3),expression:"checkTypeKey(3)"}],attrs:{label:"限流IP",prop:"limitIp",rules:e.checkTypeKey(3)?e.rulesLimit.ip:[]}},[i("el-input",{attrs:{type:"textarea",rows:2,placeholder:"多个用英文逗号隔开"},model:{value:e.limitDialogFormData.limitIp,callback:function(t){e.$set(e.limitDialogFormData,"limitIp",t)},expression:"limitDialogFormData.limitIp"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"限流策略"}},[i("el-radio-group",{model:{value:e.limitDialogFormData.limitType,callback:function(t){e.$set(e.limitDialogFormData,"limitType",t)},expression:"limitDialogFormData.limitType"}},[i("el-radio",{attrs:{label:1}},[e._v("窗口策略")]),e._v(" "),i("el-radio",{attrs:{label:2}},[e._v("令牌桶策略")])],1),e._v(" "),i("i",{staticClass:"el-icon-question limit-tip",on:{click:e.onLimitTypeTipClick}})],1),e._v(" "),i("el-form-item",{attrs:{label:"开启状态"}},[i("el-switch",{attrs:{"active-color":"#13ce66","inactive-color":"#ff4949","active-value":1,"inactive-value":0},model:{value:e.limitDialogFormData.limitStatus,callback:function(t){e.$set(e.limitDialogFormData,"limitStatus",t)},expression:"limitDialogFormData.limitStatus"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"排序",prop:"orderIndex"}},[i("el-input-number",{attrs:{"controls-position":"right",min:0},model:{value:e.limitDialogFormData.orderIndex,callback:function(t){e.$set(e.limitDialogFormData,"orderIndex",t)},expression:"limitDialogFormData.orderIndex"}}),e._v(" "),i("el-tooltip",{staticClass:"item",attrs:{content:"值小优先执行",placement:"top"}},[i("i",{staticClass:"el-icon-question limit-tip"})])],1),e._v(" "),i("el-form-item",{directives:[{name:"show",rawName:"v-show",value:e.isWindowType(),expression:"isWindowType()"}],attrs:{label:"请求数",prop:"execCountPerSecond",rules:e.isWindowType()?e.rulesLimit.execCountPerSecond:[]}},[e._v("\n            每 "),i("el-input-number",{attrs:{"controls-position":"right",min:1},model:{value:e.limitDialogFormData.durationSeconds,callback:function(t){e.$set(e.limitDialogFormData,"durationSeconds",t)},expression:"limitDialogFormData.durationSeconds"}}),e._v(" 秒可处理\n            "),i("el-input-number",{attrs:{"controls-position":"right",min:1},model:{value:e.limitDialogFormData.execCountPerSecond,callback:function(t){e.$set(e.limitDialogFormData,"execCountPerSecond",t)},expression:"limitDialogFormData.execCountPerSecond"}}),e._v(" 个请求\n          ")],1),e._v(" "),i("el-form-item",{directives:[{name:"show",rawName:"v-show",value:e.isWindowType(),expression:"isWindowType()"}],attrs:{label:"错误码",prop:"limitCode",rules:e.isWindowType()?e.rulesLimit.limitCode:[]}},[i("el-input",{model:{value:e.limitDialogFormData.limitCode,callback:function(t){e.$set(e.limitDialogFormData,"limitCode",t)},expression:"limitDialogFormData.limitCode"}})],1),e._v(" "),i("el-form-item",{directives:[{name:"show",rawName:"v-show",value:e.isWindowType(),expression:"isWindowType()"}],attrs:{label:"错误信息",prop:"limitMsg",rules:e.isWindowType()?e.rulesLimit.limitMsg:[]}},[i("el-input",{model:{value:e.limitDialogFormData.limitMsg,callback:function(t){e.$set(e.limitDialogFormData,"limitMsg",t)},expression:"limitDialogFormData.limitMsg"}})],1),e._v(" "),i("el-form-item",{directives:[{name:"show",rawName:"v-show",value:e.isTokenType(),expression:"isTokenType()"}],attrs:{label:"令牌桶容量",prop:"tokenBucketCount",rules:e.isTokenType()?e.rulesLimit.tokenBucketCount:[]}},[i("el-input-number",{attrs:{"controls-position":"right",min:1},model:{value:e.limitDialogFormData.tokenBucketCount,callback:function(t){e.$set(e.limitDialogFormData,"tokenBucketCount",t)},expression:"limitDialogFormData.tokenBucketCount"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"备注",prop:"remark"}},[i("el-input",{attrs:{type:"textarea",rows:2},model:{value:e.limitDialogFormData.remark,callback:function(t){e.$set(e.limitDialogFormData,"remark",t)},expression:"limitDialogFormData.remark"}})],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{on:{click:function(t){e.limitDialogVisible=!1}}},[e._v("取 消")]),e._v(" "),i("el-button",{attrs:{type:"primary"},on:{click:e.onLimitDialogSave}},[e._v("保 存")])],1)],1)],1)],1)],1)},l=[],o=(i("7514"),{data:function(){return{serviceTextLimitSize:20,filterText:"",treeData:[],tableData:[],serviceId:"",searchFormData:{pageIndex:1,pageSize:5},pageInfo:{list:[],total:0},routeList:[],defaultProps:{children:"children",label:"label"},dlgTitle:"设置限流",limitDialogVisible:!1,limitDialogFormData:{id:0,routeId:"",appKey:"",limitIp:"",limitKey:"",execCountPerSecond:5,durationSeconds:1,limitCode:"",limitMsg:"",tokenBucketCount:5,limitStatus:0,limitType:1,orderIndex:0,remark:"",typeKey:[]},rulesLimit:{typeKey:[{type:"array",required:!0,message:"请至少选择一个",trigger:"change"}],routeId:[{required:!0,message:"不能为空",trigger:"blur"},{min:1,max:100,message:"长度在 1 到 100 个字符",trigger:"blur"}],appKey:[{required:!0,message:"不能为空",trigger:"blur"},{min:1,max:100,message:"长度在 1 到 100 个字符",trigger:"blur"}],ip:[{required:!0,message:"不能为空",trigger:"blur"},{min:1,max:500,message:"长度在 1 到 500 个字符",trigger:"blur"}],execCountPerSecond:[{required:!0,message:"不能为空",trigger:"blur"}],limitCode:[{required:!0,message:"不能为空",trigger:"blur"},{min:1,max:64,message:"长度在 1 到 64 个字符",trigger:"blur"}],limitMsg:[{required:!0,message:"不能为空",trigger:"blur"},{min:1,max:100,message:"长度在 1 到 100 个字符",trigger:"blur"}],tokenBucketCount:[{required:!0,message:"不能为空",trigger:"blur"}],orderIndex:[{required:!0,message:"不能为空",trigger:"blur"}],remark:[{max:128,message:"长度不能超过128字符",trigger:"blur"}]}}},watch:{filterText:function(e){this.$refs.tree2.filter(e)}},created:function(){this.loadTree()},methods:{loadTree:function(){this.post("registry.service.list",{},function(e){var t=e.data;this.treeData=this.convertToTreeData(t,0)})},filterNode:function(e,t){return!e||-1!==t.label.indexOf(e)},onNodeClick:function(e,t,i){e.parentId&&(this.serviceId=e.label,this.searchFormData.serviceId=this.serviceId,this.loadTable(),this.loadRouteList(this.serviceId))},convertToTreeData:function(e,t){for(var i=[],a={label:0===e.length?"无服务":"服务列表",parentId:t},l=[],o=0;o<e.length;o++){var r={parentId:1,label:e[o]};l.push(r)}return a.children=l,i.push(a),i},loadTable:function(){this.post("config.limit.list",this.searchFormData,function(e){this.pageInfo=e.data})},loadRouteList:function(e){this.post("route.list/1.2",{serviceId:e},function(e){this.routeList=e.data})},onAdd:function(){this.serviceId?(this.dlgTitle="新增限流",this.limitDialogFormData.id=0,this.limitDialogVisible=!0):this.tip("请选择服务","info")},onSearchTable:function(){this.loadTable()},onTableUpdate:function(e){var t=this;this.dlgTitle="修改限流",this.limitDialogVisible=!0,this.$nextTick(function(){Object.assign(t.limitDialogFormData,e),e.routeId&&t.limitDialogFormData.typeKey.push(1),e.appKey&&t.limitDialogFormData.typeKey.push(2),e.limitIp&&t.limitDialogFormData.typeKey.push(3)})},onLimitDialogClose:function(){this.resetForm("limitDialogForm"),this.limitDialogFormData.limitStatus=0},infoRender:function(e){if(1===e.limitType){var t=e.durationSeconds;return"每 ".concat(t," 秒可处理 ").concat(e.execCountPerSecond," 个请求\n              <br>subCode：").concat(e.limitCode,"\n              <br>subMsg：").concat(e.limitMsg)}if(2===e.limitType)return"令牌桶容量：".concat(e.tokenBucketCount)},onLimitDialogSave:function(){var e=this;this.$refs["limitDialogForm"].validate(function(t){if(t){e.cleanCheckboxData(),e.limitDialogFormData.serviceId=e.serviceId;var i=e.limitDialogFormData.id?"config.limit.update":"config.limit.add";e.post(i,e.limitDialogFormData,function(e){this.limitDialogVisible=!1,this.loadTable()})}})},cleanCheckboxData:function(){this.checkTypeKey(1)||(this.limitDialogFormData.routeId=""),this.checkTypeKey(2)||(this.limitDialogFormData.appKey=""),this.checkTypeKey(3)||(this.limitDialogFormData.limitIp="")},onLimitTypeTipClick:function(){var e="窗口策略：每秒处理固定数量的请求，超出请求数量返回错误信息。",t="令牌桶策略：每秒放置固定数量的令牌数，每个请求进来后先去拿令牌，拿到了令牌才能继续，拿不到则等候令牌重新生成了再拿。",i=e+"<br>"+t;this.$alert(i,"限流策略",{dangerouslyUseHTMLString:!0})},onSizeChange:function(e){this.searchFormData.pageSize=e,this.loadTable()},onPageIndexChange:function(e){this.searchFormData.pageIndex=e,this.loadTable()},checkTypeKey:function(e){return this.limitDialogFormData.typeKey.find(function(t,i,a){return t===e})},isWindowType:function(){return 1===this.limitDialogFormData.limitType},isTokenType:function(){return 2===this.limitDialogFormData.limitType},limitRender:function(e){var t=[],i=[];return e.routeId&&(i.push(e.routeId),t.push("路由ID")),e.appKey&&(i.push(e.appKey),t.push("AppKey")),e.limitIp&&(i.push(e.limitIp),t.push("IP")),i.join(" + ")+"<br>("+t.join(" + ")+")"}}}),r=o,n=(i("fbea"),i("9d06"),i("2877")),s=Object(n["a"])(r,a,l,!1,null,"9527c228",null);t["default"]=s.exports},6886:function(e,t,i){},"6cda":function(e,t,i){},7514:function(e,t,i){"use strict";var a=i("5ca1"),l=i("0a49")(5),o="find",r=!0;o in[]&&Array(1)[o](function(){r=!1}),a(a.P+a.F*r,"Array",{find:function(e){return l(this,e,arguments.length>1?arguments[1]:void 0)}}),i("9c6c")(o)},"9d06":function(e,t,i){"use strict";var a=i("6cda"),l=i.n(a);l.a},cd1c:function(e,t,i){var a=i("e853");e.exports=function(e,t){return new(a(e))(t)}},e853:function(e,t,i){var a=i("d3f4"),l=i("1169"),o=i("2b4c")("species");e.exports=function(e){var t;return l(e)&&(t=e.constructor,"function"!=typeof t||t!==Array&&!l(t.prototype)||(t=void 0),a(t)&&(t=t[o],null===t&&(t=void 0))),void 0===t?Array:t}},fbea:function(e,t,i){"use strict";var a=i("6886"),l=i.n(a);l.a}}]);