package spittr.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by yudequan on 22/02/2017.
 */
@Configuration
@ComponentScan(basePackages = {"spittr"}, excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value =
        EnableWebMvc.class)})
public class RootConfig
{
}
