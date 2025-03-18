package observerPattern;

import java.util.ArrayList;
import java.util.List;

public class TaskObserver {
    interface Observer {
        void update(String taskName, String status);
    }

    // Concrete Observer (Team Member)
    static class TeamMember implements Observer {
        private String name;

        public TeamMember(String name) {
            this.name = name;
        }

        @Override
        public void update(String taskName, String status) {
            System.out.println("TeamMember " + name + " notified: Task '" + taskName + "' changed to " + status);
        }
    }

    // Subject Interface
    interface Subject {
        void attach(Observer observer);
        void detach(Observer observer);
        void notifyObservers();
    }

    // Concrete Subject (Task)
    static class Task implements Subject {
        private String taskName;
        private String status;
        private List<Observer> observers = new ArrayList<>();

        public Task(String taskName, String status) {
            this.taskName = taskName;
            this.status = status;
        }

        @Override
        public void attach(Observer observer) {
            observers.add(observer);
        }

        @Override
        public void detach(Observer observer) {
            observers.remove(observer);
        }

        @Override
        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(taskName, status);
            }
        }

        // Setter method to update task status and notify observers
        public void setStatus(String status) {
            this.status = status;
            System.out.println("\nTask '" + taskName + "' new status: " + status);
            notifyObservers();
        }
    }

        public static void main(String[] args) {

            Task task1 = new Task("Develop API", "Pending");


            TeamMember member1 = new TeamMember("Alice");
            TeamMember member2 = new TeamMember("Bob");


            task1.attach(member1);
            task1.attach(member2);


            task1.setStatus("In Progress");
            task1.setStatus("Completed");


            task1.detach(member2);


            task1.setStatus("Reviewed");
        }
}
