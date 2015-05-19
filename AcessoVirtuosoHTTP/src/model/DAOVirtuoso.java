package model;

import virtuoso.jena.driver.VirtGraph;

public class DAOVirtuoso {
	
	public static VirtGraph DAO_Virtuoso(){
		VirtGraph set = new VirtGraph ("jdbc:virtuoso://localhost:1111", "dba", "jorge140");
		return set;
	}
}
