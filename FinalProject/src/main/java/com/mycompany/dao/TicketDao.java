/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.exception.FlightException;
import com.mycompany.pojo.Ticket;
import com.mycompany.pojo.User;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author kanishk
 */
public class TicketDao extends DAO{
    public TicketDao(){}
    
    public Ticket get(Ticket ticket) throws FlightException {
        try {
            begin();
            Criteria crit = getSession().createCriteria(Ticket.class);
            crit.add(Restrictions.eq("PRN", ticket.getPNR()));
            
            Ticket checkTicket = (Ticket) crit.uniqueResult();
            commit();
            return checkTicket;

        } catch (HibernateException e) {
            rollback();
            throw new FlightException("Couldn't get flight: " + ticket.getPNR(), e);
        }
    }
    
        

    public Ticket create(Ticket ticket) throws FlightException {
        try {
            begin();
            getSession().save(ticket);
            commit();
            return ticket;
        } catch (HibernateException e) {
            rollback();
            throw new FlightException("Exception while creating Ticket:" + e.getMessage());
        }
    }

    public void delete(Ticket ticket)  throws FlightException {
        try {
            begin();
            getSession().delete(ticket);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new FlightException("Could not delete user " + ticket.getPNR(), e);
        }
    }
    
        public List<Ticket> getAll(User user) throws FlightException {
        List<Ticket> tickets = new ArrayList<Ticket>();
        try {
            begin();
            Criteria crit = getSession().createCriteria(Ticket.class);
                        crit.add(Restrictions.eq("email", user.getEmail()));

            tickets = crit.list();
            commit();
            return tickets;

        } catch (HibernateException e) {
            rollback();
            throw new FlightException("Couldn't get Bookings: ", e);
        }

    }
}
