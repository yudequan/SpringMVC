package spittr.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import spittr.web.WebConfig;

public class SpitterWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
	private static final Logger LOGGER = LogManager.getLogger(SpitterWebInitializer.class);
	
	@Override
	protected Class<?>[] getRootConfigClasses()
	{
		return new Class<?>[]
		{ RootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses()
	{
		return new Class<?>[]
		{ WebConfig.class };
	}

	@Override
	protected String[] getServletMappings()
	{
		return new String[]
		{ "/" };
	}

	@Override
	protected void customizeRegistration(Dynamic registration)
	{
		 String tempPath = System.getProperty("java.io.tmpdir");
		 LOGGER.debug("The upload temp path is {}.", tempPath);
		 registration.setMultipartConfig(new MultipartConfigElement(tempPath, 2097152, 4194304, 0));
	}

}