package controllers;

import dao.CustomerDAO;
import dao.TourDAO;
import models.Customer;
import models.Tour;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class CustomerController {
    @RequestMapping({"/customerList"})
    public ModelAndView listCustomer() {
        ModelAndView modelAndView = new ModelAndView("customer_list");
        List<Customer> listCustomer = CustomerDAO.listCustomer();
        modelAndView.addObject("customers", listCustomer);
        return modelAndView;
    }

    @RequestMapping({"/newCustomer"})
    public String newCustomer(Map<String, Object> model) {
        Customer customer = new Customer();
        model.put("customerAdd", customer);
        return "/new_customer";
    }

    @RequestMapping(value = "/saveNewCustomer", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("customerAdd") Customer customer) {
        CustomerDAO.insert(customer);
        return "redirect:/customerList";
    }

    @RequestMapping("/editCustomer")
    public ModelAndView editCustomer(@RequestParam int id) {
        ModelAndView mav = new ModelAndView("edit_customer");
        Customer customer = CustomerDAO.getCustomerById(id);
        mav.addObject("customerEdit", customer);
        return mav;
    }

    @RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
    public String updateCustomer(@ModelAttribute("customerEdit") Customer customer) {
        CustomerDAO.update(customer);
        return "redirect:/customerList";
    }

    @RequestMapping({"/deleteCustomer/{id}"})
    public String deleteCustomer(@PathVariable("id") int id) {
        CustomerDAO.deleteById(id);
        return "redirect:/customerList";
    }
}
