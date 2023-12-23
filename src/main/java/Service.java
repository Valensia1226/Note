import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Scanner;

public class Service {
    Scanner scanner;

    public Service() {
        this.scanner = new Scanner(System.in);
    }

    public void add(){
        System.out.println("Введите заметку: ");
        String content = scanner.nextLine();
        LocalDate date = LocalDate.now();
        Note note = new Note(content, date);
        Path path = Path.of("Notes.txt");
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                throw new RuntimeException("Ошибка создания файла");
            }
        }
        String text;
        try {
            text = Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения из файла");
        }

        StringBuilder sb = new StringBuilder();
        sb.append(text);
        sb.append(note.getInfo());

        try {
            Files.writeString(path, sb.toString());
        } catch (IOException e) {
            throw new RuntimeException("Ошибка записи в файл");
        }
    }

}
