<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
      table,
      table td {
        border: 1px solid #cccccc;
      }
      td {
        height: 45px;
        width: 140px;
        text-align: center;
        vertical-align: middle;
      }
     
    </style>
</head>
<body>


<%@ page import="java.sql.*" %>

<% 

try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe","nagaraju","welcome");
	
	
	out.print("<center><h1><b>POINTS TABLE</b></h1></center>");
	
    PreparedStatement ps1=con.prepareStatement("select * from pointstable order by points desc,nrr desc");
    
    ResultSet rs=ps1.executeQuery();
    
    ResultSetMetaData rsmd=rs.getMetaData();
    out.print("<center>");
    out.print("<table border='1'>");
    out.print("<tr bgcolor='Lightgreen'>");
	for(int i=1;i<=6;i++){
		out.print("<th>"+rsmd.getColumnName(i)+"</th>");
	}
	out.print("</tr>");
    while(rs.next()){
    	out.print("<tr>");
    	for(int i=1;i<=6;i++){
    		if(i==1){
    			out.print("<td><a href=' '><b>"+rs.getString(i)+"</b></a></td>");
    		}else{
    			out.print("<td>"+rs.getString(i)+"</td>");
    		}
    	}
    	out.print("</tr>");
    }
    out.print("</table>");
    out.print("</center>");
    
}
catch(Exception e) {
	out.println(e);
}

  %>

</body>
</html>