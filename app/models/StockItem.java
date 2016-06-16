package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;

/**
 * Created by zabieru on 6/6/2016.
 */
@Entity
public class StockItem extends Model{
    public Warehouse warehouse;
    public Product product;
    public Long quantity;

    public String toString() {
        return String.format("%d %s", quantity, product);
    }
}
