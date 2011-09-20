package fr.norsys.formation.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import fr.norsys.formation.dao.IDaoFacture;
import fr.norsys.formation.dataobject.DoFacture;

public class DaoFactureImpl implements IDaoFacture {

	private Connection conn;
	private String createQuery = "INSERT INTO FACTURE( NUM_FACTURE, DATE_FACTURE, ID_CLIENT ) VALUES (?, ?, ?)";
	private String findAllQuery = "SELECT NUM_FACTURE, DATE_FACTURE FROM FACTURE ";
	private String byClientQuery = "WHERE ID_CLIENT ? ";
	private String nextValSequenceQuery = "call NEXT VALUE FOR facture_sequence";

	public DaoFactureImpl(Connection connexion) {
		this.conn = connexion;
	}

	@Override
	public List<DoFacture> findAllFacture() throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(findAllQuery);
		ResultSet rs = stmt.executeQuery();
		List<DoFacture> factureList = mapResultSetToDoFacture(rs);
		stmt.close();
		return factureList;
	}

	@Override
	public List<DoFacture> findFactureByClient(int clientId)
			throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(findAllQuery
				+ byClientQuery);
		stmt.setInt(1, clientId);
		ResultSet rs = stmt.executeQuery();
		List<DoFacture> factureList = mapResultSetToDoFacture(rs);
		stmt.close();
		return factureList;
	}

	@Override
	public DoFacture create(int clientId) throws SQLException {

		PreparedStatement seqStmt = conn.prepareStatement(nextValSequenceQuery);
		ResultSet rs = seqStmt.executeQuery();
		rs.next();

		DoFacture facture = new DoFacture();
		facture.setNumFacture(rs.getInt(1));
		facture.setDateFacture(Calendar.getInstance().getTime());
		seqStmt.close();

		PreparedStatement stmt = conn.prepareStatement(createQuery);
		stmt.setInt(1, facture.getNumFacture());
		stmt.setDate(2, new Date(facture.getDateFacture().getTime()));
		stmt.setInt(3, clientId);
		stmt.executeUpdate();
		stmt.close();

		return facture;
	}

	private List<DoFacture> mapResultSetToDoFacture(ResultSet rs)
			throws SQLException {
		List<DoFacture> factureList = new ArrayList<DoFacture>();
		while (rs.next()) {
			DoFacture facture = new DoFacture();
			facture.setDateFacture(rs.getDate("DATE_FACTURE"));
			facture.setNumFacture(rs.getInt("NUM_FACTURE"));
			factureList.add(facture);
		}

		return factureList;
	}

}
