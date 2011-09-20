package fr.norsys.formation.dao;

import java.sql.SQLException;
import java.util.List;

import fr.norsys.formation.dataobject.DoClient;

public interface IDaoClient {

	public List<DoClient> findAllClient() throws SQLException;

	public void update(DoClient client) throws SQLException;
}
