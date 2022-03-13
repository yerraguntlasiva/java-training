package jee.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Welcome
 */
@WebServlet(
		urlPatterns = "/Welcome",
				initParams = {
		                @WebInitParam(name = "location", value = "D:/Uploads"),
		                @WebInitParam(name = "maxUploadSize", value = "9900000")
		               
		        }
				
		)

public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Welcome() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("Welcome cons");
    }

	

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		ServletConfig sfg=super.getServletConfig();
		sfg.getServletContext().setAttribute("contextAt1", "contextValue1");
		return  sfg;
	}

	@Override
	public ServletContext getServletContext() {
		// TODO Auto-generated method stub
		//super.getServletContext().
		System.out.println("getServletContext");
		return super.getServletContext();
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		System.out.println("getServletInfo");
		return super.getServletInfo();
		
	}

	

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stubs
		System.out.println("config : "+config.getInitParameter("location"));
		super.init(config);
		
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Service is called");
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		System.out.println("user name : "+userName);
		System.out.println("password : "+password);
		RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
		PrintWriter out=response.getWriter();
		//out.print("Welcome  "+userName);	
		Enumeration em= getServletConfig().getInitParameterNames();
		while(em.hasMoreElements()) {
			System.out.println("Init Parameter "+getServletConfig().getInitParameter((String) em.nextElement()));
		}
		Enumeration em2=getServletConfig().getServletContext().getAttributeNames();
		//while(em2.hasMoreElements()) {
			//System.out.println("context Parameter "+getServletConfig().getServletContext().getAttribute((String) em2.nextElement()));
		//}
		Cookie ck=new Cookie("userName1", userName);
		Cookie ck2=new Cookie("password1", password);
		response.addCookie(ck);
		response.addCookie(ck2);
		rd.forward(request, response);
	}



	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("destory is called");
	}
	

}
