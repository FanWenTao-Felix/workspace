
# 参数类型，枚举
---


<table>
    <tr>
        <th>接口名</th>
        <td>param.type.7</td>
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
        <tr><td>goods_name</td><td class="param-type">string</td><td><strong>是</strong></td><td>iphoneX</td><td>商品名称<br/></td></tr>
        <tr><td>goods_type</td><td class="param-type">string</td><td><strong>是</strong></td><td>FOOD</td><td>商品类型<br/> ELECTRIC：家电, CLOTH：衣服, FOOD：食物</td></tr>
    </table>

**参数示例**

```json
{
	"goods_name":"iphoneX",
	"goods_type":"FOOD"
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
            <td>string</td>
            <td>返回值。示例值：OK</td>
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


