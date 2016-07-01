package demo;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年6月23日下午3:20:50
 * @version 1.0
 */
public class HelloController extends Controller {
	public void index() {
		renderText("Hello JFinal World.");
	}

	public void add() {
		renderText("添加页面。第一个参数：" + getPara(0) + "   第二个参数：" + getPara(1));
	}

	@ActionKey("/edit/123-ddd")
	public void edit1() {
		renderText("使用@Actionkey注解d" + getPara(0) + "  " + getPara(1));
	}

	@ActionKey("/edit")
	public void edit() {
		renderText("使用@Actionkey注解ddd" + getPara(0) + "  " + getPara(1));
	}

	public void renderHtml() {
		render("/test1.html");
	}

	public void add1() {
		Record record = new Record();
		record.set("brand_name", "Jfinal测试");
		Db.save("brand", record);
		renderText("成功。");
	}
}
