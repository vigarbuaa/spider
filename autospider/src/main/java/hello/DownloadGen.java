package hello;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.vigar.method.Spider;
import com.vigar.method.Util;


/**
 * 主函数
 * 功能1：抓取知乎指定问题下的图片并下载 
	    生成发布于cms上的html模式
 * 选用任意一个方法，只需将url匹配到当前方法就行
 * 
 * @author vigarbuaa
 *
 */

//<p><img alt="" src="/jeesite/userfiles/1/images/cms/article/2016/03/largmme.jpg" style="width: 517px; height: 640px;" /></p>
public class DownloadGen {

//	public static void main(String[] args) throws Exception {
//		
//		//定义你要抓取页面的url，格式参照下文
//		//当前url对应方法一
//		String url = "https://www.zhihu.com/question/22212644";  //胸大配衣服
////		String url ="https://www.zhihu.com/question/29470294";
////		String url = "https://www.zhihu.com/question/39980813";
//	
//		String picPath = Spider.downloadPic(url);
////		String picPath ="C:/知乎爬虫/胸大怎么搭配衣服？";
////		String picPath ="C:/知乎爬虫/胸大是怎样一种体验？/mm";
//		
////		System.out.println(imgTemplate);
////				+ " style="width: #width#px; height: "height"px;" /></p>";
//		String articleContent = Util.getAllImageHtml(picPath);
//		System.out.println("articleContent: " + articleContent);
//		
//	}
}
