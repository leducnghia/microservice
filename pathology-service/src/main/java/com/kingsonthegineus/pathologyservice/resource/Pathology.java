package com.kingsonthegineus.pathologyservice.resource;


import com.kingsonthegineus.pathologyservice.models.Disease;
import com.kingsonthegineus.pathologyservice.models.DiseasesList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/pathology")
public class Pathology {
    List<Disease> diseases = Arrays.asList(
            new Disease("D1", "Ashma", "Warm water batch"),
            new Disease("D2", "Thyphoid", "Ampicilin capsule"),
            new Disease("D3", "Beru", "Ampicilin capsule")
    );

    @RequestMapping("/diseases")
    public DiseasesList getDiseases() {
        DiseasesList diseasesList = new DiseasesList();
        diseasesList.setDiseases(diseases);
        return diseasesList;
    }

    @RequestMapping("/diseases/{Id}")
    public Disease getDiseaseById(@PathVariable("Id") String Id) {
        Disease d = diseases.stream()
                .filter(disease -> Id.equals(disease.getId()))
                .findAny()
                .orElse(null);
        return d;
    }
}
