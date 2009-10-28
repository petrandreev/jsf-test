/*
 * $Id$
 *
 * License Agreement.
 *
 * Rich Faces - Natural Ajax for Java Server Faces (JSF)
 *
 * Copyright (C) 2007 Exadel, Inc.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License version 2.1 as published by the Free Software Foundation.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301  USA
 */

package org.jboss.mockgenerator;


import java.io.File;




/**
 * <p class="changed_added_4_0"></p>
 * @author asmirnov@exadel.com
 *
 */
public class MockControlSource extends JavaSource {

    private static final String fileHeader="/*\n" + 
    		" * GENERATED FILE - DO NOT EDIT\n" + 
    		" */\n" + 
    		"\n" + 
    		"package %1$s;\n" + 
    		"\n" + 
    		"import static org.easymock.EasyMock.*;\n" + 
    		"\n" + 
    		"import java.lang.reflect.Constructor;\n" + 
    		"import java.lang.reflect.Method;\n" + 
    		"\n" + 
    		"import org.easymock.IMocksControl;\n" + 
    		"import org.easymock.internal.Invocation;\n" + 
    		"import org.easymock.internal.LastControl;\n" + 
    		"import org.easymock.internal.MocksControl;\n" + 
    		"import org.easymock.internal.RecordState;\n" + 
    		"/**\n" + 
    		" * <p class=\"changed_added_4_0\"></p>\n" + 
    		" * @author asmirnov@exadel.com\n" + 
    		" *\n" + 
    		" */\n" + 
    		"public class %2$s {\n" + 
    		"    \n" + 
    		"    public interface MockObject {\n" + 
    		"        \n" + 
    		"        public IMocksControl getControl();\n" + 
    		"\n" + 
    		"    }\n" + 
    		"\n" + 
    		"    private static final Class<?>[] mockClasses = {\n" + 
    		"";
    
    private static final String fileFooter = "    };\n" + 
    		"\n" + 
    		"    \n" + 
    		"    \n" + 
    		"    public static <T> T createMock(Class<T> clazz,IMocksControl control) throws ClassNotFoundException {\n" + 
    		"        for (Class<?> mockClass : mockClasses) {\n" + 
    		"            if(clazz.isAssignableFrom(mockClass)){\n" + 
    		"                try {\n" + 
    		"                    Constructor<?> constructor = mockClass.getConstructor(IMocksControl.class);\n" + 
    		"                    return (T) constructor.newInstance(control);\n" + 
    		"                } catch (Exception e) {\n" + 
    		"                    continue;\n" + 
    		"                }\n" + 
    		"            }\n" + 
    		"        }\n" + 
    		"        throw new ClassNotFoundException(\"Mock object for class \"+clazz.getName()+\" not found\");\n" + 
    		"    }\n" + 
    		"    \n" + 
    		"    public static <T> T createMock(Class<T> clazz) throws ClassNotFoundException {\n" + 
    		"        return createMock(clazz, createControl());\n" + 
    		"    }\n" + 
    		"    \n" + 
    		"    @SuppressWarnings(\"unchecked\")\n" + 
    		"    public static <T> T invokeMethod(MockObject target,Method method, Object... args) {\n" + 
    		"        MocksControl mcontrol = (MocksControl) target.getControl();\n" + 
    		"        try {\n" + 
    		"            if (mcontrol.getState() instanceof RecordState) {\n" + 
    		"                LastControl.reportLastControl(mcontrol);\n" + 
    		"            }\n" + 
    		"            return (T) mcontrol.getState().invoke(\n" + 
    		"                    new Invocation(target, method, args));\n" + 
    		"\n" + 
    		"        } catch (Throwable t) {\n" + 
    		"            throw new RuntimeException(t); \n" + 
    		"        }\n" + 
    		"\n" + 
    		"    }\n" + 
    		"    \n" + 
    		"    public static Method findMethod(Class<?> clazz,String name,Class<?>...classes ){\n" + 
    		"        try {\n" + 
    		"            return clazz.getMethod(name, classes);\n" + 
    		"        } catch (SecurityException e) {\n" + 
    		"            throw new RuntimeException(e); \n" + 
    		"        } catch (NoSuchMethodException e) {\n" + 
    		"            return null; \n" + 
    		"        }\n" + 
    		"    }\n" +
    		""+
    		"}\n" + 
    		"";
    /**
     * <p class="changed_added_4_0"></p>
     * @param directory
     * @param mockClassName
     */
    public MockControlSource(File directory, String mockClassName) {
        super(directory, mockClassName);
    }

    public void printFileHeader() {
        sprintf(fileHeader,mockPackage,mockClass);
    }
    
    public void printMockClass(String name){
        sprintf("      %1$s.class,\n",name);
    }

    public void printFileFooter(){
        write(fileFooter);
    }

}