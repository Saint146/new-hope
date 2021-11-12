package ru.newhope.city;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(description = "Города")
@Data
public class CityDto {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
}
