import org.junit.Test;

public class ContactServiceTest {


    IContactDao dao = new ContactDao();
    ContactService service = new ContactService(dao);


    @Test(expected=ContactExecption.class)
    public void testAddNullContactExecption() throws ContactExecption, ContactNotFound {
        //Test null
        service.add(null);
    }
    @Test(expected=ContactExecption.class)
    public void testAddShortContactExecption() throws ContactExecption, ContactNotFound {
        //Test trop court
        service.add("Ui");
    }
    @Test(expected=ContactExecption.class)
    public void testAddLongContactExecption() throws ContactExecption, ContactNotFound {
        //Test trop long
        service.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed in felis enim. Nunc ac semper diam.");
    }
    @Test(expected=ContactExecption.class)
    public void testAddAlreadyHereContactExecption() throws ContactExecption, ContactNotFound {
        //Test déjà présent
        service.add("Test");
        service.add("Test");
    }

    @Test
    public void testAdd() throws ContactExecption, ContactNotFound {
        //Test déjà présent
        service.add("NotExist");
    }


    @Test(expected = ContactNotFound.class)
    public void testDelNotFound() throws ContactExecption, ContactNotFound {
        service.supprimerContact("");
    }

    @Test(expected = ContactExecption.class)
    public void testDelNull() throws ContactExecption, ContactNotFound {
        service.supprimerContact(null);
    }

    @Test
    public void testDel() throws ContactExecption, ContactNotFound {
        service.add("Cookies");
        service.supprimerContact("Cookies");
    }
}