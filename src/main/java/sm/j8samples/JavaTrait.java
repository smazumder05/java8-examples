/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.j8samples;

/**
 * Even though FooBar has two methods, only one of them (foo) is not implemented, so it
 * is still a functional interface, and can be created with a lambda expression.
 *
 * @author smazumder
 */
public interface JavaTrait {

    /**
     *
     * @param x
     * @return
     */
    int foo(int x);

    /**
     * Default implementation of the method bar is already provided
     *
     * @return
     */
    default boolean bar(int x) {
        return true;
    }

}
