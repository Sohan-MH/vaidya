package com.example.vaidya.service;

import com.example.vaidya.model.Doctor;
import com.example.vaidya.repo.DoctorRepo;
import com.example.vaidya.web.dto.DoctorRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService{
   @Autowired
   private DoctorRepo docRepo;

    public DoctorServiceImpl(DoctorRepo docRepo) {
       super();
        this.docRepo = docRepo;
    }

    @Override
    public Doctor save(DoctorRegistrationDto registrationDto){
//        Doctor doctor = new Doctor(registrationDto.getUserName(),registrationDto.getFull_Name(),Integer.toString(registrationDto.getAge()),(registrationDto.getDoc_Password()),registrationDto.getEmail(),registrationDto.getGovernment_Registration_Number(),registrationDto.getPhone_Number());
        Doctor doctor = new Doctor(registrationDto.getUserName(),registrationDto.getFull_Name(),registrationDto.getGovernment_Registration_Number(),registrationDto.getAge(),registrationDto.getEmail(),registrationDto.getPhone_Number(),registrationDto.getDoc_Password());

        //public Doctor(String userName, String full_Name, String government_Registration_Number, int age, String email, String phone_Number, String doc_Password)
        return docRepo.save(doctor);
    }

}
