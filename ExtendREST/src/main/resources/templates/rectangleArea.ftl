<#include "head.ftl">
<h1>rectangleArea 资源</h1>
<br>
<b>资源描述:</b> 面积量算结果资源，用于描述一个面积量算的结果。
<br>
<#if resource.content.area!= -1>
 <p>
         <table width="150px" id="userTable">
                <tr valign="left">
                <#setting number_format="#0.000000000#">
                <td style="width:50px"> <h5>area:</h5></td> <td style="width:50px"> ${resource.content.area}</td>
                </tr>
                <tr valign="left">
                <td style="width:50px"> <h5 >unit:</h5></td> <td style="width:50px">${resource.content.unit}</td>
                </tr>
         </table>
 </p>
<#else>
 <br><br>
    请设置 rect2D 参数。 没有设置 rect2D 参数，则结果返回-1 表示量算失败。
</#if>
<p>
<form method="get" >
        <table style="border:1px solid #000000;width:800;" >
           <#assign prerect2D>{leftBottom:{x:23,y:34},rightTop:{x:40,y:50}}</#assign>
            <tr><td>rect2D</td><td><textarea type="text" style="width:255px;height:50px" name="rect2D" >${prerect2D}</textarea></td></tr>
            <tr>
                <td>unit</td>
                <td>
                    <select name="unit">
                                <option value="METER" selected="selected">METER</option>
                                <option value="KILOMETER" selected="selected">KILOMETER</option>
                        </select>
                        </td>
                </tr>
            <tr><td></td><td><input type="submit" value="rect2DareaMeasure"/></td></tr>
        </table>
</form>
</p>
<br>
<br>
<hr>
<#include "tail.ftl">

