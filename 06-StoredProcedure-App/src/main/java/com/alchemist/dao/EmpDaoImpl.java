package com.alchemist.dao;

import javax.persistence.*;

public class EmpDaoImpl implements EmpDao{

    private EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("emp_sp");
    
    @Override
    public void callExperienceProcedure(int empNo) {

        EntityManager em = factory.createEntityManager();

        StoredProcedureQuery sp =
                em.createNamedStoredProcedureQuery("emp_experience_proc");

        sp.setParameter("ENO", empNo);

        sp.execute();

        String name = (String) sp.getOutputParameterValue("NAME");
        Double exp = (Double) sp.getOutputParameterValue("EXPERIENCE");

        System.out.println("Employee Name  : " + name);
        System.out.println("Experience(years): " + exp);

        em.close();
        factory.close();
    }

}
