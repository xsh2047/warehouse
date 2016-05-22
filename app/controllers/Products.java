package controllers;

import com.google.inject.Inject;
import models.Product;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Result;
import play.mvc.Controller;
import play.mvc.With;
import utils.Catch;
import views.html.products.details;
import views.html.products.list;
import java.util.List;

/**
 * Created by Xavier on 1/17/2016.
 */
@Catch
public class Products extends Controller {

    FormFactory formFactory;
    Form<Product> productForm;

    @Inject
    public Products(FormFactory formFactory){
        this.formFactory = formFactory;
        this.productForm = this.formFactory.form(Product.class);
    }

    public Result index(){
        return redirect(routes.Products.list(0));
    }

    public Result list(Integer page){
        List<Product> products = Product.findAll();
        return ok(list.render(products));
    }

    public Result newProduct(){
        return ok(details.render(productForm));
    }

    public Result details(String ean){
        final Product product = Product.findByEan(ean);
        if(product == null){
            return notFound(String.format("Product %s does not exist.", ean));
        }
        Form<Product> filledForm = productForm.fill(product);
        return ok(details.render(filledForm));
    }

    //TODO Fix this function
    public Result save(){
        Form<Product> boundForm = productForm.bindFromRequest();
        if(boundForm.hasErrors()){
            flash("error","Please correct the form below.");
            return badRequest(details.render(boundForm));
        }

        Product product = boundForm.get();
        product.save();
        flash("success", String.format("Saved product %s", product));
        return redirect(routes.Products.list(1));
    }

    public Result delete(String ean){
        final Product product = Product.findByEan(ean);
        if(product == null){
            return notFound(String.format("Product %s does not exist.", ean));
        }
        Product.remove(product);
        return redirect(routes.Products.list(1));
    }
}
