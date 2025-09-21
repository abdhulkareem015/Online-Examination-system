import java.util.*;

// Base class
abstract class User {
    protected String username;
    protected String password;
    public User(String username, String password) {
        this.username = username; this.password = password;
    }
    public abstract boolean login();
}

// Student class
class Student extends User {
    private Result result;
    public Student(String u, String p) { super(u, p); }
    @Override
    public boolean login() { return password.equals("student123"); }
    public void takeExam(Exam exam) { result = exam.start(this); }
    public Result getResult() { return result; }
}

// Admin class
class Admin extends User {
    public Admin(String u, String p) { super(u, p); }
    @Override
    public boolean login() { return password.equals("admin123"); }
    public void createExam(Exam exam) { 
        System.out.println("Exam created: " + exam.title); 
    }
    public void viewResults(List<Student> students) {
        System.out.println("\n--- Student Results ---");
        for (Student s : students) {
            if (s.getResult() != null) s.getResult().show();
        }
    }
}

// Question class
abstract class Question {
    String text;
    String answer;
    public Question(String t, String a) { text = t; answer = a; }
    public abstract boolean checkAnswer(String response);
}

class MCQ extends Question {
    List<String> options;
    public MCQ(String t, String a, List<String> opts) { 
        super(t,a); options = opts; 
    }
    @Override
    public boolean checkAnswer(String response) { 
        return response.equalsIgnoreCase(answer); 
    }
    public void display() {
        System.out.println(text);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i+1) + ". " + options.get(i));
        }
    }
}

class TrueFalseQ extends Question {
    public TrueFalseQ(String t, String a) { super(t,a); }
    @Override
    public boolean checkAnswer(String response) {
        return response.equalsIgnoreCase(answer);
    }
    public void display() {
        System.out.println(text + " (True/False)");
    }
}

// Exam class
class Exam {
    String title;
    List<Question> questions = new ArrayList<>();
    public Exam(String t) { title = t; }
    public void addQuestion(Question q) { questions.add(q); }
    public Result start(Student s) {
        Scanner sc = new Scanner(System.in);
        int score = 0;
        System.out.println("\nStarting exam: " + title + " for " + s.username);

        for (Question q: questions) {
            if (q instanceof MCQ) ((MCQ) q).display();
            else if (q instanceof TrueFalseQ) ((TrueFalseQ) q).display();

            long startTime = System.currentTimeMillis();
            String ans = sc.nextLine();
            long elapsed = (System.currentTimeMillis() - startTime)/1000;

            if (elapsed > 30) {
                System.out.println("Time up! Question skipped.");
                continue;
            }
            if (q.checkAnswer(ans)) score++;
        }
        Result r = new Result(s.username, score, questions.size());
        r.show();
        return r;
    }
}

// Result class
class Result {
    String student; 
    int score, total;
    public Result(String s, int sc, int tot) { 
        student = s; score = sc; total = tot;
    }
    public void show() { 
        System.out.println(student + " scored: " + score + "/" + total); 
    }
}

// Main demo
public class OnlineExamSystem {
    public static void main(String[] args) {
        Admin admin = new Admin("teacher","admin123");
        if (admin.login()) {
            Exam exam = new Exam("Java Basics");
            exam.addQuestion(new MCQ("2+2=?","4", Arrays.asList("3","4","5")));
            exam.addQuestion(new MCQ("what is the capital of india ?","delhi",
                Arrays.asList("mumbai","delhi","chennai")));
            exam.addQuestion(new TrueFalseQ("Java supports inheritance","True"));
            admin.createExam(exam);

            List<Student> students = Arrays.asList(
                new Student("ram","student123"),
                new Student("arun","student123")
            );

            for (Student s : students) {
                if (s.login()) s.takeExam(exam);
            }

            admin.viewResults(students);
        }
    }
}
