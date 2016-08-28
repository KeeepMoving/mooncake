package mybatisPersistence;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.zhong.inter.IArticleOperation;
import com.zhong.pojo.Article;
import com.zhong.util.IdGenerator;
import com.zhong.util.MybatisUtil;

@Ignore
public class ArticlePersistenceTest {

	public static SqlSession sqlSession;
	public static String id = IdGenerator.stringUuid();
	
	@Before
	public void setUp() throws Exception {
		sqlSession =  MybatisUtil.getSqlSession();
		articleAdd();
	}
	
	@Test
	public void articleQuery() throws Exception {
		IArticleOperation mapper = sqlSession.getMapper(IArticleOperation.class);
		Article actualArticle = mapper.queryById(id);
		sqlSession.commit(); 
		assertEquals ("olympics",actualArticle.getTitle());
	}
	
	@Test
	public void articleUpdate() throws Exception {
		Article article = new Article();
		article.setId(id);
		article.setUserId("3");
		article.setTitle("h3c");
		article.setContent("achieve the goal");
		article.setPrice(63.5);
		IArticleOperation mapper = sqlSession.getMapper(IArticleOperation.class);
		mapper.update(article);
		sqlSession.commit();
		Article actualArticle = mapper.queryById(id); 
		assertEquals ("h3c", actualArticle.getTitle());
	}

	@Test
	public void articleQueryByUserId() throws Exception{
		IArticleOperation mapper = sqlSession.getMapper(IArticleOperation.class);
		List<Article> articles = mapper.queryByUserId(1);
		assertEquals(4, articles.size());
		System.out.println(articles.get(0).toString());
		
	}
	
	@After
	public void articleDelete() throws Exception {
		IArticleOperation mapper = sqlSession.getMapper(IArticleOperation.class);
		mapper.deleteById(id);
		sqlSession.commit();
		Article actualArticle = mapper.queryById(id);
		assertEquals (null,actualArticle);
	}
	
	public void articleAdd() throws Exception {
		Article article = new Article();
		article.setId(id);
		article.setUserId("1");
		article.setTitle("olympics");
		article.setContent("achieve the goal");
		article.setPrice(23.6);
		IArticleOperation mapper = sqlSession.getMapper(IArticleOperation.class);
		mapper.add(article);
		sqlSession.commit();
	}
	
}
