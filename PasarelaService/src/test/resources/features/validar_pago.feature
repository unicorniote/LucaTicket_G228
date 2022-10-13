Feature: Validar el pago.
	Es posible validar el pago.

	Scenario: Validar pago sin fondos
  	Given numero tarjeta valido
  	And cvv valido
  	And sin fondos
  	When intento validar pago
  	Then operacion denegada no hay fondos
        
	Scenario: Validar pago con Cvv incorrecto
  	Given numero tarjeta valido
    And cvv incorrecto
    And fondos suficientes
    When intento validar pago
  	Then operacion denegada cvv incorrecto
  	
  Scenario: Validar pago con tarjeta invalida
		Given numero tarjeta no valido
		And cvv valido
		And fondos suficientes
		When intento validar pago
		Then operacion denegada numero tarjeta no valido

	Scenario: Validar pago con todo correcto
		Given numero tarjeta valido
		And cvv valido
		And fondos suficientes
		When intento validar pago
		Then operacion aprobada
		
		