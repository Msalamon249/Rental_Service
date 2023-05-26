package com.example.wypozyczalnia.assets;


import com.example.wypozyczalnia.assignment.AssignmentDtoMapper;
import com.example.wypozyczalnia.assignment.AssignmentUserDto;
import com.example.wypozyczalnia.exceptions.AssetNotExistException;
import com.example.wypozyczalnia.exceptions.DuplicateSerialNumberException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssetService {
    private final AssetRepository assetRepository;
    private final AssetDtoMapper assetDtoMapper;
    private final AssignmentDtoMapper assignmentUserDto;

    public AssetService(AssetRepository assetRepository, AssetDtoMapper assetDtoMapper, AssignmentDtoMapper assignmentUserDto) {
        this.assetRepository = assetRepository;
        this.assetDtoMapper = assetDtoMapper;
        this.assignmentUserDto = assignmentUserDto;
    }

    List<AssetDto> findAll() {
        return assetRepository.findAll()
                .stream()
                .map(assetDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    List<AssetDto> getAllAssetsByNameOrSerialNumber(String text) {
        return assetRepository.findAllBySerialNumberOrName(text)
                .stream()
                .map(assetDtoMapper::mapToDto)
                .collect(Collectors.toList());

    }

    AssetDto createNewAsset(AssetDto assetDto) {
        assetRepository.findBySerialNumber(assetDto.getSerialNumber()).ifPresent(asset -> {
            throw new DuplicateSerialNumberException();
        });
        Asset toSave = assetDtoMapper.mapToEntity(assetDto);
        Asset saved = assetRepository.save(toSave);
        return assetDtoMapper.mapToDto(saved);
    }

    AssetDto findById(Long id) {
        Asset asset = assetRepository.findById(id).orElseThrow(AssetNotExistException::new);
        return assetDtoMapper.mapToDto(asset);
    }

    AssetDto update(AssetDto assetDto) {
        assetRepository.findBySerialNumber(assetDto.getSerialNumber()).ifPresent(asset -> {
            if (assetDto.getId() != asset.getId()) {
                throw new DuplicateSerialNumberException();
            }
        });
        Asset toUpdate = assetDtoMapper.mapToEntity(assetDto);
        Asset updated = assetRepository.save(toUpdate);
        return assetDtoMapper.mapToDto(updated);

    }

    List<AssignmentUserDto> getAllAssignmentsUser(Long id) {
        Asset asset = assetRepository.findById(id).orElseThrow(AssetNotExistException::new);
        return asset.getAssigments()
                .stream()
                .map(assignmentUserDto::mapToUserDto)
                .collect(Collectors.toList());
    }
}
