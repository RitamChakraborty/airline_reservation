package com.cognizant.airline_ticket_reservation_system.service;

import com.cognizant.airline_ticket_reservation_system.dao.NewsFeedDao;
import com.cognizant.airline_ticket_reservation_system.model.NewsFeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsFeedService {
    private NewsFeedDao newsFeedDao;

    @Autowired
    public void setNewsFeedDao(NewsFeedDao newsFeedDao) {
        this.newsFeedDao = newsFeedDao;
    }

    public void saveNewsFeed(NewsFeed newsFeed) {
        newsFeedDao.save(newsFeed);
    }

    public List<NewsFeed> getNewsFeeds() {
        return (List<NewsFeed>) newsFeedDao.findAll();
    }
}
