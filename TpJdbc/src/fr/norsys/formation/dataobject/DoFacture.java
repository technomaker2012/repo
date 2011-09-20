package fr.norsys.formation.dataobject;

import java.util.Date;

public class DoFacture {

	private Integer numFacture;
	private Date dateFacture;
	private DoClient client;
	/**
	 * @return the numFacture
	 */
	public Integer getNumFacture() {
		return numFacture;
	}
	/**
	 * @param numFacture the numFacture to set
	 */
	public void setNumFacture(Integer numFacture) {
		this.numFacture = numFacture;
	}
	/**
	 * @return the dateFacture
	 */
	public Date getDateFacture() {
		return dateFacture;
	}
	/**
	 * @param dateFacture the dateFacture to set
	 */
	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}
	/**
	 * @return the client
	 */
	public DoClient getClient() {
		return client;
	}
	/**
	 * @param client the client to set
	 */
	public void setClient(DoClient client) {
		this.client = client;
	}
	
}