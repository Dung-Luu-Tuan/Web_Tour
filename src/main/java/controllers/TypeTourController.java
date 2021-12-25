package controllers;

import dao.PlaceDAO;
import dao.TypeTourDAO;
import models.Place;
import models.TypeTour;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class TypeTourController {
    @RequestMapping({"/typeTourList"})
    public ModelAndView listTypeTour() {
        ModelAndView modelAndView = new ModelAndView("type_tour_list");
        List<TypeTour> typeTours = TypeTourDAO.listType();
        modelAndView.addObject("typeTours", typeTours);
        return modelAndView;
    }

    @RequestMapping({"/newTypeTour"})
    public String newTypeTOur(Map<String, Object> model) {
        TypeTour typeTour = new TypeTour();
        model.put("typeTourAdd", typeTour);
        return "/new_type_tour";
    }

    @RequestMapping(value = "/saveNewTypeTour", method = RequestMethod.POST)
    public String saveTypeTour(@ModelAttribute("typeTourAdd") TypeTour typeTour) {
        TypeTourDAO.insert(typeTour);
        return "redirect:/typeTourList";
    }

    @RequestMapping("/editTypeTour")
    public ModelAndView editTypeTour(@RequestParam int id) {
        ModelAndView mav = new ModelAndView("edit_type_tour");
        TypeTour typeTour = TypeTourDAO.getById(id);
        mav.addObject("typeTourEdit", typeTour);
        return mav;
    }

    @RequestMapping(value = "/updateTypeTour", method = RequestMethod.POST)
    public String updateTypeTour(@ModelAttribute("typeTourEdit") TypeTour typeTour) {
        TypeTourDAO.update(typeTour);
        return "redirect:/typeTourList";
    }

    @RequestMapping({"/deleteTypeTour/{id}"})
    public String deleteTypeTour(@PathVariable("id") int id) {
        TypeTour typeTour = TypeTourDAO.getById(id);
        TypeTourDAO.delete(typeTour);
        return "redirect:/typeTourList";
    }
}
