package palma.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import palma.app.models.Condicion;
import palma.app.repository.CondicionRepository;

import palma.app.service.ICondicionService;


@Service
public class CondicionServiceImp implements ICondicionService {

    @Autowired
	private CondicionRepository condiRepo;

    @Override
    public List<Condicion> buscarTodas() {
        return condiRepo.findAll();
    }

    

}