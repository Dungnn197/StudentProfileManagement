//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0-b170531.0717 
//         See <a href="https://jaxb.java.net/">https://jaxb.java.net/</a> 
//         Any modifications to this file will be lost upon recompilation of the source schema. 
//         Generated on: 2018.11.06 at 04:13:46 PM ICT 
//


package model.entity.course;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the model.entity.course package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: model.entity.course
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Courses }
     * 
     */
    public Courses createCourses() {
        return new Courses();
    }

    /**
     * Create an instance of {@link Courses.Course }
     * 
     */
    public Courses.Course createCoursesCourse() {
        return new Courses.Course();
    }

}
