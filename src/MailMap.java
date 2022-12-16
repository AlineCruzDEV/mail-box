import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MailMap {

    HashMap<String, List<Mail>> mailBox = new HashMap<>();

    public void addMail(Mail mail) {
        if (mailBox.containsKey(mail.getAddress())) {
            mailBox.get(mail.getAddress()).add(mail);
        } else {
            List<Mail> mailList = new ArrayList<>();
            mailList.add(mail);
            mailBox.put(mail.getAddress(), mailList);
        }
        System.out.println(mail);
    }

    public int totalAddress() {
        return mailBox.size();
    }

    public int totalMailsOriginateFromAddress(String address) {
        int totalMails = 0;
        for (String key: mailBox.keySet()) {
            if(key == address) {
                totalMails = mailBox.get(key).size();
            }
        }
        return totalMails;
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
