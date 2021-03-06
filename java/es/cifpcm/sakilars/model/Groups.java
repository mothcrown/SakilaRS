package es.cifpcm.sakilars.model;
// Generated 26-ene-2018 13:14:50 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Groups generated by hbm2java
 */
@Entity
@Table(name="groups"
    ,catalog="sakila"
    , uniqueConstraints = @UniqueConstraint(columnNames="group_name") 
)
public class Groups  implements java.io.Serializable {


     private Integer groupId;
     private String groupName;
     private String description;
     private Set<Users> userses = new HashSet<Users>(0);

    public Groups() {
    }

	
    public Groups(String groupName) {
        this.groupName = groupName;
    }
    public Groups(String groupName, String description, Set<Users> userses) {
       this.groupName = groupName;
       this.description = description;
       this.userses = userses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="group_id", unique=true, nullable=false)
    public Integer getGroupId() {
        return this.groupId;
    }
    
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    
    @Column(name="group_name", unique=true, nullable=false, length=50)
    public String getGroupName() {
        return this.groupName;
    }
    
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    
    @Column(name="description", length=300)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="users_groups", catalog="sakila", joinColumns = { 
        @JoinColumn(name="group_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="user_name", nullable=false, updatable=false) })
    public Set<Users> getUserses() {
        return this.userses;
    }
    
    public void setUserses(Set<Users> userses) {
        this.userses = userses;
    }




}


