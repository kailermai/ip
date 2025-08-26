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
                    ToDo toDo = new ToDo(taskDetails[2]);
                    if (taskDetails[1].equals("1")) {
                        toDo.markDone();
                    }
                    tmp.add(toDo);
                case D:
                    Deadline deadline = new Deadline(taskDetails[2], taskDetails[3]);
                    if (taskDetails[1].equals("1")) {
                        deadline.markDone();
                    }
                    tmp.add(deadline);
                case E:
                    Event event = new Event(taskDetails[2], taskDetails[3], taskDetails[4]);
                    if (taskDetails[1].equals("1")) {
                        event.markDone();
                    }
                    tmp.add(event);
                }
            }
            return tmp;
        } catch (FileNotFoundException e) {
            throw new AngusException("No save data found! Generating a new save...");
        }
    }
}
