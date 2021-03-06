package de.htwg.klaut.backend.model.db;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Set;

@DynamoDBTable(tableName = "model")
@AllArgsConstructor
@NoArgsConstructor
/* IMPORTANT: Do not generate setter and getter here or composite key for DynamoDB will not work */
public class Model implements Serializable {

    @Id
    private CompositeId compositeId;

    @DynamoDBAttribute
    private String name;

    @DynamoDBAttribute
    private String algorithm;

    @DynamoDBAttribute
    private String description;

    @DynamoDBTypeConverted(converter = ModelParamConverter.class)
    private IModelParams params;

    @DynamoDBTypeConverted(converter = ModelTrainingDataConverter.class)
    private Set<ModelTrainingData> trainingData;

    @DynamoDBAttribute
    private Set<String> sourceUrls;

    @DynamoDBHashKey(attributeName = "organization")
    public String getOrganization() {
        return compositeId.getOrganization();
    }

    public void setOrganization(String organization) {
        if (compositeId == null) {
            compositeId = new CompositeId();
        }
        this.compositeId.setOrganization(organization);
    }

    @DynamoDBRangeKey(attributeName = "id")
    @DynamoDBAutoGeneratedKey
    public String getId() {
        return compositeId.getId();
    }

    public void setId(String sortKey) {
        if (compositeId == null) {
            compositeId = new CompositeId();
        }
        this.compositeId.setId(sortKey);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public IModelParams getParams() {
        return params;
    }

    public void setParams(IModelParams params) {
        this.params = params;
    }

    public Set<ModelTrainingData> getTrainingData() {
        return trainingData;
    }

    public void setTrainingData(Set<ModelTrainingData> trainingData) {
        this.trainingData = trainingData;
    }

    public Set<String> getSourceUrls() {
        return sourceUrls;
    }

    public void setSourceUrls(Set<String> sourceUrls) {
        this.sourceUrls = sourceUrls;
    }
}
