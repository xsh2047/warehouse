package controllers;

import models.Product;
import play.mvc.Result;
import play.mvc.Controller;
import views.html.products.list;

import java.util.List;

/**
 * Created by Xavier on 1/17/2016.
 */
public class Products extends Controller {

    public Result list(){
        List<Product> products = Product.findAll();
        return ok(list.render(products));
    }

    public Result newProduct(){
        return TODO;
    }

    public Result details(String ean){
        return TODO;
    }

    public Result save(){
        return TODO;
    }
}
