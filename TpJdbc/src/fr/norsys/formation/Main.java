package fr.norsys.formation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import fr.norsys.formation.dataobject.DoArticle;
import fr.norsys.formation.dataobject.DoClient;
import fr.norsys.formation.dataobject.DoFacture;
import fr.norsys.formation.service.MagasinService;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MagasinService service = new MagasinService();

		try {
			InputStreamReader converter = new InputStreamReader(System.in);
			BufferedReader in = new BufferedReader(converter);

			boolean quitter = false;
			while (!quitter) {

				displayMenu();

				String option = in.readLine();
				System.out.println("\n");

				if ("1".equals(option)) {
					listerArticle(service);
				} else if ("2".equals(option)) {
					listerFacture(service);
				} else if ("3".equals(option)) {
					choisirClient(service, in);
				} else {
					quitter = true;
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void choisirClient(MagasinService service, BufferedReader in) throws Exception {
		List<DoClient> clients = service.getListClient();

		System.out.println("Les clients existants sont :");
		for (DoClient doClient: clients) {
			System.out.println("\t" + doClient.getIdClient() + " - "
					+ doClient.getNom()+" "+doClient.getPrenom());
		}
		System.out.print("? :");
		String idClient = in.readLine();
		System.out.println("\n");
		
		DoFacture facture = service.createFactureClient(Integer.parseInt(idClient));
		System.out.println("La facture "+facture.getNumFacture()+" a été crée.");
		System.out.println("\n");
		
		boolean fin = false;
		while(!fin){
			System.out.print("Ajouter un article ?(N pour arrêter):");
			String idArticle = in.readLine();
			if("n".equals(idArticle.toLowerCase())){
				fin = true;
			}else {
				System.out.print("combien ? :");
				String nombre = in.readLine();
				service.ajouterProduitFacture(facture, Integer.parseInt(idArticle), Integer.parseInt(nombre));
			}
		}
		
		//...
	}

	private static void listerFacture(MagasinService service) throws SQLException {
		List<DoFacture> factures = service.getListFacture();

		System.out.println("Les factures sont :");
		for (DoFacture doFacture: factures) {
			System.out.println("\t" + doFacture.getNumFacture() + " du "
					+ doFacture.getDateFacture());
		}
		System.out.println("\n");
	}

	private static void listerArticle(MagasinService service)
			throws SQLException {
		List<DoArticle> articles = service.getListArticle();

		System.out.println("Les articles en stock sont :");
		for (DoArticle doArticle : articles) {
			System.out.println("\t" + doArticle.getIdArticle() + " - "
					+ doArticle.getNom() + "\t" + doArticle.getPrix()+"€");
		}
		System.out.println("\n");

	}

	private static void displayMenu() {
		System.out.println("Veuillez choisir une option :");
		System.out.println("\t1 - Lister les articles ");
		System.out.println("\t2 - Lister les factures ");
		System.out.println("\t3 - Créer une facture un client ");
		System.out.println("\tautre - Quitter ");
		System.out.print("? :");
	}

}
