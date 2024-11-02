import java.util.Scanner;
import java.util.Arrays;

class Document {
    int id;
    String title;
    String folderName;
    int pages;
    
    public Document(int id, String title, String folderName, int pages) {
        this.id = id;
        this.title = title;
        this.folderName = folderName;
        this.pages = pages;
    }   
    
    int getId() {
        return this.id;
    }
    
    String getTitle() {
        return this.title;
    }
    
    String getFolderName() {
        return this.folderName;
    }
    
    int getPages() {
        return this.pages;
    }
}

public class program11 {
    static Document[] docsWithOddPages(Document[] docs) {
        return Arrays.stream(docs).filter(doc -> doc.getPages()%2 == 1).sorted((Document doc1, Document doc2) -> Integer.compare(doc1.getId(), doc2.getId())).toArray(Document[]::new);
    }
    
    public static void main(String args[] ) throws Exception {        
        Scanner sc = new Scanner(System.in);
        Document[] docs = new Document[4];
        
        for(int i = 0; i < docs.length; i++) {
            int id = sc.nextInt();
            sc.nextLine();
            String title = sc.nextLine();
            String folderName = sc.nextLine();
            int pages = sc.nextInt();
            sc.nextLine();
            
            docs[i] = new Document(id, title, folderName, pages);
        }
        
        Document[] res = docsWithOddPages(docs);
        
        for(Document doc : res) {
            System.out.println(doc.getId() + " " + doc.getTitle() + " " + doc.getFolderName() + " "+ doc.getPages());
        }
    }
}

/*

--- input ---
1
resume
personal
50
2
question1
exams
55
3
question2
exams
45
4
India
misc
40

--- ouput ---
2 question1 exams 55
3 question2 exams 45

*/