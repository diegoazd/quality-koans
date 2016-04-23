package koans

import spock.lang.*

class Koan01 extends spock.lang.Specification {

  /*
    El objetivo del primer koan es conocer lo basico de spock
  */
  
  //En spock al iniciar las variables estas son aisladas para los 
  //diferentes tests

  //insertar codigo aqui
  
  void "Deberia mantener aislado la variable sharedVariable"() {
  when:
    isolatedVariable+= 3
  then:
    isolatedVariable == 8
  }
  
  void "Todavia deberia mantener aislado la variable sharedVariable"() {
  when:
    isolatedVariable+= 5
  then:
    isolatedVariable == 10
  }

  //La anotacion @Shared permite compartir onjetos entre los diferentes
  //tests
  
  //insertar codigo aqui

  void "Deberia modificar la variable compartida"() {
  when:
    sharedVariable+= 7
  then:
    sharedVariable == 17
  }
  
  void "Deberia compartir la variable compartida"() {
  when:
    sharedVariable+= 8
  then:
    sharedVariable == 25
  }
}
