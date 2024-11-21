package lpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lpa.music.Artist;

import java.util.List;

public class SongQuery {

    public static void main(String[] args) {

        List<Artist> artists = null;

        try(var sessionFactory = Persistence.createEntityManagerFactory("dev.lpa.music");
            EntityManager em = sessionFactory.createEntityManager();
        ){

          EntityTransaction transaction = em.getTransaction();

          transaction.begin();
          artists = getArtistsBySongName(em, "%Storm %");
          transaction.commit();

            for (Artist artist : artists) {
                System.out.println(artist);

            }

        }

    }

    private static List<Artist> getArtistsBySongName(EntityManager em, String s) {
        String jpql =  "SELECT a FROM Artist a " +
                "JOIN albums album " +
                "JOIN songs s " +
                "WHERE s.songTitle like ?1";

        var query = em.createQuery(jpql, Artist.class);
        query.setParameter(1, s);
        return query.getResultList();
    }


}
