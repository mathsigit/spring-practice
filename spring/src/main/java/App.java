import com.stana.spring.bean.EmployeeBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

import static java.lang.System.*;

public class App {
    public static void main(String[] args) {
        App main = new App();
        File file = main.getFileFromResources("applicationContext.xml");
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {file.getPath()});

        EmployeeBean employee = (EmployeeBean)context.getBean("employee");

        out.println(employee.getFullName());

        out.println(employee.getDepartmentBean().getName());
    }

    private File getFileFromResources(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();

        File file = new File(classLoader.getResource(fileName).getFile());
        if (file == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return file;
        }

    }
}