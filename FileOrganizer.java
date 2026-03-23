import java.io.File;

public class FileOrganizer {
    public static void main(String[] args) {
        String path = "C:\\Users\\YourName\\Downloads"; // change path
        File folder = new File(path);

        File[] files = folder.listFiles();

        for (File file : files) {
            if (file.isFile()) {
                String name = file.getName().toLowerCase();

                if (name.endsWith(".jpg") || name.endsWith(".png")) {
                    moveFile(file, path + "\\Images\\");
                } 
                else if (name.endsWith(".pdf") || name.endsWith(".docx")) {
                    moveFile(file, path + "\\Documents\\");
                } 
                else if (name.endsWith(".mp4")) {
                    moveFile(file, path + "\\Videos\\");
                }
            }
        }
        System.out.println("Files Organized Successfully!");
    }

    static void moveFile(File file, String folderPath) {
        File dir = new File(folderPath);
        if (!dir.exists()) dir.mkdirs();

        file.renameTo(new File(folderPath + file.getName()));
    }
}
