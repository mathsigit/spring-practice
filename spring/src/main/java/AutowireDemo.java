import com.stana.spring.bean.EmployeeBean;
import com.stana.spring.constant.Status.*;
import com.stana.spring.utils.PropertyUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

/**
 * Auto wire demo
 */
public class AutowireDemo {
    public static void main(String[] args) throws IOException {

        String contextName = (new PropertyUtil(PropertyID.ERROR)).getContextNameByID();
        InputStream stream = new AutowireDemo().getClass().getClassLoader().getResourceAsStream(contextName);
        File targetFile = new File("test.xml");
        FileUtils.copyInputStreamToFile(stream, targetFile);
        //Read File Content
        String content = new String(Files.readAllBytes(targetFile.toPath()));
        System.out.println(content);

        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {contextName});
        EmployeeBean employee = (EmployeeBean)context.getBean("employee");
        System.out.println(employee.getFullName());
        System.out.println(employee.getDepartmentBean().getName());
    }
}