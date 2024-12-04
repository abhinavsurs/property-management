package PropertyManagementSystem.Orielly_property_management_system.service.impl;

import PropertyManagementSystem.Orielly_property_management_system.converter.PropertyConverter;
import PropertyManagementSystem.Orielly_property_management_system.dto.PropertyDTO;
import PropertyManagementSystem.Orielly_property_management_system.entity.PropertyEntity;
import PropertyManagementSystem.Orielly_property_management_system.repository.PropertyRepository;
import PropertyManagementSystem.Orielly_property_management_system.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    PropertyRepository propertyRepository;
    @Autowired
    PropertyConverter propertyConverter;
    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

        PropertyEntity pe = propertyConverter.convertDTOtoEntity(propertyDTO);
        propertyRepository.save(pe);

        PropertyDTO dto = propertyConverter.convertEntitytoDTO(pe);
        return dto;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyDTO> propertyDTOList= new ArrayList<>();
       List<PropertyEntity> propertyEntityList= (List<PropertyEntity>) propertyRepository.findAll();
       for(PropertyEntity pe:propertyEntityList){
           PropertyDTO propertyDTO=propertyConverter.convertEntitytoDTO(pe);
           propertyDTOList.add(propertyDTO);
       }
        return propertyDTOList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {
       Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId);
       PropertyDTO dto =null;
       if(optEn.isPresent()){

           PropertyEntity pe = optEn.get(); // get data from database
           pe.setPrice(propertyDTO.getPrice());
           pe.setAddress(propertyDTO.getAddress());
           pe.setTitle(propertyDTO.getTitle());
           pe.setOwnerEmail(propertyDTO.getOwnerEmail());
           pe.setOwnerName(propertyDTO.getOwnerName());
           pe.setDescription(propertyDTO.getDescription());

           dto=propertyConverter.convertEntitytoDTO(pe);

           propertyRepository.save(pe);
       }

       return dto;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId);
        PropertyDTO dto =null;
        if(optEn.isPresent()){
            PropertyEntity pe = optEn.get(); // get data from database
            pe.setDescription(propertyDTO.getDescription());

            dto=propertyConverter.convertEntitytoDTO(pe);

            propertyRepository.save(pe);
        }

        return dto;
    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId);
        PropertyDTO dto =null;
        if(optEn.isPresent()){
            PropertyEntity pe = optEn.get(); // get data from database
            pe.setPrice(propertyDTO.getPrice());

            dto=propertyConverter.convertEntitytoDTO(pe);

            propertyRepository.save(pe);
        }

        return dto;
    }

    @Override
    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }
}
