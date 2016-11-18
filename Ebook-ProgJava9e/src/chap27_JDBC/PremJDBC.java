package chap27_JDBC;

import java.sql.*; // pour SQLException, DriverManager, Statement, ResultSet

public class PremJDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException { // on ne traite pas les
                                                                                         // exceptions
        // recherche et enregistrement du pilote (driver)
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        
        // établissement de la connexion avec la base stocks (crée ici avec Derby)
        Connection connec = DriverManager.getConnection("jdbc:derby:C:/Documents and Settings/claude/stocks");
        
        // cr�ation de l'objet de type Statement associ� � la connexion, contenant une requ�te SQL (ici de s�lection de donn�es)
        String requete = "SELECT nom, quantite FROM produits";
        Statement stmt = connec.createStatement();
        
        // ex�cution de la requ�te SQL de s�lection de donn�es
        ResultSet res;
        res = stmt.executeQuery(requete);
        
        // r�cup�ration et affichage des r�sultats de la s�lection
        String nom;
        int quantite;
        while (res.next()) {
            nom = res.getString(1); // premi�re colonne du r�sultat
            quantite = res.getInt(2); // deuxi�me colonne du r�sultat
            System.out.println(quantite + " " + nom);
        }
        // lib�ration des ressources
        stmt.close();
        res.close();
        connec.close();
    }
}
