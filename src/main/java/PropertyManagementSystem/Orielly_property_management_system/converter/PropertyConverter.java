package PropertyManagementSystem.Orielly_property_management_system.converter;

import PropertyManagementSystem.Orielly_property_management_system.dto.PropertyDTO;
import PropertyManagementSystem.Orielly_property_management_system.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public PropertyEntity convertDTOtoEntity(PropertyDTO propertyDTO){
        PropertyEntity pe = new PropertyEntity();
        pe.setPrice(propertyDTO.getPrice());
        pe.setAddress(propertyDTO.getAddress());
        pe.setTitle(propertyDTO.getTitle());
        pe.setOwnerEmail(propertyDTO.getOwnerEmail());
        pe.setOwnerName(propertyDTO.getOwnerName());
        pe.setDescription(propertyDTO.getDescription());
        return pe;
    }

    public PropertyDTO convertEntitytoDTO(PropertyEntity propertyEntity){
        PropertyDTO dto = new PropertyDTO();
        dto.setId(propertyEntity.getId());
        dto.setAddress(propertyEntity.getAddress());
        dto.setDescription(propertyEntity.getDescription());
        dto.setTitle(propertyEntity.getTitle());
        dto.setPrice(propertyEntity.getPrice());
        dto.setOwnerName(propertyEntity.getOwnerName());
        dto.setOwnerEmail(propertyEntity.getOwnerEmail());
        return dto;
    }
}
