package de.htwg.klaut.backend.model.db;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import de.htwg.klaut.backend.model.ModelParamConverter;
import de.htwg.klaut.backend.model.ModelParams;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@DynamoDBTable(tableName = "model")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Model {

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    public String id;

    @DynamoDBAttribute
    private String organisation;

    @DynamoDBAttribute
    private String name;

    @DynamoDBAttribute
    private String alogrithm;

    @DynamoDBAttribute
    private String description;

    @DynamoDBTypeConverted(converter = ModelParamConverter.class)
    private ModelParams params;

    @DynamoDBAttribute
    private String modelUrl;

    @DynamoDBAttribute
    private Set<String> sourceUrls;
}
