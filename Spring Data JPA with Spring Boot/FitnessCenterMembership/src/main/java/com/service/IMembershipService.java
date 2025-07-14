package com.service;

import java.util.List;
import java.util.Map;
import com.exception.InvalidMembershipException;
import com.model.Membership;

public interface IMembershipService {
    
    public Membership addMembership(Membership membership);
    public Membership viewMembershipById(String membershipId) throws InvalidMembershipException;
    public List<Membership> viewMembershipsByBenefit(String benefit);
    public List<Membership> viewMembershipsByTypeAndAccessHours(String membershipType, int monthlyAccessHours);
    public Map<String, Integer> getMembershipCountTypeWise();
}