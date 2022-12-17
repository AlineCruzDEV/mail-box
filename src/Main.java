import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        System.out.println("-------Caixa de Email-------" + "\n");
        Mail email1 = new Mail("aline.cruz@gmail.com.br", LocalDate.of(2022, 06, 04), LocalDate.of(2022, 06, 05), "Teste de Email1", "Trabalho da aula de Collections - Jornada do Conhecimento Backend Java - F1rst & Ada" + "\n");
        Mail email2 = new Mail("greg.tolentino@gmail.com.br", LocalDate.of(2022, 05, 04), LocalDate.of(2022, 05, 05), "Teste F1rst", "Trabalho da aula de Collections - Jornada do Conhecimento Backend Java - F1rst & Ada" + "\n");
        Mail email3 = new Mail("cruz.aline@gmail.com.uk", LocalDate.of(2022, 04, 04), LocalDate.of(2022, 04, 05), "Teste de Email3", "Trabalho da aula de Collections - Jornada do Conhecimento Backend Java - F1rst & Ada" + "\n");
        Mail email4 = new Mail("aline.cruz@gmail.com.br", LocalDate.of(2022, 06, 04), LocalDate.of(2022, 06, 05), "Teste de Email4", "Trabalho da aula de Collections - Jornada do Conhecimento Backend Java - F1rst & Ada" + "\n");
        Mail email5 = new Mail("c.a@gmail.com.fr", LocalDate.of(2022, 07, 04), LocalDate.of(2022, 07, 05), "Teste de Email5", "Trabalho da aula de Collections - Jornada do Conhecimento Backend Java - F1rst & Ada" + "\n");

        MailMap myMailBox = new MailMap();

        myMailBox.printMailAddresses();

        System.out.println();
        myMailBox.addMail(email1);
        myMailBox.addMail(email2);
        myMailBox.addMail(email3);
        myMailBox.addMail(email4);
        myMailBox.addMail(email5);

        myMailBox.printMailAddresses();

        System.out.println();
        System.out.println("Total de endereços remetentes: " + myMailBox.totalAddress());

        System.out.println();
        System.out.println("Total de emails de " + email1.getAddress() + " é " + myMailBox.totalMailsOriginateFromAddress("aline.cruz@gmail.com.br"));

        System.out.println();
        System.out.println("Lista de Emails que contem as palavras teste e f1rst: " + myMailBox.fetchMailsWithWordsUsingList(List.of("teste", "f1rst")));

        System.out.println();
        System.out.println("Set de Emails que contem as palavras teste e f1rst: " + myMailBox.fetchMailsWithWordsUsingSet(Set.of("teste", "f1rst")));

        System.out.println();
        myMailBox.printMailBox();

        System.out.println();
        myMailBox.removeEmailsBeforeDate(LocalDate.of(2022, 06, 05));

        System.out.println("Remover emails recebidos antes de 06-05-2022: ");
        myMailBox.printMailBox();
    }
}