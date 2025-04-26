package org.cyklon.tryoutspringboot.Service;

import org.cyklon.tryoutspringboot.DTO.GRNDTO;
import org.cyklon.tryoutspringboot.Mapper.GRNMapper;
import org.cyklon.tryoutspringboot.Model.GRN;
import org.cyklon.tryoutspringboot.Repository.GRNRepository;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GRNService{
    @Autowired
    private GRNRepository grnRepository;

    @Autowired
    private GRNMapper grnMapper;

    public GRNDTO createGRN(GRNDTO grnDTO) {
        return grnMapper.toDTO(grnRepository.save(grnMapper.toEntity(grnDTO)));
    }

    public List<GRNDTO> getAllGRN() {
        return grnRepository.findAll().stream()
                .map(grnMapper::toDTO)
                .collect(Collectors.toList());
    }

    public GRNDTO getGRNById (long id){
        return grnMapper.toDTO(grnRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("GRN not found")));
    }

    public GRNDTO updateGRN (Long id , GRNDTO grndto){
        GRN grn = grnRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("GRN not found"));
        grn.setReceivedDate(grndto.getReceivedDate());
        grn.setSupplier(grnMapper.toEntity(grndto).getSupplier());
        return grnMapper.toDTO(grnRepository.save(grn));
    }

    public void deleteGRN (Long id){
        grnRepository.deleteById(id);
    }
}