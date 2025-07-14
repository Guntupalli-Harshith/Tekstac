package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exception.InvalidMembershipException;
import com.model.Membership;
import com.repository.MembershipRepository;

@Service
public class MembershipServiceImpl implements IMembershipService {
    
    @Autowired
    private MembershipRepository membershipRepo;

    @Override
    public Membership addMembership(Membership membership) {
        return membershipRepo.save(membership);
    }

    @Override
    public Membership viewMembershipById(String membershipId) throws InvalidMembershipException {
        Optional<Membership> membership = membershipRepo.findById(membershipId);
        if (membership.isPresent()) {
            return membership.get();
        } else {
            throw new InvalidMembershipException("Membership not found with ID: " + membershipId);
        }
    }
    
    @Override
    public List<Membership> viewMembershipsByBenefit(String benefit) {
        return membershipRepo.findByBenefitsContaining(benefit);
    }

    @Override
    public List<Membership> viewMembershipsByTypeAndAccessHours(String membershipType, int monthlyAccessHours) {
        return membershipRepo.findByMembershipTypeAndMonthlyAccessHoursGreaterThan(membershipType, monthlyAccessHours);
    }
    
    @Override
    public Map<String, Integer> getMembershipCountTypeWise() {
        List<Object[]> results = membershipRepo.getMembershipCountByType();
        Map<String, Integer> countMap = new HashMap<>();
        
        for (Object[] result : results) {
            String membershipType = (String) result[0];
            Long count = (Long) result[1];
            countMap.put(membershipType, count.intValue());
        }
        
        return countMap;
    }
}