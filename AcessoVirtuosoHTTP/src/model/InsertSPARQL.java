
package model;

import bean.BeanTripla;

import com.hp.hpl.jena.query.*;

import view.ExibeGrafoConsole;
import virtuoso.jena.driver.*;

public class InsertSPARQL {
	private ResultSet results;
	
	public InsertSPARQL(BeanTripla bean, VirtGraph dao) {
		String str = null;
		VirtuosoUpdateRequest vur = null;

		// VirtGraph set = DAOVirtuoso.DAO_Virtuoso();
		// LimpaGrafo.Limpa_Grafo(set);            
 
		System.out.println("\nexecute: INSERT INTO GRAPH <http://test1> { Sujeito: " + bean.getSujeito() 
				+ ". Predicado: " + bean.getPredicado() 
				+ ". Objeto: " + bean.getObjeto() + " }");
		str = "INSERT INTO GRAPH <http://test1> { <" + bean.getSujeito() + "> <" + bean.getPredicado() + "> '" + bean.getObjeto() + "' . }";
		vur = VirtuosoUpdateFactory.create(str, dao);
		vur.exec();                  

		/*			STEP 3			*/
		/*		Select all data in virtuoso	*/
		
		SelectSPARQL grafo = new SelectSPARQL();
		this.results = grafo.getResults();
		ExibeGrafoConsole.ExibeConsole(results);

/*
		System.out.println("\nexecute: DELETE FROM GRAPH <http://test1> { <aa> <bb> 'cc' }");
		str = "DELETE FROM GRAPH <http://test1> { <aa> <bb> 'cc' }";
		vur = VirtuosoUpdateFactory.create(str, set);
		vur.exec();                  

		System.out.println("\nexecute: SELECT * FROM <http://test1> WHERE { ?s ?p ?o }");
		vqe = VirtuosoQueryExecutionFactory.create (sparql, set);
		results = vqe.execSelect();
		while (results.hasNext()) {
			QuerySolution rs = results.nextSolution();
			RDFNode s = rs.get("s");
			RDFNode p = rs.get("p");
			RDFNode o = rs.get("o");
			System.out.println(" { " + s + " " + p + " " + o + " . }");
		}

*/
	}

	public ResultSet getResults() {
		return results;
	}
}
