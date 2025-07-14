package com.repository;

import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.model.Membership;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, String> {
    
    // Custom method to find memberships by benefit (contains)
    List<Membership> findByBenefitsContaining(String benefit);
    
    // Custom method to find memberships by type and access hours greater than
    List<Membership> findByMembershipTypeAndMonthlyAccessHoursGreaterThan(
            String membershipType, int monthlyAccessHours);
    
    // Custom query to get membership count by type
    @Query("SELECT m.membershipType, COUNT(m) FROM Membership m GROUP BY m.membershipType")
    List<Object[]> getMembershipCountByType();
}