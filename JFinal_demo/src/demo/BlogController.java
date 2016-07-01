package demo;

import com.jfinal.core.Controller;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年6月29日上午10:56:43
 * @version 1.0
 */
public class BlogController extends Controller {
	public void index() {
		renderText("BlogController.index()");
	}
}
