package fr.norsys.formation.dao;

import java.sql.SQLException;
import java.util.List;

import fr.norsys.formation.dataobject.DoProduitFacture;

public interface IDaoProduitFacture {

	public List<DoProduitFacture> findAllProduitFacture(int numFacture)
			throws SQLException;

	public void create(DoProduitFacture produitFacture) throws SQLException;

}
