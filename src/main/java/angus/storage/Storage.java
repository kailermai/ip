package angus.storage;

import angus.exception.AngusException;
import angus.task.Deadline;
import angus.task.Event;
import angus.task.Task;
import angus.task.TaskList;
import angus.task.ToDo;
import angus.ui.Parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
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
                    break;
                case D:
                    LocalDate dateTime = LocalDate.parse(taskDetails[3], Parser.FORMATTER_FROM);
                    Deadline deadline = new Deadline(taskDetails[2], dateTime);
                    if (taskDetails[1].equals("1")) {
                        deadline.markDone();
                    }
                    tmp.add(deadline);
                    break;
                case E:
                    LocalDate formattedStartDate = LocalDate.parse(taskDetails[3], Parser.FORMATTER_FROM);
                    LocalDate formattedEndDate = LocalDate.parse(taskDetails[4], Parser.FORMATTER_FROM);
                    Event event = new Event(taskDetails[2], formattedStartDate, formattedEndDate);
                    if (taskDetails[1].equals("1")) {
                        event.markDone();
                    }
                    tmp.add(event);
                    break;
                }
            }
            return tmp;
        } catch (FileNotFoundException e) {
            throw new AngusException("No save data found! Generating a new save...");
        }
    }

    public void save(TaskList tasks) throws AngusException {
        try {
            FileWriter fw = new FileWriter(filePath);
            for (int i = 0; i < tasks.getSize(); i++) {
                Task curTask = tasks.getTask(i);
                fw.write(curTask.saveTask());
                fw.write("\n");
            }
            fw.close();
        } catch (IOException e) {
            throw new AngusException("Unable to save! :(");
        }
    }
}
