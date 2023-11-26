<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<form action="Updatepointstablecode" method="post">

   TEAMS : <select name="team1">
    
      <option value="IND">india</option>
              <option value="PAK">pakistan</option>
              <option value="NZ">new zealand</option>
              <option value="SA">south africa</option>
              <option value="ENG">england</option>
              <option value="BAN">bangldesh</option>
              <option value="SL">sri lanka</option>
              <option value="AFG">afghnistan</option>
              <option value="NED">netherlands</option>
              <option value="AUS">australia</option>          
      </select>
      
      <h2>VS</h2>
      
      <select name="team2">
    
      <option value="IND">india</option>
              <option value="PAK">pakistan</option>
              <option value="NZ">new zealand</option>
              <option value="SA">south africa</option>
              <option value="ENG">england</option>
              <option value="BAN">bangldesh</option>
              <option value="SL">sri lanka</option>
              <option value="AFG">afghnistan</option>
              <option value="NED">netherlands</option>
              <option value="AUS">australia</option>           
      </select><br><br>
      
     TEAM1 Total Score :  <input type="text" name="team1totalscore"><br><br>
     TEAM2 Total Score :  <input type="text" name="team2totalscore">
     
     <br><br>
      
     TEAM1 Facing Overs :  <input type="text" name="team1totalovers"><br><br>
     TEAM2 Facing Overs :  <input type="text" name="team2totalovers"><br><br>
     
     
     WIN : <select name="win">
    
      <option value="team1">team1</option>
      <option value="team2">team2</option>
                  
      </select><br><br>
      
      <input type="submit" value="update points table">

</form>

<form action="showpointstbale.jsp">
<input type="submit" value="showpointstable">
</form>

</body>
</html>