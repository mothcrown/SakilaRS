package es.cifpcm.sakilars.model;
// Generated 26-ene-2018 13:14:50 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FilmActorId generated by hbm2java
 */
@Embeddable
public class FilmActorId  implements java.io.Serializable {


     private short actorId;
     private short filmId;

    public FilmActorId() {
    }

    public FilmActorId(short actorId, short filmId) {
       this.actorId = actorId;
       this.filmId = filmId;
    }
   


    @Column(name="actor_id", nullable=false)
    public short getActorId() {
        return this.actorId;
    }
    
    public void setActorId(short actorId) {
        this.actorId = actorId;
    }


    @Column(name="film_id", nullable=false)
    public short getFilmId() {
        return this.filmId;
    }
    
    public void setFilmId(short filmId) {
        this.filmId = filmId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof FilmActorId) ) return false;
		 FilmActorId castOther = ( FilmActorId ) other; 
         
		 return (this.getActorId()==castOther.getActorId())
 && (this.getFilmId()==castOther.getFilmId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getActorId();
         result = 37 * result + this.getFilmId();
         return result;
   }   


}


