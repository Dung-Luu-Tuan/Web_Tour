package controllers;

import dao.PlaceDAO;
import dao.StaffDAO;
import models.Place;
import models.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class StaffController {
    @RequestMapping({"/staffList"})
    public ModelAndView listStaff() {
        ModelAndView modelAndView = new ModelAndView("staff_list");
        List<Staff> listStaff = StaffDAO.listStaff();
        modelAndView.addObject("staffs", listStaff);
        return modelAndView;
    }

    @RequestMapping({"/newStaff"})
    public String newStaff(Map<String, Object> model) {
        Staff staff = new Staff();
        model.put("staffAdd", staff);
        return "/new_staff";
    }

    @RequestMapping(value = "/saveNewStaff", method = RequestMethod.POST)
    public String saveStaff(@ModelAttribute("staffAdd") Staff staff) {
        StaffDAO.insert(staff);
        return "redirect:/staffList";
    }

    @RequestMapping("/editStaff")
    public ModelAndView editPlace(@RequestParam int id) {
        ModelAndView mav = new ModelAndView("edit_staff");
        Staff staff = StaffDAO.getStaffById(id);
        mav.addObject("staffEdit", staff);
        return mav;
    }

    @RequestMapping(value = "/updateStaff", method = RequestMethod.POST)
    public String updateStaff(@ModelAttribute("staffEdit") Staff staff) {
        StaffDAO.update(staff);
        return "redirect:/staffList";
    }

    @RequestMapping({"/deleteStaff/{id}"})
    public String deleteStaff(@PathVariable("id") int id) {
        StaffDAO.deleteById(id);
        return "redirect:/staffList";
    }
}
