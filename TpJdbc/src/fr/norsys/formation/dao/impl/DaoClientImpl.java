package fr.norsys.formation.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.norsys.formation.dao.IDaoClient;
import fr.norsys.formation.dataobject.DoClient;

public class DaoClientImpl implements IDaoClient {

	private Connection conn;
	private String updateQuery = "UPDATE CLIENT SET NOM=?, PRENOM=? WHERE ID_CLIENT=?";
	private String findAllQuery = "SELECT ID_CLIENT, NOM, PRENOM FROM CLIENT ";

	public DaoClientImpl(Connection connexion) {
		this.conn = connexion;
	}

	@Override
	public List<DoClient> findAllClient() throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(findAllQuery);
		ResultSet rs = stmt.executeQuery();
		List<DoClient> clientList = mapResultSetToDoClient(rs);
		stmt.close();
		return clientList;
	}

	@Override
	public void update(DoClient client) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(updateQuery);
		stmt.setString(1, client.getNom());
		stmt.setString(2, client.getPrenom());
		stmt.setInt(3, client.getIdClient());
		stmt.executeUpdate();
	}

	private List<DoClient> mapResultSetToDoClient(ResultSet rs)
			throws SQLException {
		List<DoClient> clientList = new ArrayList<DoClient>();
		while (rs.next()) {
			DoClient client = new DoClient();
			client.setIdClient(rs.getInt("ID_CLIENT"));
			client.setNom(rs.getString("NOM"));
			client.setPrenom(rs.getString("PRENOM"));
			clientList.add(client);
		}

		return clientList;
	}

}
