/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.sakilars.data.actor;

import es.cifpcm.sakilars.model.Actor;
import java.util.List;

/**
 *
 * @author mothcrown
 */
public interface ActorDao {
    public List<Actor> selectAll();
    public Actor searchByCriteria(int actorId);
    public Actor insert(Actor actor);
}
