public class ContactExecption extends Exception {


    ContactExecption(String details){
        System.err.println("Votre nom ne correspond pas aux demandes, il est "+ details);
    }
}
