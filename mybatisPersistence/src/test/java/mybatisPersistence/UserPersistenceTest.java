package mybatisPersistence;

import static org.junit.Assert.assertEquals;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import com.zhong.pojo.User;
import com.zhong.util.IdGenerator;
import com.zhong.util.MybatisUtil;

@Ignore
public class UserPersistenceTest {

	public static SqlSession sqlSession;
	public static String id = IdGenerator.stringUuid();
	
	@Before
	public void setUp() throws Exception {
		sqlSession =  MybatisUtil.getSqlSession();
		userAdd();
	}
	
	@Test
	public void userQuery() {
		User user = sqlSession.selectOne("mapping.userMapper.getUser", id); 
		assertEquals ("林夕",user.getName());
	}
	
	@Test
	public void userUpdate() {
		User user = new User();
		user.setName("林夕");
		user.setAge(43);
		user.setId(id);
		sqlSession.update("mapping.userMapper.updateUser", user);
		sqlSession.commit();
		User userActual = sqlSession.selectOne("mapping.userMapper.getUser", id); 
		assertEquals (43,userActual.getAge());
	}

	@After
	public void userDelete() {
		sqlSession.delete("mapping.userMapper.deleteUser", id);
		sqlSession.commit();
		User userActual = sqlSession.selectOne("mapping.userMapper.getUser", id); 
		assertEquals (null,userActual);
	}
	
	public void userAdd() {
		User user = new User();
		user.setName("林夕");
		user.setAge(33);
		user.setId(id);
		sqlSession.insert("mapping.userMapper.addUser", user);
		sqlSession.commit();
		User userActual = sqlSession.selectOne("mapping.userMapper.getUser", id); 
		assertEquals ("林夕",userActual.getName());
	}
	
}
