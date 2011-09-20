package fr.norsys.formation.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import fr.norsys.formation.dao.IDaoArticle;
import fr.norsys.formation.dao.IDaoClient;
import fr.norsys.formation.dao.IDaoFacture;
import fr.norsys.formation.dao.IDaoProduitFacture;
import fr.norsys.formation.dao.impl.DaoArticleImpl;
import fr.norsys.formation.dao.impl.DaoClientImpl;
import fr.norsys.formation.dao.impl.DaoFactureImpl;
import fr.norsys.formation.dao.impl.DaoProduitFactureImpl;
import fr.norsys.formation.dataobject.DoArticle;
import fr.norsys.formation.dataobject.DoClient;
import fr.norsys.formation.dataobject.DoFacture;
import fr.norsys.formation.dataobject.DoProduitFacture;
import fr.norsys.formation.util.ApplicationContext;

public class MagasinService {

	public List<DoArticle> getListArticle() throws SQLException {
		Connection conn = ApplicationContext.getConnexion();
		IDaoArticle daoArticle = new DaoArticleImpl(conn);
		List<DoArticle> articles = daoArticle.findAllArticle();
		conn.close();
		return articles;
	}

	public List<DoFacture> getListFacture() throws SQLException {
		Connection conn = ApplicationContext.getConnexion();
		IDaoFacture daoFacture = new DaoFactureImpl(conn);
		List<DoFacture> factures = daoFacture.findAllFacture();
		conn.close();
		return factures;
	}

	public List<DoClient> getListClient() throws SQLException {
		Connection conn = ApplicationContext.getConnexion();
		IDaoClient daoClient = new DaoClientImpl(conn);
		List<DoClient> clients = daoClient.findAllClient();
		conn.close();
		return clients;
	}

	public DoFacture createFactureClient(int clientId) throws SQLException {
		Connection conn = ApplicationContext.getConnexion();
		IDaoFacture daoFacture = new DaoFactureImpl(conn);
		DoFacture facture = daoFacture.create(clientId);
		conn.close();
		return facture;
	}

	public void ajouterProduitFacture(DoFacture facture, int idArticle,
			int nombre) throws SQLException {
		Connection conn = ApplicationContext.getConnexion();

		DoArticle article = new DoArticle();
		article.setIdArticle(idArticle);

		DoProduitFacture produitFacture = new DoProduitFacture();
		produitFacture.setArticle(article);
		produitFacture.setFacture(facture);
		produitFacture.setNombre(nombre);

		IDaoProduitFacture daoProduitFacture = new DaoProduitFactureImpl(conn);
		daoProduitFacture.create(produitFacture);
		conn.close();
	}

}
