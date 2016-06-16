package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zabieru on 5/24/2016.
 */
@Entity
public class Tag extends Model{

    public Long id;
    @Constraints.Required
    public String name;
    public List<Product> products;


}
