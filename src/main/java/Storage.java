import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Storage {
    String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public List<Task> load() throws AngusException {
        try {
            File f = new File(filePath);
            Scanner s = new Scanner(f);
            List<Task> tmp = new ArrayList<>();
            while (s.hasNextLine()) {
                String curTask = s.nextLine();
                String[] taskDetails = curTask.split("//");
                Task.TaskTypes taskType = Task.TaskTypes.valueOf(taskDetails[0]);
                switch (taskType) {
                case T:

                case D:

                case E:
                }
            }
            return tmp;
        } catch (FileNotFoundException e) {
            throw new AngusException("");
        }
    }
}
