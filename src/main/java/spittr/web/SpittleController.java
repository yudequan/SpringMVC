package spittr.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spittr.Spittle;
import spittr.data.SpittleRepository;

import java.util.List;

/**
 * Created by yudequan on 23/02/2017.
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController
{
    private static final Logger LOGGER = LogManager.getLogger(SpittleController.class);

    private static final String MAX_LONG_AS_STRING = "9223372036854775807";

    private static final String DEFAULT_COUNT_AS_String = "20";

    @Autowired
    private SpittleRepository spittleRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
                                  @RequestParam(value = "count", defaultValue = DEFAULT_COUNT_AS_String) int count)
    {
        LOGGER.debug("max value : {}", max);
        LOGGER.debug("count value : {}", count);
        return this.spittleRepository.findSpittles(max, count);
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showSpittle(@RequestParam("spittleId") long spittleId, Model model)
    {
        LOGGER.debug("spittleId value : {}", spittleId);
        model.addAttribute(spittleRepository.findOne(spittleId));
        return ViewName.SPITTLE.getName();
    }

    @RequestMapping(value ="/{spittleId}", method = RequestMethod.GET)
    public String spittle(@PathVariable long spittleId, Model model)
    {
        LOGGER.debug("spittleId value : {}", spittleId);
        model.addAttribute(spittleRepository.findOne(spittleId));
        return ViewName.SPITTLE.getName();
    }
}
