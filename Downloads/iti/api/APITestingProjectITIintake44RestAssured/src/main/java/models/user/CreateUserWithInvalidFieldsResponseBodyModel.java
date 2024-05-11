package models.user;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.processing.Generated;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "field",
            "message"
    })
    @Generated("jsonschema2pojo")
    public class CreateUserWithInvalidFieldsResponseBodyModel {

        @JsonProperty("field")
        private String field;
        @JsonProperty("message")
        private String message;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

        @JsonProperty("field")
        public String getField() {
            return field;
        }

        @JsonProperty("field")
        public void setField(String field) {
            this.field = field;
        }

        @JsonProperty("message")
        public String getMessage() {
            return message;
        }

        @JsonProperty("message")
        public void setMessage(String message) {
            this.message = message;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

