import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

class Software {
    @BugReport(description = "Null pointer exception occurs in edge cases.")
    @BugReport(description = "Performance issue when processing large data.")
    public void processData() {
        System.out.println("Processing data...");
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Method method = Software.class.getMethod("processData");

        if (method.isAnnotationPresent(BugReports.class)) {
            BugReports reports = method.getAnnotation(BugReports.class);
            for (BugReport report : reports.value()) {
                System.out.println("Bug: " + report.description());
            }
        }
    }
}
