package com.alchemist;

import com.alchemist.dao.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	EmpDao dao = new EmpDaoImpl();

        dao.callExperienceProcedure(7369);   // EMPNO you want

    }
}
