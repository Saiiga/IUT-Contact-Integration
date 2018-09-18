import org.easymock.*;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class ContactServiceMockTest extends EasyMockSupport{

    @Rule
    public EasyMockRule rule = new EasyMockRule(this);

    @TestSubject
    private ContactService service = new ContactService();

    @Mock
    private IContactDao dao;

    @Test(expected = ContactExecption.class)
    public void testAddContact() throws ContactExecption, ContactNotFound {
        // 1 Enregistrement des comportements de mocks
        EasyMock.expect(dao.findByName("UnNom")).andReturn(new Contact());

        // 2 Fin d'enregistrement
        replayAll();

        // 3 Test
        service.add("UnNom");
    }

    @Test
    public void testDelContact() throws ContactExecption, ContactNotFound {
//        service.add("Cookies");
        Contact contact= new Contact();
        contact.setNom("Cookies");

        //EasyMock.expect(dao.findByName(EasyMock.anyString())).andReturn(contact);

        Capture<String> contactCapture = EasyMock.newCapture();
        dao.del(EasyMock.capture(contactCapture));

        replayAll();

        service.supprimerContact("Cookies");

        Assert.assertEquals("Cookies", contactCapture.getValue());
    }
}
