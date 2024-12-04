package PropertyManagementSystem.Orielly_property_management_system.controller;

import PropertyManagementSystem.Orielly_property_management_system.dto.PropertyDTO;
import PropertyManagementSystem.Orielly_property_management_system.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> addProperty(@RequestBody PropertyDTO propertyDTO){
      propertyDTO= propertyService.saveProperty(propertyDTO);

       ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDTO>> getAllProperties(){
       List<PropertyDTO> propertyList= propertyService.getAllProperties();
       ResponseEntity<List<PropertyDTO>> responseEntity = new ResponseEntity<>(propertyList,HttpStatus.OK);
       return responseEntity;
    }

    @PutMapping("/properties/{propertyId}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO,@PathVariable Long propertyId){

        propertyDTO= propertyService.updateProperty(propertyDTO,propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return responseEntity;
    }
    @PatchMapping("/properties/update-description/{propertyId}")
    public  ResponseEntity<PropertyDTO> updatedescription(@RequestBody PropertyDTO propertyDTO,@PathVariable Long propertyId){
        propertyDTO= propertyService.updatePropertyDescription(propertyDTO,propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return responseEntity;

    }
    @PatchMapping("/properties/update-price/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyPrice(@RequestBody PropertyDTO propertyDTO,@PathVariable Long propertyId){
        propertyDTO= propertyService.updatePropertyPrice(propertyDTO,propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return responseEntity;
    }
    @DeleteMapping("/properties/{propertyId}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long propertyId){
        propertyService.deleteProperty(propertyId);
        ResponseEntity<Void>responseEntity = new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        return responseEntity;
    }
}
