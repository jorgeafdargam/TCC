package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.VirtuosoSPARQL;

@WebServlet("/InputServlet")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String sujeito;
	private String predicado;
	private String objeto;

	public InputServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.sujeito = (String)request.getParameter("sujeito");
		this.predicado = (String)request.getParameter("predicado");
		this.objeto = (String)request.getParameter("objeto");
		HttpSession session = request.getSession();
		System.out.println("O sujeito é: " + sujeito + 
				". O predicado é: " + predicado + 
				". O objeto é: " + objeto);
		
		VirtuosoSPARQL virt = new VirtuosoSPARQL(this.sujeito, this.predicado, this.objeto);
	}
}
