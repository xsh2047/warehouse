package models;

import akka.japi.Option;
import com.avaje.ebean.Model;
import play.libs.F;
import play.mvc.QueryStringBindable;
import play.data.validation.Constraints;
import utils.EAN;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.*;

/**
 * Created by Xavier on 1/17/2016.
 */
@Entity
public class Product extends Model { //implements QueryStringBindable<Product> {

    @Id
    public Long id;

    @Constraints.Required
    //@Constraints.ValidateWith(value = EanValidator.class, message = "must be 13 numbers")
    @EAN
    public String ean;
    @Constraints.Required
    public String name;
    public String description;
    public List<Tag> tags;
    public byte[] picture;

    public static Finder<Long, Product> find = new Finder<Long,Product>(Product.class);

    public String toString(){
        return name;
    }


//    @Override
//    public Optional<Product> bind(String key, Map<String, String[]> data) {
//        return Optional.of(findByEan(data.get("ean")[0]));
//    }
//
//
//    @Override
//    public String unbind(String key) {
//        return null;
//    }
//
//    @Override
//    public String javascriptUnbind() {
//        return this.ean;
//    }
//    public static class EanValidator extends Constraints.Validator<String>{
//
//        @Override
//        public boolean isValid(String value) {
//            String pattern = "^[0-9]{13}$";
//            return value != null && value.matches(pattern);
//        }
//
//        @Override
//        public F.Tuple<String, Object[]> getErrorMessageKey() {
//            return new F.Tuple<String, Object[]>("error.invalid.ean", new Object[]{});
//        }
//    }
}