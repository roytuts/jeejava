<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<title>Struts2, Spring3 and Hibernate3 Integration Example</title>
<h2>List of Cds</h2>
<s:if test="cds.size() > 0">
	<s:iterator value="cds"></s:iterator>
	<table cellpadding="5px" border="1px">
		<tbody>
			<tr>
				<th>CD Id</th>
				<th>Title</th>
				<th>Interpret</th>
			</tr>
			<tr>
				<td><s:property value="id"></s:property></td>
				<td><s:property value="titel"></s:property></td>
				<td><s:property value="interpret"></s:property></td>
			</tr>
		</tbody>
	</table>
</s:if>
<s:else>
No CD found!
</s:else>