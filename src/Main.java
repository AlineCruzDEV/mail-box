import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        System.out.println("-------Caixa de Email-------" + "\n");
        Mail email1 = new Mail("aline.cruz@gmail.com.br", LocalDate.of(2022, 06, 04), LocalDate.of(2022, 06, 05), "Teste de Email1", "Trabalho da aula de Collections - Jornada do Conhecimento Backend Java - F1rst & Ada" + "\n");
        Mail email2 = new Mail("greg.tolentino@gmail.com.br", LocalDate.of(2022, 05, 04), LocalDate.of(2022, 05, 05), "Teste de Email2", "Trabalho da aula de Collections - Jornada do Conhecimento Backend Java - F1rst & Ada" + "\n");
        Mail email3 = new Mail("cruz.aline@gmail.com.uk", LocalDate.of(2022, 04, 04), LocalDate.of(2022, 04, 05), "Teste de Email3", "Trabalho da aula de Collections - Jornada do Conhecimento Backend Java - F1rst & Ada" + "\n");
        Mail email4 = new Mail("aline.cruz@gmail.com.br", LocalDate.of(2022, 06, 04), LocalDate.of(2022, 06, 05), "Teste de Email4", "Trabalho da aula de Collections - Jornada do Conhecimento Backend Java - F1rst & Ada" + "\n");
        Mail email5 = new Mail("c.a@gmail.com.fr", LocalDate.of(2022, 07, 04), LocalDate.of(2022, 07, 05), "Teste de Email5", "Trabalho da aula de Collections - Jornada do Conhecimento Backend Java - F1rst & Ada" + "\n");

        MailMap myMailBox = new MailMap();

        myMailBox.printMails();

        System.out.println();
        myMailBox.addMail(email1);
        myMailBox.addMail(email2);
        myMailBox.addMail(email3);
        myMailBox.addMail(email4);
        myMailBox.addMail(email5);
        myMailBox.printMails();
        System.out.println(myMailBox.totalAddress());
        System.out.println(myMailBox.totalMailsOriginateFromAddress("aline.cruz@gmail.com.br"));

    }
}