package lpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import lpa.music.Artist;

public class Main {

    public static void main(String[] args) {

        try(var sessionFactory = Persistence.createEntityManagerFactory("dev.lpa.music");
            EntityManager entityManager = sessionFactory.createEntityManager();){

            var transaction = entityManager.getTransaction();
            transaction.begin();
            Artist artist = entityManager.find(Artist.class, 205);
            System.out.println(artist);
//            artist.removeDuplicates();
            artist.addAlbum("The best of muddy waters");
            System.out.println(artist);
//            entityManager.remove(artist);
//            entityManager.persist(new Artist("Mussy Wussy"));
            transaction.commit();

        }catch (Exception e){
            e.printStackTrace();
        }



    }


}
