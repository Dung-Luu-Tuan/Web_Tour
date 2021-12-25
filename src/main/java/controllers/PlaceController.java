package controllers;

import dao.PlaceDAO;
import models.Place;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class PlaceController {
    @RequestMapping({"/placeList"})
    public ModelAndView listPlace() {
        ModelAndView modelAndView = new ModelAndView("place_list");
        List<Place> listPlace = PlaceDAO.listPlace();
        modelAndView.addObject("places", listPlace);
        return modelAndView;
    }

    @RequestMapping({"/newPlace"})
    public String newPlace(Map<String, Object> model) {
        Place place = new Place();
        model.put("placeAdd", place);
        return "/new_place";
    }

    @RequestMapping(value = "/saveNewPlace", method = RequestMethod.POST)
    public String savePlace(@ModelAttribute("placeAdd") Place place) {
        PlaceDAO.insert(place);
        return "redirect:/placeList";
    }

    @RequestMapping("/editPlace")
    public ModelAndView editPlace(@RequestParam int id) {
        ModelAndView mav = new ModelAndView("edit_place");
        Place place = PlaceDAO.getPlaceById(id);
        mav.addObject("placeEdit", place);
        return mav;
    }

    @RequestMapping(value = "/updatePlace", method = RequestMethod.POST)
    public String updatePlace(@ModelAttribute("placeEdit") Place place) {
        PlaceDAO.update(place);
        return "redirect:/placeList";
    }

    @RequestMapping({"/deletePlace/{id}"})
    public String deletePlace(@PathVariable("id") int id) {
        PlaceDAO.deleteById(id);
        return "redirect:/placeList";
    }
}
