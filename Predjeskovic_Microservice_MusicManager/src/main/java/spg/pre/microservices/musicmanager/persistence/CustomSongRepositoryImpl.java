package spg.pre.microservices.musicmanager.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.BasicUpdate;
import org.springframework.data.mongodb.core.query.Criteria;
import spg.pre.microservices.musicmanager.domain.documents.Song;


public class CustomSongRepositoryImpl implements CustomSongRepository {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public void partialUpdate(String songId, String fieldName, Object fieldValue) {
        mongoTemplate.findAndModify(BasicQuery.query(Criteria.where("id").is(songId)),
                BasicUpdate.update(fieldName,fieldValue), FindAndModifyOptions.none(), Song.class);
    }
}
