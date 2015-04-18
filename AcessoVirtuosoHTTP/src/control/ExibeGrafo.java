package control;

import virtuoso.jena.driver.VirtuosoQueryExecution;
import virtuoso.jena.driver.VirtuosoQueryExecutionFactory;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.RDFNode;

public class ExibeGrafo {
	System.out.println("\nexecute: SELECT * FROM <http://test1> WHERE { ?s ?p ?o }");
	Query sparql = QueryFactory.create("SELECT * FROM <http://test1> WHERE { ?s ?p ?o }");
	VirtuosoQueryExecution vqe = VirtuosoQueryExecutionFactory.create (sparql, set);
	ResultSet results = vqe.execSelect();
	while (results.hasNext()) {
		QuerySolution rs = results.nextSolution();
		RDFNode s = rs.get("s");
		RDFNode p = rs.get("p");
		RDFNode o = rs.get("o");
		System.out.println(" { " + s + " " + p + " " + o + " . }");
	}
}
