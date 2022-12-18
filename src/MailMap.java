import java.time.LocalDate;
import java.util.*;

public class MailMap {

    HashMap<String, List<Mail>> mailBox = new HashMap<>();

    private static boolean validateCountry(String country) {
        if (country == null) {
            System.out.println("É necessário informar um país!");
            return false;
        } else
            return true;
    }

    // Guardar um novo email recebido
    public void addMail(Mail mail) {
        if (mail != null) {
            if (mailBox.containsKey(mail.getAddress())) {
                mailBox.get(mail.getAddress()).add(mail);
            } else {
                List<Mail> mailList = new ArrayList<>();
                mailList.add(mail);
                mailBox.put(mail.getAddress(), mailList);
            }
            System.out.println("Adicionando... \n" + mail);
        } else {
            System.out.println("Não foi possível adicionar o email. Tente Novamente");
        }
    }

    // Determinar o total de endereços a partir dos quais se recebeu mail
    public int totalAddress() {
        return mailBox.size();
    }

    // Determinar quantos mails têm por origem um dado endereço
    public int totalMailsOriginateFromAddress(String address) {
        int totalMails = 0;
        if (isAddressNullOrEmpty(address))
            throw new IllegalArgumentException("Email inválido");

        for (String key : mailBox.keySet()) {
            if (Objects.equals(key, address)) {
                totalMails = mailBox.get(key).size();
            }
        }

        return totalMails;
    }

    private boolean isAddressNullOrEmpty(String address) {
        return address.isEmpty() || address.isBlank();
    }

    // Criar uma lista com todos os endereços que enviaram mails contendo no seu assunto uma lista de palavras dada como parâmetro
    public List<String> fetchMailsWithWordsUsingList(List<String> words) {
        isMailBoxEmpty();
        List<String> mailAddresses = new ArrayList<>();
        fetchMailsWithWords(words, mailAddresses);
        return mailAddresses;
    }

    // O mesmo que a questão anterior, mas criando um conjunto contendo os mails
    public Set<String> fetchMailsWithWordsUsingSet(Set<String> words) {
        isMailBoxEmpty();
        Set<String> mailAddresses = new HashSet<>();
        fetchMailsWithWords(words, mailAddresses);
        return mailAddresses;
    }

    // Dada uma lista de palavras, eliminar todos os mails de um dado endereço que no seu assunto contenham uma qualquer destas (anti-spam)
    private void fetchMailsWithWords(Collection<String> words, Collection<String> mailAddresses) {
        for (String key : mailBox.keySet()) {
            for (Mail mail : mailBox.get(key)) {
                String subject = mail.getSubject().toLowerCase();
                for (String word : words) {
                    if (subject.contains(word)) {
                        if (mailAddresses.contains(mail.getAddress())) {
                            break;
                        } else {
                            mailAddresses.add(mail.getAddress());
                        }
                    }
                }
            }
        }
    }

    private void isMailBoxEmpty() {
        if (mailBox.isEmpty()) {
            System.out.println("Caixa de emails vazia");
        }
    }

    // Eliminar todos os emails recebidos antes de uma data que é dada como parâmetro
    public void removeEmailsBeforeDate(final LocalDate date) {
        for (String key : mailBox.keySet()) {
            removeEmailsBeforeDateFromAddress(date, key);
        }
    }

    // Criar uma lista dos endereços que hoje enviaram mails - receber uma data
    public List<String> fetchMailAddressesSentEmailsForDate(LocalDate date) {
        final List<String> sentMails = new ArrayList<>();
        for (String key : mailBox.keySet()) {
            for (Mail mail : mailBox.get(key)) {
                if (mail.getDateSend().equals(date)) {
                    sentMails.add(key);
                    break;
                }
            }
        }
        return sentMails;
    }

    //Eliminar todos os mails de um dado endereço anteriores a uma data dada
    private void removeEmailsBeforeDateFromAddress(LocalDate date, String key) {
        mailBox.get(key).removeIf(mail -> mail.getDateReceive().isBefore(date));
    }

    // Criar uma listagem com todos os endereços de mail oriundos de um determinado país
    public List<String> fetchMailAddressesFromCountry(String country) {
        List<String> mailAddressesFromCountry = new ArrayList<>();
        isMailBoxEmpty();
        if (validateCountry(country)) {
            for (String address : mailBox.keySet()) {
                if (address.endsWith(country)) {
                    mailAddressesFromCountry.add(address);
                }
            }
        }
        return mailAddressesFromCountry;
    }

    public void printMailAddresses() {
        if (mailBox.isEmpty()) {
            System.out.println("Não há emails");
        } else {
            System.out.println("Você tem emails de: ");
            for (String key : mailBox.keySet()) {
                System.out.println(key);
            }
        }
    }

    public void printMailBox() {
        System.out.println("Sua caixa de entrada");
        for (String key : mailBox.keySet()) {
            System.out.println("\n" + key);
            for (Mail mail : mailBox.get(key)) {
                System.out.println(mail);
            }
        }
    }
}
