package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.RDFNode;

public class ExibeGrafoWeb extends HttpServlet{

	public ExibeGrafoWeb (ResultSet results, HttpServletResponse response) throws IOException, ServletException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head><title>Resultado do Sistema de Busca Semântica</title></head>");
		out.println("<body>");
		out.println("<h2>Sistema de Busca Semântica</h2><br/>");

		while (results.hasNext()) {
			QuerySolution rs = results.nextSolution();
			RDFNode s = rs.get("s");
			out.println("Sujeito: " + s + "<br/>"); 
			RDFNode p = rs.get("p");
			out.println("Predicado: " + p + "<br/>");
			RDFNode o = rs.get("o");
			out.println("Objeto: " + o + "<br/>"); 
		}
		
		out.println("</body></html>");
		out.close();
	}

}
