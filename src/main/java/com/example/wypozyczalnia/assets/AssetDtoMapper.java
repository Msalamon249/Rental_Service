package com.example.wypozyczalnia.assets;

import com.example.wypozyczalnia.category.Category;
import com.example.wypozyczalnia.category.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AssetDtoMapper {

    private final CategoryRepository categoryRepository;


    public AssetDtoMapper(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public AssetDto mapToDto(Asset asset) {
        AssetDto assetDto = new AssetDto();
        assetDto.setId(asset.getId());
        assetDto.setName(asset.getName());
        assetDto.setDescription(asset.getDescription());
        assetDto.setSerialNumber(asset.getSerialNumber());
        Category category = asset.getCategory();
        if (category.getName() != null) {
            assetDto.setCategoryName(category.getName());
        }
        return assetDto;
    }

    public Asset mapToEntity(AssetDto assetDto) {
        Asset asset = new Asset();
        asset.setId(assetDto.getId());
        asset.setName(assetDto.getName());
        asset.setDescription(assetDto.getDescription());
        asset.setSerialNumber(assetDto.getSerialNumber());
        String categoryName = assetDto.getCategoryName();
        Optional<Category> byName = categoryRepository.findByName(categoryName);
      byName.ifPresent(asset::setCategory);
        return asset;

    }
}
