

public class ContactService implements IContactService {

    private IContactDao dao;

    public ContactService(){

    }

    public ContactService(IContactDao dao){
        this.dao = dao;
    }

    public void add(String contactName) throws ContactExecption, ContactNotFound {
        dao.add(creerContact(contactName));

    }

    @Override
    public Contact creerContact(String nom) throws ContactExecption, ContactNotFound {
        Contact res = null;
        if(nom == null){
            throw new ContactExecption("nul");
        }
        if(nom.length() <= 3){
            throw new ContactExecption("trop court (moins de 3 caractères)");
        }
        if(nom.length() >= 40){
            throw new ContactExecption("trop long (plus de 40 caractères)");
        }
        if(dao.findByName(nom) != null){
            throw new ContactExecption("déjà présent !");
        }

        res = new Contact(nom);

        return res;
    }

    @Override
    public void supprimerContact(String nom) throws ContactExecption, ContactNotFound {

        if(nom != null){
            dao.del(nom);
        }else{
            throw new ContactExecption("nul");
        }
    }
}
