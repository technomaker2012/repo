package fr.norsys.formation.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.norsys.formation.dao.IDaoProduitFacture;
import fr.norsys.formation.dataobject.DoArticle;
import fr.norsys.formation.dataobject.DoFacture;
import fr.norsys.formation.dataobject.DoProduitFacture;

public class DaoProduitFactureImpl implements IDaoProduitFacture {

	private Connection conn;
	private String createQuery = "INSERT INTO PRODUIT_FACTURE( NUM_FACTURE, ID_ARTICLE, NOMBRE ) VALUES (?, ?, ?)";
	private String findAllQuery = "SELECT NUM_FACTURE, ID_ARTICLE, NOMBRE FROM PRODUIT_FACTURE WHERE NUM_FACTURE = ? ";

	public DaoProduitFactureImpl(Connection connexion) {
		this.conn = connexion;
	}

	@Override
	public List<DoProduitFacture> findAllProduitFacture(int numFacture)
			throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(findAllQuery);
		stmt.setInt(1, numFacture);
		ResultSet rs = stmt.executeQuery();
		List<DoProduitFacture> factureList = mapResultSetToDoProduitFacture(rs);
		stmt.close();
		return factureList;
	}

	@Override
	public void create(DoProduitFacture produitFacture) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(createQuery);
		stmt.setInt(1, produitFacture.getFacture().getNumFacture());
		stmt.setInt(2, produitFacture.getArticle().getIdArticle());
		stmt.setInt(3, produitFacture.getNombre());
		stmt.executeUpdate();
		stmt.close();
	}

	private List<DoProduitFacture> mapResultSetToDoProduitFacture(ResultSet rs)
			throws SQLException {
		List<DoProduitFacture> produitFactureList = new ArrayList<DoProduitFacture>();
		while (rs.next()) {

			DoFacture facture = new DoFacture();
			facture.setNumFacture(rs.getInt("NUM_FACTURE"));

			DoArticle article = new DoArticle();
			article.setIdArticle(rs.getInt("ID_ARTICLE"));

			DoProduitFacture produitFacture = new DoProduitFacture();
			produitFacture.setFacture(facture);
			produitFacture.setArticle(article);
			produitFacture.setNombre(rs.getInt("NOMBRE"));
			produitFactureList.add(produitFacture);
		}

		return produitFactureList;
	}

}
