import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ClassDescriber {
    public static String describeVars(Object obj) {
        StringBuilder ret = new StringBuilder();
        for (Field field : obj.getClass().getDeclaredFields()) {
            try {
                Class klass = ClassLoader.getSystemClassLoader().loadClass(field.toString().substring(field.toString().lastIndexOf(' ')+1, field.toString().lastIndexOf('.')));
                Object object = null;
                for (Constructor constructor : klass.getConstructors()) {
                    if (constructor.getParameterTypes().length == 0) {
                        object = constructor.newInstance();
                        break; // because there is only 1 constructor with 0 params
                    }
                }
                ret.append(field.toString().replaceFirst(obj.getClass().getName() + ".", "") + " = " + field.get(object) + "\n");
            } catch (Exception e) {
                ret.append(field.toString().replaceFirst(obj.getClass().getName() + ".", "") + "\n");
            }
        }
        return new String(ret);
    }

    public static String describeMethods(Object obj) {
        StringBuilder ret = new StringBuilder();
        for (Method method : obj.getClass().getMethods()) {
            ret.append(method.getName() + "(");
            if (method.getParameters().length == 0) ret.append("void)\n");
            else {
                for (Parameter parameter : method.getParameters()) {
                    ret.append(parameter.getType().getName() + ' ' + parameter.getName() + ", ");
                }
                ret.deleteCharAt(ret.length()-1);
                ret.deleteCharAt(ret.length()-1);
                ret.append(")\n");
            }
        }
        return new String(ret);
    }

    public static String describeConstructors(Object obj) {
        StringBuilder ret = new StringBuilder();
        for (Constructor constructor : obj.getClass().getConstructors()) {
            ret.append(constructor.getName() + "(");
            if (constructor.getParameters().length == 0) ret.append("void)\n");
            else {
                for (Parameter parameter : constructor.getParameters()) {
                    ret.append(parameter.getType().getName() + ' ' + parameter.getName() + ", ");
                }
                ret.deleteCharAt(ret.length()-1);
                ret.deleteCharAt(ret.length()-1);
                ret.append(")\n");
            }
        }
        return new String(ret);
    }

    public static String describe(Object object) {
        StringBuilder ret = new StringBuilder();

        ret.append("Class: " + object.getClass().getName() + "\n");
        ret.append("\nConstructors:\n" + describeConstructors(object));
        ret.append("\nMethods:\n" + describeMethods(object));
        ret.append("\nFields:\n" + describeVars(object));

        return new String(ret);
    }
}
