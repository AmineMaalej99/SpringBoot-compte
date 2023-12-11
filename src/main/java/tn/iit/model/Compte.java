package tn.iit.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="comptes")

public class Compte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	

	private long id;
	@Column(name="nom_client")
	private String NomClient;
	@Column(name="prenom_client")
	private String PrenomClient;
	@Column(name="adresse_client")
	private String AdresseClient;
	@Column(name="solde")
	private String Solde;
	@Column(name="rib")
	private String Rib;
	public Compte() {
		
	}
	
	public Compte(String nomClient, String prenomClient, String adresseClient, String solde, String rib) {
		super();
		NomClient = nomClient;
		PrenomClient = prenomClient;
		AdresseClient = adresseClient;
		Solde = solde;
		Rib = rib;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomClient() {
		return NomClient;
	}
	public void setNomClient(String nomClient) {
		NomClient = nomClient;
	}
	public String getPrenomClient() {
		return PrenomClient;
	}
	public void setPrenomClient(String prenomClient) {
		PrenomClient = prenomClient;
	}
	public String getAdresseClient() {
		return AdresseClient;
	}
	public void setAdresseClient(String adresseClient) {
		AdresseClient = adresseClient;
	}
	public String getSolde() {
		return Solde;
	}
	public void setSolde(String solde) {
		Solde = solde;
	}
	public String getRib() {
		return Rib;
	}
	public void setRib(String rib) {
		Rib = rib;
	}
	}
	
	