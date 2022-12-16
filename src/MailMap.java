import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

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

    public void printMails() {
        if (mailBox.isEmpty()) {
            System.out.println("Não há emails");
        } else {
            System.out.println("Você tem emails de: ");
            for (String key : mailBox.keySet()) {
                System.out.println(key);
            }
        }
    }
}
