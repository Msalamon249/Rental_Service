package com.example.wypozyczalnia.assets;

import com.example.wypozyczalnia.assignment.AssignmentUserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/assets")
public class AssetController {
    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @GetMapping()
    List<AssetDto> getAllAssets(@RequestParam(required = false) String text) {
        if (text != null) {
            return assetService.getAllAssetsByNameOrSerialNumber(text);
        } else {
            return assetService.findAll();
        }
    }

    @PostMapping
    ResponseEntity<AssetDto> createNewAsset(@RequestBody AssetDto assetDto) {
        if (assetDto.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Przesłano obiekt z ustawionym id");
        }
        AssetDto newAsset = assetService.createNewAsset(assetDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newAsset.getId()).toUri();
        return ResponseEntity.created(uri).body(newAsset);
    }


    @GetMapping("/{id}")
    AssetDto findById(@PathVariable Long id) {
        return assetService.findById(id);
    }

    @PutMapping("/{id}")
    ResponseEntity<AssetDto> updateAsset(@PathVariable Long id, @RequestBody AssetDto assetDto) {
        if (!id.equals(assetDto.getId()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Aktualizowany obiekt musi mieć id zgodne z id w ścieżce zasobu");
        AssetDto updated = assetService.update(assetDto);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{assetId}/assignments")
    List<AssignmentUserDto> getAllUserAssignment(@PathVariable Long assetId) {
        return assetService.getAllAssignmentsUser(assetId);
    }
}
