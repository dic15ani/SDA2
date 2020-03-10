import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

	private static Scanner scan = new Scanner(System.in);
	private static ArrayList<Task> taskList = new ArrayList<>();

	private static void printOptions() {
		StringBuilder sb = new StringBuilder();
		sb.append("********** \n");
		sb.append("Welcome to ToDoly \n");
		sb.append("You have X tasks todo and Y tasks are done! \n");
		sb.append("Pick an option: \n");
		sb.append("(1) Show Task List (by date or project) \n");
		sb.append("(2) Add New Task \n");
		sb.append("(3) Edit Task (update, mark as done, remove) \n");
		sb.append("(4) Save and Quit");
		System.out.println(sb.toString());
	}

	private static void showTaskList(String input) {
		switch (input) {
		case "1":
			if (taskList.size() == 0) {
				System.out.println("No task added");
			}
			for (Task t : taskList) {
				t.print();
			}
			break;
		case "2":
			if (taskList.size() == 0) {
				System.out.println("No task added");
			}
			for (Task t : taskList) {
				t.print();
			}
			break;
		default:
			System.out.println("Invalid option!");
		}
	}

	private static boolean addTask() {
		boolean notAdded = true;
		while (notAdded) {
			System.out.println("Task name:");
			String name = scan.next();

			System.out.println("Project name: ");
			String project = scan.next();

			System.out.println("Set due date in format dd-mm-yyy");
			SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
			Date date;
			try {
				date = sdf.parse(scan.next());
				Task task = new Task(name, date, project);
				task.print();
				taskList.add(task);
				notAdded = false;
			} catch (ParseException e) {
				System.out.println("Unvalid date input, try again!");
			}
		}
		System.out.println("Task added!");
		return true;
	}

	private static void showOptions(String input) {
		switch (input) {
		case "1":
			System.out.println("(1) Show by date");
			System.out.println("(2) Show by project");
			showTaskList(scan.next());
			break;
		case "2":

			addTask();
			break;
		case "3":
			System.out.println("Option 3");
			break;
		case "4":
			System.out.println("Save and Quit");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid option!");
		}
	}

	public static void main(String[] args) {
		while (true) {
			printOptions();
			showOptions(scan.next());

		}
	}
}
