import java.time.LocalDate;

public class Mail {
    private String address;
    private LocalDate dateSend;
    private LocalDate dateReceive;
    private String subject;
    private String body;

    public Mail(String address, LocalDate dateSend, LocalDate dateReceive, String subject, String body) {
        this.address = address;
        this.dateSend = dateSend;
        this.dateReceive = dateReceive;
        this.subject = subject;
        this.body = body;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateSend() {
        return dateSend;
    }

    public void setDateSend(LocalDate dateSend) {
        this.dateSend = dateSend;
    }

    public LocalDate getDateReceive() {
        return dateReceive;
    }

    public void setDateReceive(LocalDate dateReceive) {
        this.dateReceive = dateReceive;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        String email = "------ MENSAGEM ---------\n" + "De: " + address + "\n" +
                "Assunto: " + subject + "\n" +
                "Enviada em: " + dateSend + "\n" +
                "Recebida em: " + dateReceive + "\n" +
                "Assunto: " + subject + "\n" +
                body + "\n";
        return email;
    }
}
