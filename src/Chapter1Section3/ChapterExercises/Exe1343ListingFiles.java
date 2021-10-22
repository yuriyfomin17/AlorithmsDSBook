package Chapter1Section3.ChapterExercises;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Exe1343ListingFiles {
    private static String FILE_PATH = "/Users/icom/Desktop/files";
    static class FileLister{
        private final String dirPath;
        private File file;

        public FileLister(String aDirPath){
            this.dirPath = aDirPath;
            this.file = new File(this.dirPath);
        }
        public boolean isDirectory(String directoryName){
            File currentDirectory = new File(directoryName);
            if (currentDirectory.isDirectory()) return true;
            return false;
        }
        public boolean isFile(String fileName){
            File currentFile = new File(fileName);
            if (currentFile.isFile()) return true;
            return false;
        }

        public File getFile() {
            return file;
        }
    }
    static class Queue<Item>{
        private int N = 0;
        private Node first = null;
        private Node last = null;

        public void enqueue(Item item){
            Node oldLast = this.last;

            this.last = new Node();
            this.last.item = item;

            if (isEmpty()) this.first = this.last;
            else oldLast.next = this.last;
            N++;
        }
        public Item dequeue(){
            Item item = (Item) this.first.item;
            this.first = this.first.next;
            N--;
            if (isEmpty()) this.last = null;
            return item;
        }
        public boolean isEmpty(){ return this.first == null; }
        public int size(){ return N; }
    }
    public static void main(String[] args) {
        listFileContent();
    }

    public static void listFileContent(){
        Queue directoryQueue = new Queue();
        File file = new File(FILE_PATH);
        if (file.isDirectory()){
            directoryQueue.enqueue(file);
            while (!directoryQueue.isEmpty()){
                File directory = (File) directoryQueue.dequeue();
                String[] directoryContent = directory.list();
                for (int i = 0; i < directoryContent.length; i++) {
                    File currentFile = new File(directory + "/" + directoryContent[i]);
                    if (currentFile.exists() && !currentFile.isDirectory()) {
                        System.out.println();
                        System.out.println("Directory Name: " + directory);
                        System.out.println("File Name: " + currentFile.getName());
                        readFileContent( directory + "/" + currentFile.getName());
                        System.out.println();
                    } else if (currentFile.exists() && currentFile.isDirectory()) directoryQueue.enqueue(currentFile);
                }
            }
        } else if (file.isFile()) readFileContent(file.getAbsolutePath());
    }
    public static void readFileContent(String fileName){
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
