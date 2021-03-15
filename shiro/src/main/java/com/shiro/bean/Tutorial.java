package com.shiro.bean;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/3/15
 */
public class Tutorial {
    private static final transient Logger log = LoggerFactory.getLogger(Tutorial.class);

    private static boolean notAuthenticated(Subject currentUser) {
        return !currentUser.isAuthenticated();
    }

    public static void main(String[] args) {
        log.info("My First Apache Shiro Application");
        try {
            //1.
            Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro/shiro.ini");

            //2.
            SecurityManager securityManage = factory.getInstance();

            //3.
            SecurityUtils.setSecurityManager(securityManage);

            Subject currentUser = SecurityUtils.getSubject();

            Session session = currentUser.getSession();
            session.setAttribute("someKey", "someValue");
            log.info("someKey value [" + session.getAttribute("someKey") + "] setAttribute in successfully.");

            if (notAuthenticated(currentUser)) {
                //collect user principals and credentials in a gui specific manner
                //such as username/password html form, X509 certificate, OpenID, etc.
                //We'll use the username/password example here since it is the most common.
                UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");

                //this is all you have to do to support 'remember me' (no config - built in!):
                token.setRememberMe(true);
                try {
                    currentUser.login(token);
                } catch (UnknownAccountException uae) {
                    //username wasn't in the system, show them an error message?
                } catch (IncorrectCredentialsException ice) {
                    //password didn't match, try again?
                } catch (LockedAccountException lae) {
                    //account for that username is locked - can't login.  Show them a message?
                }//more types exceptions to check if you want ...
                catch (AuthenticationException ae) {
                    //unexpected condition - error?
                }

                log.info("User [" + currentUser.getPrincipal() + "] logged in successfully.");

                if (currentUser.hasRole("schwartz")) {
                    log.info("May the Schwartz be with you!");
                } else {
                    log.info("Hello, mere mortal.");
                }

                if (currentUser.isPermitted("lightsaber:wield")) {
                    log.info("You may use a lightsaber ring.  Use it wisely.");
                } else {
                    log.info("Sorry, lightsaber rings are for schwartz masters only.");
                }

                if (currentUser.isPermitted("winnebago:drive:eagle5")) {
                    log.info("You are permitted to 'drive' the 'winnebago' with license plate (id) 'eagle5'.  " +
                            "Here are the keys - have fun!");
                } else {
                    log.info("Sorry, you aren't allowed to drive the 'eagle5' winnebago!");
                }

            } else {
                log.info("user is authenticated!");
            }
            //removes all identifying information and invalidates their session too.
            currentUser.logout();
            log.info("user logout!");
            log.info("System well exit!");
            System.exit(0);
        } catch (
                Exception e) {
            log.error(e.getMessage());
        }
    }
}
