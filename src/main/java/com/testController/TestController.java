//package com.testController;
//
//
//
//import com.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.persistence.EntityManager;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//import java.util.List;
//
//@RestController
//public class TestController {
//    @Autowired
//    private EntityManager entityManager;
//
//    @GetMapping("/test")
//    public String getTest (Model model) {
//
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//
//        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
//        Root<User> root = query.from(User.class);
//        query.select(root)
//                .where(criteriaBuilder.equal(root.get("name"), "Asha"));
//        List<User> resultList = entityManager.createQuery(query).getResultList();
//
//        model.addAttribute("userlist", resultList );
//        return "test";
//    }
//
//
//
//
//}
