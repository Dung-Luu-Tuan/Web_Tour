package controllers;

import dao.PlaceDAO;
import dao.TypeCostDAO;
import models.Place;
import models.TypeCost;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class TypeCostController {
    @RequestMapping({"/typeCostList"})
    public ModelAndView listPlace() {
        ModelAndView modelAndView = new ModelAndView("type_cost_list");
        List<TypeCost> typeCostList = TypeCostDAO.listTypeCost();
        modelAndView.addObject("typeCosts", typeCostList);
        return modelAndView;
    }

    @RequestMapping({"/newTypeCost"})
    public String newTypeCost(Map<String, Object> model) {
        TypeCost typeCost = new TypeCost();
        model.put("typeCostAdd", typeCost);
        return "/new_type_cost";
    }

    @RequestMapping(value = "/saveNewTypeCost", method = RequestMethod.POST)
    public String saveTypeCost(@ModelAttribute("typeCostAdd") TypeCost typeCost) {
        TypeCostDAO.insert(typeCost);
        return "redirect:/typeCostList";
    }

    @RequestMapping("/editTypeCost")
    public ModelAndView editTypeCost(@RequestParam int id) {
        ModelAndView mav = new ModelAndView("edit_type_cost");
        TypeCost typeCost = TypeCostDAO.getTypeCostById(id);
        mav.addObject("typeCostEdit", typeCost);
        return mav;
    }

    @RequestMapping(value = "/updateTypeCost", method = RequestMethod.POST)
    public String updateTypeCost(@ModelAttribute("typeCostEdit") TypeCost typeCost) {
        TypeCostDAO.update(typeCost);
        return "redirect:/typeCostList";
    }

    @RequestMapping({"/deleteTypeCost/{id}"})
    public String deleteTypeCost(@PathVariable("id") int id) {
        TypeCostDAO.deleteById(id);
        return "redirect:/typeCostList";
    }
}
