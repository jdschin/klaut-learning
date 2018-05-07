package de.htwg.klaut.backend.service;

import de.htwg.klaut.backend.exception.ModelNotFoundException;
import de.htwg.klaut.backend.model.db.CompositeId;
import org.deeplearning4j.models.word2vec.Word2Vec;

import java.io.File;
import java.io.IOException;

public interface IS3StorageService {
    void deleteFilesForId(CompositeId modelId) throws IOException, ModelNotFoundException;

    File getSourceFile(String sourceUrl) throws IOException;

    String addSourceFile(String fileName) throws IOException;

    String addModel(Word2Vec word2Vec) throws IOException;
}
