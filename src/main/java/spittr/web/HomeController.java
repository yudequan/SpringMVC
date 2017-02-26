package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yudequan on 22/02/2017.
 */
@Controller
@RequestMapping("/")
public class HomeController
{
    @RequestMapping(method = RequestMethod.GET)
    public String home()
    {
        return ViewName.HOME.getName();
    }
}
