package model;

import virtuoso.jena.driver.VirtGraph;
import virtuoso.jena.driver.VirtuosoUpdateFactory;
import virtuoso.jena.driver.VirtuosoUpdateRequest;

public class LimpaGrafo {
	
	public static void Limpa_Grafo(VirtGraph dao){
		System.out.println("\nexecute: CLEAR GRAPH <http://test1>");
		String str = "CLEAR GRAPH <http://test1>";
		VirtuosoUpdateRequest vur = VirtuosoUpdateFactory.create(str, dao);
		vur.exec();   
	}
	
}
