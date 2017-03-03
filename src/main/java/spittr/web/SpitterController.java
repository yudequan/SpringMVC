package spittr.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import spittr.Spitter;
import spittr.data.SpitterRepository;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

	private static final Logger LOGGER = LogManager.getLogger(SpitterController.class);
	
  private SpitterRepository spitterRepository;

  @Autowired
  public SpitterController(SpitterRepository spitterRepository) {
    this.spitterRepository = spitterRepository;
  }
  
//  @ModelAttribute
//  public Spitter spitter() {
//    return new Spitter();
//  }
  
  @RequestMapping(value="/register", method=GET)
  public String showRegistrationForm(Model model) {
    model.addAttribute(new Spitter());
    return "registerForm";
  }
  
  @RequestMapping(value="/register", method=POST)
  public String processRegistration(@RequestPart("profilePicture") MultipartFile profilePicture,
      @Valid Spitter spitter, 
      Errors errors, HttpServletRequest req) {
    if (errors.hasErrors()) {
      return "registerForm";
    }
    
    spitterRepository.save(spitter);
    
    String realPath = req.getServletContext().getRealPath("/");
    LOGGER.debug("The real path is {}.", realPath);
   
    String uploadPath = realPath + "WEB-INF/uploads/" +profilePicture.getOriginalFilename(); 
    LOGGER.debug("The upload path is {}.", uploadPath);
    
    File file = new File(uploadPath);
    try
	{
		profilePicture.transferTo(file);
	} catch (IllegalStateException e)
	{
		LOGGER.debug(e.getCause());
	} catch (IOException e)
	{
		LOGGER.debug(e.getCause());
	}
    return "redirect:/spitter/" + spitter.getUsername();
  }
  
  @RequestMapping(value="/{username}", method=GET)
  public String showSpitterProfile(@PathVariable String username, Model model) {
    Spitter spitter = spitterRepository.findByUsername(username);
    model.addAttribute(spitter);
    return "profile";
  }
  
}
