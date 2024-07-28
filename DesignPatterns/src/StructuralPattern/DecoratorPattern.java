package StructuralPattern;

//Component interface
interface TextView {
 void draw();
}

//Concrete component
class SimpleTextView implements TextView {
 @Override
 public void draw() {
     System.out.println("Drawing TextView.");
 }
}

//Decorator
abstract class TextViewDecorator implements TextView {
 protected TextView decoratedTextView;

 public TextViewDecorator(TextView textView) {
     this.decoratedTextView = textView;
 }

 public void draw() {
     decoratedTextView.draw();
 }
}

//Concrete decorators
class BorderDecorator extends TextViewDecorator {
 public BorderDecorator(TextView textView) {
     super(textView);
 }

 @Override
 public void draw() {
     decoratedTextView.draw();
     System.out.println("Adding border.");
 }
}

class ScrollDecorator extends TextViewDecorator {
 public ScrollDecorator(TextView textView) {
     super(textView);
 }

 @Override
 public void draw() {
     decoratedTextView.draw();
     System.out.println("Adding scroll.");
 }
}

//Usage
public class DecoratorPattern {
 public static void main(String[] args) {
     TextView simpleTextView = new SimpleTextView();
     TextView borderedTextView = new BorderDecorator(simpleTextView);
     TextView scrollableTextView = new ScrollDecorator(borderedTextView);

     scrollableTextView.draw();
 }
}

