package fr.norsys.formation.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.hsqldb.jdbc.JDBCDataSource;

public class ApplicationContext {

	private static JDBCDataSource DATASOURCE;

	private static DataSource getApplicationDataSource() {
		if (DATASOURCE == null) {
			DATASOURCE = new JDBCDataSource();
			DATASOURCE.setUrl("jdbc:hsqldb:file:C:/astalin/WorkspaceTest/TpJdbc/data/DB_TP_JDBC");
		}
		return DATASOURCE;
	}

	public static Connection getConnexion() throws SQLException {
		DataSource ds = getApplicationDataSource();
		return ds.getConnection();
	}

}
