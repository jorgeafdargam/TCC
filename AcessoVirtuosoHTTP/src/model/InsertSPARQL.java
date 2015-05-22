
package model;

import bean.BeanTripla;

import com.hp.hpl.jena.query.*;

import view.ExibeGrafoConsole;
import virtuoso.jena.driver.*;

public class InsertSPARQL {
	
	public InsertSPARQL(BeanTripla bean, VirtGraph dao) {
		String str = null;
		VirtuosoUpdateRequest vur = null;
 
		System.out.println("\nexecute: INSERT INTO GRAPH <http://test1> { Sujeito: " + bean.getSujeito() 
				+ ". Predicado: " + bean.getPredicado() 
				+ ". Objeto: " + bean.getObjeto() + " }");
		str = "INSERT INTO GRAPH <http://test1> { <" + bean.getSujeito() + "> <" + bean.getPredicado() + "> '" + bean.getObjeto() + "' . }";
		vur = VirtuosoUpdateFactory.create(str, dao);
		vur.exec();       
	}
}
