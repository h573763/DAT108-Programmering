package no.hvl.dat108.oblig4.utilites;

import no.hvl.dat108.oblig4.dataobjects.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Login {

        private static final int MAX_INTERVAL = 300;
        public static void userLogOut(HttpSession session){
            session.invalidate();
        }
        public static void userLogIn(HttpServletRequest request, String password, String phonenumber){
            userLogOut(request.getSession());

            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(MAX_INTERVAL);
            session.setAttribute("password", password);
            session.setAttribute("phonenumber", phonenumber);
            session.setAttribute("person", new Person());
        }
        public static boolean isNotLogedIn(HttpSession session){
            return session == null
                    || session.getAttribute("password") == null
                    || session.getAttribute("person") == null;
        }
    }
