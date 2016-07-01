package config;

import com.jfinal.config.Routes;

import demo.AdminController;
import demo.UserController;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年6月29日上午10:51:54
 * @version 1.0
 */
public class AdminRoutes extends Routes {

	@Override
	public void config() {
		add("/admin", AdminController.class);
		add("/admin/user", UserController.class);
	}

}
