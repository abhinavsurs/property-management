package PropertyManagementSystem.Orielly_property_management_system.service;

import PropertyManagementSystem.Orielly_property_management_system.dto.PropertyDTO;

import java.util.List;

public interface PropertyService {

     PropertyDTO saveProperty(PropertyDTO propertyDTO);
    List<PropertyDTO> getAllProperties();
    PropertyDTO updateProperty(PropertyDTO propertyDTO,Long propertyId);
    PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO,Long propertyId);
    PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO,Long propertyId);
    void deleteProperty(Long id);


}
