/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crowdfounding;

/**
 *
 * @author Juan Camilo
 */
public abstract class Person {
    protected String Name;
    protected int Age;
    protected String id;

    public Person(String Name, int Age, String id) {
        this.Name = Name;
        this.Age = Age;
        this.id = id;
    }
    
}
