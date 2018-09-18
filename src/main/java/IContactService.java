public interface IContactService {

    /**
     * Méthodes qui permet de créer un contact
     *
     * @param  nom Nom du contact a créer
     * @return Contact crée
     * @throws ContactExecption execption lorsque le contact ne peut-être ajouté (Nom invalide ou non unique)*/

    Contact creerContact(String nom) throws ContactExecption, ContactNotFound;

    void supprimerContact(String nom) throws ContactExecption, ContactNotFound;

}
