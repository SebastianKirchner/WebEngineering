package models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


/**
 * Base entity for all JPA classes
 */
@MappedSuperclass
public class BaseEntity {


    @Id
    @GeneratedValue
    protected Long id;


    public Long getId() {
        return id;
    }

}
