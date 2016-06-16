package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zabieru on 6/6/2016.
 */
@Entity
public class Warehouse extends Model{
    public String name;
    public List<StockItem> stock = new ArrayList<>();

    public String toString(){
        return name;
    }
}
