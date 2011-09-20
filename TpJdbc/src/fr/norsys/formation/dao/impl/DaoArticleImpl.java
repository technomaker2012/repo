package fr.norsys.formation.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.norsys.formation.dao.IDaoArticle;
import fr.norsys.formation.dataobject.DoArticle;

public class DaoArticleImpl implements IDaoArticle {

	private Connection conn;
	private String findAllQuery = "SELECT ID_ARTICLE, NOM, PRIX FROM ARTICLE ";

	public DaoArticleImpl(Connection connexion) {
		this.conn = connexion;
	}

	@Override
	public List<DoArticle> findAllArticle() throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(findAllQuery);
		ResultSet rs = stmt.executeQuery();
		List<DoArticle> articleList = mapResultSetToDoArticle(rs);
		stmt.close();
		return articleList;
	}

	private List<DoArticle> mapResultSetToDoArticle(ResultSet rs)
			throws SQLException {
		List<DoArticle> articleList = new ArrayList<DoArticle>();
		while (rs.next()) {
			DoArticle article = new DoArticle();
			article.setIdArticle(rs.getInt("ID_ARTICLE"));
			article.setNom(rs.getString("NOM"));
			article.setPrix(rs.getDouble("PRIX"));
			articleList.add(article);
		}

		return articleList;
	}

}
