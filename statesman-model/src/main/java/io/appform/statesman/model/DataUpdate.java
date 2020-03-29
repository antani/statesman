package io.appform.statesman.model;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Value;

/**
 *
 */
@Value
public class DataUpdate {
    String workflowId;
    JsonNode data;
    DataAction dataAction;
}
