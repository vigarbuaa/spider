package hello;

import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.vigar.dao.ArticleDataMapper;
import com.vigar.dao.ArticleMapper;
import com.vigar.method.Spider;
import com.vigar.method.Util;
import com.vigar.model.Article;
import com.vigar.model.ArticleData;

@SpringBootApplication
//@EnableScheduling
public class Application  implements CommandLineRunner  {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class);
        System.out.println("hahah");
    }
    
	@Override
	public void run(String... strings) throws Exception {
		String url = "https://www.zhihu.com/question/39980813";
		String picPath = Spider.downloadPic(url);
		String articleContent = Util.getAllImageHtml(picPath);
		System.out.println("articleContent: " + articleContent);
		
		String resource = "Configuration.xml";
		// 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
		InputStream is = getClass().getClassLoader().getResourceAsStream(resource);
		// 构建sqlSession的工厂x
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		
		SqlSession session = sessionFactory.openSession();

		Article article = new Article();
		String articleId=UUID.randomUUID().toString().replaceAll("-", "");
		article.setId(articleId);
		article.setCategoryId("3");
		article.setKeywords("性感,美女,大胸");
		String [] childPath = picPath.split("/");
		String title = childPath[childPath.length-1];
		title = new String(title); 
		article.setTitle(childPath[childPath.length-1]);
		article.setDelFlag("0");
		article.setCreateBy("1");
		article.setCreateDate(new Date());
		article.setUpdateDate(new Date());
		
		ArticleData article_data = new ArticleData();
		article_data.setId(articleId);
		article_data.setContent(articleContent);
		ArticleMapper daoArticle =session.getMapper(ArticleMapper.class);
		daoArticle.insert(article);
		ArticleDataMapper dao2= session.getMapper(ArticleDataMapper.class);
		dao2.insert(article_data);
		session.commit();
	}
}
