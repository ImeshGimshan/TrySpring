package org.cyklon.tryoutspringboot.Controller;

import jakarta.validation.Valid;
import org.cyklon.tryoutspringboot.DTO.GRNDTO;
import org.cyklon.tryoutspringboot.Service.GRNService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grn")
public class GRNController{
    private final GRNService grnService;

    public GRNController(GRNService grnService) {
        this.grnService = grnService;
    }

    @PostMapping
    public GRNDTO createGrn (@Valid @RequestBody GRNDTO grndto){
        return grnService.createGRN(grndto);
    }

    @GetMapping
    public List<GRNDTO> getAllGRN (){
        return grnService.getAllGRN();
    }

    @GetMapping("/{id}")
    public GRNDTO getGRNById (@PathVariable Long id){
        return grnService.getGRNById(id);
    }

    @PutMapping("/{id}")
    public GRNDTO updateGRN (@PathVariable Long id, @Valid @RequestBody GRNDTO grndto){
        return grnService.updateGRN(id, grndto);
    }

    @DeleteMapping("/{id}")
    public void deleteGRN (@PathVariable Long id){
        grnService.deleteGRN(id);
    }
}