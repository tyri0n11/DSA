package JavaOOP.Reinforcement;

class Main {
    // Give three examples of life-critical software applications.

    public static void examples(){
        System.out.println(" Medical Devices: Pacemakers, anesthesia machines, and radiation therapy machines all rely on critical software for precise control and patient safety. Malfunctions can have life-threatening consequences.");
        System.out.println("Medical Devices: Pacemakers, anesthesia machines, and radiation therapy machines all rely on critical software for precise control and patient safety. Malfunctions can have life-threatening consequences.");
        System.out.println("Nuclear Power Plant Control: Reactor control, safety monitoring, and emergency shutdown systems in nuclear plants rely on software for safe operation. Errors can cause meltdowns or other disasters.");
    }
    // R-2.2 Give an example of a software application in which adaptability can mean the
    // difference between a prolonged lifetime of sales and bankruptcy.
    public static void example(){
        System.out.println("Mobile OS adaptability is crucial for long-term success.");
        System.out.println("Adaptability allows for:");
        System.out.println("  - Responding to new technologies and user needs");
        System.out.println("  - Supporting diverse devices and app ecosystems");
        System.out.println("Without adaptability, an OS faces:");
        System.out.println("  - Shrinking user base and app development");
        System.out.println("  - Security vulnerabilities and limited compatibility");
        System.out.println("In a rapidly changing market, adaptability is key to survival.");
    }
    // R-2.3 Describe a component from a text-editor GUI and the methods that it encapsulates.
    public static void describe(){
        System.out.println("Text Editor Text Area Component");
        System.out.println("Component: Text Area");
        System.out.println("Functionality: The text area is a central component in a text editor GUI where users enter, view, and edit text.");
        System.out.println("\nEncapsulated Methods:");
        System.out.println("  getText(): Returns the entire text content currently displayed in the text area.");
        System.out.println("  setText(String text): Sets the text content of the text area, replacing any existing text.");
        System.out.println("  append(String text): Appends the provided text to the end of the existing text in the text area.");
        System.out.println("  setSelectionStart(int start): Sets the starting index of the currently selected text within the text area.");
        System.out.println("  getSelectionEnd(): Returns the ending index of the currently selected text within the text area.");
        System.out.println("  getSelectedText(): Returns the currently selected text as a String.");
        System.out.println("  setSelectionRange(int start, int end): Sets the selection range within the text area, highlighting the specified portion of text.");
        System.out.println("  undo(): Reverts the most recent text editing action (if supported by the implementation).");
        System.out.println("  redo(): Redoes the most recent undone text editing action (if supported by the implementation).");
        System.out.println("  cut(): Cuts the selected text and stores it on the clipboard for pasting elsewhere.");
        System.out.println("  copy(): Copies the selected text to the clipboard without removing it from the text area.");
        System.out.println("  paste(): Inserts the content from the clipboard at the current cursor position within the text area.");
        System.out.println("  setFont(Font font): Sets the font style and size for the text displayed in the text area.");
        System.out.println("  setEditable(boolean editable): Enables or disables user interaction with the text area, allowing editing or read-only mode.");
        System.out.println("\nThese methods provide essential functionality for manipulating text within the text editor and interacting with the clipboard. They encapsulate the underlying implementation details, allowing developers to focus on the higher-level logic of text editing without worrying about low-level text manipulation.");
    }
    // R-2.4 Assume that we change the CreditCard class (see Code Fragment 1.5) so that
    // instance variable balance has private visibility. Why is the following implemen
    //tation of the PredatoryCreditCard.charge method flawed?
    public static void  answer(){
        System.out.println("It cannot be executed, private attributes, methods only can be used directly inside same class.");
        System.out.println("Predatory Credit Card class is extended from Credit Card class but Credit Card not included Predatory Credit Card.");
    }
    // R-2.8 Can two interfaces mutually extend each other? Why or why not?
    // ANSWER: No, two interfaces cannot mutually extend each other in Java as it would lead to a circular dependency,
    // which is not allowed.
    // Interfaces can extend multiple other interfaces, but not each other reciprocally.

    // R-2.9 Whataresomepotentialefficiencydisadvantagesofhaving very deep inheritance
    // trees, that is, a large set of classes, A, B, C, and so on, such that B extends A, C
    // extends B, D extends C, etc.?
    public static void printDisadvantages() {
        String[] disadvantages = {
                "Increased complexity in understanding the code, as behavior is distributed across multiple classes.",
                "Maintenance challenges, since changes in base classes can have unforeseen effects on derived classes.",
                "Performance overhead due to method look-up time when navigating up the hierarchy.",
                "Difficulty in debugging, as the source of errors can be obscured by many layers of inheritance.",
                "Limitations in design flexibility, as it can be hard to modify or extend the behavior of classes deep in the hierarchy without affecting others."
        };
        for (String disadvantage : disadvantages) {
            System.out.println(disadvantage);
        }
    }
    // R-2.10 What are some potential efficiency disadvantages of having very shallow inheritance trees,
    // that is, a large set of classes, A, B, C, and so on, such that all of these
    // classes extend a single class, Z?
    public static void printDisadvantages2() {
        String[] disadvantages = {
                "Code Duplication: Without intermediate classes to encapsulate common behavior, code may be repeated across subclasses.",
                "Difficulty in Maintenance: Any change in the base class could require changes in all subclasses.",
                "Reduced Flexibility: It's harder to introduce new levels of hierarchy or modify existing ones without affecting all subclasses.",
                "Poor Abstraction: The base class might become a 'god class' with too many responsibilities, making it less of an abstraction and more of a catch-all.",
                "Increased Complexity: A large number of subclasses directly depending on a single class can make the system more complex and harder to understand.",
                "Inefficient Memory Use: If the base class has many fields, subclasses may inherit unnecessary data, leading to memory wastage.",
                "Difficulty in Reusability: Subclasses might be less reusable due to tight coupling with the base class."
        };

        for (String disadvantage : disadvantages) {
            System.out.println(disadvantage);
        }
    }
    // R-2.13 Consider the inheritance of classes from Exercise R-2.12, and let d be an object
    // variable of type Horse. If d refers to an actual object of type Equestrian, can it
    // be cast to the class Racer? Why or why not?
    public static void printCastingDetails() {
        String explanation = "For the given classes, Racer and Equestrian are both subclasses of Horse. "
                + "If d is an object variable of type Horse and refers to an actual object of type Equestrian, "
                + "it cannot be cast directly to Racer because Equestrian is not a subclass of Racer. "
                + "They are sibling subclasses under Horse. This is known as a \"horizontal\" cast, "
                + "which is not allowed because there is no \"is-a\" relationship between Equestrian and Racer; "
                + "an Equestrian is not a Racer, and vice versa.";
        System.out.println(explanation);
    }
    // R-2.14 Give an example of a Java code fragment that performs an array reference that
    // is possibly out of bounds, and if it is out of bounds, the program catches that
    // exception and prints the following error message:
    // “Don’t try buffer overflow attacks in Java!”
    public static void performOutOfBound(){

        try{
            int[] array = {1,2,3,4,5,6};
            int n = array[6];
        }catch (Exception e){
            System.out.println("“Don’t try buffer overflow attacks in Java!”");
        }
    }
    public static void main(String[] args){
        performOutOfBound();
    }
}
