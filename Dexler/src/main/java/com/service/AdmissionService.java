package com.service;

import org.springframework.stereotype.Service;
import com.model.Admission;

@Service
public class AdmissionService {

    public double calculateProgramFee(Admission admission) {
        switch (admission.getProgramName()) {
            case "Play Group": return 600;
            case "Nursery": return 800;
            case "Euro Junior": return 1000;
            case "Euro Senior": return 1200;
            default: return 0;
        }
    }
}