package controllers;


import dao.*;
import models.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;
import java.awt.TrayIcon.MessageType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class TouristGroupController {
    List<Tour> tourList;

    @RequestMapping({"/touristGroupList"})
    public ModelAndView tourList() {
        ModelAndView modelAndView = new ModelAndView("tourist_group_list");
        List<TouristGroup> listTouristGroup = TouristGroupDAO.listTourGroup();
        modelAndView.addObject("touristGroups", listTouristGroup);
        return modelAndView;
    }

    @RequestMapping({"/newTouristGroup"})
    public String newTour(Map<String, Object> model) {
        tourList = TourDAO.listTour();
        TouristGroup touristGroup = new TouristGroup();
        model.put("touristGroupAdd", touristGroup);
        model.put("tours", tourList);
        return "/new_tourist_group";
    }

    @RequestMapping(value = "/saveNewTouristGroup", method = RequestMethod.POST)
    public String saveTour(@ModelAttribute("touristGroupAdd") TouristGroup touristGroup) {
        TouristGroupDAO.insert(touristGroup);
        return "redirect:/touristGroupList";
    }

    @RequestMapping(value = "getDetailTour/{id}", method = RequestMethod.GET)
    public ModelAndView getTourDetail(@PathVariable("id") int id, Map<String, Object> model) {
        try{
            ModelAndView modelAndView = new ModelAndView("new_tourist_group");
            tourList = TourDAO.listTour();
            TouristGroup touristGroup = new TouristGroup();
            model.put("touristGroupAdd", touristGroup);
            model.put("tours", tourList);
            Tour result = TourDAO.getDetail(id);
            modelAndView.addObject("tourPrices", result.getPrices());
            modelAndView.addObject("tourLocations", result.getPlaceOrders());
            return modelAndView;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "getDetailTour_Edit/{id}/{madoan}", method = RequestMethod.GET)
    public ModelAndView getTourDetailEdit(@PathVariable("id") int id, @PathVariable("madoan") int madoan, Map<String, Object> model) {
        ModelAndView modelAndView = new ModelAndView("edit_tourist_group");
        tourList = TourDAO.listTour();
        TouristGroup touristGroup = TouristGroupDAO.getTouristGroupById(madoan);
        model.put("tours", tourList);
        Tour result = TourDAO.getDetail(id);
        modelAndView.addObject("tourPrices", result.getPrices());
        modelAndView.addObject("tourLocations", result.getPlaceOrders());
        modelAndView.addObject("touristGroupEdit", touristGroup);
        return modelAndView;
    }

    @RequestMapping(value = "/getDetailTouristGroup/{id}", method = RequestMethod.GET)
    public ModelAndView getDetailTouristGroup(@PathVariable("id") int id, Map<String, Object> model) {
        ModelAndView mav = new ModelAndView("tourist_group_detail");
        DetailTourGroup detailTourGroup = new DetailTourGroup();
        DetailTourGroup detail = TouristGroupDetailDAO.getById(id);
        if (detail == null) {
            mav.addObject("touristDetail", detailTourGroup);
        } else {
            mav.addObject("touristDetail", detail);
        }
        float price = getPrice(id);
        model.put("price", price);
        model.put("cus_quantity", TouristGroupDAO.getDetails(id).getCustomerTour().size());
        model.put("revenue", TouristGroupDAO.getTouristGroupById(id).getDoanhthu());
        model.put("touristGroupId", id);
        return mav;
    }

    @RequestMapping(value = "/saveTouristGroupDetail", method = RequestMethod.POST)
    public String saveTouristGroupDetail(@ModelAttribute("touristDetail") DetailTourGroup detailTourGroup) {
        TouristGroupDetailDAO.insert(detailTourGroup);
        return "redirect:/touristGroupList";
    }

    @RequestMapping(value = "/updateTouristGroupDetail", method = RequestMethod.POST)
    public String updateTouristGroupDetail(@ModelAttribute("touristDetail") DetailTourGroup detailTourGroup) {
        TouristGroupDetailDAO.update(detailTourGroup);
        return "redirect:/touristGroupList";
    }

    @RequestMapping({"/deleteTouristGroup/{id}"})
    public String deleteTour(@PathVariable("id") int id) {
        TouristGroupDetailDAO.deleteById(id);
        return "redirect:/touristGroupList";
    }

    @RequestMapping("/editTouristGroup")
    public ModelAndView editTouristGroup(@RequestParam int id, Map<String, Object> model) {
        ModelAndView mav = new ModelAndView("edit_tourist_group");
        tourList = TourDAO.listTour();
        TouristGroup touristGroup = TouristGroupDAO.getTouristGroupById(id);
        mav.addObject("touristGroupEdit", touristGroup);
        model.put("tours", tourList);
        model.put("madoan", touristGroup.getMadoan());
        return mav;
    }

    @RequestMapping(value = "/updateTouristGroup", method = RequestMethod.POST)
    public String updateTouristGroup(@ModelAttribute("touristGroupEdit") TouristGroup touristGroup) {
        TouristGroupDAO.update(touristGroup);
        return "redirect:/touristGroupList";
    }

    @RequestMapping({"/touristGroupCustomer/{id}"})
    public ModelAndView touristGroupCustomer(@PathVariable("id") int id, Map<String, Object> model) {
        ModelAndView modelAndView = new ModelAndView("tourist_group_customer_list");
        List<CustomerTour> listCustomerTour;
        listCustomerTour = TouristGroupDAO.getDetails(id).getCustomerTour();
        List<Customer> CustomerInfo = new ArrayList<>();
        TouristGroup touristGroup = TouristGroupDAO.getTouristGroupById(id);

        for (CustomerTour c : listCustomerTour) {
            CustomerInfo.add(CustomerDAO.getCustomerById(c.getMakhachhang()));
        }
        modelAndView.addObject("touristGroupCustomer", CustomerInfo);
        model.put("idTourGroup", id);
        return modelAndView;
    }

    @RequestMapping({"/customerListAdd/{id}"})
    public ModelAndView listCustomer(Map<String, Object> model, @PathVariable("id") int id_tourGroup) {
        ModelAndView modelAndView = new ModelAndView("add_customer_tourist_group");
        List<Customer> listCustomer = CustomerDAO.listCustomer();
        modelAndView.addObject("customers", listCustomer);
        model.put("idTourGroup", id_tourGroup);
        return modelAndView;
    }

    @RequestMapping(value = "/AddCustomerTouristGroup/{is_tourGroup}/{id_cus}", method = RequestMethod.GET)
    public String AddTouristGroupDetail(@PathVariable("is_tourGroup") int id_tourGroup, @PathVariable("id_cus") int id_cus, Map<String, Object> model) throws AWTException {
        try {
            CustomerTour customerTour = new CustomerTour(id_tourGroup, id_cus);
            CustomerTourDAO.insertCustomerTour(customerTour);
            float revenue = setRevenue(id_tourGroup);
            TouristGroupDAO.update2(id_tourGroup, revenue);
            model.put("revenue", revenue);
            return "redirect:/touristGroupCustomer/{is_tourGroup}";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/customerListAdd/{is_tourGroup}";
        }
    }

    public static float setRevenue(int id){
        TouristGroup touristGroup = TouristGroupDAO.getTouristGroupById(id);
        Tour tour = TourDAO.getDetail(touristGroup.getMatour());
        int customer_quantity = touristGroup.getCustomerTour().size();
        Float price = null;
        for (TourPrice tourPrice : tour.getPrices()) {
            if (tourPrice.getDateStart().equals(touristGroup.getNgaykhoihanh())) {
                price = tourPrice.getThanhtien();
                break;
            }
        }
        float revenue = price*customer_quantity;
        touristGroup.setDoanhthu(revenue);

        return revenue;
    }

    public static float getPrice(int id){
        TouristGroup touristGroup = TouristGroupDAO.getTouristGroupById(id);
        Tour tour = TourDAO.getDetail(touristGroup.getMatour());
        Float price = null;
        for (TourPrice tourPrice : tour.getPrices()) {
            if (tourPrice.getDateStart().equals(touristGroup.getNgaykhoihanh())) {
                price = tourPrice.getThanhtien();
                break;
            }
        }
        return price;
    }


    @RequestMapping({"/deleteCustomerTouristGroup/{is_tourGroup}/{id_cus}"})
    public String deleteTour(@PathVariable("is_tourGroup") int is_tourGroup, @PathVariable("id_cus") int id_cus, Map<String, Object> model) {
        CustomerTour customerTour = new CustomerTour(is_tourGroup, id_cus);
        CustomerTourDAO.deleteCustomerTour(customerTour);
        float revenue = setRevenue(is_tourGroup);
        TouristGroupDAO.update2(is_tourGroup, revenue);
        model.put("revenue", revenue);
        return "redirect:/touristGroupCustomer/{is_tourGroup}";
    }

    @RequestMapping(value = "/staffAllocationList/{id}")
    public ModelAndView staffAllocationList(@PathVariable("id") int id, Map<String, Object> model) {
        ModelAndView modelAndView = new ModelAndView("tourist_group_staff");
        List<StaffAllocation> staffAllocations = TouristGroupDAO.getDetails(id).getStaffAllocations();
        modelAndView.addObject("touristStaff", staffAllocations);
        model.put("idTourGroup", id);
        return modelAndView;
    }

    @RequestMapping(value = "/newStaffAllocation/{id}")
    public String newStaffAllocation(Map<String, Object> model, @PathVariable("id") int id) {
        List<Staff> staffs = StaffDAO.listStaff();
        StaffAllocation staffAllocation = new StaffAllocation();
        model.put("staffAllocationAdd", staffAllocation);
        model.put("tours", tourList);
        model.put("staffs", staffs);
        model.put("idTourGroup", id);
        return "/new_staff_allocation";
    }

    @RequestMapping(value = "/saveNewStaffAllocation", method = RequestMethod.POST)
    public String saveNewStaffAllocation(@ModelAttribute("staffAllocationAdd") StaffAllocation staffAllocation) {
        StaffAllocationDAO.insert(staffAllocation);
        return "redirect:/staffAllocationList/" + staffAllocation.getMadoan();
    }

    @RequestMapping("/editStaffAllocation/{id_tourGroup}/{id_staff}/{nv}")
    public ModelAndView editStaffAllocation(Map<String, Object> model, @PathVariable("id_tourGroup") int id_tourGroup, @PathVariable("id_staff") int id_staff, @PathVariable("nv") String nv) {
        ModelAndView mav = new ModelAndView("edit_staff_allocation");
        List<Staff> staffs = StaffDAO.listStaff();
        StaffAllocation staffAllocation = new StaffAllocation(id_staff, id_tourGroup, nv);
        mav.addObject("staffAllocationEdit", staffAllocation);
        model.put("staffs", staffs);
        model.put("idTourGroup", id_tourGroup);
        return mav;
    }

    @RequestMapping(value = "/updateStaffAllocation", method = RequestMethod.POST)
    public String updateTour(@ModelAttribute("staffAllocationEdit") StaffAllocation staffAllocation) {
        StaffAllocationDAO.update(staffAllocation);
        return "redirect:/staffAllocationList/" + staffAllocation.getMadoan();
    }

    @RequestMapping({"/deleteCustomerTouristGroup/{id_tourGroup}/{id_staff}/{nv}"})
    public String deleteCustomerTouristGroup(Map<String, Object> model, @PathVariable("id_tourGroup") int id_tourGroup, @PathVariable("id_staff") int id_staff, @PathVariable("nv") String nv) {
        StaffAllocation staffAllocation = new StaffAllocation(id_staff, id_tourGroup, nv);
        StaffAllocationDAO.delete(staffAllocation);
        return "redirect:/staffAllocationList/" + staffAllocation.getMadoan();
    }


    @RequestMapping(value = "/costList/{id}")
    public ModelAndView costList(@PathVariable("id") int id, Map<String, Object> model) {
        ModelAndView modelAndView = new ModelAndView("tourist_group_cost");
        List<Cost> costs = TouristGroupDAO.getDetails(id).getCosts();
        modelAndView.addObject("costs", costs);
        model.put("idTourGroup", id);
        return modelAndView;
    }

    @RequestMapping(value = "/newCostTouristGroup/{id}")
    public String newCostTouristGroup(Map<String, Object> model, @PathVariable("id") int id) {
        List<TypeCost> typeCosts = TypeCostDAO.listTypeCost();
        Cost cost = new Cost();
        model.put("costAdd", cost);
        model.put("typeCosts", typeCosts);
        model.put("idTourGroup", id);
        return "/new_cost";
    }

    @RequestMapping(value = "/saveCostTouristGroup", method = RequestMethod.POST)
    public String saveCostTouristGroup(@ModelAttribute("costAdd") Cost cost) {
        CostDAO.insert(cost);
        return "redirect:/costList/" + cost.getMadoan();
    }

    @RequestMapping("/editCost/{id_cost}")
    public ModelAndView editCost(Map<String, Object> model, @PathVariable("id_cost") int id_cost) {
        ModelAndView mav = new ModelAndView("edit_cost");
        List<TypeCost> typeCosts = TypeCostDAO.listTypeCost();
        Cost cost = CostDAO.getById(id_cost);
        mav.addObject("costEdit", cost);
        model.put("typeCosts", typeCosts);
        return mav;
    }

    @RequestMapping(value = "/updateCost", method = RequestMethod.POST)
    public String updateCost(@ModelAttribute("costEdit") Cost cost) {
        CostDAO.update(cost);
        return "redirect:/costList/" + cost.getMadoan();
    }

    @RequestMapping({"/deleteCost/{id_cost}"})
    public String deleteCost(@PathVariable("id_cost") int id_cost) {
        Cost cost = CostDAO.getById(id_cost);
        CostDAO.delete(cost);
        return "redirect:/costList/" + cost.getMadoan();
    }
}
