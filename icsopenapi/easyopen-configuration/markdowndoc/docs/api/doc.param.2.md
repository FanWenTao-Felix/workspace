
# 参数方式2,继承
---

指定参数类Demo2Param，Demo2Param继承GoodsParam内容

<table>
    <tr>
        <th>接口名</th>
        <td>doc.param.2</td>
        <th>版本号</th>
        <td></td>
    </tr>
</table>

**请求参数**

<table>
    <tr>
        <th>名称</th>
        <th>类型</th>
        <th>是否必须</th>
        <th>示例值</th>
        <th>描述</th>
    </tr>
        <tr><td>idList</td><td class="param-type">array</td><td>否</td><td></td><td>id列表<br/></td></tr>
        <tr><td>time</td><td class="param-type">datetime</td><td>否</td><td></td><td>时间<br/></td></tr>
        <tr><td>goods_name</td><td class="param-type">string</td><td><strong>是</strong></td><td>iphoneX</td><td>商品名称<br/></td></tr>
    </table>

**参数示例**

```json
{
	"goods_name":"iphoneX",
	"idList":[],
	"time":""
}
```

**返回结果**

<table>
    <tr>
        <th>名称</th>
        <th>类型</th>
        <th>描述</th>
    </tr>
    <tr>
        <td>code</td>
        <td>string</td>
        <td>状态值，"0"表示成功，其它都是失败</td>
    </tr>
    <tr>
        <td>msg</td>
        <td>string</td>
        <td>错误信息，出错时显示</td>
    </tr>
        <tr>
        <td>data</td>
        <td>object</td>
        <td>返回的数据，没有则返回{}
            <table>
                <tr>
                    <th>名称</th>
                    <th>类型</th>
                    <th>示例值</th>
                    <th>描述</th>
                </tr>
                                <tr><td>id</td><td>long</td><td></td><td>id<br/></td></tr>
                                <tr><td>goods_name</td><td>string</td><td></td><td>商品名称<br/></td></tr>
                                <tr><td>price</td><td>float</td><td></td><td>价格<br/></td></tr>
                            </table>
        </td>
    </tr>
    </table>

**返回示例**

```json
{
	"code":"0",
	"data":{
		"goods_name":"",
		"price":"",
		"id":""
	},
	"msg":""
}
```


