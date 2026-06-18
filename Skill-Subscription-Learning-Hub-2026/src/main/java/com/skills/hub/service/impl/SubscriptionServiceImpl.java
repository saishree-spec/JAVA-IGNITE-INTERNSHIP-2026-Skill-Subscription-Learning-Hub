package com.skills.hub.service.impl;

import com.skills.hub.model.Subscription;
import com.skills.hub.repository.SubscriptionRepository;
import com.skills.hub.service.SubscriptionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subRepo;

    public SubscriptionServiceImpl(SubscriptionRepository subRepo) {
        this.subRepo = subRepo;
    }

    @Override
    public Subscription subscribe(Long userId, Long packId) {

        Subscription subscription = new Subscription();

        subscription.setStartDate(LocalDate.now());
        subscription.setEndDate(LocalDate.now().plusDays(30));
        subscription.setStatus("ACTIVE");

        return subRepo.save(subscription);
    }

    @Override
    public List<Subscription> getUserSubscriptions(Long userId) {

        return subRepo.findAll();
    }

    public SubscriptionRepository getSubRepo() {
        return subRepo;
    }
}