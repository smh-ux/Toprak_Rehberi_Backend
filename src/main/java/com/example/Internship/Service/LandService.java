package com.example.Internship.Service;

import com.example.Internship.DTO.LandDTO;
import com.example.Internship.DTO.ProductDTO;
import com.example.Internship.Entity.Land;
import com.example.Internship.Entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LandService {
    public LandDTO convertToDTO(Land land) {
        LandDTO landDTO = new LandDTO();
        landDTO.setId(land.getId());
        landDTO.setLandName(land.getLandName());
        landDTO.setCity(land.getCity());
        landDTO.setTown(land.getTown());
        landDTO.setNeighborhood(land.getNeighborhood());
        landDTO.setArea(land.getArea());
        landDTO.setUserId(land.getUser().getId());

//        List<ProductDTO> productDTOs = land.getProducts().stream()
//                .map(this::convertToProductDTO)
//                .collect(Collectors.toList());
//        landDTO.setProducts(productDTOs);

        return landDTO;
    }

    private ProductDTO convertToProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPlantedArea(product.getPlantedArea());
        productDTO.setLandId(product.getLand().getId());
        return productDTO;
    }

    public Land convertToEntity(LandDTO landDTO) {
        Land land = new Land();
        land.setId(landDTO.getId());
        land.setLandName(landDTO.getLandName());
        land.setCity(landDTO.getCity());
        land.setTown(landDTO.getTown());
        land.setNeighborhood(landDTO.getNeighborhood());
        land.setArea(landDTO.getArea());

        // Burada gerekirse ürünler veya kullanıcı ile ilgili işlemler yapılabilir
        return land;
    }
}
