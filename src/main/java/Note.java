import java.time.LocalDate;

public class Note {
    private String content;
    private LocalDate date;

    public Note(String content, LocalDate date) {
        this.content = content;
        this.date = date;
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append(date.toString());
        sb.append(" -> ");
        sb.append(content);
        sb.append("\n");
        return sb.toString();
    }
}
