package fr.norsys.formation.dao;

import java.sql.SQLException;
import java.util.List;

import fr.norsys.formation.dataobject.DoArticle;

public interface IDaoArticle {

	public List<DoArticle> findAllArticle() throws SQLException;
}
