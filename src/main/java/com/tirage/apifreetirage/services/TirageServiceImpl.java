package com.tirage.apifreetirage.services;

import com.tirage.apifreetirage.modele.Tirage;
import com.tirage.apifreetirage.repository.TirageRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@AllArgsConstructor
public class TirageServiceImpl implements TirageService{

    public final TirageRepo tirageRepo;

    @Override
    public Tirage creer(@RequestBody Tirage tirage) {

        return tirageRepo.save(tirage);
    }
}
