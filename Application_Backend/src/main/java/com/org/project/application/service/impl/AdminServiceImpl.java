package com.org.project.application.service.impl;

import com.org.project.application.dto.DtoAdmin;
import com.org.project.application.entity.Admin;
import com.org.project.application.repo.AdminRepository;
import com.org.project.application.service.custom.AdminService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{


    private final AdminRepository adminRepository;
    private final ModelMapper modelMapper;

    @Override
    public void save(DtoAdmin dtoAdmin) {
        if (dtoAdmin.getAdminID() == null) {
            dtoAdmin.setAdminID(getLastID());
        }
        adminRepository.save(modelMapper.map(dtoAdmin, Admin.class));
    }

    @Override
    public void update(DtoAdmin dtoAdmin) {
        if(adminRepository.existsById(dtoAdmin.getAdminID()))
            throw new RuntimeException();
        else {
            adminRepository.save(modelMapper.map(dtoAdmin,Admin.class));
        }
    }

    @Override
    public List<DtoAdmin> getAll() {
        List<DtoAdmin> dtoAdmins=new ArrayList<>();
        adminRepository.findAll().forEach(admin -> {
            dtoAdmins.add(modelMapper.map(admin,DtoAdmin.class));
        });
        return dtoAdmins;
    }


    @Override
    public void delete(String id) {
        adminRepository.deleteById(id);
    }

    @Override
    public DtoAdmin find(String id) {
        return modelMapper.map(adminRepository.findById(id),DtoAdmin.class);
    }

    @Override
    public String getLastID() {
        List<String> ids=adminRepository.getLastID();
        if (ids.get(0) == null) return "A001";
        int num = Integer.parseInt(ids.get(0) .substring(1));
        num++;
        return String.format("A%03d", num);
    }

    @Override
    public long getCount() {
        return  adminRepository.count();
    }

    @Override
    public boolean ifExit(String id) {
        return adminRepository.existsById(id);
    }
}
