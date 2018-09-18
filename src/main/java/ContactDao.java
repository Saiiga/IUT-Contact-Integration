import java.util.ArrayList;

public class ContactDao implements IContactDao {

    private ArrayList<Contact> contacts;

    public ContactDao(){
        this.contacts = new ArrayList<Contact>();
    }

    @Override
    public  ArrayList<Contact> readAll(){
        return contacts;
    }

    @Override
    public Contact findByName(String name){
        Contact res = null;
        for(Contact contact : contacts){
            if(contact.getNom().equals(name)){
                res = contact;
                break;
            }
        }

        return res;
    }

    @Override
    public void add(Contact contact) throws ContactExecption {
        if(!nameInBase(contact.getNom())){
            this.contacts.add(contact);
        }else{
            throw new ContactExecption("déjà présent dans la base");
        }
    }


    private boolean nameInBase(String name){
        boolean res = false;
        for(Contact myContact : this.contacts){
            if(myContact.getNom().equals(name)){
                res = true;
            }
        }
        return res;

    }

    @Override
    public void del(String name) throws ContactNotFound {
        Contact contact = findByName(name);

        if(contact != null){
            this.contacts.remove(contact);
        }else{
            throw new ContactNotFound();
        }
    }
}
