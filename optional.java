import java.util.Optional;

public class optional {
    public static void main(String[] args) {
        String[] words = new String[10];
        Optional<String> checkNull = Optional.ofNullable(words[6]);

        if(words[6] == null) System.out.println("This is null"); // without optional
        if(checkNull.isPresent()) {                                // with optional
            System.out.println(words[6].toLowerCase());
        } else {
            System.out.println("Word is null");
        }
    }
}
