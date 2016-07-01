package config;

import bean.Brand;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;

import demo.HelloController;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年6月23日下午3:18:15
 * @version 1.0
 */
public class DemoConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		me.setDevMode(true);
	}

	@Override
	public void configHandler(Handlers arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configInterceptor(Interceptors arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configPlugin(Plugins me) {
		loadPropertyFile("config/jdbc.properties");
		System.out.println(getProperty("jdbc.driver"));
		C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty("jdbc.url"),
				getProperty("jdbc.username"), getProperty("jdbc.password"));
		c3p0Plugin.setDriverClass(getProperty("jdbc.driver"));
		me.add(c3p0Plugin);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		me.add(arp);
		arp.addMapping("brand", Brand.class);
	}

	@Override
	public void configRoute(Routes me) {
		me.add("/hello", HelloController.class);
		me.add(new FrontRoutes());
		me.add(new AdminRoutes());
	}
}
