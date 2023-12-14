package com.cbc.cbc.communities.controller;

import com.cbc.cbc.communities.pojo.Community;
import com.cbc.cbc.communities.service.CommunityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/community")
@CrossOrigin
@AllArgsConstructor
public class CommunityController {

    private CommunityService communityService;

    @PostMapping("/add")
    public Community addCommunity(@RequestBody Community community) {
        communityService.saveCommunity(community);
        return community;
    }

    @GetMapping("/getAll")
    public List<Community> getAllCommunities() {
        return communityService.getAllCommunities();
    }
}