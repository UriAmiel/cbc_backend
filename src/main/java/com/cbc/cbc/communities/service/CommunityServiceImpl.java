package com.cbc.cbc.communities.service;

import com.cbc.cbc.communities.model.dto.AddCommunityRequest;
import com.cbc.cbc.communities.model.dto.CommunityDTO;
import com.cbc.cbc.communities.model.mapper.CommunityMapper;
import com.cbc.cbc.communities.record.Community;
import com.cbc.cbc.communities.repository.CommunityRepository;
import com.cbc.cbc.users.record.User;
import com.cbc.cbc.users.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CommunityServiceImpl implements CommunityService {

    private CommunityRepository communityRepository;
    private UserRepository userRepository;
    private CommunityMapper communityMapper;

    @Transactional
    @Override
    public CommunityDTO addCommunity(AddCommunityRequest communityToAdd) {
        Community community = communityMapper.toCommunity(communityToAdd);
        User communityCreator = getUser(community.getCreatorId());
        if (communityCreator != null) {
            addUserToCommunityAndSaveCommunity(community, communityCreator);
            return communityMapper.toCommunityDTO(community);
        }
        return null;
    }

    @Override
    public List<CommunityDTO> getAllCommunities() {
        return communityRepository.findAll()
                .stream()
                .map(community -> communityMapper.toCommunityDTO(community))
                .toList();
    }

    private User getUser(Long userId) {
        return userRepository.findById(userId)
                .orElse(null);
    }

    private void addUserToCommunityAndSaveCommunity(Community community, User user) {
        user.addCommunity(community);
        community.addMember(user);
        communityRepository.save(community);
    }
}