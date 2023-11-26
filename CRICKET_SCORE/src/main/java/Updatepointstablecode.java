

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Updatepointstablecode
 */
@WebServlet("/Updatepointstablecode")
public class Updatepointstablecode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updatepointstablecode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String team1=request.getParameter("team1");
		String team2=request.getParameter("team2");
		
		int team1tscore=Integer.parseInt(request.getParameter("team1totalscore"));
		int team2tscore=Integer.parseInt(request.getParameter("team2totalscore"));
		
		double team1overs=Double.parseDouble(request.getParameter("team1totalovers"));
		double team2overs=Double.parseDouble(request.getParameter("team2totalovers"));
		
		int t1matches=0,t1win=0,t1lost=0,t1points=0;
		int t2matches=0,t2win=0,t2lost=0,t2points=0;
		double t1nrr=0.0,t2nrr=0.0;
		
	
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe","nagaraju","welcome");
			
			
            PreparedStatement ps1=con.prepareStatement("select * from pointstable where teams=?");
            
            ps1.setString(1, team1);
            
            ResultSet rs1=ps1.executeQuery();
            
            
            PreparedStatement ps2=con.prepareStatement("select * from pointstable where teams=?");
            
            ps2.setString(1, team2);
            
            ResultSet rs2=ps2.executeQuery();
            
            if(rs1.next() && rs2.next()) {
            	t1matches=Integer.parseInt(rs1.getString(2));
            	t2matches=Integer.parseInt(rs2.getString(2));
            	
            	t1win=Integer.parseInt(rs1.getString(3));
            	t2win=Integer.parseInt(rs2.getString(3));
            	
            	t1lost=Integer.parseInt(rs1.getString(4));
            	t2lost=Integer.parseInt(rs2.getString(4));
            	
            	t1points=Integer.parseInt(rs1.getString(5));
            	t2points=Integer.parseInt(rs2.getString(5));
            	
            	t1nrr=Double.parseDouble(rs1.getString(6));
            	t1nrr=Double.parseDouble(rs2.getString(6));
            }else {
            	out.print("invalid details");
            }
            
            t1matches++;
        	t2matches++;
        	
            if(request.getParameter("win").equals("team1")) {
            	
            	t1win++;
            	t2lost++;
            	t1points+=2;
            	
            }else {
            	
            	t2win++;
            	t1lost++;
            	t2points+=2;
            	
            }
            t1nrr+=((team1tscore/team1overs)-(team2tscore/team2overs))/12;
            t2nrr+=((team2tscore/team2overs)-(team1tscore/team1overs))/12;
            
            out.println("team1"+t1matches+" "+t1win+" "+t1lost+" "+t1points+" "+t1nrr);
            out.println("team1"+t1matches+" "+t1win+" "+t1lost+" "+t1points+" "+t1nrr);
            
PreparedStatement ps3=con.prepareStatement("update pointstable set matches=?, won=?, lost=?, points=?, nrr=? where teams=?");
            ps3.setInt(1, t1matches);
            ps3.setInt(2, t1win);
            ps3.setInt(3, t1lost);
            ps3.setInt(4, t1points);
            ps3.setDouble(5, t1nrr);
            ps3.setString(6, team1);
            
            int i=ps3.executeUpdate();
            
            PreparedStatement ps4=con.prepareStatement("update pointstable set matches=?, won=?, lost=?, points=?, nrr=? where teams=?");
            ps4.setInt(1, t2matches);
            ps4.setInt(2, t2win);
            ps4.setInt(3, t2lost);
            ps4.setInt(4, t2points);
            ps4.setDouble(5, t2nrr);
            ps4.setString(6, team2);
            
            int j=ps4.executeUpdate();
            if(i==1 && j==1) {
            	out.print("pointstable update successfully");
            }else {
            	out.print("pointstable update failed");
            }
            
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
