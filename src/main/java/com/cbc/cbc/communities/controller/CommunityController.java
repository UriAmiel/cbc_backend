package com.cbc.cbc.communities.controller;

import com.cbc.cbc.communities.model.dto.AddCommunityRequest;
import com.cbc.cbc.communities.model.dto.CommunityDTO;
import com.cbc.cbc.communities.service.CommunityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/community")
@CrossOrigin
@AllArgsConstructor
public class CommunityController {

    private CommunityService communityService;

    @PostMapping("/add")
    public ResponseEntity<?> addCommunity(@RequestBody AddCommunityRequest communityToAdd) {
        CommunityDTO communityDTO = communityService.addCommunity(communityToAdd);
        return communityDTO != null ?
                ResponseEntity.status(HttpStatus.OK).body(communityDTO) :
                ResponseEntity.status(HttpStatus.CONFLICT).body("Cannot create community");
    }

    @GetMapping("/getAll")
    public List<CommunityDTO> getAllCommunities() {
        return communityService.getAllCommunities();
    }
}
