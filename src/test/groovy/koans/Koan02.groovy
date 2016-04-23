package koans

import spock.lang.*

class Koan02 extends Specification {
  
  /*
    Los fixtures methods son responsables por inicializar y
    limpiar cada feature method
  */

  @Shared int fixtureVariable = 3
  

  //setup y cleanup corren al inicio y al final de cada test
  void setup() {
  //Insertar codigo aqui
  }

  void cleanup() {
  }
  
  void "Primera iteracion del fixture"() {
  when:
    fixtureVariable+= 4
  then:
    fixtureVariable == 13
  }
  
  void "Deberia reiniciar la variable"() {
  when:
    fixtureVariable+= 9
  then:
    fixtureVariable == 18
  }

  /*
    Sin embargo setupSpec y cleanupSpec corre antes del primer test
    y al final de cada test
  */

  @Shared int fixtureVariableSpec
  void setupSpec() {
    //Insertar codigo aqui
  }

  void "Deberia tenear el valor inicial"() {
  expect:
    fixtureVariableSpec == 23
  }

}
