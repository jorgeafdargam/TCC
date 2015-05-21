package model;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.RDFNode;

import virtuoso.jena.driver.VirtGraph;
import virtuoso.jena.driver.VirtuosoQueryExecution;
import virtuoso.jena.driver.VirtuosoQueryExecutionFactory;
import virtuoso.jena.driver.VirtuosoUpdateFactory;
import virtuoso.jena.driver.VirtuosoUpdateRequest;

public class DeleteSPARQL {
	String suj = null;
	String pred = null;
	String obj = null;
	String str = null;
	VirtuosoUpdateRequest vur = null;

	public DeleteSPARQL(String suj, String pred, String obj){
		this.suj = suj;
		this.pred = pred;
		this.obj = obj;
		this.delete();
	}

	public void delete(){
		VirtGraph set = DAOVirtuoso.DAO_Virtuoso();
		//LimpaGrafo.Limpa_Grafo(set);   

		System.out.println("\nexecute: DELETE FROM GRAPH <http://test1> { <aa> <bb> 'cc' }");
		str = "DELETE FROM GRAPH <http://test1> { <aa> <bb> 'cc' }";
		vur = VirtuosoUpdateFactory.create(str, set);
		vur.exec();                  

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
}
