package mybatisPersistence;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.zhong.model.User;
import com.zhong.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:config/spring-mybatis.xml"})  
public class TestMybatis {
	
	  private static Logger logger = Logger.getLogger(TestMybatis.class);
	  
	    @Resource  
	    private IUserService userService;  

	//  private ApplicationContext ac = null;  
	  
	//  @Before  
	//  public void before() {  
	//  ac = new ClassPathXmlApplicationContext("applicationContext.xml");  
	// userService = (IUserService) ac.getBean("userService");  
	//  }  
	  
	    @Test  
	    public void test1() throws Exception {  
	        System.out.println("hello");
	        User user = userService.getUserById(1);
	        System.out.println("--->" + user.getAge());
	        System.out.println(logger.isDebugEnabled());
	        logger.error(user.getPassword());
	        logger.info(JSON.toJSONString(user));  
	    }  
}
