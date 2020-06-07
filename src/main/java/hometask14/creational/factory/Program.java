package hometask14.creational.factory;

public class   Program {
    public static void main(String[] args) {
//        JavaDeveloper javaDeveloper = new JavaDeveloper();
//        javaDeveloper.writeJavaCode();

//        CppDeveloper cppDeveloper = new CppDeveloper();
//        cppDeveloper.writeCppCode();

//        Developer developer = new CppDeveloper();
//
//        developer.writeCode();

        DeveloperFactory developerFactory = createDeveloperBySpecialty("php");
        Developer developer = developerFactory.createDeveloper();
        developer.writeCode();

    }

    static DeveloperFactory createDeveloperBySpecialty(String specialty) {
        if (specialty.equalsIgnoreCase("java")) {
            return new JavaDeveloperFactory();
        } else if (specialty.equalsIgnoreCase("c++")) {
            return new CppDeveloperFactory();
        } else if (specialty.equalsIgnoreCase("php")) {
            return new PhpDeveloperFactory();
        } else {
            throw new RuntimeException(specialty + " is unknown specialty.");
        }
    }

}


//Enum
//Reflection