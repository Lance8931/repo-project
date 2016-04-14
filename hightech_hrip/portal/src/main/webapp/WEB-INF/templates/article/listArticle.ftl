<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
</head>
<body>
 <table>
    <tbody>
        <#list list as p>
            <tr id="tr${p_index+1}">
                <td width="4%">
                    <input id="${p_index+1}" type="radio" name="check_box">
                    <span style="display:none;" id="id${p_index+1}">${p.id}</span>
                </td>
                <td id="typeName${p_index+1}" width="48%">${p.title}</td>
                <td id="description${p_index+1}" width="48%">${p.author}</td>
            </tr>
        </#list>
    </tbody>
</table>
</body>
</html>