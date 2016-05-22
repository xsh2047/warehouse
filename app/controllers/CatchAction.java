package controllers;

import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;
import utils.Catch;
import utils.ExceptionMailer;

import java.util.concurrent.CompletionStage;

/**
 * Created by Xavier on 01/02/2016.
 */
public class CatchAction extends Action<Catch> {
    public CompletionStage<Result> call(Http.Context ctx) {
        try {
            return delegate.call(ctx);
        } catch(Throwable e) {
            if (configuration.send())
                ExceptionMailer.send(e);
            else
                e.printStackTrace();
        }
        return null;
    }
}
