package demo;

import com.jfinal.core.Controller;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年6月29日上午10:55:32
 * @version 1.0
 */
public class IndexController extends Controller {
	public void index() {
		renderText("IndexController.index()");
	}
}
