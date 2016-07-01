package config;

import com.jfinal.config.Routes;

import demo.BlogController;
import demo.IndexController;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年6月29日上午10:51:54
 * @version 1.0
 */
public class FrontRoutes extends Routes {

	@Override
	public void config() {
		add("/", IndexController.class);
		add("/blog", BlogController.class);
	}

}
