package cz.czechitas.java2webapps.lekce6.controller.cokolada;

import cz.czechitas.java2webapps.lekce6.controller.alkohol.AlkoholForm;
import cz.czechitas.java2webapps.lekce6.controller.cokolada.CokoladaForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

/**
 *
 */
@Controller
@RequestMapping("/cokolada")
public class CokoladaController {

  private final Random random = new Random();

  @GetMapping("")
  public ModelAndView index() {
    ModelAndView modelAndView = new ModelAndView("/cokolada/formular");
    modelAndView.addObject("form", new CokoladaForm());
    return modelAndView;
  }

  @PostMapping("") // @valid abzsme rekli springu, ze to ma validovat
  public Object form(@Valid @ModelAttribute("form") AlkoholForm form, BindingResult bindingResult) {
    // binding results do toho nam spring doplni jak to dopadlo s tou validaci

/*
    if (form.getVek() < 18) {
      return "/alkohol/nizky-vek";
    }
*/

    if (bindingResult.hasErrors()) {
      System.out.println(bindingResult.hasErrors());
      System.out.println("dkfjdkfd");
      return "/cokolada/formular";
    }
    System.out.println("aaaaa");
    return new ModelAndView("/cokolada/objednano")
            .addObject("kod", Math.abs(random.nextInt()))
            .addObject("email", form.getEmail());
  }
}