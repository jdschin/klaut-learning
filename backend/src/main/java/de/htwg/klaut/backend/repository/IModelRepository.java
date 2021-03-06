package de.htwg.klaut.backend.repository;

import de.htwg.klaut.backend.model.db.CompositeId;
import de.htwg.klaut.backend.model.db.Model;
import org.socialsignin.spring.data.dynamodb.repository.DynamoDBPagingAndSortingRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.socialsignin.spring.data.dynamodb.repository.EnableScanCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@EnableScan
@EnableScanCount
public interface IModelRepository extends DynamoDBPagingAndSortingRepository<Model, CompositeId> {

    Page<Model> findByOrOrganization(String organization, Pageable pageable);
}
