package spg.pre.microservices.musicmanager.persistence;

public interface CustomSongRepository {

    void partialUpdate(String songId, String fieldName, Object fieldValue);

}
