/*
 *  $Id: VirtuosoSPARQLExample8.java,v 1.2 2008/06/19 07:39:35 source Exp $
 *
 *  This file is part of the OpenLink Software Virtuoso Open-Source (VOS)
 *  project.
 *
 *  Copyright (C) 1998-2008 OpenLink Software
 *
 *  This project is free software; you can redistribute it and/or modify it
 *  under the terms of the GNU General Public License as published by the
 *  Free Software Foundation; only version 2 of the License, dated June 1991.
 *
 *  This program is distributed in the hope that it will be useful, but
 *  WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 *  General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along
 *  with this program; if not, write to the Free Software Foundation, Inc.,
 *  51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 *
 */

package model;

import com.hp.hpl.jena.query.*;
import com.hp.hpl.jena.rdf.model.RDFNode;

import control.DAOVirtuoso;
import control.ExibeGrafo;
import control.LimpaGrafo;
import view.ExibeGrafoConsole;
import virtuoso.jena.driver.*;

public class VirtuosoSPARQL {
	
	public VirtuosoSPARQL(String sujeito, String predicado, String objeto) {
		String suj = sujeito;
		String pred = predicado;
		String obj = objeto;
		String str = null;
		VirtuosoUpdateRequest vur = null;

		VirtGraph set = DAOVirtuoso.DAO_Virtuoso();
		LimpaGrafo.Limpa_Grafo(set);            
 
		System.out.println("\nexecute: INSERT INTO GRAPH <http://test1> { Sujeito: " + suj 
				+ ". Predicado: " + pred 
				+ ". Objeto: " + obj + " }");
		str = "INSERT INTO GRAPH <http://test1> { <" + suj + "> <" + pred + "> '" + obj + "' . }";
		vur = VirtuosoUpdateFactory.create(str, set);
		vur.exec();                  

		/*			STEP 3			*/
		/*		Select all data in virtuoso	*/
		
		ExibeGrafo grafo = new ExibeGrafo();
		ResultSet results = grafo.getResults();
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
}
