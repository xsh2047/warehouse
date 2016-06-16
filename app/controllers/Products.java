package controllers;

import com.google.common.io.Files;
import com.google.inject.Inject;
import models.Product;
import models.Tag;
import static play.mvc.Http.MultipartFormData;

import play.api.db.Database;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Result;
import play.mvc.Controller;
import play.mvc.With;
import utils.Catch;
import views.html.products.details;
import views.html.products.list;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Xavier on 1/17/2016.
 */
@Catch
public class Products extends Controller {

    private Database db;
    FormFactory formFactory;
    Form<Product> productForm;

    @Inject
    public Products(FormFactory formFactory, Database db){
        this.formFactory = formFactory;
        this.productForm = this.formFactory.form(Product.class);
        this.db = db;
    }

    public Result index(){
        return redirect(routes.Products.list(0));
    }

    public Result list(Integer page){
        List<Product> products = Product.find.all();
        return ok(list.render(products));
    }

    public Result newProduct(){
        return ok(details.render(productForm));
    }

    public Result details(String ean){
        final Product product = Product.find.byId((long) 0);
        if(product == null){
            return notFound(String.format("Product %s does not exist.", ean));
        }
        Form<Product> filledForm = productForm.fill(product);
        return ok(details.render(filledForm));
    }
//    public Result details(Product product){
//        Form<Product> filledForm = productForm.fill(product);
//        return ok(details.render(filledForm));
//    }

    //TODO Fix this function
    public Result save(){
        Form<Product> boundForm = productForm.bindFromRequest();
        if(boundForm.hasErrors()){
            flash("error","Please correct the form below.");
            return badRequest(details.render(boundForm));
        }
        Product product = boundForm.get();
        MultipartFormData body = request().body().asMultipartFormData();
        MultipartFormData.FilePart part = body.getFile("picture");
        if(part != null){
            File picture = (File) part.getFile();
            try {
                product.picture = Files.toByteArray(picture);
            } catch (IOException e) {
                return internalServerError("Error reading file upload");
            }
        }
        product.save();
        flash("success", String.format("Saved product %s", product));
        return redirect(routes.Products.list(1));
    }

    public Result delete(String ean){
//        final Product product = Product.findByEan(ean);
//        if(product == null){
//            return notFound(String.format("Product %s does not exist.", ean));
//        }
//        Product.remove(product);
//        return redirect(routes.Products.list(1));
        return TODO;
    }

    public Result picture(String ean) {
//        final Product product = Product.findByEan(ean);
//        if(product == null) return notFound();
//        return ok(product.picture);
        return TODO;
    }
}
