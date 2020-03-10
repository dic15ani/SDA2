import java.util.Date;

public class Task {
	private String title, project;
	private Date dueDate;
	private boolean status;
	private StringBuilder sb;

	public Task(String title, Date dueDate, String project) {
		this.title = title;
		this.project = project;
		this.dueDate = dueDate;
		status = false;
	}

	public void markDone() {
		status = true;
	}

	public void edit(String newTitle, Date newDate, String newProject) {
		title = newTitle;
		dueDate = newDate;
		project = newProject;
	}

	public boolean getStatus() {
		return status;
	}

	public String getProject() {
		return project;
	}

	public void print() {
		sb = new StringBuilder();
		sb.append("Name: " + title + "\n");
		sb.append("Task due date: " + dueDate.toString() + "\n");
		sb.append("Project: " + project + "\n");
		sb.append("Task done: " + status);
		System.out.println(sb.toString());
	}

}
