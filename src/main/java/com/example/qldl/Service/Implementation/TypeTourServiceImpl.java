package com.example.qldl.Service.Implementation;

import com.example.qldl.Entity.TypeTourE;
import com.example.qldl.Repository.TypeTourRepo;
import com.example.qldl.Service.TypeTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeTourServiceImpl implements TypeTourService {
    @Autowired
    private TypeTourRepo typeTourRepo;

    @Override
    public List<TypeTourE> getAllTypeTourE() { return typeTourRepo.findAll() ; }

    @Override
    public List<TypeTourE> getTypeTourEByTypeName(String type_id) { return typeTourRepo.findByType_Name(type_id);
    }
}
