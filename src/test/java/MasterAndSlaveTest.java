import com.test.entity.Master;
import com.test.entity.Slave;
import com.test.service.IAnnotationService;
import com.test.service.ICodingService;
import com.test.service.IInterceptorService;
import com.test.service.ITemplateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class MasterAndSlaveTest {

    @Autowired
    ICodingService codingService;

    @Autowired
    ITemplateService templateService;

    @Autowired
    IAnnotationService annotationService;

    @Autowired
    IInterceptorService interceptorService;

    @Test
    public void interceptorSave(){
        Random random = new Random();
        Integer number = random.nextInt(8999)+1001;
        Master master = new Master();
        master.setPrice(number);
        Slave slave = new Slave();
        slave.setPrice(number);
        System.out.println(interceptorService.save(master,slave));
    }

    @Test
    public void interceptorUpdate(){
        Random random = new Random();
        Integer number = random.nextInt(8999)+1001;
        Master master = new Master();
        master.setId(1);
        master.setPrice(number);
        Slave slave = new Slave();
        slave.setPrice(number);
        slave.setId(1);
        System.out.println(interceptorService.update(master,slave));
    }


    @Test
    public void annotationSave(){
        Random random = new Random();
        Integer number = random.nextInt(8999)+1001;
        Master master = new Master();
        master.setPrice(number);
        Slave slave = new Slave();
        slave.setPrice(number);
        System.out.println(annotationService.save(master,slave));
    }

    @Test
    public void annotationUpdate(){
        Random random = new Random();
        Integer number = random.nextInt(8999)+1001;
        Master master = new Master();
        master.setId(1);
        master.setPrice(number);
        Slave slave = new Slave();
        slave.setPrice(number);
        slave.setId(1);
        System.out.println(annotationService.update(master,slave));
    }

    @Test
    public void templateSave(){
        Random random = new Random();
        Integer number = random.nextInt(8999)+1001;
        Master master = new Master();
        master.setPrice(number);
        Slave slave = new Slave();
        slave.setPrice(number);
        System.out.println(templateService.save(master,slave));
    }

    @Test
    public void templateUpdate(){
        Random random = new Random();
        Integer number = random.nextInt(8999)+1001;
        Master master = new Master();
        master.setId(1);
        master.setPrice(number);
        Slave slave = new Slave();
        slave.setPrice(number);
        slave.setId(1);
        System.out.println(templateService.update(master,slave));
    }


    @Test
    public void codingSave(){
        Random random = new Random();
        Integer number = random.nextInt(9000)+1000;
        Master master = new Master();
        master.setPrice(number);
        Slave slave = new Slave();
        slave.setPrice(number);
        System.out.println(codingService.save(master,slave));
    }

    @Test
    public void codingUpdate(){
        Random random = new Random();
        Integer number = random.nextInt(9000)+1000;
        Master master = new Master();
        master.setId(1);
        master.setPrice(number);
        Slave slave = new Slave();
        slave.setPrice(number);
        slave.setId(1);
        System.out.println(codingService.update(master,slave));
    }

}
