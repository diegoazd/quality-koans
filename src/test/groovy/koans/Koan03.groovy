package koans

import spock.lang.*

class Koan03 extends Specification {

  /*  Bloques
    Spock esta contruido para soportar cada una de las fases
    de pruebas
    setup -> stimulus -> response -> cleanup
  */ 
  
  //WARNING: Los bloques no pueden ser anidados

  /*
    El bloque setup sirve para inicializar los fixtures necesarios para elaborar la prueba
    Este no puede ser precedido por otros bloques
  */

  void "Deberia inicializar el fixture dentro del bloque setup"() {
  setup:
    //Inserta el codigo aqui para que la prueba funcione
    ArrayList<String> list 
  expect:
    list.join(' ') == 'Hello world'
  }

  /* Conditions
     when - then, siempre van juntos, mientras el bloque when describen un 'stimulus'
     el bloque then espera una respuesta, dentro de un bloque when va codigo convencional
     en el bloque then estan las restricciones como pueden ser condiciones, excepciones, 'interactions'
     y definicion de variables
     En una prueba puede haber varios bloques when - then
  */

  void "Deberia ejecutar un bloques when then"() {
  when: 'Primer bloque when'
    Stack<Integer> stack = new Stack()
    //Incerta el codigo necesario para que la prueba pase
  then: 'El bloque then evalua un estado esperado, todas las expresiones son evaluadas con un true/false mediante el Groovy truth'
    stack.size() == 2
    stack.pop() == 12
    stack.pop() == 4
  }

  void "Deberia manejar excepciones"() {
  setup:
    Stack stack = new Stack()
  when:
    stack.pop()
  then: 'Espcecifica la excepcion correspondiente dentro de thrown ejemplo: thrown(MyException)'
    thrown()
  }

  void "Otra forma de manejar excepciones"() {
  setup:
    Stack stack = new Stack()
  when:'Tambien las excepciones pueden guardarse como variables'
    stack.pop()
  then:
    //Indica el tipo de excepcion
    ex = thrown()
    ex.cause == null
  }

  void "No deberia arrojar excepciones"() {
  when:
    stack.pop()
  then:
    notThrown(EmptyStackException)
  }
}
