package com.siping.hrip;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.Ordered;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.stroma.framework.core.platform.intercept.TokenInteceptor;
import org.stroma.framework.core.platform.web.freemarker.view.DefaultFreemarkerViewResolver;
import org.stroma.framework.core.util.I18nUtil;

import com.siping.domain.interceptor.LoginInterceptor;
import com.siping.hrip.common.freemarker.IntranetFreemarkerView;

@Configuration
public class WebConfig extends SiteConfig {

    @Override
    public DefaultFreemarkerViewResolver freeMarkerViewResolver() {
        DefaultFreemarkerViewResolver resolver = super.freeMarkerViewResolver();
        resolver.setOrder(0);
        resolver.setViewClass(IntranetFreemarkerView.class);
        return resolver;
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public I18nUtil i18nUtil() {
        return new I18nUtil();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // add memcache support.
        registry.addInterceptor(requestContextInterceptor());
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        registry.addViewController("/").setViewName("forward:/jobs");
    }

    @Override
    public void addBusinessInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor());
        registry.addInterceptor(tokenInteceptor());
    }

    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    @Bean
    public TokenInteceptor tokenInteceptor() {
        return new TokenInteceptor();
    }
}
