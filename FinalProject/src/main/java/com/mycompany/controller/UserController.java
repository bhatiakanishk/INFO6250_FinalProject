/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.dao.TicketDao;
import com.mycompany.dao.UserDao;
import com.mycompany.exception.FlightException;
import com.mycompany.pojo.Ticket;
import com.mycompany.pojo.User;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kanishk
 */
@Controller
@SessionAttributes("userLogin")
public class UserController {

    Random rand;
    Date date = new Date();

    // Login Page
    @GetMapping("userLogin.htm")
    public String showLoginForm(ModelMap model, User user) {
        model.addAttribute("user", user);
        return "loginPage";
    }

    // Open user pages if user is verified
    @PostMapping("userLogin.htm")
    public ModelAndView handleLogin(@ModelAttribute("user") User user, BindingResult result, SessionStatus status, UserDao userdao, HttpSession session) throws FlightException {

        if (result.hasErrors()) {
            ModelAndView model = new ModelAndView("register");
            return model;
        } else {
            // Show Usser Welcome Page if user is valid
            User retrievedUser = userdao.get(user);
            System.out.println(retrievedUser);
            if (retrievedUser != null) {
                session.setAttribute("user", retrievedUser);
                status.setComplete(); //Mark it complete
                ModelAndView model = new ModelAndView("userWelcome");
                model.setViewName("redirect:userWelcome.htm");
                return model;
                // Show error page
            } else {
                ModelAndView model = new ModelAndView("error");
                return model;
            }
        }
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public String redirect() {

        return "redirect:userWelcome";
    }

    @RequestMapping(value = "/userWelcome", method = RequestMethod.GET)
    public String userWelcome() {

        return "userWelcome";
    }

    @GetMapping("userRegister.htm")
    public String showRegistrationForm(ModelMap model) {
        User user = new User(); // FormBackingObject
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("userRegister.htm")
    public String handleRegistrationForm(ModelMap model, @ModelAttribute("user") User user, BindingResult result, SessionStatus status, UserDao userdao) throws FlightException {
        if (result.hasErrors()) {
            return "register";
        } else {
            User alreadyUser = userdao.get(user);

            if (alreadyUser == null) {
                if (user.getAge() <= 0 && user.getContactNo() <= 99999999) {
                    return "registerError";
                }
                userdao.create(user);
                status.setComplete();
                return "addedUser";
            } else {
                model.addAttribute("user", alreadyUser);
                return "registerError";
            }

        }
    }

    // Logout 
    @RequestMapping("logout.htm")
    public ModelAndView getLogout(HttpSession session) {
        session.invalidate();
        ModelAndView model = new ModelAndView("redirect:/");
        return model;
    }

    @GetMapping("bookTicket.htm")
    public String showAdminFlightForm(ModelMap model, Ticket ticket) {

        model.addAttribute("ticket", ticket);
        return "bookTicket";
    }

    @PostMapping("bookTicket.htm")
    public String handleCreateFlightForm(ModelMap model, @ModelAttribute("ticket") Ticket ticket, BindingResult result, SessionStatus status, TicketDao ticketDao) throws FlightException {

        if (result.hasErrors()) {
            return "bookTicket";
        } else if (ticket.getTravel_date().before(date)) {
            return "flightError";
        } else {
            int num = (int) System.currentTimeMillis();
            ticket.setPNR(Math.abs(num));
            ticket.setDate(date);
            Ticket alreadyTicket = ticketDao.get(ticket);

            if (alreadyTicket == null) {
                ticketDao.create(ticket);
                status.setComplete();
                return "flightDataAdded";
            } else {
                model.addAttribute("flight", alreadyTicket);
                return "flightError";
            }
        }
    }

    @GetMapping("closeAccount.htm")
    public String showDeleteUser(ModelMap model, User user) {

        model.addAttribute("user", user);
        return "closeUser";
    }

    @PostMapping("closeAccount.htm")
    public String handleDeleteUser(ModelMap model, @ModelAttribute("user") User user, BindingResult result, SessionStatus status, UserDao userDao) throws FlightException {
        if (result.hasErrors()) {
            return "closeUser";
        } else {
            User alreadyUser = userDao.getforDelete(user);
            if (alreadyUser != null) {
                userDao.delete(alreadyUser);
                status.setComplete();
                return "deleteUserSuccess";
            } else {
                model.addAttribute("flight", alreadyUser);
                return "flightError";
            }
        }
    }

    @GetMapping("deleteTicket.htm")
    public String deleteUserTicketForm(ModelMap model, Ticket ticket) {

        model.addAttribute("ticket", ticket);
        return "deleteTicket";
    }

    @PostMapping("deleteTicket.htm")
    public String handleDeleteAdminUsersForm(ModelMap model, @ModelAttribute("ticket") Ticket ticket, BindingResult result, SessionStatus status, TicketDao ticketDao) throws FlightException {
        if (result.hasErrors()) {
            return "deleteTicket";
        } else {
            Ticket alreadyTicket = ticketDao.get(ticket);
            if (alreadyTicket != null) {
                ticketDao.delete(alreadyTicket);
                status.setComplete();
                return "deleteTicketSuccess";
            } else {
                model.addAttribute("flight", alreadyTicket);
                return "flightError";
            }
        }
    }

    @GetMapping("updateUser1.htm")
    public String updateAdminUsersForm(ModelMap model, User user) {

        model.addAttribute("user", user);
        return "editUserData_1";
    }

    @PostMapping("updateUser1.htm")
    public String handleEditAdminUserForm(ModelMap model, @ModelAttribute("user") User user, BindingResult result, SessionStatus status, UserDao userDao) throws FlightException {
        if (result.hasErrors()) {
            return "editUserData_1";
        } else {

            User alreadyUser = userDao.getforDelete(user);
            if (alreadyUser != null) {
                userDao.delete(alreadyUser);
                userDao.create(user);
                status.setComplete();
                return "updateUserSuccess";
            } else {
                model.addAttribute("user", alreadyUser);
                return "userError";
            }
        }

    }

    @GetMapping("viewAllBookings.htm")
    public String showUserInformation(HttpServletRequest request, TicketDao ticketDao, HttpSession session) throws FlightException {
        List<Ticket> ticketList = ticketDao.getAll((User) (session.getAttribute("user")));
        request.setAttribute("ticketList", ticketList);
        return "viewBookingData";
    }

}
