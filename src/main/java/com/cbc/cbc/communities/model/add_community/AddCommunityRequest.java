package com.cbc.cbc.communities.model.add_community;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddCommunityRequest {

    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
}
