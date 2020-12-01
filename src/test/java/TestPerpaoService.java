import com.baizhi.entity.Perpao;
import com.baizhi.service.PerpaoService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPerpaoService {
    @Test
    public void testDAO() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
/*        PerpaoDAO perpaoDAO = (PerpaoDAO) context.getBean("perpaoDAO");
        Perpao perpao = new Perpao();
        perpao.setId("1");
        perpao.setName("da可爱");
        perpao.setSalary(1000.0);
        perpao.setAge(23);
        perpaoDAO.save(perpao);*/
    }

    @Test
    public void testService() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        PerpaoService perpaoService = (PerpaoService) context.getBean("perpaoService");
        Perpao perpao = new Perpao();
        perpao.setId("3");
        perpao.setName("lao可爱");
        perpao.setSalary(5000.0);
        perpao.setAge(53);
        perpaoService.save(perpao);
    }

    @Test
    public void testService1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        PerpaoService perpaoService = (PerpaoService) context.getBean("perpaoService");

        int i = 1;

        while (i < 10) {
            for (Perpao perpao : perpaoService.queryAll()) {
                System.out.println(perpao);
            }
            i++;
        }

    }

    @Test
    public void testService2() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        PerpaoService perpaoService = (PerpaoService) context.getBean("perpaoService");
        perpaoService.delete("291a573f-a052-4117-a044-d411caa9da0a");
    }

    @Test
    public void testService3() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        PerpaoService perpaoService = (PerpaoService) context.getBean("perpaoService");
        Perpao perpao1 = perpaoService.queryOne("1");
        System.out.println(perpao1);
        perpao1.setName("www");
        perpao1.setSalary(4000.0);
        perpao1.setAge(66);
        perpaoService.update(perpao1);
    }
}
