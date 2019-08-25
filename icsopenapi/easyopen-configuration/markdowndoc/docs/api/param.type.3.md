
# 参数类型，Map接收
---


<table>
    <tr>
        <th>接口名</th>
        <td>param.type.3</td>
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
        <tr><td>id</td><td class="param-type">integer</td><td>否</td><td>1</td><td><br/></td></tr>
        <tr><td>goodsName</td><td class="param-type">string</td><td>否</td><td>iPhone6</td><td>商品名称<br/></td></tr>
    </table>

**参数示例**

```json
{
	"id":"1",
	"goodsName":"iPhone6"
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
                            </table>
        </td>
    </tr>
    </table>

**返回示例**

```json
{
	"code":"0",
	"data":{},
	"msg":""
}
```

