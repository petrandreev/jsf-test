/*
 * GENERATED FILE - DO NOT EDIT
 */

package org.jboss.test.faces.mock;

import static org.easymock.EasyMock.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.easymock.IMocksControl;
import org.easymock.internal.Invocation;
import org.easymock.internal.LastControl;
import org.easymock.internal.MocksControl;
import org.easymock.internal.ObjectMethodsFilter;
import org.easymock.internal.RecordState;
/**
 * <p class="changed_added_4_0"></p>
 * @author asmirnov@exadel.com
 *
 */
public class FacesMock {
    

    
    
    public static <T> T createMock(Class<T> clazz,IMocksControl control){
                try {
                    return FacesMockController.createMock(clazz, control);
                } catch (ClassNotFoundException e) {
                    return control.createMock(clazz);
                }
    }
    
    public static <T> T createMock(Class<T> clazz){
        return createMock(clazz, createControl());
    }
    
    public static <T> T createNiceMock(Class<T> clazz){
        return createMock(clazz, createNiceControl());
    }

    public static <T> T createStrictMock(Class<T> clazz){
        return createMock(clazz, createStrictControl());
    }

    private static IMocksControl getControl(Object mock) {
        if (mock instanceof FacesMockController.MockObject) {
            FacesMockController.MockObject mockObject = (FacesMockController.MockObject) mock;
            return mockObject.getControl();
        } else {
            // Delegate to EazyMock
            return ((ObjectMethodsFilter) Proxy
                    .getInvocationHandler(mock)).getDelegate().getControl();
        }
    }

    public static void replay(Object... mocks) {
        for (Object mock : mocks) {
            getControl(mock).replay();
        }
    }

    public static void reset(Object... mocks) {
        for (Object mock : mocks) {
            getControl(mock).reset();
        }
    }

    /**
     * Resets the given mock objects (more exactly: the controls of the mock
     * objects) and turn them to a mock with nice behavior. For details, see 
     * the EasyMock documentation.
     * 
     * @param mocks
     *            the mock objects
     */
    public static void resetToNice(Object... mocks) {
        for (Object mock : mocks) {
            getControl(mock).resetToNice();
        }
    }
    
    /**
     * Resets the given mock objects (more exactly: the controls of the mock
     * objects) and turn them to a mock with default behavior. For details, see 
     * the EasyMock documentation.
     * 
     * @param mocks
     *            the mock objects
     */
    public static void resetToDefault(Object... mocks) {
        for (Object mock : mocks) {
            getControl(mock).resetToDefault();
        }
    }
    
    /**
     * Resets the given mock objects (more exactly: the controls of the mock
     * objects) and turn them to a mock with strict behavior. For details, see 
     * the EasyMock documentation.
     * 
     * @param mocks
     *            the mock objects
     */
    public static void resetToStrict(Object... mocks) {
        for (Object mock : mocks) {
            getControl(mock).resetToStrict();
        }
    }

    public static void verify(Object... mocks) {
        for (Object object : mocks) {
            getControl(object).verify();
        }
    }
    
    /**
     * Switches order checking of the given mock object (more exactly: the
     * control of the mock object) the on and off. For details, see the EasyMock
     * documentation.
     * 
     * @param mock
     *            the mock object.
     * @param state
     *            <code>true</code> switches order checking on,
     *            <code>false</code> switches it off.
     */
    public static void checkOrder(Object mock, boolean state) {
        getControl(mock).checkOrder(state);
    }

}