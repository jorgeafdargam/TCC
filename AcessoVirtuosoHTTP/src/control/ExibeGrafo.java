package control;

import virtuoso.jena.driver.VirtGraph;
import virtuoso.jena.driver.VirtuosoQueryExecution;
import virtuoso.jena.driver.VirtuosoQueryExecutionFactory;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSet;

public class ExibeGrafo {
	ResultSet results = null;
	
	public ExibeGrafo(){
		this.exibe();
	}

	public void exibe(){
		VirtGraph set = DAOVirtuoso.DAO_Virtuoso();
		System.out.println("\nexecute: SELECT * FROM <http://test1> WHERE { ?s ?p ?o }");
		Query sparql = QueryFactory.create("SELECT * FROM <http://test1> WHERE { ?s ?p ?o }");
		VirtuosoQueryExecution vqe = VirtuosoQueryExecutionFactory.create (sparql, set);
		results = vqe.execSelect();
	}

	public ResultSet getResults() {
		return results;
	}

}
