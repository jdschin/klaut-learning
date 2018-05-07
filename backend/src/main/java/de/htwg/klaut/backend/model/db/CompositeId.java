package de.htwg.klaut.backend.model.db;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompositeId implements Serializable {

    @DynamoDBHashKey
    private String organization;

    @DynamoDBAutoGeneratedKey
    @DynamoDBRangeKey
    public String id;
}