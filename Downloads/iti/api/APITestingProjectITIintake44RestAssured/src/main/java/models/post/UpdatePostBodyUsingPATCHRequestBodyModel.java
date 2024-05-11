package models.post;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.LinkedHashMap;
import java.util.Map;

public class UpdatePostBodyUsingPATCHRequestBodyModel {
    @JsonIgnore
    private Map<String, Object> addProperty = new LinkedHashMap<String, Object>();
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.addProperty;
    }

    @JsonAnySetter
    public void setField(String name, String value) {
        this.addProperty.put(name, value);
    }

}
