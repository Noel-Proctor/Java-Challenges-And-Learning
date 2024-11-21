package lpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lpa.music.Artist;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.TreeMap;

public class MainQuery {

    public static void main(String[] args) {

        List<Artist> artists = null;

        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "dev.lpa.music");
            EntityManager em = emf.createEntityManager();
        ){

            var transaction = em.getTransaction();
            transaction.begin();
            artists = getArtistsJPQL(em, "%Stev%");
            artists.forEach(System.out::println);
            System.out.println("============================================================");
            artists = getGreatestHitsJPQL(em);
            artists.forEach(System.out::println);

            System.out.println("======================CRITERIA BUILDER======================================");
            Stream<Artist> sartists = getArtistBuilder(em, "AC DC");

            var map = sartists.limit(10).collect(Collectors.toMap(Artist::getArtistName,
                    (a)-> a.getAlbums().size(), Integer::sum, TreeMap::new));

            map.forEach((k,v)-> System.out.println(k +" : "+v));

//            var names = getArtistNamesJPQL(em, "%Steve%");
//            names.forEach(System.out::println);
//
//            var namesId = getArtistNamesStreamJPQL(em, "%Stev%");
//            namesId.map(a -> new Artist(a.get("id", Integer.class),
//                    (String) a.get("name"))).forEach(System.out::println);
            transaction.commit();



        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static List<Artist> getGreatestHitsJPQL(EntityManager em) {

        String jpql = "SELECT a FROM Artist a JOIN albums album "+
                "WHERE album.albumName like ?1";
        var query = em.createQuery(jpql, Artist.class);
        query.setParameter(1, "Greatest Hits");
        return query.getResultList();


    }

    private static List<Artist> getArtistsJPQL(EntityManager em,
                                               String matchedValue){

        String jpql = "SELECT a FROM Artist a WHERE a.artistName like :partialName";
        var query = em.createQuery(jpql, Artist.class);
        query.setParameter("partialName", matchedValue);
        return query.getResultList();

    }

    private static List<String> getArtistNamesJPQL(EntityManager em,
                                               String matchedValue){

        String jpql = "SELECT a.artistName FROM Artist a WHERE a.artistName like :partialName";
        var query = em.createQuery(jpql, String.class);
        query.setParameter("partialName", matchedValue);
        return query.getResultList();

    }

    private static List<Tuple> getArtistNamesTupleJPQL(EntityManager em,
                                                  String matchedValue){

        String jpql = "SELECT a.artistId, a.artistName FROM Artist a WHERE a.artistName like :partialName";
        var query = em.createQuery(jpql, Tuple.class);
        query.setParameter("partialName", matchedValue);
        return query.getResultList();

    }

    private static Stream<Tuple> getArtistNamesStreamJPQL(EntityManager em,
                                                            String matchedValue){

        String jpql = "SELECT a.artistId id, a.artistName name FROM Artist a WHERE a.artistName like :partialName";
        var query = em.createQuery(jpql, Tuple.class);
        query.setParameter("partialName", matchedValue);
        return query.getResultStream();

    }



    private static Stream<Artist> getArtistBuilder(EntityManager em,
                                                          String matchedValue){

       CriteriaBuilder builder = em.getCriteriaBuilder();
       CriteriaQuery<Artist> criteriaQuery = builder.createQuery(Artist.class);
       Root<Artist> root = criteriaQuery.from(Artist.class);
       criteriaQuery
               .select(root)
               .where(builder.like(root.get("artistName"), matchedValue))
               .orderBy(builder.asc(root.get("artistName")));

       return em.createQuery(criteriaQuery).getResultStream();

    }

}
