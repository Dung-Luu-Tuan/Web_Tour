package controllers;

import dao.*;
import models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Controller
public class TourListController {
    List<PlaceOrder> tourLocations = new ArrayList<>();
    List<TourPrice> tourPrices = new ArrayList<>();
    PlaceOrder location_old;

    @RequestMapping("/tourList")
    public ModelAndView tourList() {
        ModelAndView modelAndView = new ModelAndView("tourList");
        List<Tour> listTour = TourDAO.listTour();
        modelAndView.addObject("tours", listTour);
        return modelAndView;
    }

    @RequestMapping(value = "/getTourDetail/{id}", method = RequestMethod.GET)
    public ModelAndView getTourDetail(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("tourDetail");
        Tour result = TourDAO.getDetail(id);
        List<Tour> tourList = new ArrayList<>();
        tourPrices = result.getPrices();
        tourLocations = result.getPlaceOrders();
        tourLocations.sort(Comparator.comparing(PlaceOrder::getThutu));
        tourList.add(result);
        modelAndView.addObject("tourDetail", tourList);
        modelAndView.addObject("tourPrices", tourPrices);
        modelAndView.addObject("tourLocations", tourLocations);
        modelAndView.addObject("idTour", tourList.get(0).getMatour());
        return modelAndView;
    }

    @RequestMapping({"/newTour"})
    public String newTour(Map<String, Object> model) {
        List<TypeTour> typeTours = TypeTourDAO.listType();
        Tour tour = new Tour();
        model.put("tourAdd", tour);
        model.put("typeTours", typeTours);
        return "/new_tour";
    }

    @RequestMapping(value = "/saveNewTour", method = RequestMethod.POST)
    public String saveTour(@ModelAttribute("tourAdd") Tour tour) {
        TourDAO.insert(tour);
        return "redirect:/tourList";
    }

    @RequestMapping("/editTour")
    public ModelAndView editTour(@RequestParam int id) {
        ModelAndView mav = new ModelAndView("edit_tour");
        Tour tour = TourDAO.getTourById(id);
        mav.addObject("tourEdit", tour);
        return mav;
    }

    @RequestMapping(value = "/updateTour", method = RequestMethod.POST)
    public String updateTour(@ModelAttribute("tourEdit") Tour tour) {
        TourDAO.update(tour);
        return "redirect:/tourList";
    }

    @RequestMapping({"/deleteTour/{id}"})
    public String deleteTour(@PathVariable("id") int id) {
        TourDAO.deleteById(id);
        return "redirect:/tourList";
    }

    @RequestMapping("/newLocationTour")
    public String newLocationTour(Map<String, Object> model, @RequestParam int id) {
        PlaceOrder locationTour = new PlaceOrder();
        model.put("locationAdd", locationTour);
        model.put("locationTour", id);
        model.put("sizeListLocation", tourLocations.size() + 1);
        List<Place> places = PlaceDAO.listPlace();
        model.put("places", places);
        return "/new_location_tour";
    }

    @RequestMapping(value = "/deleteTourLocation/{id_tour}/{id_location}/{stt}")
    public String deletePlaceForm(@PathVariable("id_tour") int id_tour, @PathVariable("id_location") int id_location, @PathVariable("stt") int stt) {
        PlaceOrder location = new PlaceOrder(id_tour, id_location, stt);
        LocationDAO.delete(location);
        return "redirect:/getTourDetail/" + id_tour;
    }

    @RequestMapping("/editTourLocation/{id_tour}/{id_location}/{stt}")
    public ModelAndView editTourLocation(Map<String, Object> model, @PathVariable("id_tour") int id_tour, @PathVariable("id_location") int id_location, @PathVariable("stt") int stt) {
        ModelAndView mav = new ModelAndView("edit_location_tour");
        PlaceOrder location = new PlaceOrder(id_tour, id_location, stt);
        location_old = location;
        mav.addObject("locationTourEdit", location);
        List<Place> places = PlaceDAO.listPlace();
        model.put("places", places);
        return mav;
    }

    @RequestMapping(value = "/updateTourLocation", method = RequestMethod.POST)
    public String updateTour(@ModelAttribute("locationTourEdit") PlaceOrder location) {
        LocationDAO.update(location);
        LocationDAO.delete(location_old);
        return "redirect:/getTourDetail/" + location.getMatour();
    }


    @RequestMapping("/newPriceTour")
    public String newPriceTour(Map<String, Object> model, @RequestParam int id) {
        TourPrice priceTour = new TourPrice();
        model.put("priceAdd", priceTour);
        model.put("idTour", id);
        return "/new_price";
    }

    @RequestMapping(value = "/saveNewLocationTour", method = RequestMethod.POST)
    public String saveLocation(@ModelAttribute("locationAdd") PlaceOrder placeOrder) {
        LocationDAO.insert(placeOrder);
        return "redirect:/getTourDetail/" + placeOrder.getMatour();
    }

    @RequestMapping(value = "/saveNewPriceTour", method = RequestMethod.POST)
    public String saveNewPriceTour(@ModelAttribute("priceAdd") TourPrice priceTour) {
        PriceDAO.insert(priceTour);
        return "redirect:/getTourDetail/" + priceTour.getMatour();
    }

    @RequestMapping({"/deleteTourPrice/{id}/{id_tour}"})
    public String deleteTourPrice(@PathVariable("id") int id, @PathVariable("id_tour") int id_tour) {
        PriceDAO.deleteById(id);
        return "redirect:/getTourDetail/" + id_tour;
    }

    @RequestMapping("/editPrice/{id_price}/{id_tour}")
    public ModelAndView editPrice(@PathVariable("id_price") int id_price, @PathVariable("id_tour") int id_tour, Map<String, Object> model) {
        ModelAndView mav = new ModelAndView("edit_price");
        TourPrice price = PriceDAO.getPriceByid(id_price);
        mav.addObject("priceEdit", price);
        model.put("idTour", id_tour);
        return mav;
    }

    @RequestMapping(value = "/updatePrice", method = RequestMethod.POST)
    public String updateTour(@ModelAttribute("priceEdit") TourPrice price) {
        PriceDAO.update(price);
        return "redirect:/getTourDetail/" + price.getMatour();
    }
}
