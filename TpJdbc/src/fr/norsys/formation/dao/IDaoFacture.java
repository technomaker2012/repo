package fr.norsys.formation.dao;

import java.sql.SQLException;
import java.util.List;

import fr.norsys.formation.dataobject.DoFacture;

public interface IDaoFacture {

	public List<DoFacture> findAllFacture() throws SQLException;

	public List<DoFacture> findFactureByClient(int clientId) throws SQLException;

	public DoFacture create(int clientId) throws SQLException;

}
