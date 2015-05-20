package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import view.ExibeGrafoWeb;
import bean.BeanTripla;
import model.VirtuosoSPARQL;

@WebServlet("/InputServlet")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InputServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BeanTripla bean = new BeanTripla();
		
		bean.setSujeito((String)request.getParameter("sujeito"));
		bean.setPredicado((String)request.getParameter("predicado"));
		bean.setObjeto((String)request.getParameter("objeto"));
		
		HttpSession session = request.getSession();
		System.out.println("O sujeito é: " + bean.getSujeito() + 
				". O predicado é: " + bean.getPredicado() + 
				". O objeto é: " + bean.getObjeto());
		
		VirtuosoSPARQL virt = new VirtuosoSPARQL(bean);
		
		// passa o ResultSet para a classe java que gera a saída
		ExibeGrafoWeb exibe = new ExibeGrafoWeb(virt.getResults(), response);
		
		// passa o ResultSet para o JSP view de saída
		// request.setAttribute("Results", virt.getResults());		
		// RequestDispatcher rd = request.getRequestDispatcher("/exibe.jsp");
		// rd.forward(request,response);
	}
}
