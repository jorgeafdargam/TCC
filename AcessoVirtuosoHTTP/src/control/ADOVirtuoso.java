package control;

import virtuoso.jena.driver.VirtGraph;

public class ADOVirtuoso {
	
	public static VirtGraph ADO_Virtuoso(){
		VirtGraph set = new VirtGraph ("jdbc:virtuoso://localhost:1111", "dba", "jorge140");
		return set;
	}
}
