package com.springboot.io.bean;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;

/*@Component*/
public class CustomizationBean implements EmbeddedServletContainerCustomizer {

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(9090);
	}

}
