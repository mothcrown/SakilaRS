
package es.cifpcm.sakilars.services.rest;

import es.cifpcm.sakilars.data.actor.ActorDao;
import es.cifpcm.sakilars.data.actor.ActorDaoImpl;
import es.cifpcm.sakilars.model.Actor;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author mothcrown
 */

@Path("actors")
public class ActorRest {
    
    public ActorRest() {}
    
    /**
     * Devuelve toda una lista de actores. Choporromil. Sin filtro ni ná.
     * @return 
     */
    @GET
    @Path("/selectall")
    @Produces ("application/json")
    public String selectAll() {
        ActorDao actorDao = new ActorDaoImpl();
        List<Actor> actors = actorDao.selectAll();
        // Después de hora y media de hacer el canelo con HashMaps y tratando de
        // hacer streams en Java EE 7 me rindo y pongo String
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        
        for (Actor actor : actors) {
            sb.append("\"");
            sb.append(actor.getActorId().toString());
            sb.append("\":{\"firstName\":\"");
            sb.append(actor.getFirstName());
            sb.append("\", \"lastName\":\"");
            sb.append(actor.getLastName());
            sb.append("\"},");
        }
        sb.setLength(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }
    
    /**
     * Busca actor. Por si se te ha vuelto a perder Bill Murray por ahí!
     * @param actorId
     * @return 
     */
    @GET
    @Path("/search")
    @Produces ("application/json")
    public String searchByActorId(@QueryParam("actorid") int actorId) {
        ActorDao actorDao = new ActorDaoImpl();
        Actor actor = actorDao.searchByCriteria(actorId);
        StringBuffer sb = new StringBuffer();
        sb.append("{\"actorId\":\"");
        sb.append(actor.getActorId());
        sb.append("\", \"firstName\":\"");
        sb.append(actor.getFirstName());
        sb.append("\", \"lastName\":\"");
        sb.append(actor.getLastName());
        sb.append("\"}");
        return sb.toString();
    }
    
    /**
     * De pequeño querías ser una estrella de cine? Don't worry! Ahora puedes
     * añadir tu nombre a... uhh.. PENELOPE GUINESS, que debe ser la hija
     * sin talento de Obi Wan.
     * 
     * @param actor
     * @return 
     */
    @POST
    @Path("/insert")
    @Produces ("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public String insert(Actor actor) {
        ActorDao actorDao = new ActorDaoImpl();
        actor = actorDao.insert(actor);
        StringBuffer sb = new StringBuffer();
        sb.append("{\"actorId\":\"");
        sb.append(actor.getActorId());
        sb.append("\", \"firstName\":\"");
        sb.append(actor.getFirstName());
        sb.append("\", \"lastName\":\"");
        sb.append(actor.getLastName());
        sb.append("\"}");
        return sb.toString();
    }
    
}
