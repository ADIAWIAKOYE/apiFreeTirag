package com.tirage.apifreetirage.services;

import com.tirage.apifreetirage.modele.Tirage;
import com.tirage.apifreetirage.repository.TirageRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class TirageServiceImpl implements TirageService{

    public final TirageRepo tirageRepo;



    @Override
    public List<Object> creer(@RequestBody Tirage tirage, List<Object[]> listAtrier, Long nbre) {

        //création d'une variable random
        Random rand = new Random();
        List<Object> list = new ArrayList<>();
        for (int i = 0; i< nbre; i++)
        {
            Integer idAct = rand.nextInt(listAtrier.size());

            //while (idAct == 0 || list.contains(idAct)){
                //idAct = rand.nextInt(listAtrier.size());
            //}

            list.add(listAtrier.get(idAct));

            listAtrier.remove(listAtrier.get(idAct));
        }
        tirageRepo.save(tirage);
        return list;
    }

    @Override
    public Tirage trouverTirageParLibelle(String libelle) {
        return tirageRepo.findByLibellet(libelle);
    }

}
