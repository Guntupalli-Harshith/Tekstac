package com.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.exception.AssetInvalidException;
import com.model.AssetInfo;
import com.service.AssetService;

import jakarta.validation.Valid;
//Provide necessary Annotation


@RestController
@RequestMapping("/AMS")

public class AssetController {

	//Provide necessary Annotation
	@Autowired
    private AssetService assetService;

    //Provide necessary Annotations
    @PostMapping("/insertAsset")
    public ResponseEntity<AssetInfo> addAsset(@Valid @RequestBody AssetInfo assetObj) {
    
            AssetInfo addedAsset = assetService.addAsset(assetObj);
    
    	return new ResponseEntity<>(addedAsset,HttpStatus.OK);
    }
    @GetMapping("/viewAssetById/{assetId}")
    public ResponseEntity<AssetInfo> viewAssetById(@PathVariable int assetId) throws AssetInvalidException {
    	AssetInfo asset = assetService.viewAssetById(assetId);
    	return new ResponseEntity<>(asset,HttpStatus.OK);
    }
    @GetMapping("/viewAssetsByTypeAndCondition/{assetType}/{assetCondition}")
    public ResponseEntity<List<AssetInfo>> viewAssetsByTypeAndCondition(@PathVariable String assetType,@PathVariable String assetCondition) {
        List<AssetInfo>assets = assetService.viewAssetsByTypeAndCondition(assetType,assetCondition);
        
    	return new ResponseEntity<>(assets,HttpStatus.OK);                 
    }
    @PutMapping("/updateAssetCondition/{assetId}/{newCondition}")
    public ResponseEntity<AssetInfo> updateAssetCondition(@PathVariable int assetId, @PathVariable String newCondition) throws AssetInvalidException {
    	AssetInfo updatedAsset = assetService.updateAssetCondition(assetId, newCondition);
    	return new ResponseEntity<>(updatedAsset,HttpStatus.OK);
        
    }
    @DeleteMapping("/deleteAsset/{assetId}")
    public ResponseEntity<Boolean> deleteAsset(@PathVariable int assetId) throws AssetInvalidException {
    	boolean deleted = assetService.deleteAsset(assetId);
    	return new ResponseEntity<>(deleted,HttpStatus.OK);
        
    }
}

