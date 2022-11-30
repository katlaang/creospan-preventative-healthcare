package com.health.preventivehealth.service;

import com.health.preventivehealth.model.*;
import com.health.preventivehealth.repository.ClinicRepository;
import com.health.preventivehealth.repository.HospitalRepository;
import com.health.preventivehealth.repository.LabRepository;
import com.health.preventivehealth.repository.PharmacyRepository;
import com.health.preventivehealth.utility.ServiceProviderType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceProviderService {
    @Autowired
    private HospitalRepository hospitalRepository;
    @Autowired
    private LabRepository labRepository;
    @Autowired
    private ClinicRepository clinicRepository;
    @Autowired
    private PharmacyRepository pharmacyRepository;

    public List<? extends ServiceProvider> getAllServiceProvider(ServiceProviderType type){
        List<? extends ServiceProvider> serviceProviders = null;
        switch (type) {
            case HOSPITAL: {
                serviceProviders = hospitalRepository.findAll();
                break;
            }
            case LAB: {
                serviceProviders = labRepository.findAll();
                break;
            }
            case CLINIC: {
                serviceProviders = clinicRepository.findAll();
                break;
            }
            case PHARMACY: {
                serviceProviders = pharmacyRepository.findAll();
                break;
            }
            default: {
                //Does nothing
            }
        }
        return serviceProviders;
    }

    public ServiceProvider saveServiceProvider(ServiceProvider serviceProvider){
       ServiceProvider savedServiceProvider = null;
       switch (serviceProvider.getServiceProviderType()){
           case HOSPITAL: {
               Hospital hospital = new Hospital(serviceProvider.getName(), serviceProvider.getEmail(),
                       serviceProvider.getPhone(), serviceProvider.getServiceProviderType(), serviceProvider.getAddress());
               if(serviceProvider.getId() != null)
                   hospital.setId(serviceProvider.getId());
               savedServiceProvider = hospitalRepository.save(hospital);
               break;
           }
           case LAB: {
               Lab lab = new Lab(serviceProvider.getName(), serviceProvider.getEmail(),
                       serviceProvider.getPhone(), serviceProvider.getServiceProviderType(), serviceProvider.getAddress());
               if(serviceProvider.getId() != null)
                   lab.setId(serviceProvider.getId());
               savedServiceProvider = labRepository.save(lab);
               break;
           }
           case CLINIC: {
               Clinic clinic = new Clinic(serviceProvider.getName(), serviceProvider.getEmail(),
                       serviceProvider.getPhone(), serviceProvider.getServiceProviderType(), serviceProvider.getAddress());
               if(serviceProvider.getId() != null)
                   clinic.setId(serviceProvider.getId());
               savedServiceProvider = clinicRepository.save(clinic);
               break;
           }
           case PHARMACY: {
               Pharmacy pharmacy = new Pharmacy(serviceProvider.getName(), serviceProvider.getEmail(),
                       serviceProvider.getPhone(), serviceProvider.getServiceProviderType(), serviceProvider.getAddress());
               if(serviceProvider.getId() != null)
                   pharmacy.setId(serviceProvider.getId());
               savedServiceProvider = pharmacyRepository.save(pharmacy);
               break;
           }
           default: {
               //Does nothing
           }
       }
       return savedServiceProvider;
    }

    public Optional<? extends ServiceProvider> findServiceProvider(Long id, ServiceProviderType serviceProviderType){
        Optional<? extends ServiceProvider> serviceProvider = null;
        switch (serviceProviderType){
            case HOSPITAL: {
                serviceProvider = hospitalRepository.findById(id);
                break;
            }
            case LAB: {
                serviceProvider = labRepository.findById(id);
                break;
            }
            case CLINIC: {
                serviceProvider = clinicRepository.findById(id);
                break;
            }
            case PHARMACY: {
                serviceProvider = pharmacyRepository.findById(id);
                break;
            }
            default: {
                //Does nothing
            }
        }
        return serviceProvider;
    }

    public void deleteServiceProvider(Long id, ServiceProviderType serviceProviderType){
        switch (serviceProviderType){
            case HOSPITAL: {
                hospitalRepository.deleteById(id);
                break;
            }
            case LAB: {
                labRepository.deleteById(id);
                break;
            }
            case CLINIC: {
                clinicRepository.deleteById(id);
                break;
            }
            case PHARMACY: {
                pharmacyRepository.deleteById(id);
                break;
            }
            default: {
                //Does nothing
            }
        }
    }
}
