package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Index;
import models.Inventory;
import models.LoadTodays;
import models.PrintOne;
import models.PrintTodays;
import models.CreateNew;
import models.ViewAll;
import models.ViewNew;
import play.*;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.*;
import views.html.*;
import wsticker.DataLoader;
import wsticker.InventoryDAO;


public class Application extends Controller {

    public static Long id;
    private static final Form<Index> indexForm = Form.form(Index.class);
    private static final Form<CreateNew> createNewForm = Form.form(CreateNew.class);
    private static final Form<ViewAll> viewAllForm = Form.form(ViewAll.class);
    private static final Form<ViewNew> viewNewForm = Form.form(ViewNew.class);
    private static final Form<PrintOne> printOneForm = Form.form(PrintOne.class);
    private static final Form<PrintTodays> printTodaysForm = Form.form(PrintTodays.class);
    private static final Form<LoadTodays> loadTodaysForm = Form.form(LoadTodays.class);
    public static final List<Inventory> inventoryForm = new ArrayList<Inventory>();


    @Security.Authenticated(Secured.class)
    public static Result index() {
        System.out.println("Main - index");
        return ok(views.html.index.render(indexForm));
    }


    @Security.Authenticated(Secured.class)
    public static Result createNew() {
        System.out.println("Main - createNew");
        return ok(views.html.createnew.render(createNewForm));
    }


    @Transactional
    public static Result viewAll() {
        System.out.println("Main - viewAll");
        List<Inventory> inventoryList = Inventory.findAll();
        return ok(views.html.viewall.render(inventoryList));
    }


    public static Result viewNew() {
        System.out.println("Main - viewNew");
        return ok(views.html.viewnew.render(viewNewForm));
    }


    @Transactional
    public static Result loadTodays() {
        System.out.println("Main - loadTodays");

        DataLoader.load();
        return ok(views.html.loadtodays.render(loadTodaysForm));
    }


    @Transactional
    public static Result printOne(Long id) {
        System.out.println("Main - printOne");

        Inventory inv = InventoryDAO.findById(id);

        return ok(views.html.printone.render(inv));
    }


    public static Result printTodays() {
        System.out.println("Main - printTodays");
        return ok(views.html.printtodays.render(printTodaysForm));
    }


    public static Result login() {
        return ok(login.render(Form.form(Login.class)));
    }


    public static Result authenticate() {

        Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
        System.out.println("Rich:" + loginForm);

        if (loginForm.hasErrors()) {
            return badRequest(login.render(loginForm));
        } else {
            session().clear();
            session("email", loginForm.data().get("email"));
            System.out.println("Rich:" + loginForm.data().get("email") + ", pass: " + loginForm.data().get("password"));
            return redirect(routes.Application.index()
            );
        }
    }

//    public String validate() {
//        if (User.authenticate(email, password) == null) {
//            return "Invalid user or password";
//        }
//        return null;
//    }


    public static class Login {

        public String email;
        public String password;

    }


    public static Result logout() {
        session().clear();
        flash("success", "You've been logged out");
        return redirect( routes.Application.login()    );
    }

}




