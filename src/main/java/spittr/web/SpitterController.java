/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spittr.Spitter;
import spittr.data.SpitterRepository;

import javax.validation.Valid;

/**
 * Created by yudequan on 24/02/2017.
 */
@Controller
@RequestMapping("/spitter")
public class SpitterController
{
    @Autowired
    private SpitterRepository spitterRepository;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm()
    {
        return ViewName.REGISTER.getName();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(
            @Valid Spitter spitter,
            Errors errors)
    {
        if (errors.hasErrors())
        {
            return ViewName.REGISTER.getName();
        }

        spitterRepository.save(spitter);
        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(
            @PathVariable String username, Model model)
    {
        Spitter spitter = spitterRepository.findByUsername(username);
        model.addAttribute(spitter);
        return ViewName.PROFILE.getName();
    }
}
