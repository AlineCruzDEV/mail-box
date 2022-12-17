import java.time.LocalDate;
import java.util.*;

public class MailMap {

    HashMap<String, List<Mail>> mailBox = new HashMap<>();

    public void addMail(Mail mail) {
        if (mail != null) {
            if (mailBox.containsKey(mail.getAddress())) {
                mailBox.get(mail.getAddress()).add(mail);
            } else {
                List<Mail> mailList = new ArrayList<>();
                mailList.add(mail);
                mailBox.put(mail.getAddress(), mailList);
            }
            System.out.println(mail);
        } else {
            System.out.println("Não foi possível adicionar o email. Tente Novamente");
        }
    }

    public int totalAddress() {
        return mailBox.size();
    }

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

    public List<String> fetchMailsWithWordsUsingList(List<String> words) {
        isMailBoxEmpty();
        List<String> mailAddresses = new ArrayList<>();
        fetchMailsWithWords(words, mailAddresses);
        return mailAddresses;
    }

    public Set<String> fetchMailsWithWordsUsingSet(Set<String> words) {
        isMailBoxEmpty();
        Set<String> mailAddresses = new HashSet<>();
        fetchMailsWithWords(words, mailAddresses);
        return mailAddresses;
    }

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
    public void removeEmailsBeforeDate(final LocalDate date) {
        for (String key : mailBox.keySet()) {
            removeEmailsBeforeDateFromAddress(date, key);
        }
    }

    private void removeEmailsBeforeDateFromAddress(LocalDate date, String key) {
        mailBox.get(key).removeIf(mail -> mail.getDateReceive().isBefore(date));
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
            System.out.println("\n"+ key);
            for (Mail mail : mailBox.get(key)) {
                System.out.println(mail);
            }
        }
    }
}
