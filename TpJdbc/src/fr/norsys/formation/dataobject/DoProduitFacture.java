package fr.norsys.formation.dataobject;

public class DoProduitFacture {

	private DoFacture facture;
	private DoArticle article;
	private int nombre;
	
	/**
	 * @return the facture
	 */
	public DoFacture getFacture() {
		return facture;
	}
	/**
	 * @param facture the facture to set
	 */
	public void setFacture(DoFacture facture) {
		this.facture = facture;
	}
	/**
	 * @return the article
	 */
	public DoArticle getArticle() {
		return article;
	}
	/**
	 * @param article the article to set
	 */
	public void setArticle(DoArticle article) {
		this.article = article;
	}
	/**
	 * @return the nombre
	 */
	public int getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
}
