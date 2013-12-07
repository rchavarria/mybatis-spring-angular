package es.rchavarria.library.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import es.rchavarria.library.domain.Course;
import es.rchavarria.library.service.CourseService;

@Controller
@RequestMapping("/library/courses")
public class CourseQueriesController {

    private static Logger LOGGER = LoggerFactory.getLogger(CourseQueriesController.class);

    @Autowired
    private CourseService courseService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Course> getAllOrders() {
        LOGGER.info("all courses will be returned");
        return courseService.requestAllCourses().getCourses();
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
//    public ResponseEntity<Order> viewOrder(@PathVariable String id) {
//
//        OrderDetailsEvent details = courseService.requestOrderDetails(new RequestOrderDetailsEvent(UUID.fromString(id)));
//
//        if (!details.isEntityFound()) {
//            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
//        }
//
//        Order order = Order.fromOrderDetails(details.getOrderDetails());
//
//        return new ResponseEntity<Order>(order, HttpStatus.OK);
//    }
}
