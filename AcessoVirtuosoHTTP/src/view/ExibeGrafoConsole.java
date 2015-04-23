package view;

import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.RDFNode;

public class ExibeGrafoConsole {

	public static void ExibeConsole(ResultSet results) {
		while (results.hasNext()) {
			QuerySolution rs = results.nextSolution();
			RDFNode s = rs.get("s");
			RDFNode p = rs.get("p");
			RDFNode o = rs.get("o");
			System.out.println(" { " + s + " " + p + " " + o + " . }");
		}
		
	}

}
